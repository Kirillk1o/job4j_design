package ru.job4j.io;

import javax.imageio.IIOException;
import java.io.FileOutputStream;
import java.io.IOException;

import static ru.job4j.io.MatrixIO.multiple;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(multiple(4).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}