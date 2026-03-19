import java.sql.*;

public class PostManager {

    public void createPost(Post post) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO Posts(title, content, author_id) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, post.getTitle());
            ps.setString(2, post.getContent());
            ps.setInt(3, post.getAuthor().getId());

            ps.executeUpdate();

            System.out.println("Saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showPosts() {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = """
                        SELECT p.id, p.title, p.content, u.username
                        FROM Posts p
                        JOIN Users u ON p.author_id = u.id
                    """;

            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Content: " + rs.getString("content"));
                System.out.println("Author: " + rs.getString("username"));
                System.out.println("----------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePost(int id, String newContent) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE Posts SET content = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, newContent);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}