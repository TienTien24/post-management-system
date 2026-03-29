package repository;

import model.Translation;
import java.util.*;

public class TranslationRepository {

    private List<Translation> list = new ArrayList<>();

    public void save(Translation t) {
        list.add(t);
    }

    public List<Translation> findByPost(int postId) {
        List<Translation> result = new ArrayList<>();
        for (Translation t : list) {
            if (t.getPostId() == postId)
                result.add(t);
        }
        return result;
    }
}