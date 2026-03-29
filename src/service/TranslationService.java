package service;

import model.Translation;
import repository.TranslationRepository;

import java.util.List;

public class TranslationService {
    private final TranslationRepository translationRepository;

    public TranslationService(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    public void saveTranslation(Translation translation) {
        translationRepository.save(translation);
    }

    public List<Translation> getTranslationsByPost(int postId) {
        return translationRepository.findByPost(postId);
    }
}
