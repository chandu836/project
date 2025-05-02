package arbitraryarithmetic;

public class AFloat {

    String value;

    public AFloat() {
        this.value = "0.0";
    }

    public AFloat(String s) {
        this.value = s;
    }

    public AFloat(AFloat other) {
        this.value = other.value;
    }

    public static AFloat parse(String s) {
        return new AFloat(s);
    }

    @Override
    public String toString() {
        return this.value;
    }

    public AFloat add(AFloat other) {
        String num1 = this.value;
        String num2 = other.value;

        boolean isNeg1 = num1.startsWith("-");
        boolean isNeg2 = num2.startsWith("-");

        if (isNeg1) {
            num1 = num1.substring(1);
        }
        if (isNeg2) {
            num2 = num2.substring(1);
        }

        if (isNeg1 && isNeg2) {
            return new AFloat("-" + new AFloat(num1).add(new AFloat(num2)).value);
        } else if (isNeg1) {
            return new AFloat(new AFloat(num2).subtract(new AFloat(num1)).value);
        } else if (isNeg2) {
            return new AFloat(new AFloat(num1).subtract(new AFloat(num2)).value);
        }

        int i, j;
        for (i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) == '.') {
                break;
            }
        }
        String deci1;
        if (i < num1.length() - 1) {
            deci1 = num1.substring(i + 1);
        } else {
            deci1 = "0";
        }

        for (j = 0; j < num2.length(); j++) {
            if (num2.charAt(j) == '.') {
                break;
            }
        }
        String deci2;
        if (j < num2.length() - 1) {
            deci2 = num2.substring(j + 1);
        } else {
            deci2 = "0";
        }
        String dum = "";

        if (deci1.length() > deci2.length()) {
            for (int k = 0; k < deci1.length() - deci2.length(); k++) {
                dum = dum + "0";
            }
            deci2 += dum;
        } else if (deci1.length() < deci2.length()) {
            for (int k = 0; k < deci2.length() - deci1.length(); k++) {
                dum = dum + "0";
            }
            deci1 += dum;
        }
        String in1 = num1.substring(0, i) + deci1;
        String in2 = num2.substring(0, j) + deci2;
        AInteger result_in = new AInteger(in1).add(new AInteger(in2));
        if (result_in.value.equals("0")) {
            return new AFloat("0.0");
        }
        while (result_in.value.length() <= deci1.length()) {
            result_in.value = "0" + result_in.value;
        }
        int dot = result_in.value.length() - deci1.length();
        String result = result_in.value.substring(0, dot) + "." + result_in.value.substring(dot);

        int a = result.length() - 1;
        while (a >= 0 && result.charAt(a) == '0') {
            a--;
        }
        if (result.charAt(a) == '.') {
            result = result.substring(0, a + 2);
        } else {
            result = result.substring(0, a + 1);
        }

        return new AFloat(result);
    }

    public AFloat subtract(AFloat other) {
        String num1 = this.value;
        String num2 = other.value;

        boolean isNeg1 = num1.startsWith("-");
        boolean isNeg2 = num2.startsWith("-");

        if (isNeg1) {
            num1 = num1.substring(1);
        }
        if (isNeg2) {
            num2 = num2.substring(1);
        }

        if (isNeg1 && isNeg2) {
            return new AFloat(num2).subtract(new AFloat(num1));
        } else if (isNeg1 && !isNeg2) {
            return new AFloat("-" + new AFloat(num1).add(new AFloat(num2)).value);
        } else if (!isNeg1 && isNeg2) {
            return new AFloat(new AFloat(num1).add(new AFloat(num2)).value);
        }
        int i, j;
        for (i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) == '.') {
                break;
            }
        }
        String deci1;
        if (i < num1.length() - 1) {
            deci1 = num1.substring(i + 1);
        } else {
            deci1 = "0";
        }

        for (j = 0; j < num2.length(); j++) {
            if (num2.charAt(j) == '.') {
                break;
            }
        }
        String deci2;
        if (j < num2.length() - 1) {
            deci2 = num2.substring(j + 1);
        } else {
            deci2 = "0";
        }
        String dum = "";

        if (deci1.length() > deci2.length()) {
            for (int k = 0; k < deci1.length() - deci2.length(); k++) {
                dum = dum + "0";
            }
            deci2 += dum;
        } else if (deci1.length() < deci2.length()) {
            for (int k = 0; k < deci2.length() - deci1.length(); k++) {
                dum = dum + "0";
            }
            deci1 += dum;
        }
        String in1 = num1.substring(0, i) + deci1;
        String in2 = num2.substring(0, j) + deci2;
        AInteger result_in = new AInteger(in1).subtract(new AInteger(in2));
        if (result_in.value.equals("0")) {
            return new AFloat("0.0");
        }
        while (result_in.value.length() <= deci1.length()) {
            result_in.value = "0" + result_in.value;
        }
        int dot = result_in.value.length() - deci1.length();
        String result = result_in.value.substring(0, dot) + "." + result_in.value.substring(dot);

        int a = result.length() - 1;
        while (a >= 0 && result.charAt(a) == '0') {
            a--;
        }
        if (result.charAt(a) == '.') {
            result = result.substring(0, a + 2);
        } else {
            result = result.substring(0, a + 1);
        }
        return new AFloat(result);
    }

    public AFloat multiply(AFloat other) {
        String num1 = this.value;
        String num2 = other.value;

        boolean isNeg1 = num1.startsWith("-");
        boolean isNeg2 = num2.startsWith("-");

        if (isNeg1) {
            num1 = num1.substring(1);
        }
        if (isNeg2) {
            num2 = num2.substring(1);
        }

        if (isNeg1 && isNeg2) {
            return new AFloat(num1).multiply(new AFloat(num2));
        } else if (isNeg1 && !isNeg2) {
            return new AFloat("-" + new AFloat(num1).multiply(new AFloat(num2)).value);
        } else if (!isNeg1 && isNeg2) {
            return new AFloat("-" + new AFloat(num1).multiply(new AFloat(num2)).value);
        }
        int i, j;
        for (i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) == '.') {
                break;
            }
        }
        String deci1;
        if (i < num1.length() - 1) {
            deci1 = num1.substring(i + 1);
        } else {
            deci1 = "0";
        }

        for (j = 0; j < num2.length(); j++) {
            if (num2.charAt(j) == '.') {
                break;
            }
        }
        String deci2;
        if (j < num2.length() - 1) {
            deci2 = num2.substring(j + 1);
        } else {
            deci2 = "0";
        }
        String dum = "";

        if (deci1.length() > deci2.length()) {
            for (int k = 0; k < deci1.length() - deci2.length(); k++) {
                dum = dum + "0";
            }
            deci2 += dum;
        } else if (deci1.length() < deci2.length()) {
            for (int k = 0; k < deci2.length() - deci1.length(); k++) {
                dum = dum + "0";
            }
            deci1 += dum;
        }
        String in1 = num1.substring(0, i) + deci1;
        String in2 = num2.substring(0, j) + deci2;
        AInteger result_in = new AInteger(in1).multiply(new AInteger(in2));
        if (result_in.value.equals("0")) {
            return new AFloat("0.0");
        }
        while (result_in.value.length() <= deci1.length() + deci2.length()) {
            result_in.value = "0" + result_in.value;
        }
        int dot = result_in.value.length() - (deci1.length() + deci2.length());
        String result = result_in.value.substring(0, dot) + "." + result_in.value.substring(dot);

        int a = result.length() - 1;
        while (a >= 0 && result.charAt(a) == '0') {
            a--;
        }
        if (result.charAt(a) == '.') {
            result = result.substring(0, a + 2);
        } else {
            result = result.substring(0, a + 1);
        }
        return new AFloat(result);
    }

    public AFloat div(AFloat other) {
        String num1 = this.value;
        String num2 = other.value;

        if (num2.equals("0.0") || num2.equals("-0.0") || num2.equals("0")) {
            throw new ArithmeticException("Division by zero");
        }

        boolean isNeg1 = num1.startsWith("-");
        boolean isNeg2 = num2.startsWith("-");

        if (isNeg1) {
            num1 = num1.substring(1);
        }
        if (isNeg2) {
            num2 = num2.substring(1);
        }

        if (isNeg1 && isNeg2) {
            return new AFloat(num1).div(new AFloat(num2));
        } else if (isNeg1 && !isNeg2) {
            return new AFloat("-" + new AFloat(num1).div(new AFloat(num2)).value);
        } else if (!isNeg1 && isNeg2) {
            return new AFloat("-" + new AFloat(num1).div(new AFloat(num2)).value);
        }

        int i, j;
        for (i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) == '.') {
                break;
            }
        }
        String deci1;
        if (i < num1.length() - 1) {
            deci1 = num1.substring(i + 1);
        } else {
            deci1 = "0";
        }

        for (j = 0; j < num2.length(); j++) {
            if (num2.charAt(j) == '.') {
                break;
            }
        }
        String deci2;
        if (j < num2.length() - 1) {
            deci2 = num2.substring(j + 1);
        } else {
            deci2 = "0";
        }
        String dum = "";

        if (deci1.length() > deci2.length()) {
            for (int k = 0; k < deci1.length() - deci2.length(); k++) {
                dum = dum + "0";
            }
            deci2 += dum;
        } else if (deci1.length() < deci2.length()) {
            for (int k = 0; k < deci2.length() - deci1.length(); k++) {
                dum = dum + "0";
            }
            deci1 += dum;
        }
        String in1 = num1.substring(0, i) + deci1;
        String in2 = num2.substring(0, j) + deci2;
        AInteger result_in = new AInteger(in1).div(new AInteger(in2));

        StringBuilder re = new StringBuilder();
        re.append(result_in.value);
        String temp = new AInteger(result_in.value).multiply(new AInteger(in2)).value;
        String remainder = new AInteger(in1).subtract(new AInteger(temp)).value;

        if (!remainder.equals("0")) {
            re.append(".");
            int k = 30;
            while (k >= 0) {
                int m = 0;
                while (compare(remainder, in2) < 0) {
                    remainder += "0";
                    m++;
                }
                for (int n = 0; n < m - 1; n++) {
                    re.append("0");
                }
                int l = 0;
                while (compare(remainder, in2) >= 0) {
                    remainder = new AInteger(remainder).subtract(new AInteger(in2)).value;
                    l++;
                }
                re.append(l);
                if (remainder.equals("0")) {
                    break;
                }
                k--;
            }
        } else {
            re.append(".0");
        }
        return new AFloat(re.toString());
    }

    public int compare(String a, String b) {
        if (a.length() < b.length()) {
            return -1;
        }
        if (a.length() > b.length()) {
            return 1;
        }
        return a.compareTo(b);
    }
}
