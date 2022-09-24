package Paths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt"); // get path to file in src folder
        printFile(path);

        System.out.println("----------------------------------------------------------");

//      Path filePath = FileSystems.getDefault().getPath("fromPaths","SubdirectoryFile.txt"); // get path to file in project folder and subdirectory
        Path filePath = Paths.get(".","fromPaths","SubdirectoryFile.txt"); // get path to file in project folder and subdirectory with Paths.get()
        printFile(filePath);

        System.out.println("----------------------------------------------------------");

//      filePath = Paths.get("C:\\Users\\Unmin\\Desktop\\OutThere.txt"); // get path to file in random place in file system
        filePath = Paths.get("C:\\","Users", "Unmin", "Desktop\\OutThere.txt"); // we can write absolute path by parts
        printFile(filePath);

        System.out.println("----------------------------------------------------------");

        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        System.out.println("----------------------------------------------------------");
        // C:\Examples\.\subfolder\..\directory  // ".." moves us up to the previous folder
        // C:\Examples\directory // equals example higher

        Path path2 = FileSystems.getDefault().getPath(".", "fromPaths", "..", "fromPaths","SubdirectoryFile.txt");

        // How it works
        // 1. C:\Users\Unmin\Desktop\JavaCore\.
        // 2. C:\Users\Unmin\Desktop\JavaCore\.\fromPaths
        // 3. C:\Users\Unmin\Desktop\JavaCore\
        // 4. C:\Users\Unmin\Desktop\JavaCore\fromPaths
        // 5. C:\Users\Unmin\Desktop\JavaCore\fromPaths\SubdirectoryFile.txt

        System.out.println(path2.normalize().toAbsolutePath()); // we can fix this node by .normalize()
        printFile(path2);

        System.out.println("----------------------------------------------------------");

        Path path3 = FileSystems.getDefault().getPath("thisfiledoesnotexist.txt"); // we can creat path to file which does not exist
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("W:\\random", "\\efjsofjosrjbgnvs", "thisfiledoesnotexist.txt"); // we can creat path to file which does not exist
        System.out.println(path4.toAbsolutePath());

        filePath = FileSystems.getDefault().getPath("fromPaths");

        System.out.println("----------------------------------------------------------");

        System.out.println(path3.toAbsolutePath());
        System.out.println("Exists = " + Files.exists(path3));

        System.out.println(path4.toAbsolutePath());
        System.out.println("Exists = " + Files.exists(path4));

        System.out.println(filePath.toAbsolutePath());
        System.out.println("Exists = " + Files.exists(filePath));


    }

    private static void printFile(Path path){
        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
