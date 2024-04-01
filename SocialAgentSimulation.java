/*
  Author: Vishnu Varadhan

  Purpose was to simluate agents on a landscape for the exploration section of my report.

  Date: 3/10/2024

  Name: SocialAgentSimulation.java
*/


import java.util.Random;

public class SocialAgentSimulation {

    public static void main(String[] args) throws InterruptedException {


        if(args.length > 2 || args.length == 0){
            System.out.println("Usage: java SocialAgentSimulation <numofagents> <radius size>"); 
            System.exit(0);
        }

        int numofAgents = Integer.parseInt(args[0]);
        int radiusSize = Integer.parseInt(args[1]);


        Landscape scape = new Landscape(500, 500);
        Random gen = new Random();

        // Creates 100 SocialAgents and 100 AntiSocialAgents
        for (int i = 0; i < numofAgents; i++) {
            scape.addAgent(new SocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(), radiusSize));
        }

        LandscapeDisplay display = new LandscapeDisplay(scape);

        //Uncomment below when updateAgents() has been implemented
        int counter = 0;
        System.out.println("Before: " + scape.updateAgents());
        int moved_agents = 1;
        while(moved_agents > 0 && counter < 5000){
            Thread.sleep(10);
            scape.updateAgents();
            display.repaint();
            counter++;
            moved_agents = scape.updateAgents();
            System.out.println(moved_agents);
        }

        System.out.println(counter);
    }
}
