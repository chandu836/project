
import arbitraryarithmetic.AInteger;

public class Test {

    public static void main(String[] args) {
        AInteger num1 = new AInteger("12345678901234567890");
        AInteger num2 = new AInteger("98765432109876543210");
        AInteger result = num2.subtract(num1);
        System.out.println("Sum: " + result);
    }
}
