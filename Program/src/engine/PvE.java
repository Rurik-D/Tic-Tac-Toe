package engine;

import java.util.Scanner;
import players.Enviorment;
import players.Human;

/*
 * Classe che gestisce le sessioni di gioco PvE.
 */
public class PvE extends Engine{
    private Human human;
    private Enviorment env;

    /*
     * Metodo che setta i valori delle variabili da utilizzare
     * nella sessione di gioco.
     */
    @Override
    protected void setVariables(Scanner scan) {
        this.human = new Human(scan);
        this.env = new Enviorment();
        this.currentTurn = Turn.getRandTurn();
        this.table.setTable();
    }

    /*
     * Metodo principale della classe, consente di avviare
     * la partita a tris.
     */
    @Override
    protected void run(Scanner scan) {
        setVariables(scan);
        int[] coords;

        while (true) {
            table.print();

            if (this.checkEnd()) {
                break;
            }
            
            System.out.println("\nTurno di " + currentTurn.toChar() + "\n");

            coords = switch (currentTurn) {
                case X_TURN -> human.getInput(this.table);
                case O_TURN -> env.getInput(this.table);
            };
            
            table.markBox(coords, currentTurn.toChar());
            
            currentTurn = currentTurn.switchTurn(currentTurn);
        }

    }


    
}
