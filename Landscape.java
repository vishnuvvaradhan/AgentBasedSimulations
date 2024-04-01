/*
  Author: Vishnu Varadhan

  Landscape creation for the agents to reside on. 

  Date: 3/10/2024

  Name: Landscape.java
*/


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Landscape {
    private int width;
    private int height;
    private LinkedList<Agent> agents;
    static final Random rand = new Random();

    public Landscape(int w, int h){
        width = w;
        height = h;
        agents = new LinkedList<Agent>();
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public void addAgent(Agent a){
        agents.add(a);
    }

    public String toString(){
        return "Number of Agents: " +  agents.size();
    }


    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius){
        LinkedList<Agent> neighbors = new LinkedList<>();
        for (Agent agent : agents) {
            double distance = Math.sqrt(Math.pow(agent.getX() - x0, 2) + Math.pow(agent.getY() - y0, 2));
            if (distance <= radius) {
                neighbors.add(agent);
            }
        }
        return neighbors;
    }

    public void draw(Graphics g){
        for(Agent agent : agents){
            agent.draw(g);
        }
    }

    public int updateAgents(){
        int agentsMoved = 0;
        if (agents.size() > 0) {
            int randomNode = rand.nextInt(agents.size()); 
            Agent randomAgent = agents.get(randomNode);
            AntiSocialAgent newAgent = new AntiSocialAgent(randomAgent.getX(), randomAgent.getY(), randomAgent.getRadius());
            agents.remove(randomNode);
            agents.add(newAgent);
    
            for (int i = 0; i < agents.size(); i++) {
                Agent agent = agents.get(i);
                agent.updateState(this); 
                if (agent.getMoved()) {
                    agentsMoved++;
                    //agent.moved = false;
                    
                }
            }
        }
        return agentsMoved;
    }

}
