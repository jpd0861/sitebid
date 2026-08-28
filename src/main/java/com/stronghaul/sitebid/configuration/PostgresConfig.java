package com.stronghaul.sitebid.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "postgres")
public class PostgresConfig {

    private String userProfileTable;

    public String getUserProfileTable() {
        return userProfileTable;
    }

    public void setUserProfileTable(String userProfileTable) {
        this.userProfileTable = userProfileTable;
    }
}