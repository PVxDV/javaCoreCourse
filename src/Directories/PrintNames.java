package Directories;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

//about file visitor
// you have to implement next methods

// .preVisitDirectory - this method accepts a reference to the directory, and the BasicFileAttributes instance
// for the directory. It`s called before entries in directory are visited.

// .postVisitDirectory() - this method accepts a reference to the directory and an exception object (when necessary)
// It`s called after entries in the directory, and all its descendants, have been visited. The exception parameter
// will be set when an exception happens during the traversal of the entries and descendants

// .visitFile() - this method accepts a reference to the file and BasicFileAttributes instance. This is where you run
// code that will operate on the file. It`s only called for files

// .visitFileFailed() - this method is called when a file can`t be accessed. The exception that`s thrown is passed to the method.
// you can then decide what to do with it (throw it, print it, or anything else tha makes sense for the application
// and operation being performed). Can be called for files and directories.

// Simple File Visitor it`s prepared version from jdk

public class PrintNames extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error accessing file: " + file.toAbsolutePath() + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
