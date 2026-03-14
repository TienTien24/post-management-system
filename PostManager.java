public class PostManager {

    public int getTotalPosts(int a, int b){
        return a + b; 
    }

    public static void main(String[] args) {
        PostManager pm = new PostManager();
        int total = pm.getTotalPosts(5,3);
        System.out.println("Total posts: " + total);
    }
}
