package main.backend.devices;

public class Light implements Device {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " light turned ON 💡");
    }

    @Override
    public void turnOff() {
        System.out.println(name + " light turned OFF 💤");
    }

    @Override
    public String getName() {
        return name;
    }
}
