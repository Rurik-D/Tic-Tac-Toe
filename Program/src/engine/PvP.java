package engine;

import java.util.Scanner;
import players.Human;

/*
 * Classe che gestisce le sessioni di gioco PvP.
 */
public class PvP extends Engine{
    private Human player1;
    private Human player2;


    /*
     * Metodo che setta i valori delle variabili da utilizzare
     * nella sessione di gioco.
     */
    @Override
    protected void setVariables(Scanner scan) {
        this.player1 = new Human(scan);
        this.player2 = new Human(scan);
        this.currentTurn = Turn.getRandTurn();
        this.table.setTable();
    }
    
    /*
     * Metodo principale della classe, consente di avviare
     * la partita a tris.
     */
    @Override
    protected void run(Scanner scan) {
        this.setVariables(scan);    
        int[] coords;    

        while (true) {
            table.print();

            if (this.checkEnd()) 
                break;
            
            System.out.println("\nTurno di " + currentTurn.toChar() + "\n");
            
            coords = switch (currentTurn) {
                case X_TURN -> player1.getInput(this.table);
                case O_TURN -> player2.getInput(this.table);
            };
            
            table.markBox(coords, currentTurn.toChar());
            
            currentTurn = currentTurn.switchTurn(currentTurn);
        }
    }

}