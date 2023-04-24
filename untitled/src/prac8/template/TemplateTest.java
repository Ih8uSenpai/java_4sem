package prac8.template;

abstract class Car {
    abstract void startEngine();
    abstract void stopEngine();

    public final void start(){
        startEngine();
        stopEngine();
    }
}
class FirstCar extends Car {
    public void startEngine() {
        System.out.println("Start engine 1");
    }
    public void stopEngine() {
        System.out.println("Stop engine 1");
    }
}
class SecondCar extends Car {
    public void startEngine() {
        System.out.println("Start engine 2");
    }
    public void stopEngine() {
        System.out.println("Stop engine 2");
    }
}

public class TemplateTest {//тест
    public static void main(String[] args) {
        Car car1 = new FirstCar();
        car1.start();
        System.out.println();
        Car car2 = new SecondCar();
        car2.start();
    }
}