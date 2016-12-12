package com.dexusint;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration to include our services
 *
 * @author Denis Lyubo
 */
@Configuration
@ComponentScan(basePackageClasses = {RoadCityService.class})
public class SpringAnnotationConfig {
}