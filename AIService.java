public class AIService {

    public static void runAI() {
        System.out.println("AI TASK");

        System.out.println("""
                SQL:
                SELECT pt.title
                FROM Posts p
                JOIN Post_Translations pt ON p.id = pt.post_id
                JOIN Languages l ON pt.language_id = l.id
                WHERE l.code = 'en';

                Explanation:
                This query retrieves all English posts.

                Query Plan:
                The database filters language first, then joins related tables using foreign keys.
                """);
    }
}