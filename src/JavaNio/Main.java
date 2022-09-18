package JavaNio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            // write data by one shot chain version
//            ByteBuffer buffer = ByteBuffer.allocate(100);
//            byte[] outputBytes = "Hello World!".getBytes();
//            byte[] outputBytes2 = "Nice to meet you".getBytes();
//            buffer.put(outputBytes).putInt(245437583).putInt(-45458).put(outputBytes2).putInt(1000).flip();

            // write data by one shot simple version
            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            buffer.putInt(245437583);
            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-45458);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);
            buffer.flip();

            binChannel.write(buffer);

            // read data by one shot
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
//            ByteBuffer readBuffer = ByteBuffer.allocate(100);
//            channel.read(readBuffer);
//            readBuffer.flip();
//
//            byte[] inputString = new byte[outputBytes.length];
//            readBuffer.get(inputString);
//
//            System.out.println("inputString = " + new String(inputString));
//            System.out.println("int1 = " + readBuffer.getInt());
//            System.out.println("int2 = " + readBuffer.getInt());
//
//            byte[] inputString2 = new byte[outputBytes2.length];
//            readBuffer.get(inputString2);
//
//            System.out.println("inputString2 = " + new String(inputString2));
//            System.out.println("int3 = " + readBuffer.getInt());

            // Methods of Seekable byte channel
            //read(ByteBuffer) - reads bytes beginning at the channel's current position, and after the read,
            //                   updates the position accordingly. Note that now we're talking about
            //                   the channel's position, not the byte buffer's position.
            //                   Of course, the bytes will be placed into the buffer starting at its current position.
            //write(ByteBuffer) - the same as read, except it writes. There's one exception.
            //                    If a datasource is opened in APPEND mode, then the first write will take place starting
            //                    at the end of the datasource, rather than at position 0. After the write, the position
            //                    will be updated accordingly.
            //position() - returns the channel's position.
            //position(long) - sets the channel's position to the passed value.
            //truncate(long) - truncates the size of the attached datasource to the passed value.
            //size() - returns the size of the attached datasource

            //read data in reverse order
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);

            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());

            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            // write data in random order
            byte[] outputString = "Hello, World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245).flip();

            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);
            intBuffer.flip();

            intBuffer.putInt(-98756).flip();

            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            intBuffer.flip();
            intBuffer.putInt(1000).flip();

            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));

            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));

            //read and write data in few iterations
//            byte[] outputBytes = "Hello World!".getBytes();
//            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
//            buffer.put(outputBytes);
//
//            buffer.flip();
//            int numBytes = binChannel.write(buffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245437583);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-45458);
//            intBuffer.flip();
//            numBytes = binChannel.write(intBuffer);
//            System.out.println("numBytes written was: " + numBytes);
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//
//            outputBytes[0] = 'a';
//            outputBytes[4] = '!';
//
//            buffer.flip();
//
//            long numBytesRead = channel.read(buffer);
//
//            if (buffer.hasArray()) {
//                System.out.println("byte buffer = " + new String(buffer.array()));
////                System.out.println("byte buffer = " + new String(outputBytes));
//            }

//            //absolute read method
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0));
//
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0));
//            System.out.println(intBuffer.getInt());

            //relative read method
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());

//            System.out.println("outPutBytes = " + new String(outputBytes));

            // read file by RAF
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);

            // read file Channel
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();
//            Path dataPath = FileSystems.getDefault().getPath("data.txt");
//            Files.write(dataPath, "\nLine 5".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
//            List<String> lines = Files.readAllLines(dataPath);
//            for(String line : lines){
//                System.out.println(line);
//            }

//            channel.close();
//            ra.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
