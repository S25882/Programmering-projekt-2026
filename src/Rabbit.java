import itumulator.simulator.Actor;
import itumulator.world.Location;
import itumulator.world.World;

import java.util.*;

public class Rabbit implements Actor {
    @Override
    public void act(World world) {
        Random r = new Random();
        Location current = world.getLocation(this);
        List<Location> empty = new ArrayList<>(world.getEmptySurroundingTiles(current));
        if (empty.isEmpty()) return;
        world.move(this, empty.get(r.nextInt(empty.size())));
    }
}
