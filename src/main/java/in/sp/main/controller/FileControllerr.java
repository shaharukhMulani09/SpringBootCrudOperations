package in.sp.main.controller;


import com.example.demo.service.FileServices;

import in.sp.main.service.FileServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileControllerr {

    @Autowired
    private FileServices fileService;

    @PostMapping("/{filename}")
    public ResponseEntity<Void> createFile(@PathVariable String filename, @RequestBody String content) {
        try {
            fileService.createFile(filename, content);
            return ResponseEntity.status(201).build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{filename}")
    public ResponseEntity<String> readFile(@PathVariable String filename) {
        try {
            String content = fileService.readFile(filename);
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{filename}")
    public ResponseEntity<Void> updateFile(@PathVariable String filename, @RequestBody String content) {
        try {
            fileService.updateFile(filename, content);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<Void> deleteFile(@PathVariable String filename) {
        try {
            fileService.deleteFile(filename);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
