package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DublicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, List<Path>> map = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty current = new FileProperty(file.toFile().length(), file.getFileName().toString());
        map.putIfAbsent(current, new ArrayList<>());
        map.get(current).add(file.toAbsolutePath());
        return super.visitFile(file, attrs);
    }

    public void getFiles() {
       map.entrySet().stream()
                .filter(n -> n.getValue().size() > 1)
                .forEach(x -> {
                    System.out.println(x.getKey().getName() + " - " + x.getKey().getSize());
                    for (Path path : x.getValue()) {
                        System.out.println(path);
                    }
                });
    }
}
