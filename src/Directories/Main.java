package Directories;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // about filters
        // glob pattern
        // the * character matches any string (which can contain any number of characters)
        // *.dat will match any path with the .dat extension
        // *.{dat,txt} wi;; match any path that has the extension .dat or .txt
        // ? matches exactly one character. // ??? = 3 any characters
        // myfile* matches any paths that begin with "myfile"
        // b?*.txt matches any paths that are at least two characters long and begin with the character b (the & forces a second character, and the * matches
        // 0 or more characters)
        // check glob syntax

        // create own filter classic
 /*       DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            public boolean accept(Path path) throws IOException {
                return (Files.isRegularFile(path));
            }
        };
*/
        //create own filter with lambda
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        // receive separator
        // "\\" for windows
        // "/" for mac or linux
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        System.out.println("===========================================");

        //Path directory = FileSystems.getDefault().getPath("fromDirectories\\Dir2"); // hard codded separator (wrong version)
        Path directory = FileSystems.getDefault().getPath("fromDirectories" + File.separator + "Dir2"); // normal code
        try (//DirectoryStream<Path> contents = Files.newDirectoryStream(directory) // directory stream returns directory stream of paths
                                                                                    // this method returns first level of contents and
                                                                                    // dont look at the directories inside the target directory

//          DirectoryStream<Path> contents = Files.newDirectoryStream(directory, "*.dat")) {     //use filter by ".dat"
            DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {     //use my own filter
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("===========================================");

        // create temp files
        try{
            Path tempFile = Files.createTempFile("myapp", ".appext"); // prefix, name of temporary file begins with this prefix
                                                                                 // suffix, file extension
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("===========================================");

        // get ifo about stores on computer
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store: stores){
            System.out.println(store);
            System.out.println(store.getUsableSpace());
            System.out.println(store.getTotalSpace());
            System.out.println(store.type());
        }

        System.out.println("===========================================");

        // get ifo about root path
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths){
            System.out.println(path);
        }




        //create target directories and files
 /*       try {
            Path path = FileSystems.getDefault().getPath("fromDirectories");
            Files.createDirectory(path);

            for (int i = 0; i < 5; i++) {
                String s;
                StringBuilder sb = new StringBuilder();

                if(i != 0) {
                    if (i == 3) {
                        sb.append("Dir2\\");
                    }
                    sb.append("Dir");
                    sb.append(i);
                    s = sb.toString();
                    path = FileSystems.getDefault().getPath("fromDirectories", s);
                    Files.createDirectory(path);
                }

                sb.append("\\file");

                int k, j;
                if (i==0 ||i == 1 || i == 3) {
                    j = 1;
                    k = 3;
                } else if (i == 2) {
                    j = 1;
                    k = 4;
                } else {
                    j = 3;
                    k = 4;
                }
                while (j < k) {
                    sb.append(j);
                    sb.append(".txt");
                    s = sb.toString();
                    path = FileSystems.getDefault().getPath("fromDirectories", s);
                    Files.createFile(path);
                    sb.delete((s.length() - 5), s.length());
                    j++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }
}
