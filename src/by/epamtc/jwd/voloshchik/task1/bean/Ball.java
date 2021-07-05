package by.epamtc.jwd.voloshchik.task1.bean;

import java.io.Serializable;

public class Ball implements Serializable {
    private Color color;
    private double weight;
    public Ball() {

    }

    public Ball(double weight,Color color) {
        this.weight = weight;
        this.color = color;
    }

    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(getClass() != obj.getClass())return false;
        if(this != obj)return false;
        Ball ball = (Ball)obj;
        return color.compareTo(ball.color) == 0 && Double.compare(weight, ball.weight) == 0;
    }

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = result * prime + (color == null?0:color.hashCode());
        result = result * prime + Double.hashCode(weight);
        return result;
    }

    public String toString() {
        return  "Classname + " + getClass().getSimpleName() +
                "\nColor " + color.toString() +
                "\nWeight" + weight;
    }

    public Color getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
