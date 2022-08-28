package chapter6;

public class ItemizedBill {

    public static void main(String args[]){

        PhoneBill yourBill = new PhoneBill(123, 100, 20, 30);
     //   yourBill = yourBill.getBill();
        yourBill.printBill();
    }
}
