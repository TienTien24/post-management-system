package repository;

import model.Post;
import java.util.*;

public class PostRepository {
    private List<Post> posts = new ArrayList<>();

    public void save(Post post) {
        posts.add(post);
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findById(int id) {
        for (Post p : posts) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }
}