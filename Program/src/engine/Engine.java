package engine;

import java.util.Scanner;

/*
 * Classe che gestisce i controlli all'interno del gioco.
 */
abstract class Engine {
    protected Table table;
    protected Turn currentTurn;

    public Engine() {
        this.table = new Table();
    }
    
    /*
     * Controlla se la partita è finita (per vittoria o
     * per riempimento della tabella).
     */
    protected boolean checkEnd() {
        char winner = getWinner();

        if (winner != ' ') {
            System.out.println("\n\tIl vincitore e' " + winner + "!\n");
            return true;
        } else {
            return this.checkComplete();
        }

    }

    /*
     * Effettua tutti i controlli di vittoria, e nel caso
     * ritorna il vincitore.
     */
    protected char getWinner() {
        char winner = ' ';

        winner = checkRows();
        if (winner == ' ')
            winner = checkColumns();
        if (winner == ' ')
            winner = checkDiagonals();
        
        return winner;
    }
    
    /*
     * Controlla se esiste una riga con tutti elementi
     * uguali e diversi dalla cella vuota (' ').
     * In caso affermativo torna il carattere che riempie
     * la riga, altrimenti ' '.
     */
    protected char checkRows(){
        int countEquals;
        for (int y = 0; y < 3; y++) {
            countEquals = 0;
            for (int x = 0; x < 2; x++){
                if (table.getBox(y, x) != ' ' && table.getBox(y, x) == table.getBox(y, x+1))  {
                    countEquals++;
                    if (countEquals == 2) 
                        return table.getBox(y, x);
                } else {
                    break;
                }
            }
        }

        return ' ';
    }

    /*
     * Controlla se esiste una colonna con tutti elementi
     * uguali e diversi dalla cella vuota (' ').
     * In caso affermativo torna il carattere che riempie
     * la colonna, altrimenti ' '.
     */
    protected char checkColumns(){
        int countEquals;
        for (int x = 0; x < 3; x++) {
            countEquals = 0;
            for (int y = 0; y < 2; y++){
                if (table.getBox(y, x) != ' ' && table.getBox(y, x) == table.getBox(y+1, x))  {
                    countEquals++;
                    if (countEquals == 2) 
                        return table.getBox(y, x);
                } else {
                    break;
                }
            }
        }
        return ' ';
    }
    
    /*
     * Controlla se esiste una diagonale con tutti elementi
     * uguali e diversi dalla cella vuota (' ').
     * In caso affermativo torna il carattere che riempie
     * la diagonale, altrimenti ' '.
     */
    protected char checkDiagonals(){
        if (table.getBox(1, 1) != ' ') {
            if (table.getBox(0,0) == table.getBox(1,1) && table.getBox(1,1) == table.getBox(2,2)) 
                return table.getBox(1,1);
            
            if (table.getBox(0,2) == table.getBox(1,1) && table.getBox(1,1) == table.getBox(2,0))
                return table.getBox(1,1);
        }
        return ' ';
    
    }

    /*
     * Controlla se la tabella sia piena.
     */
    protected boolean checkComplete(){
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++){
                if (table.getBox(y, x) == ' ') {
                    return false;
                }
            }
        }
        
        System.out.println("\n\tPareggio!\n");
        return true;
    }

    /*
     * Metodo che setta i valori delle variabili da utilizzare
     * nella sessione di gioco.
     */
    protected abstract void setVariables(Scanner scan);

    /*
     * Metodo principale della classe, consente di avviare
     * la partita a tris.
     */
    protected abstract void run(Scanner scan);

}