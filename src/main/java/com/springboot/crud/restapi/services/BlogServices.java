package com.springboot.crud.restapi.services;

import com.springboot.crud.restapi.model.BlogModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
@Component
public class BlogServices {
    //add blog
    //get blog
    //delete blog
    //update blog
    //get all blog

    //to store the multiple blog using List
    List<BlogModel> blogModelList = new CopyOnWriteArrayList<>();

    //take the first blog id 1
    int blogID = 1;

    //add the blog using model
    public BlogModel addBlog(BlogModel blogModel) {
        blogModel.setId(blogID);
        blogModelList.add(blogModel);
        blogID++;
        return blogModel;

    }

    public List<BlogModel> getBlogs() {
        return blogModelList;
    }

    //to fetch the particular blog
    public BlogModel getBlog(int blogId) {
        return blogModelList.stream().filter(t -> t.getId() == blogId)
                .findFirst().get();
    }
    //to delete the blog
    public void deleteBlog(int blogId)
    {
        blogModelList.stream()
                .forEach(t -> {
                    if (t.getId() == blogId)
                    {
                        blogModelList.remove(t);
                    }
                });
    }
    //to update the blog
    public BlogModel updateBlog(int blogId, BlogModel blogModel)
    {
        blogModelList.stream().forEach(t -> {
            if (t.getId()== blogId){
                t.setBlogTitle(blogModel.getBlogTitle());
                t.setBlogDescription(blogModel.getBlogDescription());
                t.setBlogAuthor(blogModel.getBlogAuthor());
                t.setBlogDate(blogModel.getBlogDate());
            }
        });

        return blogModelList.stream()
                .filter(t -> t.getId()  == blogId)
                .findFirst()
                .get();
    }

    }


