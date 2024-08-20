import java.util.Arrays;

/**
 * Classe che memorizza i risultati di una simulazione di lanci di dado.
 */
public class SimulationResult {
    private final int[] rollFrequencies; // Frequenze dei risultati dei lanci
    private final double[] rollPercentages; // Percentuali dei risultati

    public SimulationResult(int numberOfSides) {
        this.rollFrequencies = new int[numberOfSides];
        this.rollPercentages = new double[numberOfSides];
    }

    /**
     * Registra il risultato di un lancio di dado.
     * @param side il lato ottenuto.
     */
    public void recordRoll(int side) {
        if (side < 1 || side > rollFrequencies.length) {
            throw new IllegalArgumentException("Numero di lato non valido.");
        }
        rollFrequencies[side - 1]++;
    }

    /**
     * Calcola le percentuali di ogni lato in base al numero totale di lanci.
     * @param totalRolls numero totale di lanci.
     */
    public void calculatePercentages(int totalRolls) {
        if (totalRolls <= 0) {
            throw new IllegalArgumentException("Il numero totale di lanci deve essere maggiore di zero.");
        }
        for (int i = 0; i < rollFrequencies.length; i++) {
            rollPercentages[i] = (double) rollFrequencies[i] / totalRolls * 100;
        }
    }

    public int[] getRollFrequencies() {
        return Arrays.copyOf(rollFrequencies, rollFrequencies.length);
    }

    public double[] getRollPercentages() {
        return Arrays.copyOf(rollPercentages, rollPercentages.length);
    }
}
