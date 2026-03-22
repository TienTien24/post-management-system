public class Main {

    public static void main(String[] args) {

        User user = new User(1, "Tien");

        Post post1 = new Post(1, "Java OOP", "Learning Java OOP", user);
        Post post2 = new Post(2, "GitHub Flow", "Using Pull Request", user);

        PostManager manager = new PostManager();

        manager.createPost(post1);
        manager.createPost(post2);

        System.out.println("List of posts:");
        manager.showPosts();

        manager.updatePost(0, "Updated Java OOP content");

        System.out.println("After update:");
        manager.showPosts();

    }

}
