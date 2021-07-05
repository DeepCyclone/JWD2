package by.epamtc.jwd.voloshchik.task1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import by.epamtc.jwd.voloshchik.task1.services.Operations;

public class Basket implements Iterable<Ball>, Serializable {
    private final List<Ball> balls;
    public final double weightLimit;
    private static final double MAX_WEIGHT = 100.00;
    public Basket() {
        this(MAX_WEIGHT);
    }

    public Basket(double maxWeight) {
        balls = new ArrayList<Ball>();
        weightLimit = maxWeight;
    }

    public boolean addBall(Ball ball) {
        if(ball == null ||
                !isUniqueBall(ball) ||
                !isPossibleToAdd(ball) ||
                ball.getWeight() <= 0) {
            return false;
        }
        return balls.add(ball);
    }

    public void addBalls(List<Ball> balls) {
        for(Ball ball:balls) {
            addBall(ball);
        }
    }
    public boolean removeBall(Ball ball) {
        return balls.remove(ball);
    }
    public Ball getBall(double weight,Color color){
        for(Ball ball:balls) {
            if(ball.getColor() == color && Double.hashCode(ball.getWeight()) == Double.hashCode(weight)) {
                return ball;
            }
        }
        return null;
    }
    private boolean isUniqueBall(Ball ball) {
        boolean uniqueStatus = true;
        for(Ball b:balls) {
            if(ball == b) {
                uniqueStatus = false;
                break;
            }
        }
        return uniqueStatus;
    }

    private boolean isPossibleToAdd(Ball ball) {
        boolean isPossible = true;
        if(Operations.calculateBallsWeight(this) + ball.getWeight() >= weightLimit) {
            isPossible = false;
        }
        return isPossible;
    }

    public Iterator<Ball> iterator() {
        return new Iterator<Ball>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < balls.size();
            }

            @Override
            public Ball next() {
                Ball element = balls.get(cursor);
                ++cursor;
                return element;
            }
        };
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        for(Ball ball:balls) {
            result = result * prime + (ball == null?0:ball.hashCode());
        }
        result = result * prime * Double.hashCode(weightLimit);
        return result;
    }

    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(getClass() != obj.getClass())return false;
        if(this != obj)return false;
        Basket basket = (Basket) obj;
        return balls.equals(basket.balls) &&
                Double.compare(weightLimit,basket.weightLimit) == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classname " + getClass().getSimpleName());
        sb.append("\nBalls in this " + getClass().getSimpleName() +   " - "  + balls.size() + "\n");
        for(Ball ball:balls) {
            sb.append("Ball:");
            sb.append(ball.getColor());
            sb.append("|");
            sb.append(ball.getWeight());
            sb.append("\n");
        }
        return sb.toString();
    }
}
