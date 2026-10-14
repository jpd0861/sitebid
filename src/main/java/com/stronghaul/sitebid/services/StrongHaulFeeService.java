package com.stronghaul.sitebid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stronghaul.sitebid.models.Address;
import com.stronghaul.sitebid.models.CubicYardRequest;
import com.stronghaul.sitebid.models.DistanceResponse;
import com.stronghaul.sitebid.models.Product;
import com.stronghaul.sitebid.models.StrongHaulRate;
import com.stronghaul.sitebid.models.StrongHaulSettings;
import com.stronghaul.sitebid.models.Vendor;
import com.stronghaul.sitebid.models.VendorProduct;
import com.stronghaul.sitebid.validate.StrongHaulFeeValidate;

@Service 
public class StrongHaulFeeService {

    @Autowired CubicYardService cubicYardService;
    @Autowired DistanceService distanceService;
    @Autowired PostgresDbService postgresDbService;
    @Autowired StrongHaulRateService strongHaulRateService;
    @Autowired StrongHaulFeeValidate strongHaulFeeValidate;

    private StrongHaulSettings strongHaulSettings;

    private String error;
    public String getError() {
        return error;
    }

    public StrongHaulRate calculateUsingCubicYards(
        CubicYardRequest cubicYardRequest, 
        String siteAddress, 
        String siteZip,
        Vendor vendor,
        Address vendorAddress, 
        Product product,
        VendorProduct vendorProduct){
            StrongHaulRate strongHaulRate = new StrongHaulRate();
            this.error = "";
            this.strongHaulSettings = null;

            if(!strongHaulFeeValidate.isValid(siteAddress, siteZip, vendor, vendorAddress, product, vendorProduct)){
                strongHaulRate.setError(strongHaulFeeValidate.getError());
                return strongHaulRate;
            }
            
            Double cubicYardsNeeded = 
                this.cubicYardService.calculate(cubicYardRequest);
            
            if(cubicYardsNeeded < 1){
                strongHaulRate.setError(this.cubicYardService.getError());
                return strongHaulRate;
            }

            Double maxCubicYardsPerTrip = 
            this.cubicYardService.getMaxCubicYardsPerTrip(
                product.getAverageWeight(), getStrongHaulMaxPayload());
            
            if(maxCubicYardsPerTrip < 1){
                strongHaulRate.setError(this.cubicYardService.getError());
                return strongHaulRate;
            }

            strongHaulRate.setProduct(product);
            strongHaulRate.setRetail(vendorProduct.getRetail());
            strongHaulRate.setQuantity(cubicYardsNeeded.intValue());
            strongHaulRate.setDiscountPercentage(vendorProduct.getDiscountPercentage() > vendor.getDiscountPercentage() 
                ? vendorProduct.getDiscountPercentage() 
                : vendor.getDiscountPercentage());

            Double totalTripsNeeded = Math.ceil(cubicYardsNeeded / maxCubicYardsPerTrip);
            
            Double charges = 0.0;
            charges += this.strongHaulSettings.getLocalZipCodes().contains(siteZip)
                ? getBaseFees(totalTripsNeeded)
                : getPerMileCharges(vendorAddress, siteAddress, siteZip, totalTripsNeeded);
            charges += addOnlineTransactionFee(charges);
            
            strongHaulRate = this.strongHaulRateService.calculate(strongHaulRate, charges);
            return strongHaulRate;
        }

        private Double getPerMileCharges(Address vendorAddress, String siteAddress, String siteZip, Double totalTripsNeeded){
            Double charges = 0.0;
            DistanceResponse distanceFromBaseToVendor = 
                this.getDistanceToSite(
                    getStrongHaulStreet(), 
                    getStrongHaulZip(), 
                    vendorAddress.getStreet(), 
                    vendorAddress.getZip());
                charges += 
                    distanceFromBaseToVendor.getDistanceMiles() * 
                    strongHaulSettings.getRatePerMile();

                DistanceResponse distanceFromVendorToSite =
                this.getDistanceToSite(
                    vendorAddress.getStreet(), 
                    vendorAddress.getZip(), 
                    siteAddress, 
                    siteZip);
                
                charges += 
                    distanceFromVendorToSite.getDistanceMiles() * 
                    strongHaulSettings.getRatePerMile() * 
                    totalTripsNeeded;

                return charges;
        }

        private Double addOnlineTransactionFee(Double charge){
            return (charge + this.strongHaulSettings.getOnlineTransactionFee())/
                 (1 - this.strongHaulSettings.getOnlineTransactionPercentage());
        }

        private void getStrongHaulSettings(){
            this.strongHaulSettings = this.postgresDbService.getStrongHaulSettings();
        }

        private DistanceResponse getDistanceToSite(String originAddress, String originZip, String destinationAddress, String destinationZip){
            String origin = String.format("%s, %s", originAddress, originZip);
            String destination = String.format("%s, %s", destinationAddress, destinationZip);
            return this.distanceService.getDistance(origin, destination);
        }

        private Double getBaseFees(Double numberOfTrips){
            if(this.strongHaulSettings == null){
                this.getStrongHaulSettings();
            }
            return (numberOfTrips * this.strongHaulSettings.getBaseHookupFee()) 
            + this.strongHaulSettings.getTechPlatformFee();
        }

        private String getStrongHaulStreet(){
            if(this.strongHaulSettings == null){
                this.getStrongHaulSettings();
            }
            return this.strongHaulSettings.getStreet();
        }

        private String getStrongHaulZip(){
            if(this.strongHaulSettings == null){
                this.getStrongHaulSettings();
            }
            return this.strongHaulSettings.getZip();
        }

        private Double getStrongHaulMaxPayload(){
            if(this.strongHaulSettings == null){
                this.getStrongHaulSettings();
            }
            return this.strongHaulSettings.getMaxPayload();
        }
}
