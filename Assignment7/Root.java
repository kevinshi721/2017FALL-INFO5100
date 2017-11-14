package com.kevinshi721.Assignment7;

public class Root {

    public static void main(String[] args) {

        Device device = new Device();
        Sensor heat = new Sensor(device);
        Sensor pressure = new Sensor(device);

        Controller controller = new Controller(device,heat,pressure);

        controller.start();
        heat.start();
        pressure.start();

    }
}

class Device {

    public void startup() {
        System.out.println("Device is starting");
    }
    public void shutdown() {
        System.out.println(" is shutting down and exit");
    }
}

class Sensor extends Thread{

    private final Device device;
    private double value;

    public Sensor(Device device) {
        this.device = device;
    }
    public double getValue() {
        return value;
    }
    public void updateValue() {
        this.value += 0.01;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (device) {
                updateValue();
                device.notify();
            }
        }
    }
}

class Controller extends Thread{

    private Device device;
    private Sensor heat;
    private Sensor pressure;

    public Controller(Device device, Sensor heat, Sensor pressure) {
        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
    }

    @Override
    public void run() {
        device.startup();
        synchronized (device){
            while (true) {
                try {
                    device.wait();
                } catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                System.out.println("Heat: " + heat.getValue());
                System.out.println("Pressure: " + pressure.getValue());
                if (heat.getValue() > 70 || pressure.getValue() > 100){
                    device.shutdown();
                    break;
                }
            }
        }
    }
}