/**
 * Classe che gestisce una simulazione di lanci di dado.
 */
public class DiceSimulation {
    private final int numberOfRolls; // Numero di lanci
    private final Dice[] diceArray; // Array di dadi
    private final SimulationResult result; // Risultati della simulazione

    private DiceSimulation(Builder builder) {
        this.numberOfRolls = builder.numberOfRolls;
        this.diceArray = new Dice[builder.numberOfDice];
        for (int i = 0; i < builder.numberOfDice; i++) {
            this.diceArray[i] = new Dice(builder.numberOfSides);
        }
        this.result = new SimulationResult(builder.numberOfDice * builder.numberOfSides);
    }

    /**
     * Esegue la simulazione dei lanci.
     */
    public void run() {
        for (int i = 0; i < numberOfRolls; i++) {
            int rollResult = rollDice();
            result.recordRoll(rollResult);
        }
        result.calculatePercentages(numberOfRolls);
    }

    /**
     * Lancia tutti i dadi e somma i risultati.
     * @return la somma dei risultati dei lanci.
     */
    private int rollDice() {
        int sum = 0;
        for (Dice dice : diceArray) {
            sum += dice.roll();
        }
        return sum;
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
        private int numberOfDice;

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

        public Builder setNumberOfDice(int numberOfDice) {
            if (numberOfDice <= 0) {
                throw new IllegalArgumentException("Il numero di dadi deve essere maggiore di zero.");
            }
            this.numberOfDice = numberOfDice;
            return this;
        }

        public DiceSimulation build() {
            return new DiceSimulation(this);
        }
    }
}
