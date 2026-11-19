import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import itumulator.executable.DisplayInformation;
import itumulator.executable.Program;
import itumulator.world.Location;
import itumulator.world.World;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Tema1/t1-1a.txt");
        List<String> tokens = new ArrayList<>();
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            tokens.add(sc.next());
        }
        sc.close();

        int size = Integer.parseInt(tokens.get(0));
        Program p = new Program(size, 800, 500);
        World w = p.getWorld();

        int amount = Integer.parseInt(tokens.get(2));
        Random r = new Random();
        for(int o = 0; o < amount; o++) {
        int x = r.nextInt(size);
        int y = r.nextInt(size);
        Location grassLoc = new Location(x, y);

            w.setTile(grassLoc, new Grass());
        }
        w.setTile(new Location(2,2), new Rabbit());

        p.setDisplayInformation(Grass.class, new DisplayInformation(Color.green, "grass"));
        p.setDisplayInformation(Rabbit.class, new DisplayInformation(Color.white, "rabbit-large"));

        p.show();
        for (int i = 0; i < 200; i++) {
            if(i % 25 == 0){
                int x2 = r.nextInt(size);
                int y2 = r.nextInt(size);
                Location grassLoc2 = new Location(x2, y2);
            w.setTile(grassLoc2, new Grass());
            }
            p.simulate();
        }
    }
}