package chapter11;

public class ShapeTester {

    public static void main(String args[]){

        Shape rectangle = new Rectangle(20, 50);
        rectangle.print();
        System.out.println(rectangle.calculateArea());
    }
}
