package chapter9;

public class InheritanceTester {

    public static void main(String args[]){

 /*       Rectangle rectangle = new Rectangle();
        rectangle.print();
        Square square = new Square();
        square.print("Square");*/
        Mother mom = new Mother();
        mom.setName("bjarne");
        System.out.println(mom.getName() + " is a " + mom.getGender());
    }
    public static void testSquareOverride(){
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(4);
        rectangle.setWidth(8);
        System.out.println(rectangle.calculatePerimeter());

        Square square = new Square();
        square.setLength(5);
        square.setWidth(10);
        System.out.println(square.calculatePerimeter());
    }
}
