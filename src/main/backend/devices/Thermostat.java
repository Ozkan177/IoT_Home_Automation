package main.backend.devices;

public class Thermostat implements Device {
    private String name;
    private int temperature = 22;

    public Thermostat(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " thermostat is active 🌡️");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " thermostat turned off 📴");
    }

    public void setTemperature(int t) {
        temperature = t;
        System.out.println(name + " temperature set to " + t + "°C 🌡️");
    }

    @Override
    public String getName() {
        return name;
    }
}
