package com.example.task1.blog.controller;

import com.example.task1.blog.dto.BlogDto;
import com.example.task1.blog.entity.Blog;
import com.example.task1.blog.service.BlogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogServiceI blogServiceI;

    private Long id;

    @GetMapping("/blog")
    public ResponseEntity<List<BlogDto>> getAll() {
        return ResponseEntity.ok(blogServiceI
                .getAll());
    }

    @PostMapping(value = "/blog", params = {"action", "text"})
    public ResponseEntity<Blog> addEntry(@RequestParam String action, @RequestParam String text) {
        if (action.equals("new")) {
            return ResponseEntity.ok(blogServiceI.addBlog(text));
        } else {
            return null;
        }
    }

    @DeleteMapping(value = "/blog", params = {"action", "id"})
    public ResponseEntity<String> deleteEntry(@RequestParam String action, @RequestParam Long id) {
        if (action.equals("delete")) {
            this.blogServiceI.delete(id);
            return ResponseEntity.ok("OK");
        } else {
            return null;
        }
    }
}
