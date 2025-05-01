package arbitraryarithmetic;

public class Main {

    public static void main(String[] args) {
        AInteger num1 = new AInteger("2345");
        AInteger num2 = new AInteger("555");
        AInteger sum = num1.div(num2);
        System.out.println("Sum: " + sum.value);

        AFloat f1 = new AFloat("23455789.026");
        AFloat f2 = new AFloat("56.78");
        AFloat fSum = f1.div(f2);
        System.out.println("Float Sum: " + fSum.value);
    }
}
