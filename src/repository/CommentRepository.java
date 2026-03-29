package repository;

import model.Comment;
import java.util.*;

public class CommentRepository {

    private List<Comment> list = new ArrayList<>();

    public void save(Comment c) {
        list.add(c);
    }

    public List<Comment> findByPost(int postId) {
        List<Comment> result = new ArrayList<>();
        for (Comment c : list) {
            if (c.getPostId() == postId)
                result.add(c);
        }
        return result;
    }
}