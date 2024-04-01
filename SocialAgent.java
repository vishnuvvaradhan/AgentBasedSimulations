/*
  Author: Vishnu Varadhan

  Based on the agent abstract class, created a socialagent with certain rules

  Date: 3/10/2024

  Name: SocialAgent.java
*/




import java.awt.Color;
import java.awt.Graphics;
import java.util.Random; 
import java.awt.Graphics2D;
import java.awt.GradientPaint;
public class SocialAgent extends Agent{

    static final Random rand = new Random();
    
    public SocialAgent(double x0, double y0, int radius){
        super(x0, y0, radius);
        moved = false;
    }



    /*If there are less than 4 agents within its own radius from itself, it changes both its x and y coordinates by a random value between -10 and 10. 
    Make sure that it stays within the boundary of the window!

    To your AntiSocialAgent class, add an analagous method that would move the Agent if there is more than 1 neighbor within its radius.

    */
    public void updateState(Landscape scape){
        LinkedList<Agent> neigbors = scape.getNeighbors(getX(), getY(), radius);
        if(neigbors.size() < 4){
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

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; // Cast to use Graphics2D features
        GradientPaint gp = new GradientPaint(
            (float) getX(), (float) getY(), moved ? new Color(125, 125, 255) : new Color(0, 0, 255),
            (float) getX() + 5, (float) getY() + 5, Color.WHITE,
            true);
        g2d.setPaint(gp);
        g2d.fillOval((int) getX(), (int) getY(), 5, 5);
    }
}
