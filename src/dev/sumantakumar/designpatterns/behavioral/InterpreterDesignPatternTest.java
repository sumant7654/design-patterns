package dev.sumantakumar.designpatterns.behavioral;

public class InterpreterDesignPatternTest {
    public static void main(String[] args) {
        Number five = new Number(5);
        Number three = new Number(3);
        Number two = new Number(2);
        Number one = new Number(1);


        Expression add1 = new Add(five, three);
        Expression add2 = new Add(one, two);
        Expression subtract = new Subtract(add1, add2);
        System.out.println("Result:"+subtract.interpret());

    }
}

interface Expression {
    int interpret();
}

class Number implements Expression {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return this.number;
    }
}

class Add implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;

    public Add(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() + rightExpression.interpret();
    }
}

class Subtract implements Expression {
    private final Expression leftExpression;
    private final Expression rightExpression;
    public Subtract(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret() {
        return leftExpression.interpret() - rightExpression.interpret();
    }
}