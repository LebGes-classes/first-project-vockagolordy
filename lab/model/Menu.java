package model;
import java.util.*;

public class Menu {
	public static Scanner scan = new Scanner(System.in);


	public static void start(){

		boolean flag = true;
		 

		while(flag) {
			int command = scan.nextInt(); 
	    switch (command){
		    case (1):
		    	System.out.println("Next level");
		        flag = false;  
		        break;
		    case (2):  
		       System.out.println("Rules w - up; a - left; s - down; d - right");
		       break;  
		    case (3):    
		       System.out.println("Thanks for playing!");
		       System.exit(0);  
		    default:  
		       System.out.println("Unknown comand, try again");  
		    }
		}
	}


	public static void nextLevel(){

		System.out.println("Menu\n1 - Continue the game\n2 - Exit\n");
		boolean flag = true;

		while(flag) {
			int command = scan.nextInt();
		switch (command){
		    case (1):
		       System.out.println("Next level");
		       flag = false;
		       break;
		    case (2):  
		       System.out.println("Thanks for playing!");
		       System.exit(0);  
		       break;
		    default:  
		       System.out.println("Unknown comand, try again");  
		    }
		}
	}

}