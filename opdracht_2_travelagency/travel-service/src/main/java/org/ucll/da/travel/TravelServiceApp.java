package org.ucll.da.travel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TravelServiceApp {
	
	public static void main(String[] args) {
        SpringApplication.run(TravelServiceApp.class, args);
    }
	
}