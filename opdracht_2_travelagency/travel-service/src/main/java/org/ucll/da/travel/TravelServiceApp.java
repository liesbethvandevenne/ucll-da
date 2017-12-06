package org.ucll.da.travel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "travel-service")
public class TravelServiceApp {
	
	public static void main(String[] args) {
        SpringApplication.run(TravelServiceApp.class, args);
    }
	
}