import java.util.Random;

public class FireAlarm {
    public static void main(String[] args) {
        Random random = new Random();

        double heatThreshold = 65.0;
        double smokeThreshold = 70.0;

        System.out.println("=== Fire Alarm Simulation Started ===");

        for (int cycle = 1; cycle <= 10; cycle++) {
            double heatLevel = 20 + random.nextDouble() * 80;   // 20 to 100
            double smokeLevel = 10 + random.nextDouble() * 90;  // 10 to 100

            System.out.println("\nCycle " + cycle);
            System.out.printf("Heat Level: %.2f C%n", heatLevel);
            System.out.printf("Smoke Level: %.2f %% %n", smokeLevel);

            if (heatLevel >= heatThreshold && smokeLevel >= smokeThreshold) {
                System.out.println("ALARM! FIRE DETECTED! Evacuate immediately!");
            } else if (heatLevel >= heatThreshold || smokeLevel >= smokeThreshold) {
                System.out.println("Warning: Possible fire condition. Monitoring closely...");
            } else {
                System.out.println("Status: Safe. No fire detected.");
            }
        }

        System.out.println("\n=== Simulation Ended ===");
    }
}
