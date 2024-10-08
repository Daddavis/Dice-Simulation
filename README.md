# Dice Simulation in Java

## Overview
This Java project simulates rolling one or more dice with a configurable number of sides and trials. It calculates and displays statistical data, including the mean, variance, and standard deviation, along with a visual histogram representing the frequency distribution.

## Project Structure
The project is structured as follows:


dice-simulation/ <br>
│ <br>
├── src/ <br>
│‎ ├── Dice.java <br>
│‎‎ ├── DiceSimulation.java <br>
│‎‎ ├── SimulationResult.java <br>
│‎‎ ├── Statistics.java <br>
│‎‎ ├── Main.java <br>
│ <br>
└── README.md <br>

## Features
- **Customizable Dice Simulation**: Set the number of sides on the dice, the number of rolls and the number of the dice.
- **Statistical Analysis**: Calculate and display mean, variance, and standard deviation.
- **Histogram Output**: Visual representation of frequency distribution using histograms.
- **Object-Oriented Design**: Modular code with separation of concerns.
- **Builder Pattern**: Simplifies the configuration and creation of simulations.

## Customization
- To modify the number of rolls, sides, and dice, edit the `Main` class in `Main.java`:<br>

   ```java
   DiceSimulation simulation = new DiceSimulation.Builder()
           .setNumberOfRolls(60)   // Set the number of dice rolls
           .setNumberOfSides(6)    // Set the number of sides on each die
           .setNumberOfDice(3)     // Set the number of dice to roll
           .build();


## Requirements
- **Java 8** or later.

## Running the Project
1. Clone the repository or download the source files.
2. Open the project folder in Visual Studio Code.
3. Compile the Java files:

   ```bash
   javac src/*.java
