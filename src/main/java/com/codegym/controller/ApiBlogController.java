package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class ApiBlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<Iterable<Blog>> listAllBlog() {
        Iterable<Blog> blogs = blogService.findByAll();
        if (blogs == null) {
            return new ResponseEntity<Iterable<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Iterable<Blog>>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<Blog> listBlog(@RequestParam("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }

    @PostMapping("/blogs")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder uriComponentsBuilder) {
        blogService.save(blog);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/blogs/{id}").buildAndExpand(blog.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }
}
