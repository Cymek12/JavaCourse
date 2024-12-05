package polimorfizm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(new Circle(2.5));
        shapeList.add(new Circle(5.5));
        shapeList.add(new Rectangle(5.5, 7.2));
        shapeList.add(new Rectangle(1.5, 4.2));

        for (Shape shape : shapeList) {
            System.out.println("Pole obiektu = " + shape.calculate());
        }
    }
}
