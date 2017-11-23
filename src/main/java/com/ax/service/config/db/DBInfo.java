package com.ax.service.config.db;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("dbconfig.dbmysql")
public class DBInfo {
    private String driver;
    private String url;
    private String username;
    private String password;
}
