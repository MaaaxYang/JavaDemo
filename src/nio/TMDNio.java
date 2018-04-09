/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class TMDNio {

    public static void main(String[] args) throws Exception{

        Path path = Paths.get("test.txt");
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            for (String line = null; (line = br.readLine()) != null;) {
                //
                System.out.println(line);


            }
        }


        try(BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND)){
            bw.write("");
            
        }


    }



    public static void func2() throws Exception{
        Path path = Paths.get("test.txt");
        try (SeekableByteChannel ch = Files.newByteChannel(path)){
            ByteBuffer bb = ByteBuffer.allocateDirect(1000);
            for(;;) {
                StringBuilder line = new StringBuilder();
                int n = ch.read(bb);
                // add chars to line
                // ...
            }
        }
    }

    public static void func3(){

    }
}
