package Paths;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class WorkWithDir {
    public static void main(String[] args)  {

        try{
            // files attributes
            Path filePath = FileSystems.getDefault().getPath("fromPaths", "Examples", "Dir1\\file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            System.out.println("=========================================================");

            // multiple attributes
            BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attributes.size() + "\n" +
                               "Last modified = " + attributes.lastModifiedTime() + "\n" +
                               "Created = " + attributes.creationTime() + "\n" +
                               "Is directory = " + attributes.isDirectory() + "\n" +
                               "Is a regular file = " + attributes.isRegularFile());

            // create files and directories
/*         // create file
            Path fileToCreate = FileSystems.getDefault().getPath("fromPaths", "Examples", "file2.txt");
            Files.createFile(fileToCreate);
            // create directory
            Path dirToCreate = FileSystems.getDefault().getPath("fromPaths", "Examples", "Dir4");
            Files.createDirectory(dirToCreate);

            // create few directories
            Path dirToCreate = FileSystems.getDefault().getPath("fromPaths", "Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
            Files.createDirectories(dirToCreate); // create few directories is one shot

            Path dirToCreate = FileSystems.getDefault().getPath("fromPaths\\Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7"); // deals same
            Files.createDirectories(dirToCreate);
*/
            // delete file (if we want to delete a direction, it has to be EMPTY!)
/*            Path fileToDelete = FileSystems.getDefault().getPath("fromPaths", "Examples", "Dir1", "file1copy.txt");
            //Files.delete(fileToDelete); // to avoid IOException if file not exist we can use .deleteIfExists()
            Files.deleteIfExists(fileToDelete);
*/
            // rename files
/*            Path fileToMove = FileSystems.getDefault().getPath("fromPaths","Examples", "file1.txt");
            Path destination = FileSystems.getDefault().getPath("fromPaths","Examples", "file2.txt");
            Files.move(fileToMove, destination);
*/
            // move files
/*          Path fileToMove = FileSystems.getDefault().getPath("fromPaths","Examples", "file1copy.txt");
            Path destination = FileSystems.getDefault().getPath("fromPaths","Examples", "Dir1", "file1copy.txt"); // u nave specify full path of the destination
            Files.move(fileToMove, destination);
*/
            // copy files and directions
/*           Path sourceFile = FileSystems.getDefault().getPath("fromPaths", "Examples", "file1.txt");
            Path copyFile = FileSystems.getDefault().getPath("fromPaths", "Examples", "file1copy.txt");

            // copy files
//          Files.copy(sourceFile, copyFile); // if file already exist we throws IOException, we can use 3rd parameter to replace existing file
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            // copy directory
            sourceFile = FileSystems.getDefault().getPath("fromPaths", "Examples", "Dir1"); //copy dir
            copyFile = FileSystems.getDefault().getPath("fromPaths", "Examples", "Dir4"); // destination
            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING); // copy only direction, not files inside this direction
*/
        } catch (IOException e) {
            System.out.println("IO exception " + e.getMessage());
            e.printStackTrace();
        }
    }
}
