package me.lm.learning.effective.createordestroyobject.item7;

/**
 * Created by blue_ann on 04/09/2018.
 */
public class House {
    private String name;
    private Cat cat;

    public House(String name, Cat cat) {
        this.name = name;
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public Cat getCat() {
        return cat;
    }
}
