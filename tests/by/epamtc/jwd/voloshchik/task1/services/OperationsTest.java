package by.epamtc.jwd.voloshchik.task1.services;

import by.epamtc.jwd.voloshchik.task1.bean.Ball;
import by.epamtc.jwd.voloshchik.task1.bean.Basket;
import by.epamtc.jwd.voloshchik.task1.bean.Color;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperationsTest {

    @Test
    public void calculateBallsWeightInEmptyBasket() {
        Basket a = new Basket();
        double expected = 0.0;
        double actual = Operations.calculateBallsWeight(a);
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void calculateBallsWeight() {
        Basket a = new Basket();
        a.addBall(new Ball(10.2, Color.BLUE));
        a.addBall(new Ball(10.3, Color.RED));
        double expected = 20.5;
        double actual = Operations.calculateBallsWeight(a);
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void calculateBallsWeightInNullBasket() {
        Basket a = null;
        double expected = 0.0;
        double actual = Operations.calculateBallsWeight(a);
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void determineCertainBallsAmount() {
        Basket a = new Basket();
        a.addBall(new Ball(10.2, Color.BLUE));
        a.addBall(new Ball(10.3, Color.RED));
        a.addBall(new Ball(10.5, Color.BLUE));
        int expected = 2;
        int actual = Operations.determineCertainBallsAmount(a,Color.BLUE);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void determineCertainBallsAmountInNullBasket() {
        Basket a = null;
        int expected = 0;
        int actual = Operations.determineCertainBallsAmount(a,Color.BLUE);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void determineCertainBallsAmountOfUndefinedColor() {
        Basket a = null;
        int expected = 0;
        int actual = Operations.determineCertainBallsAmount(a,null);
        Assert.assertEquals(expected,actual);
    }
}