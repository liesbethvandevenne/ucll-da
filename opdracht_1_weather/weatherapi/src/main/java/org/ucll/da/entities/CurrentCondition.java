package org.ucll.da.entities;

import java.util.List;

import org.omg.CORBA.Current;

public class CurrentCondition implements WeatherData{
	
	private City city;
	private List<Weather> weather;
	private Main main;
	
	public CurrentCondition(){}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return "CurrentCondition [weather=" + weather + ", main=" + main + "]";
	}

	public void setCity(City city){
		this.city = city;
	}
	
	@Override
	public City getCity() {
		return city;
	}
	
	
	
	
}
