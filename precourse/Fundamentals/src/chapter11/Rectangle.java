package chapter11;

public class Rectangle extends Shape{


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    private double length;
    private double width;

    public Rectangle(double length, double width){
        setLength(length);
        setWidth(width);
    }
    @Override
    public double calculateArea(){
        return length * width;
    }
}
