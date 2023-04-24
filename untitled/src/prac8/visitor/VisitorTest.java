package prac8.visitor;

interface Visitor {
    void visit(SportCar sportCar);
    void visit(Engine engine);
    void visit(Wheel wheel);
}
interface Car {
    void accept(Visitor visitor);
}
class Engine implements Car {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class Wheel implements Car {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class SportCar implements Car {
    Car[] cars;
    public SportCar(){
        cars = new Car[]{new Engine(), new Wheel()};
    }
    public void accept(Visitor visitor) {
        for (int i = 0; i < cars.length; i++) {
            cars[i].accept(visitor);
        }
        visitor.visit(this);
    }
}
class CarVisitor implements Visitor {
    public void visit(SportCar sportCar) {
        print("car");
    }
    public void visit(Engine engine) {
        print("engine");
    }
    public void visit(Wheel wheel) {
        print("wheel");
    }
    private void print(String string) {
        System.out.println(string);
    }
}

public class VisitorTest {//тест
    public static void main(String[] args) {
        Car sportCar = new SportCar();
        sportCar.accept(new CarVisitor());
    }
}