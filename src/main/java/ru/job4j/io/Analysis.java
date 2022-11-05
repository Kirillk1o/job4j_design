package ru.job4j.io;

import java.io.*;
import java.util.List;

import static java.lang.System.out;

public class Analysis {
    public void unavailable(String sours, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(sours))) {
            try (PrintWriter print = new PrintWriter(new FileOutputStream(target))) {
                boolean status = true;
                String line;
                while ((line = reader.readLine()) != null) {
                    if ((line.startsWith("400") || line.startsWith("500")) && status) {
                        print.print(line.substring(4));
                        print.print(System.lineSeparator());
                        status = false;
                    } else if ((line.startsWith("200") || line.startsWith("300")) && !status) {
                        print.print(line.substring(4));
                        print.print(System.lineSeparator());
                        status = true;
                    }
                }
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/server.log", "./data/target.txt");
    }
}
