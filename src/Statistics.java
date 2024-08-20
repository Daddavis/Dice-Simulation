/**
 * Classe per calcolare le statistiche di una serie di lanci di dado.
 */
public class Statistics {
    private double mean; // Media dei risultati
    private double variance; // Varianza dei risultati
    private double standardDeviation; // Deviazione standard

    /**
     * Calcola la media, la varianza e la deviazione standard.
     * @param results array delle frequenze dei risultati.
     */
    public void calculate(int[] results) {
        int sum = 0;
        
        for (int result : results) {
            sum += result;
        }

        this.mean = (double) sum / results.length;

        double sumOfSquares = 0.0;
        for (int result : results) {
            sumOfSquares += Math.pow(result - mean, 2);
        }

        this.variance = sumOfSquares / results.length;
        this.standardDeviation = Math.sqrt(variance);
    }

    public void display() {
        System.out.printf("Media: %.2f%n", mean);
        System.out.printf("Varianza: %.2f%n", variance);
        System.out.printf("Deviazione Standard: %.2f%n", standardDeviation);
    }

    public double getMean() {
        return mean;
    }

    public double getVariance() {
        return variance;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }
}
