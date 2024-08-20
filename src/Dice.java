import java.util.Random;

/**
 * Classe che rappresenta un dado.
 */
public class Dice {
    private final int numberOfSides; // Numero di lati del dado
    private final Random randomGenerator; // Generatore di numeri casuali

    public Dice(int numberOfSides) {
        if (numberOfSides < 1) {
            throw new IllegalArgumentException("Un dado deve avere almeno un lato.");
        }
        this.numberOfSides = numberOfSides;
        this.randomGenerator = new Random();
    }

    /**
     * Simula il lancio del dado.
     * @return il risultato del lancio.
     */
    public int roll() {
        return randomGenerator.nextInt(numberOfSides) + 1;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }
}
