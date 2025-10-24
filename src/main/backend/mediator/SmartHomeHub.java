package main.backend.mediator;

import java.util.*;
import main.backend.commands.Command;
import main.backend.devices.Device;

public class SmartHomeHub {
    private static SmartHomeHub instance;
    private List<Device> devices = new ArrayList<>();

    private SmartHomeHub() {} // Singleton

    public static SmartHomeHub getInstance() {
        if (instance == null)
            instance = new SmartHomeHub();
        return instance;
    }

    public void registerDevice(Device device) {
        devices.add(device);
        System.out.println(device.getName() + " registered ✅");
    }

    public void executeCommand(Command cmd) {
        cmd.execute();
    }

    public void showAllDevices() {
        System.out.println("\nConnected Devices:");
        for (Device d : devices) {
            System.out.println("- " + d.getName());
        }
    }
}
