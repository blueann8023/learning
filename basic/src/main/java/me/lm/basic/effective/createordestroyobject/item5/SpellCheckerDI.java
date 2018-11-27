package me.lm.basic.effective.createordestroyobject.item5;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Created by blue_ann on 29/08/2018.
 */
public class SpellCheckerDI implements SpellChecker{

    private Lexicon dictionary ;

    public SpellCheckerDI(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public SpellCheckerDI(Supplier<Lexicon> dictionary) {
        this.dictionary = dictionary.get();
    }

    @Override
    public boolean isValid(String word) {
        if (dictionary.constains(word)) {
            return true;
        }
        return false;
    }

    public static SpellChecker create(Supplier<Lexicon> dictionary){
        return new SpellCheckerDI(dictionary);
    }
}
