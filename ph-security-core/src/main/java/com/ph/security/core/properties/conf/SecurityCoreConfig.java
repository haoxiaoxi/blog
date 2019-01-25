package com.ph.security.core.properties.conf;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.ph.security.core.properties.SecurityProperties;

/**
 * 使SecurityProperties的配置生效
 * @author panha
 *
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
