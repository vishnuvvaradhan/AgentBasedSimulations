/*
  Author: Vishnu Varadhan

  Based on the agent abstract class, created a explorer agent with certain rules

  Date: 3/10/2024

  Name: ExplorerAgent.java
*/



import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class ExplorerAgent extends Agent{
    static final Random rand = new Random();
    private int threshold; 

    public ExplorerAgent(double x0, double y0, int radius){
        super(x0, y0, radius);
        moved = false;
        threshold = 3;
    }

    public void draw(Graphics g){
        if(!moved) g.setColor(new Color(198, 233, 198));
        else g.setColor(new Color(0, 255, 0));
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }


    public void updateState(Landscape scape){
        LinkedList<Agent> neigbors = scape.getNeighbors(getX(), getY(), radius);
        if(neigbors.size() > threshold){
            findOpenAreas(scape);
            moved = true;
        }else{
            moved = false;
        }
        
    }

    private void findOpenAreas(Landscape scape){
        double newX = getX();
        double newY = getY();
        int leastNeighbors = Integer.MAX_VALUE;

        for (int i = 0; i < 8; i++) {
            double trialX = getX() + rand.nextInt(-10, 11);
            double trialY = getY() + rand.nextInt(-10, 11);
            trialX = Math.max(0, Math.min(trialX, scape.getWidth() - 1));
            trialY = Math.max(0, Math.min(trialY, scape.getHeight() - 1));

            int neighborsCount = scape.getNeighbors(trialX, trialY, getRadius()).size();
            if (neighborsCount < leastNeighbors) {
                newX = trialX;
                newY = trialY;
                leastNeighbors = neighborsCount;
            }
        }
        setX(newX);
        setY(newY);
        }
    }
