package org.ucll.da.cli;

import java.security.Provider.Service;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class View {

	public View(){
		System.out.println( "Starting weather Service..." );
	}
	
	public String showMenu(){
		System.out.println("Enter F for forecast, C for current condition: ");
		Scanner scanner = new Scanner( System.in );
		String input = scanner.next();
		return input;
	}
	
	public String getCityName(){
		System.out.println("Enter a Belgian cityname: ");
		Scanner scanner = new Scanner( System.in );
		String input = scanner.next();
		return input;
	}

	public void showData(String data) {
		System.out.println("The current weather is:");
		System.out.println(data);
	}

	public void showError(String string) {
		System.out.println(string);		
	}
}
