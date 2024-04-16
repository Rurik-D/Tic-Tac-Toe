package engine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	Menu menu = new Menu(scan);
    	boolean run = true;
    	
    	while (run) {
    		run = menu.mainMenu();
    	}
    	
    	scan.close();

    	System.out.println("\nCiao ciao =D\n");
    }
}