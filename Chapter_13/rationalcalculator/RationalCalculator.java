package rationalcalculator;

import testrationalclass.Rational;

public class RationalCalculator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Calculator String");
            System.exit(1);
        }
        Rational result = new Rational();
        String[] output = args[0].replaceAll(" ", "/").split("/");
        if(output.length == 5) {
            Rational n1 = new Rational(Integer.parseInt(output[0]), Integer.parseInt(output[1]));
            Rational n2 = new Rational(Integer.parseInt(output[3]), Integer.parseInt(output[4]));
            calculate(n1, n2, result, output[2]);
        }
        else if(output.length > 5) {
            Rational n1 = new Rational(Integer.parseInt(output[0]), Integer.parseInt(output[1]));
            Rational n2 = new Rational(Integer.parseInt(output[4]), Integer.parseInt(output[5]));
            calculate(n1, n2, result, "/");
        }
    }
    
    public static void calculate(Rational n1, Rational n2, Rational result, String sign) {
        switch (sign.charAt(0)) { 
            case '+': result = n1.add(n2);
                      break;
            case '-': result = n1.subtract(n2);
                      break;
            case '.': result = n1.multiply(n2);
                      break;
            case '/': result = n1.divide(n2);
                      break;
            default : System.out.println("Illegal Argument: +-./");
                      System.exit(1);
        }
        System.out.println("" + n1 + ' ' + sign + ' ' + n2 + " = " + result);
    }
}
