package org.ucll.da.entities;

public class Forecast {
	
	private Weather weather;
	private Main main;
	
	public Forecast(){}
	
	public void setWeather(Weather weather){
		this.weather = weather;
	}
	
	public Weather getWeather(){
		return weather;
	}
	
	public void setMain(Main main){
		this.main = main;
	}
	
	public Main getMain(){
		return main;
	}

	@Override
	public String toString() {
		return "Forecast [weather=" + weather + ", main=" + main + "]";
	}
	
	
}
