package model;

public class Translation {
    private int postId;
    private String language;
    private String title;
    private String content;

    public Translation(int postId, String language, String title, String content) {
        this.postId = postId;
        this.language = language;
        this.title = title;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void display() {
        System.out.println(language + ": " + title + " - " + content);
    }
}