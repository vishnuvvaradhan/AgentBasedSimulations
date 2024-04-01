
/*
  Author: Vishnu Varadhan

  An abstract class that provides a framework for agents. 

  Date: 3/10/2024

  Name: Agent.java
*/



import java.awt.Color;
import java.awt.Graphics;


public abstract class Agent{
    private double xPosition;
    private double yPosition;
    protected int radius;
    protected boolean moved;

    public Agent(double x0, double y0, int radius){
        xPosition = x0;
        yPosition = y0;
        this.radius = radius;
    }

    public double getX(){
        return xPosition;
    }

    public double getY(){
        return yPosition;
    }

    public int getRadius(){
        return radius;
    }

    public boolean getMoved(){
        return moved;
    }

    public void setX(double newX){
        xPosition = newX;
    }

    public void setY(double newY){
        yPosition = newY;
    }

    public void setRadius(int newRadius){
        radius = newRadius;
    }

    public String toString(){ 
        return "(" + xPosition + ", " + yPosition + ")";
    }

    public abstract void updateState(Landscape scape);

    public abstract void draw(Graphics g);

}