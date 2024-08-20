/**
 * Classe che gestisce una simulazione di lanci di dado.
 */
public class DiceSimulation {
    private final int numberOfRolls; // Numero di lanci
    private final Dice dice; // Il dado da lanciare
    private final SimulationResult result; // Risultati della simulazione

    private DiceSimulation(Builder builder) {
        this.numberOfRolls = builder.numberOfRolls;
        this.dice = new Dice(builder.numberOfSides);
        this.result = new SimulationResult(builder.numberOfSides);
    }

    /**
     * Esegue la simulazione dei lanci.
     */
    public void run() {
        for (int i = 0; i < numberOfRolls; i++) {
            int rollResult = dice.roll();
            result.recordRoll(rollResult);
        }
        result.calculatePercentages(numberOfRolls);
    }

    public SimulationResult getResult() {
        return result;
    }

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    /**
     * Builder per configurare e creare una simulazione di lanci di dado.
     */
    public static class Builder {
        private int numberOfRolls;
        private int numberOfSides;

        public Builder setNumberOfRolls(int numberOfRolls) {
            if (numberOfRolls <= 0) {
                throw new IllegalArgumentException("Il numero di lanci deve essere maggiore di zero.");
            }
            this.numberOfRolls = numberOfRolls;
            return this;
        }

        public Builder setNumberOfSides(int numberOfSides) {
            if (numberOfSides <= 0) {
                throw new IllegalArgumentException("Il numero di lati deve essere maggiore di zero.");
            }
            this.numberOfSides = numberOfSides;
            return this;
        }

        public DiceSimulation build() {
            return new DiceSimulation(this);
        }
    }
}
