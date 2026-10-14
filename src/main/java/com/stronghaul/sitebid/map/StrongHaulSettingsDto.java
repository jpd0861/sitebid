package com.stronghaul.sitebid.map;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.stronghaul.sitebid.models.StrongHaulSettings;

public class StrongHaulSettingsDto {

    public StrongHaulSettings map(ResultSet resultSet) throws SQLException {
        StrongHaulSettings strongHaulSettings = new StrongHaulSettings();
        if (resultSet.next()) {
            strongHaulSettings.setId(resultSet.getLong("id"));
            strongHaulSettings.setBaseHookupFee(resultSet.getDouble("base_hookup_fee"));
            strongHaulSettings.setTechPlatformFee(resultSet.getDouble("tech_platform_fee"));
            strongHaulSettings.setOnlineTransactionFee(resultSet.getDouble("online_transaction_fee"));
            strongHaulSettings.setOnlineTransactionPercentage(resultSet.getDouble("online_transaction_percentage"));
            strongHaulSettings.setRatePerMile(resultSet.getDouble("rate_per_mile"));
        }
        return strongHaulSettings;
    }
}
