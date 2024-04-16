package players;

import java.util.Scanner;
import engine.Table;


/*
 * Classe che definisce il comportamento del giocatore
 * umano.
 */
public class Human extends Player {
    private Scanner scan;

    public Human(Scanner scan) {
        this.scan = scan;
    }

    /*
     * Prende un input dall'utente fin quando non
     * e' un intero compreso tra 1 e 9.
     */
    @Override
    public int[] getInput(Table table) {
        boolean errato = false;
        int selection;
        int[] coords;
        char box;

        do {
            System.out.println("\n\tInserire input:");
            selection = this.scan.nextInt();
            this.scan.nextLine();

            coords = this.getCoordinates(selection);
            box = table.getBox(coords);

            if (selection < 1 || selection > 9 || box != ' ') {
                errato = true;
                System.out.println("L'indice inserito non e' valido");
            } else {
                errato = false;
            }
        } while(errato);
        
        return coords;
    }
    
}
