package me.lm.basic.effective.createordestroyobject.item5;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Created by blue_ann on 29/08/2018.
 */
public class SpellCheckClient {

    @Test
    public void testSpellCheckerClientSingleton(){
        //英语字典
        SpellCheckerSingleton.INSTANCE.isValid("你好");
    }

    @Test
    public void testSpellCheckerClientStatic(){
        //中文字典
        SpellCheckerStatic.isValid("test");
    }

    // inflexable  and testable
    @Test
    public void testSpellCheckerClientDI(){
        SpellChecker chinesseSpellCheckernew  = new SpellCheckerDI(new Lexicon("Chinesse"));
        chinesseSpellCheckernew.isValid("aa");

        Supplier<Lexicon> englishLexionSupplier = () -> new Lexicon("english");
        SpellChecker englishSpellChecker = new SpellCheckerDI(englishLexionSupplier);
        englishSpellChecker.isValid("bb");

        Supplier<Lexicon> japannesseLexionSupplier = () -> new Lexicon("japannesse");
        SpellChecker japannesseSpellChecker = SpellCheckerDI.create(japannesseLexionSupplier);
        japannesseSpellChecker.isValid("aaa");
    }
}
