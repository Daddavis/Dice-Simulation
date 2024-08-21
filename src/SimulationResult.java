import java.util.Arrays;

/**
 * Classe che memorizza i risultati di una simulazione di lanci di dado.
 */
public class SimulationResult {
    private final int[] rollFrequencies; // Frequenze dei risultati dei lanci
    private final double[] rollPercentages; // Percentuali dei risultati

    public SimulationResult(int maxRollResult) {
        this.rollFrequencies = new int[maxRollResult];
        this.rollPercentages = new double[maxRollResult];
    }

    /**
     * Registra il risultato di un lancio di dado.
     * @param rollResult il risultato ottenuto.
     */
    public void recordRoll(int rollResult) {
        if (rollResult < 1 || rollResult > rollFrequencies.length) {
            throw new IllegalArgumentException("Numero di risultato non valido.");
        }
        rollFrequencies[rollResult - 1]++;
    }

    /**
     * Calcola le percentuali di ogni risultato in base al numero totale di lanci.
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
