package by.epamtc.jwd.voloshchik.task1.runner;

import by.epamtc.jwd.voloshchik.task1.bean.*;
import by.epamtc.jwd.voloshchik.task1.services.*;
public class Run {
    public static void main(String[] args) {
        Basket bask2 = new Basket();
        Ball ball1 = new Ball(13.5, Color.BLUE);
        Ball ball2 = new Ball(52.4,Color.BLUE);
        Ball ball3 = new Ball(12.1,Color.RED);
        bask2.addBall(ball1);
        bask2.addBall(ball2);
        bask2.addBall(ball3);
        System.out.println(Operations.calculateBallsWeight(bask2));
        System.out.println(Operations.determineCertainBallsAmount(bask2,Color.BLUE));
    }
}
