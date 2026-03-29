package manager;

import service.AIService;
import model.Post;

public class AIManager {
    private final AIService aiService;

    public AIManager(AIService aiService) {
        this.aiService = aiService;
    }

    public String summarizePost(Post post) {
        if (post == null) {
            return "No post available.";
        }
        return aiService.generateSummary(post.toString());
    }
}
