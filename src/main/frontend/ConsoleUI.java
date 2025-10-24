package main.frontend;

import java.util.Scanner;
import main.backend.devices.*;
import main.backend.commands.*;
import main.backend.mediator.SmartHomeHub;

public class ConsoleUI {
    public void start() {
        SmartHomeHub hub = SmartHomeHub.getInstance();
        Light light = new Light("Living Room");
        Thermostat thermostat = new Thermostat("Bedroom");
        Camera camera = new Camera("Garden");

        hub.registerDevice(light);
        hub.registerDevice(thermostat);
        hub.registerDevice(camera);

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== SMART HOME MENU ====");
            System.out.println("1. Turn on Light");
            System.out.println("2. Turn off Light");
            System.out.println("3. Set Thermostat Temperature");
            System.out.println("4. Turn on Camera");
            System.out.println("5. Turn off Camera");
            System.out.println("6. Show all devices");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> hub.executeCommand(new TurnOnCommand(light));
                case 2 -> hub.executeCommand(new TurnOffCommand(light));
                case 3 -> {
                    System.out.print("Enter new temperature: ");
                    int temp = sc.nextInt();
                    hub.executeCommand(new SetTemperatureCommand(thermostat, temp));
                }
                case 4 -> hub.executeCommand(new TurnOnCommand(camera));
                case 5 -> hub.executeCommand(new TurnOffCommand(camera));
                case 6 -> hub.showAllDevices();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 0);
        sc.close();
    }
}
