public class Main {

    public static void main(String[] args) {

        User user = new User(1, "Tien");

        Post post1 = new Post(1, "Java OOP", "Learning Java", user);
        Post post2 = new Post(2, "GitHub", "Using PR", user);

        PostManager manager = new PostManager();

        manager.createPost(post1);
        manager.createPost(post2);

        manager.showPosts();

        manager.updatePost(1, "Updated content");

        AIService.runAI();
    }
}