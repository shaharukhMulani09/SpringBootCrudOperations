package in.sp.main.service;


import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServices {
    private final String directory = "src/main/resources/files";

    public void createFile(String filename, String content) throws IOException {
        Path path = Paths.get(directory, filename);
        Files.write(path, content.getBytes());
    }

    public String readFile(String filename) throws IOException {
        Path path = Paths.get(directory, filename);
        return new String(Files.readAllBytes(path));
    }

    public void updateFile(String filename, String content) throws IOException {
        createFile(filename, content); // Overwrites the existing file
    }

    public void deleteFile(String filename) throws IOException {
        Path path = Paths.get(directory, filename);
        Files.deleteIfExists(path);
    }
}
