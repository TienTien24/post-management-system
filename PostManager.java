import java.util.ArrayList;

public class PostManager {

    ArrayList<Post> postList = new ArrayList<>();

    public void createPost(Post post) {
        postList.add(post);
    }

    public void showPosts() {
        for (Post post : postList) {
            post.displayPost();
        }
    }

    public void updatePost(int index, String newContent) {

        postList.get(index).updateContent(content);

    }

}
