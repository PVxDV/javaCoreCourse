package Directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalkingByDirTree {
    public static void main(String[] args) {

        // walking on directories
        System.out.println("======Walking Tree for Dir 2=====");
        Path dir2Path = FileSystems.getDefault().getPath("fromDirectories" + File.separator + "Dir2");
        try{
            Files.walkFileTree(dir2Path, new PrintNames()); // printNames have to be extends from SimpleFileVisitor
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        // copy files and directories
        System.out.println("======Copy Dir2 to Dir4/Dir2Copy=====");
        Path copyPath = FileSystems.getDefault().getPath("fromDirectories" + File.separator + "Dir4" + File.separator + "Dir2Copy");

        try{
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("=====================================");

        // convert io path to nio path
        File file = new File("fromPaths\\Examples\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("io path = " + file);
        System.out.println("convertedPath to nio = " + convertedPath);

        System.out.println("=====================================");

        // resolve path
        File parent = new File("fromPaths\\Examples");
        File resolvedFile = new File(parent, "dir\\file.txt"); // file instance as 1st parameter and String as a child
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("fromPaths\\Examples", "dir\\file.txt"); // String as 1st parameter and String as a child
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("fromPaths");
        Path childRelativePath1 = Paths.get("Examples");
        Path childRelativePath2 = Paths.get("dir\\file.txt");

        System.out.println(parentPath.resolve(childRelativePath1.resolve(childRelativePath2)));

        System.out.println("=====================================");

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("====== print Dir2 contents using list() =====");
        File dir2File = new File(workingDirectory, "\\fromDirectories\\Dir2");
        String[] dir2Contents = dir2File.list(); // return a first level of tree, don`t look at the subdirectories
        for(int i=0; i<dir2Contents.length; i++){
            System.out.println("i= " + i + ": " + dir2Contents[i]);
        }

        System.out.println("====== print Dir2 contents using listFiles() =====");
        File[] dir2Files = dir2File.listFiles();
        for(int i=0; i<dir2Files.length; i++){
            System.out.println("i= " + i + ": " + dir2Files[i].getName());
        }


    }
}
