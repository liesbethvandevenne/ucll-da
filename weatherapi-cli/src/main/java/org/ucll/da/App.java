package org.ucll.da;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.ucll.da.cli.Controller;

@SpringBootApplication
public class App {
	
    public static void main( String[] args ){
        Controller controller = new Controller();
        controller.start();
    }
    
}
