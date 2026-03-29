package manager;

import model.Comment;
import service.CommentService;

import java.util.List;

public class CommentManager {
    private final CommentService commentService;

    public CommentManager(CommentService commentService) {
        this.commentService = commentService;
    }

    public void addComment(Comment comment) {
        commentService.saveComment(comment);
    }

    public List<Comment> getCommentsByPost(int postId) {
        return commentService.getCommentsByPost(postId);
    }
}
