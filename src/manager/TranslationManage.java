package manager;

import model.Translation;
import service.TranslationService;

import java.util.List;

public class TranslationManage {
    private final TranslationService translationService;

    public TranslationManage(TranslationService translationService) {
        this.translationService = translationService;
    }

    public void addTranslation(Translation translation) {
        translationService.saveTranslation(translation);
    }

    public List<Translation> getTranslationsByPost(int postId) {
        return translationService.getTranslationsByPost(postId);
    }
}
