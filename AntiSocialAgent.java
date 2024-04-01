/*
  Author: Vishnu Varadhan

  Based on the agent abstract class, created a antisocialagent with certain rules

  Date: 3/10/2024

  Name: AntiSocialAgent.java
*/


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class AntiSocialAgent extends Agent{
    static final Random rand = new Random();

    public AntiSocialAgent(double x0, double y0, int radius){
        super(x0, y0, radius);
        moved = false;
    }

    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(255, 0, 0));
        else g.setColor(new Color(255, 125, 125));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape){
        LinkedList<Agent> neigbors = scape.getNeighbors(getX(), getY(), radius);
        if(neigbors.size() > 1){
            int displacementX = rand.nextInt(-10, 11);
            int displacementY = rand.nextInt(-10, 11);
            double newX = Math.max(0, Math.min(getX() + displacementX, scape.getWidth() - 1));
            double newY = Math.max(0, Math.min(getY() + displacementY, scape.getHeight() - 1));
            setX(newX);                
            setY(newY);
            moved = true;
        }else{
            moved = false;
        }
    }
    
}
