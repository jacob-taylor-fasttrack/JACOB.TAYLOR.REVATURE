package main;

import java.util.Scanner;

public class Converter {

		public static void main(String[] args) {

			Scanner scanner=new Scanner(System.in);
		
			        
			
			      System.out.println("1. Celsius to Fahrenheit");
			 
			        System.out.println("2. Miles to Kilometers");
			 
			        System.out.println("3. Gallons to Liters");
			 
			        System.out.println("4. Quit the program\n");
			
			 
			        System.out.print("Enter your choice: ");
			        			
		
		int  menuSelection=scanner.nextInt();
		while(menuSelection!=4) {
			 boolean quit=false;
			
		 switch(menuSelection) {
		 case 1:
			 System.out.println("You have chose celsius to fahrenheit");
			 double celsius=scanner.nextDouble();
			 double fahrenheit=(((celsius*9)/5)+32);
				System.out.println(celsius+" degrees celsius is "+fahrenheit+" degrees fahrenheit");
			 break;
		 case 2:
			 System.out.println("You have chose miles to kilometers");
			 double miles=scanner.nextDouble();
			 double kilometers= (miles*1.60934);
				System.out.println(miles+" miles is "+kilometers+" kilometers");
			 break;
		 case 3:
			 System.out.println("You have chose gallons to liters");
			 double gallons=scanner.nextDouble();
			 double liters=(gallons*3.7854);
				System.out.println(gallons+" gallons is "+liters+" liters");
			 break;
		 
			 default:
				 System.out.println("Invalid entry. please enter number 1-4");}
		 break;
		
		 }
		 }}

		
	


