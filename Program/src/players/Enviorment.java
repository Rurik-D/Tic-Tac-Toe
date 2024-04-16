package players;

import java.util.Random;
import engine.Table;

/*
 * Classe che definisce il comportamento del giocatore
 * artificiale.
 */
public class Enviorment extends Player {

    private Random rand;

    public Enviorment() {
        this.rand = new Random();
    }

    /*
     * Seleziona randomicamente una casellae.
     * Se si seleziona una casella occupata, il programma prendera' la 
     * successiva, ricominciando dalla prima se si arriva all'ultima.
     * 
     * Si tornano le coordinate della casella selezionata, altrimenti un
     * array vuoto (ci sarà un controllo a parte per il completamento).
     */
    @Override
    public int[] getInput(Table table) {
        int selection;
        int[] coords;
        char box;

        selection = this.rand.nextInt(1, 10);

        for (int i = 0; i < 9; i++){
            coords = this.getCoordinates(selection);
            box = table.getBox(coords);

            if (box == ' ') {
                return coords;
            }
            selection = selection % 9 + 1;
        }
        return new int[1];
    }
    
}
