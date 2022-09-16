package InputOutput;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        //write locations and exits as objects to file by stream of bytes
        // we added to class Locations interface "Serializable" and int serialVersionUID

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {
            for (Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }

        // write locations and exits to file by stream of bytes
 /*       try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))) {

            for (Location location : locations.values()) {

                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());

                System.out.println("Writing location " + location.getLocationID() + " : " + location.getDescription());
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.");

                locFile.writeInt(location.getExits().size() - 1);

                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));

                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
*/

        // write locations and exits to file by stream of chars
/*        try (BufferedWriter bwLoc = new BufferedWriter(new FileWriter("locations.txt"));
             BufferedWriter bwDir = new BufferedWriter(new FileWriter("directions.txt"))) {
            for (Location location : locations.values()) {
                bwLoc.write(location.getLocationID() + "," + location.getDescription() + "\n");

                for (String direction : location.getExits().keySet()) {
                    if (!direction.equalsIgnoreCase("Q")) {
                        bwDir.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
*/
    }

    static {
        //read locations and exits as objects from file by stream of bytes
        // we added to class Locations interface "Serializable" and int serialVersionUID
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Location location = (Location) locFile.readObject();

                    System.out.println("Read location " + location.getLocationID() + " : " + location.getDescription());
                    System.out.println("Find exits " + location.getExits().size() + " exits");

                    locations.put(location.getLocationID(), location);
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (InvalidClassException ice) {
            System.out.println("Invalid Class Exception " + ice.getMessage());
        } catch (IOException io) {
            System.out.println("IO Exception " + io.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found Exception " + e.getMessage());
        }

        //read locations and exits from file by stream of bytes
 /*       try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))) {
            boolean eof = false;
            while (!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<>();

                    int locId = locFile.readInt();
                    String description = locFile.readUTF();
                    int numExits = locFile.readInt();

                    System.out.println("Read location " + locId + " : " + description);
                    System.out.println("Found " + numExits + " exits");

                    for (int i = 0; i < numExits; i++) {
                        String direction = locFile.readUTF();
                        int destination = locFile.readInt();

                        exits.put(direction, destination);

                        System.out.println("\t\t" + direction + "," + destination);
                    }

                    locations.put(locId, new Location(locId, description, exits));
                } catch (EOFException e) {
                    eof = true;
                }

            }
        } catch (IOException e) {
            System.out.println("IO Exception " + e.getMessage());
        }
*/

        // read locations from file by stream of chars
 /*       try (BufferedReader brLoc = new BufferedReader(new FileReader("locations_big.txt"))) {
            String input;
            while ((input = brLoc.readLine()) != null) {
                String[] data = input.split(",");

                int locID = Integer.parseInt(data[0]);
                String locDescription = data[1];
                Map<String, Integer> exits = new HashMap<>();

                locations.put(locID, new Location(locID, locDescription, exits));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        // read exits from file by stream of chars
 /*       try (BufferedReader brDir = new BufferedReader(new FileReader("directions_big.txt"))) {
            String input;

            while ((input = brDir.readLine()) != null) {
                String[] data = input.split(",");

                int locID = Integer.parseInt(data[0]);
                String locDir = data[1];
                int locTargetId = Integer.parseInt(data[2]);

                locations.get(locID).addExit(locDir, locTargetId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
// implement later
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
