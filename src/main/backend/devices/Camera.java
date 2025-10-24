package main.backend.devices;

public class Camera implements Device {
    private String name;

    public Camera(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " camera started recording 🎥");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " camera turned off 🔒");
    }

    @Override
    public String getName() {
        return name;
    }
}
