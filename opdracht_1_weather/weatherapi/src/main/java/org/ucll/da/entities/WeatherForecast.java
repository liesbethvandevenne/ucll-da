package org.ucll.da.entities;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class WeatherForecast implements WeatherData{

	private City city;
	@SerializedName("list") 
	private List<Object> forecast;

	public WeatherForecast(){}
	
	public void setCity(City city){
		this.city = city;
	}
	
	public City getCity(){
		return city;
	}
	
	public List<Object> getForecast() {
		return this.forecast;
	}

	public void setForecast( List<Object> forecast ) {
		this.forecast = forecast;
	}

	@Override
	public String toString() {
		return "WeatherForecast [forecast=" + forecast + "]";
	}
}
