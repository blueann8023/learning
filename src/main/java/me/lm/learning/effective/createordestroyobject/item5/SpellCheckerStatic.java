package me.lm.learning.effective.createordestroyobject.item5;

/**
 * Created by blue_ann on 29/08/2018.
 */
public class SpellCheckerStatic{

    private static final Lexicon dictionary = new Lexicon("Chinesse");

    public static boolean isValid(String word) {
        if (dictionary.constains(word)) {
            return true;
        }
        return false;
    }
}
