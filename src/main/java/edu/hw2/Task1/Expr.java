package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(double number) implements Expr {
        public Negate(Expr numb) {
            this(numb.evaluate());
        }

        @Override
        public double evaluate() {
            return number > 0 ? number * -1 : number;
        }
    }

    public record Exponent(double base, double exp) implements Expr {
        public Exponent(Expr first, double second) {
            this(first.evaluate(), second);
        }

        public Exponent(Expr first, Expr second) {
            this(first.evaluate(), second.evaluate());
        }

        public Exponent(double first, Expr second) {
            this(first, second.evaluate());
        }

        @Override
        public double evaluate() {
            return Math.pow(base, exp);
        }
    }

    public record Addition(double first, double second) implements Expr {
        public Addition(Expr first, Expr second) {
            this(first.evaluate(), second.evaluate());
        }

        public Addition(Expr first, double second) {
            this(first.evaluate(), second);
        }

        public Addition(double first, Expr second) {
            this(second, first);
        }

        @Override
        public double evaluate() {
            return first + second;
        }
    }

    public record Multiplication(double first, double second) implements Expr {

        public Multiplication(Expr first, Expr second) {
            this(first.evaluate(), second.evaluate());
        }

        public Multiplication(Expr first, double second) {
            this(first.evaluate(), second);
        }

        public Multiplication(double first, Expr second) {
            this(second, first);
        }

        @Override
        public double evaluate() {
            return first * second;
        }
    }
}


