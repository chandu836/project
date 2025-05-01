package arbitraryarithmetic;

public class AInteger {

    String value;

    public AInteger() {
        this.value = "0";
    }

    public AInteger(String s) {
        this.value = s;
    }

    public AInteger(AInteger other) {
        this.value = other.value;
    }

    public static AInteger parse(String s) {
        return new AInteger(s);
    }

    @Override
    public String toString() {
        return this.value;
    }

    public AInteger add(AInteger other) {
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
            return new AInteger("-" + new AInteger(num1).add(new AInteger(num2)).value);
        } else if (isNeg1) {
            return new AInteger(num2).subtract(new AInteger(num1));
        } else if (isNeg2) {
            return new AInteger(num1).subtract(new AInteger(num2));
        }

        int len1 = num1.length();
        int len2 = num2.length();
        String dum = "";
        if (len1 > len2) {
            for (int i = 0; i < (len1 - len2); i++) {
                dum = dum + "0";
            }
            num2 = dum + num2;
        } else if (len2 > len1) {
            for (int i = 0; i < (len2 - len1); i++) {
                dum = dum + "0";
            }
            num1 = dum + num1;
        }

        int[] digits1 = new int[num1.length()];
        int[] digits2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            digits1[i] = num1.charAt(i) - '0';
            digits2[i] = num2.charAt(i) - '0';
        }
        int[] sum = new int[num1.length() + 1];
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int temp = digits1[i] + digits2[i] + carry;
            sum[i + 1] = temp % 10;
            carry = temp / 10;
        }
        if (carry != 0) {
            sum[0] = carry;
        }
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (k < sum.length) {
            if (sum[k] != 0) {
                break;
            }
            k++;
        }
        if (k == sum.length) {
            k -= 1;
        }
        for (int i = k; i < sum.length; i++) {
            sb.append(sum[i]);
        }
        String result = sb.toString();

        return new AInteger(result);
    }

    public AInteger subtract(AInteger other) {
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
        if (!isNeg1 && isNeg2) {
            return new AInteger(num1).add(new AInteger(num2));
        } else if (isNeg1 && !isNeg2) {
            return new AInteger("-" + new AInteger(num1).add(new AInteger(num2)).value);
        } else if (isNeg1 && isNeg2) {
            return new AInteger(num2).subtract(new AInteger(num1));
        }

        boolean isNegative = false;
        if (num1.length() < num2.length() || (num1.length() == num2.length() && num1.compareTo(num2) < 0)) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
            isNegative = true;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        String dum = "";
        if (len1 > len2) {
            for (int i = 0; i < (len1 - len2); i++) {
                dum = dum + "0";
            }
            num2 = dum + num2;
        } else if (len2 > len1) {
            for (int i = 0; i < (len2 - len1); i++) {
                dum = dum + "0";
            }
            num1 = dum + num1;
        }

        int[] digits1 = new int[num1.length()];
        int[] digits2 = new int[num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            digits1[i] = num1.charAt(i) - '0';
            digits2[i] = num2.charAt(i) - '0';
        }
        int[] sub = new int[num1.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            if (digits1[i] >= digits2[i]) {
                int temp = digits1[i] - digits2[i];
                sub[i] = temp;
            } else {
                digits1[i] += 10;
                digits1[i - 1] -= 1;
                int temp = digits1[i] - digits2[i];
                sub[i] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        int k = 0;
        while (k < sub.length) {
            if (sub[k] != 0) {
                break;
            }
            k++;
        }
        if (k == sub.length) {
            k -= 1;
        }
        for (int i = k; i < sub.length; i++) {
            sb.append(sub[i]);
        }
        String result = sb.toString();

        if (result.length() == 0 || result.equals("-0")) {
            return new AInteger("0");
        }
        if (isNegative) {
            result = "-" + result;
        }
        return new AInteger(result);
    }

    public AInteger multiply(AInteger other) {
        String num1 = this.value;
        String num2 = other.value;
        if (other.value.equals("0") || other.value.equals("00")) {
            return new AInteger("0");
        }

        boolean isNeg1 = num1.startsWith("-");
        boolean isNeg2 = num2.startsWith("-");

        if (isNeg1) {
            num1 = num1.substring(1);
        }
        if (isNeg2) {
            num2 = num2.substring(1);
        }
        if ((isNeg1 && !isNeg2) || (!isNeg1 && isNeg2)) {
            return new AInteger("-" + new AInteger(num1).multiply(new AInteger(num2)).value);
        } else if (isNeg1 && isNeg2) {
            return new AInteger(num2).multiply(new AInteger(num1));
        }

        int len2 = num2.length();
        int[] digits2 = new int[num2.length()];
        for (int i = 0; i < num2.length(); i++) {
            digits2[i] = num2.charAt(i) - '0';
        }
        String result = "0";
        for (int j = len2 - 1; j >= 0; j--) {
            String sum = "0";
            for (int k = 0; k < digits2[j]; k++) {
                sum = new AInteger(sum).add(new AInteger(num1)).value;
            }
            String dum = "";
            for (int i = j; i < len2 - 1; i++) {
                dum += "0";
            }
            sum += dum;
            result = new AInteger(result).add(new AInteger(sum)).value;
        }
        if (result.length() == 0) {
            return new AInteger("0");
        }
        return new AInteger(result);
    }

    public AInteger div(AInteger other) {
        String num1 = this.value;
        String num2 = other.value;

        if (num2.equals("0") || num2.equals("-0")) {
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
        if ((isNeg1 && !isNeg2) || (!isNeg1 && isNeg2)) {
            return new AInteger("-" + new AInteger(num1).div(new AInteger(num2)).value);
        } else if (isNeg1 && isNeg2) {
            return new AInteger(num2).div(new AInteger(num1));
        }

        if (compare(num1, num2) < 0) {
            return new AInteger("0");
        }

        StringBuilder re = new StringBuilder();
        int i = 0;
        while (compare(num1, num2) >= 0) {
            num1 = new AInteger(num1).subtract(new AInteger(num2)).value;
            i++;
        }
        re.append(i);

        String result = re.toString();
        return new AInteger(result);
    }

    private int compare(String a, String b) {
        StringBuilder a_sb = new StringBuilder();
        int k = 0;
        while (k < a.length()) {
            if (a.charAt(k) != '0') {
                break;
            }
            k++;
        }
        for (int i = k; i < a.length(); i++) {
            a_sb.append(a.charAt(i));
        }
        String result1 = a_sb.toString();

        StringBuilder b_sb = new StringBuilder();
        k = 0;
        while (k < b.length()) {
            if (b.charAt(k) != '0') {
                break;
            }
            k++;
        }
        for (int i = k; i < b.length(); i++) {
            b_sb.append(b.charAt(i));
        }
        b = b_sb.toString();

        if (result1.length() != b.length()) {
            return result1.length() - b.length();
        }
        return result1.compareTo(b);
    }
}
