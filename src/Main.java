/**
 * Classe principale per eseguire la simulazione di lanci di dado.
 */
public class Main {
    public static void main(String[] args) {
        // Configura la simulazione per lanciare 3 dadi a 6 facce 60 volte
        DiceSimulation simulation = new DiceSimulation.Builder()
                .setNumberOfRolls(60)  // Numero di lanci
                .setNumberOfSides(6)   // Numero di lati del dado
                .setNumberOfDice(2)    // Numero di dadi da lanciare
                .build();

        simulation.run();

        // Ottieni e mostra i risultati
        SimulationResult result = simulation.getResult();
        Statistics statistics = new Statistics();
        statistics.calculate(result.getRollFrequencies());

        displayResults(simulation, result, statistics);
    }

    /**
     * Mostra i risultati della simulazione e le statistiche calcolate.
     */
    private static void displayResults(DiceSimulation simulation, SimulationResult result, Statistics statistics) {
        System.out.println("Numero di lanci: " + simulation.getNumberOfRolls());
        for (int i = 0; i < result.getRollFrequencies().length; i++) {
            System.out.printf("Risultato %d: %d lanci (%.2f%%)%n", i + 1, result.getRollFrequencies()[i], result.getRollPercentages()[i]);
        }

        statistics.display();
        displayHistogram(result);
    }

    /**
     * Visualizza un istogramma dei risultati.
     */
    private static void displayHistogram(SimulationResult result) {
        System.out.println("\nIstogramma:");
        for (int i = 0; i < result.getRollFrequencies().length; i++) {
            System.out.print((i + 1) + ": ");
            int barLength = (int) (result.getRollPercentages()[i]);
            for (int j = 0; j < barLength; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
