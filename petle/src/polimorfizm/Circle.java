package polimorfizm;

public class Circle extends Shape{
    static double PI = 3.14;
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }


    @Override
    public double calculate() {
        return PI * r * r;
    }
}
