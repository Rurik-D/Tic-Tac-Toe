package engine;

import java.util.Random;

public enum Turn {
    X_TURN('X'), O_TURN('O');
	
    private char round;

    Turn(char round) {
        this.round = round;
    }
    
    /*
     * Restituisce il valore associato alla costante
     * enumerativa.
     */
    public char toChar() {
        return round;
    }

    /*
     * Dato un turno, ritorna l'altro turno.
     */
    public Turn switchTurn(Turn r) {
        return switch(r) {
            case X_TURN -> O_TURN;
            case O_TURN -> X_TURN;
        };
    }

    /*
     * Torna un turno casuale.
     */
    static Turn getRandTurn() {    
    	Random rand = new Random();
    	return switch (rand.nextInt(2)) {
    		case 0 -> X_TURN;
    		case 1 -> O_TURN;
    		default -> X_TURN;
    	};
    	
    }
}