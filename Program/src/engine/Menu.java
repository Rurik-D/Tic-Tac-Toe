package engine;

import java.util.Scanner;

public final class Menu {
	private Scanner scan;
	private char choice;
	private PvE pve;
	private PvP pvp;
	
	
	public Menu(Scanner scan) {
		this.scan = scan;
		this.pve = new PvE();
		this.pvp = new PvP();

	}
	
	/*
	 * Prende l'input dall'utente e decide se aprire il menu'
	 * di gioco o chiudere il programma.
	 * Ritorna true se il programma si deve ripetere e false
	 * se si deve chiudere.
	 */
	public boolean mainMenu() {
		boolean run = true;
		
		Selected:
		while (true) {
			printMainMenu();
			this.choice = this.scan.next().charAt(0);
			
			switch (this.choice) {
				case '1':				// play
					this.gameMenu();
					break Selected;
				case '2':				// quit
					run = false;
					break Selected;
				default:
					System.out.printf("\n\tIl carattere %c inserito non è valido!\n", choice);
					break;
			}
		}
		
		return run;
	}
	
	/*
	 * Prende l'input dall'utente e decide se avviare una
	 * partita PvE, PvP o se tornare al menu' principale.
	 */
	private void gameMenu() {
		Selected:
		while (true) {
			printGameMenu();
			this.choice = this.scan.next().charAt(0);			
			
			switch (this.choice) {
				case '1':				// PvE
					pve.run(this.scan);
					break;
				case '2':				// PvP
					pvp.run(this.scan);
					break;
				case '3':				// quit
					break Selected;
				default:
					System.out.printf("\n\tIl carattere %c inserito non è valido!\n", choice);
					break;
			}
		}
		
	}
	
	
	/*
	 * Stampa il menu' principale del gioco.
	 */
	private static void printMainMenu() {
		String menu = "\n\t<>  Main Menu'  <>" + 
					  "\n\t   1. Play" +
					  "\n\t   2. Quit";
		System.out.println(menu);
	}
	
	/*
	 * Stampa il menu di selezione della modalità di gioco.
	 */
	private static void printGameMenu() {
		String menu = "\n\t<>     Play     <>" + 
					  "\n\t   1. PvE" +
					  "\n\t   2. PvP" +
					  "\n\t   3. Back";
		System.out.println(menu);

	}
}
