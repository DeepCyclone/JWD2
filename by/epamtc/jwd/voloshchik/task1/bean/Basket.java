package by.epamtc.jwd.voloshchik.task1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket implements Iterable<Ball>, Serializable {
    private List<Ball> balls;
    private double ballsWeight;
    private double weightLimit;
    private static final double MAX_WEIGHT = 100.00;
    public Basket() {
        balls = new ArrayList<Ball>();
        weightLimit = MAX_WEIGHT;
    }

    public Basket(double maxWeight) {
        balls = new ArrayList<Ball>();
        weightLimit = maxWeight;
    }

    public void addBall(Ball ball) {
        if(ball == null ||
                !isUniqueBall(ball) ||
                !isPossibleToAdd(ball) ||
                ball.getWeight() <= 0) {
            return;
        }
        balls.add(ball);
        ballsWeight += ball.getWeight();
    }

    public void addBalls(List<Ball> balls) {
        for(Ball ball:balls) {
            addBall(ball);
        }
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
        if(ballsWeight + ball.getWeight() >= weightLimit) {
            isPossible = false;
        }
        return isPossible;
    }

    public Iterator<Ball> iterator() {
        return balls.iterator();
    }

    public int hashCode() {
        int result = 0;
        result += 31 * balls.hashCode();
        result += 31 * Double.hashCode(weightLimit);
        return result;
    }

    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(getClass() != obj.getClass())return false;
        if(this != obj)return false;
        Basket basket = (Basket) obj;
        return balls.equals(basket.balls) &&
                Double.hashCode(weightLimit) == Double.hashCode(basket.weightLimit);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Classname " + getClass().getSimpleName());
        sb.append("\nBalls in this basket - " + balls.size() + "\n");
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
