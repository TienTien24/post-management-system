import java.util.ArrayList;

public class PostManager {

    private ArrayList<Post> postList;

    public PostManager() {
        postList = new ArrayList<>();
    }

    public void createPost(Post post) {
        postList.add(post);
    }

    public void showPosts() {
        if (postList.isEmpty()) {
            System.out.println("No posts available.");
            return;
        }

        for (Post post : postList) {
            post.displayPost();
        }
    }

    public void updatePost(int index, String newContent) {
        if (index >= 0 && index < postList.size()) {
            Post post = postList.get(index);
            post.updateContent(newContent);
            System.out.println("Post updated successfully.");
        } else {
            System.out.println("Post not found.");
        }
    }
}
