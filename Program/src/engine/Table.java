package engine;

public class Table {
    private char[][] table;

    public Table() {
        this.table = new char[3][3];
    }
    
    /*
     * Setta i valori dei caratteri della tabella con
     * il relativo indice nella tabella (da 1 a 9).
     */
    public void setTable() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                this.table[y][x] = ' ';
            }
        }
    }

    /*
     * Setta i valori dei caratteri della tabella con
     * il relativo indice nella tabella (da 1 a 9).
     */
    public char getBox(int[] coords) {
        return this.table[coords[0]][coords[1]];
    }

    public char getBox(int y, int x) {
        return this.table[y][x];
    }

    /*
     * Metodo che prende in input un array di due valori 
     * e un carattere. Contrassegna la casella in quella 
     * posizione con quel carattere.
     * 
     * Ritorna true se la casella e' stata marcata,
     * false altrimenti.
     */
    public void markBox(int[] coords, char sign) {
        if (coords.length == 2) {
            this.table[coords[0]][coords[1]] = sign;
        }
    }

    /*
     * Stampa a schermo i valori attuali della tabella.
     */
    public void print() {
        char box;
        int i = 1;

        System.out.println("\n|---+---+---|");
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                box = this.table[y][x];

                // se la casella e' vuota stampo l'indice corrispettivo
                if (box == ' ') {
                    box = (char) (i + '0');
                } 
                System.out.print("| " + box + " ");

                i += 1;
            }
            System.out.println("|\n|---+---+---|");
        }
    }

}