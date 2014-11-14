package application;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
* JUnit tests to test the fillMaps() method
* @author Stephen Song
*/
public class SSUnit {

   private Planet p;
   private Marketplace m;

   @Test
       public void testFillMaps() {

           // init tests
           p = new Planet();
           p.planetTechInteger = 1;
           m = new Marketplace(p);
           p.marketplace = m;

           // test early planet maps
           assertTrue(m.sellableResources.get("Water") != -1);
           assertTrue(m.buyableResources.get("Water") != -1);
           assertTrue(m.sellableResources.get("Furs") != -1);
           assertTrue(m.buyableResources.get("Furs") != -1);
           assertTrue(m.sellableResources.get("Food") != -1);
           assertTrue(m.buyableResources.get("Food") != -1);
           assertFalse(m.sellableResources.get("Ore") != -1);
           assertFalse(m.buyableResources.get("Ore") != -1);
           assertTrue(m.sellableResources.get("Games") != -1);
           assertFalse(m.buyableResources.get("Games") != -1);
           assertTrue(m.sellableResources.get("Firearms") != -1);
           assertFalse(m.buyableResources.get("Firearms") != -1);
           assertTrue(m.sellableResources.get("Medicine") != -1);
           assertFalse(m.buyableResources.get("Medicine") != -1);
           assertTrue(m.sellableResources.get("Narcotics") != -1);
           assertFalse(m.buyableResources.get("Narcotics") != -1);
           assertFalse(m.sellableResources.get("Machines") != -1);
           assertFalse(m.buyableResources.get("Machines") != -1);
           assertFalse(m.sellableResources.get("Robots") != -1);
           assertFalse(m.buyableResources.get("Robots") != -1);
           // test hi tech planet maps
           p.planetTechInteger = 6;
           m = new Marketplace(p);
           p.marketplace = m;
           for(java.util.Map.Entry<String, Resource> entry : Resource.resources.entrySet()) {
           String name = entry.getKey();
           assertTrue(m.sellableResources.get(name) != -1);
           assertTrue(m.buyableResources.get(name) != -1);
       }
}