package org.ucll.da.entities;

public class City {

	private long id;
	private String name;
	private String country;
	
	public City(){}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getId(){
		return id;
	}
	
	public void setCountry(String countryCode){
		this.country = countryCode;
	}
	
	public String getCountry(){
		return country;
	}
}
