package com.springboot.crud.restapi.controller;

import com.springboot.crud.restapi.model.BlogModel;
import com.springboot.crud.restapi.services.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.PrintService;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping(value = "/blog")
public class PrintController {

    //create api using endPoint
    @GetMapping(value = "/print")
    public String printData() {
        return "Welcome springboot in my life";

    }

    //create blog api using endPoint
    @GetMapping(value = "/blog")
    public String printBlog() {
        int id = 1;
        String blogTitle = "Spring Boot";
        String blogDesc = "Working on Spring Boot";
        String authorName = "John Doe";
        String data = "22 jan 2024";

        return String.valueOf(id) + "<br> " + blogTitle + " <br>" + blogDesc + "<br> " + authorName + "<br> " + data;
    }

    @Autowired
    private BlogServices blogServices;

    @PostMapping(value = "/addBlog")
    public BlogModel addBlog(@RequestBody BlogModel blogModel) {
        return blogServices.addBlog(blogModel);
    }
    @GetMapping(value = "/getBlog")
    public List<BlogModel> getBlogs()
    {
        return blogServices.getBlogs();
    }
    //to get particular blog
    @GetMapping(value = "/{blogId}")
    public BlogModel getBlog(@PathVariable("blogId") int blogId)
    {
        return blogServices.getBlog(blogId);
    }
    //to delete the particular blog

    @DeleteMapping(value = "/{blogId}")
    public void deleteTickets(@PathVariable("blogId") int blogId)
    {
        blogServices.deleteBlog(blogId);
    }
    @PutMapping(value =  "/{blogId}")
    public BlogModel updateBlog(@PathVariable("blogId") int blogId, @RequestBody BlogModel blogModel)
    {
        return blogServices.updateBlog(blogId, blogModel);
    }



}




