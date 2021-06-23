package com.example.newsfeed;

public class Post
{
    private String user;
    private String post;
    private String time;

    public Post(){};

    public Post(String user, String post, String time) {
        this.user = user;
        this.post = post;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
