package by.epamtc.jwd.voloshchik.task1.services;

import by.epamtc.jwd.voloshchik.task1.bean.Ball;
import by.epamtc.jwd.voloshchik.task1.bean.Basket;
import by.epamtc.jwd.voloshchik.task1.bean.Color;

public class Operations {
    public static double calculateBallsWeight(Basket basket) {
        if(basket == null) {
            return 0;
        }
        double weight = 0;
        for(Ball ball:basket) {
            weight+=ball.getWeight();
        }
        return weight;
    }
    public static int determineCertainBallsAmount(Basket basket, Color color) {
        if(basket == null || color == null) {
            return 0;
        }
        int amount = 0;
        for(Ball ball:basket) {
            if(ball.getColor() == color) {
                ++amount;
            }
        }
        return amount;
    }
}
