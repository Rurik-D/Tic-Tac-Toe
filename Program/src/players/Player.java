package players;
import engine.Table;

abstract class Player {

    public abstract int[] getInput(Table table);

    /*
     * Preso in input un indice restituisce le coordinate
     * della casella a quell'indice.
     */
    protected int[] getCoordinates(int index){
        index -= 1;
        //                      y         ,      x
        int[] coordinate = {(int) index / 3, index % 3};
        return coordinate;

    }
}