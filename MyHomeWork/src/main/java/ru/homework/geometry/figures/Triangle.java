package ru.homework.geometry.figures;

public class Triangle {
    private double side_a;
    private double side_b;
    private double side_c;

    public Triangle(double a, double b, double c) {
        this.side_a = a;
        this.side_b = b;
        this.side_c = c;
    }

    public void printProperties() {
        var text = String.format("Triangle is %f x %f x %f", this.side_a, this.side_b, this.side_c);
        System.out.println(text);
    }

    public double perimeter() {
        return this.side_a + this.side_b + this.side_c;
    }

    public double area() {
        var p = this.perimeter() / 2;
        var s = Math.sqrt(p * (p - this.side_a)
                            * (p - this.side_b)
                            * (p - this.side_c)
                         );
        return s;
    }
}
