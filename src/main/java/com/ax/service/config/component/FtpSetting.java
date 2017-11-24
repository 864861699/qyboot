package com.ax.service.config.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * FTP上传工具
 */
@Data
@Component
@ConfigurationProperties(prefix = "ftp")
public class FtpSetting {
    private String host;
    private String path;
    private String addr;
    private String port;
    private String user;
    private String pass;
}
