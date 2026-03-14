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

    public void displayPost() {
        System.out.println("Post ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Author: " + author.getName());
        System.out.println("----------------------");
    }

    public void updateContent(String newContent) {
        this.content = newContent;
    }

}
