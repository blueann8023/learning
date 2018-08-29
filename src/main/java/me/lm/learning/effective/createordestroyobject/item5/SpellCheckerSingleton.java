package me.lm.learning.effective.createordestroyobject.item5;

/**
 * Created by blue_ann on 29/08/2018.
 */
public class SpellCheckerSingleton implements SpellChecker{

    private final Lexicon dictionary = new Lexicon("English");

    private SpellCheckerSingleton() {
    }

    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    @Override
    public boolean isValid(String word) {
        if (dictionary.constains(word)) {
            return true;
        }
        return false;
    }
}
