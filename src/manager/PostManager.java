package manager;

import model.Comment;
import model.Post;
import model.Translation;
import model.User;
import service.PostService;

import java.util.List;

public class PostManager {
    private final PostService postService;

    public PostManager(PostService postService) {
        this.postService = postService;
    }

    public void createSampleData() {
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");

        postService.saveUser(user1);
        postService.saveUser(user2);

        Post post1 = new Post(1, "Welcome to the blog", "This is the first post.", user1);
        Post post2 = new Post(2, "Second post", "Today we add a manager layer.", user2);

        postService.savePost(post1);
        postService.savePost(post2);

        Comment comment1 = new Comment(1, "Nice post!");
        Comment comment2 = new Comment(2, "Great addition.");

        postService.saveComment(comment1);
        postService.saveComment(comment2);

        Translation translation1 = new Translation(1, "vi", "Chào mừng đến với blog", "Đây là bài viết đầu tiên.");
        Translation translation2 = new Translation(2, "vi", "Bài viết thứ hai", "Hôm nay chúng ta thêm lớp manager.");

        postService.saveTranslation(translation1);
        postService.saveTranslation(translation2);
    }

    public void displayAllPosts() {
        List<Post> posts = postService.getAllPosts();
        for (Post post : posts) {
            post.display();
            displayComments(post.getId());
            displayTranslations(post.getId());
        }
    }

    public void displayPostById(int postId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            System.out.println("Post details for ID " + postId + ":");
            post.display();
            displayComments(postId);
            displayTranslations(postId);
        } else {
            System.out.println("Post not found: " + postId);
        }
    }

    private void displayComments(int postId) {
        List<Comment> comments = postService.getCommentsByPost(postId);
        if (!comments.isEmpty()) {
            System.out.println("Comments:");
            for (Comment comment : comments) {
                System.out.println("- " + comment.getContent());
            }
        }
    }

    private void displayTranslations(int postId) {
        List<Translation> translations = postService.getTranslationsByPost(postId);
        if (!translations.isEmpty()) {
            System.out.println("Translations:");
            for (Translation translation : translations) {
                translation.display();
            }
        }
    }
}
