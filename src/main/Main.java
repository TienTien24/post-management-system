package main;

import manager.PostManager;
import repository.CommentRepository;
import repository.PostRepository;
import repository.TranslationRepository;
import repository.UserRepository;
import service.PostService;

public class Main {
    public static void main(String[] args) {
        PostRepository postRepository = new PostRepository();
        UserRepository userRepository = new UserRepository();
        CommentRepository commentRepository = new CommentRepository();
        TranslationRepository translationRepository = new TranslationRepository();

        PostService postService = new PostService(postRepository, userRepository, commentRepository,
                translationRepository);
        PostManager postManager = new PostManager(postService);

        postManager.createSampleData();
        postManager.displayAllPosts();

        System.out.println("\nDisplay single post by ID");
        postManager.displayPostById(1);
    }
}