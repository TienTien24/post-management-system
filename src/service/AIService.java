package service;

public class AIService {
    public String generateSummary(String text) {
        if (text == null || text.isEmpty()) {
            return "No content to summarize.";
        }
        return "Summary: " + (text.length() <= 50 ? text : text.substring(0, 47) + "...");
    }
}
