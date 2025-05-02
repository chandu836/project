
import arbitraryarithmetic.AFloat;
import arbitraryarithmetic.AInteger;

public class MyInfArith {

    public static void main(String[] args) {
        if (args.length != 4) {
            System.out.println("Usage: java MyInfArith <int/float> <add/sub/mul/div> <operand1> <operand2>");
            return;
        }

        String type = args[0];
        String op = args[1];
        String op1 = args[2];
        String op2 = args[3];

        try {
            if (type.equals("int")) {
                AInteger a = new AInteger(op1);
                AInteger b = new AInteger(op2);
                AInteger result = null;

                switch (op) {
                    case "add":
                        result = a.add(b);
                        break;
                    case "sub":
                        result = a.subtract(b);
                        break;
                    case "mul":
                        result = a.multiply(b);
                        break;
                    case "div":
                        result = a.div(b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation");
                }

                System.out.println(result);
            } else if (type.equals("float")) {
                AFloat a = new AFloat(op1);
                AFloat b = new AFloat(op2);
                AFloat result = null;

                switch (op) {
                    case "add":
                        result = a.add(b);
                        break;
                    case "sub":
                        result = a.subtract(b);
                        break;
                    case "mul":
                        result = a.multiply(b);
                        break;
                    case "div":
                        result = a.div(b);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operation");
                }

                System.out.println(result);
            } else {
                System.out.println("Invalid type. Use 'int' or 'float'.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
