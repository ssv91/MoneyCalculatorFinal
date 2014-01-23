package Model;

public class Number {

    private int numerator;
    private int denominator;

    public Number(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Number(Number number) {
        this.numerator = number.getNumerator();
        this.denominator = number.getDenominator();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    

    public Number(int number) {
        this.numerator = number;
        this.denominator = 1;
    }

    public Number(long number) {
        this.numerator = (int) number;
        this.denominator = 1;
    }

    public Number(double number) {
        this.numerator = (int) number;
        this.denominator = 1;
        while (number != numerator) {
            number *= 10;
            denominator *= 10;
            numerator = (int) number;
        }
        reduce();
    }

    public Number add(Number number) {
        if (this.denominator == number.denominator) {
            return new Number(numerator + number.numerator, number.denominator);
        } else {
            return new Number (minimoComunMultiplo(this,number).numerator + minimoComunMultiplo(number,this).numerator,
                               minimoComunMultiplo(number,this).denominator); 
        }
    }

    public Number multiply(Number factorA) {
        Number result;
        result = new Number(factorA.numerator * numerator, factorA.denominator * denominator);
        result.reduce();
        return result;
    }

    public Number divide(Number dividend, Number divisor) {
        return new Number(dividend.numerator * divisor.denominator, dividend.denominator * divisor.denominator);
    }

    private int[] getPrimeNumbers() {
        return new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23};
    }

    private boolean isDivisible(int number) {
        return ((numerator % number == 0) & denominator % number == 0);
    }

    private void reduce() {
        int[] primeNumbers = getPrimeNumbers();
        for (int Number : primeNumbers) {
            while (isDivisible(Number)) {
                numerator = numerator / Number;
                denominator = denominator / Number;
            }
        }
    }

    private Number minimoComunMultiplo(Number numberA, Number numberB) {
        return new Number(numberA.numerator*numberB.denominator,numberA.denominator*numberB.denominator);
    }

    @Override
    public String toString() {
        return numerator + " / " + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Number other = (Number) obj;
        if (this.numerator != other.numerator) {
            return false;
        }
        if (this.denominator != other.denominator) {
            return false;
        }
        return true;
    }
    
    
    
}

