package model;

public class Post {
    private int id;
    private String title;
    private String content;
    private User author;

    public Post(int id, String title, String content, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Author: " + author.getName());
        System.out.println("------------------");
    }
}