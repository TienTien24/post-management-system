package service;

import model.Comment;
import model.Post;
import model.Translation;
import model.User;
import repository.CommentRepository;
import repository.PostRepository;
import repository.TranslationRepository;
import repository.UserRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final TranslationRepository translationRepository;

    public PostService(PostRepository postRepository,
            UserRepository userRepository,
            CommentRepository commentRepository,
            TranslationRepository translationRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
        this.translationRepository = translationRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void saveTranslation(Translation translation) {
        translationRepository.save(translation);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(int id) {
        return postRepository.findById(id);
    }

    public List<Comment> getCommentsByPost(int postId) {
        return commentRepository.findByPost(postId);
    }

    public List<Translation> getTranslationsByPost(int postId) {
        return translationRepository.findByPost(postId);
    }
}
