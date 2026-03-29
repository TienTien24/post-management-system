package model;

public class Comment {
    private int postId;
    private String content;

    public Comment(int postId, String content) {
        this.postId = postId;
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }
}