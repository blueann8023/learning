package me.lm.basic.effective.createordestroyobject.item7;


import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by blue_ann on 04/09/2018.
 */
public class ObsoleteObjectReferences {

    @Test
    public void testWeakReference() throws InterruptedException {
        //强引用
        Cat cat1 = new Cat("mm",10);
        House house = new House("lm",cat1);
        System.out.println(house.getCat());
        cat1 = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(house.getCat());
        //弱引用
        Cat cat = new Cat("mm",10);
        WeakReference<Cat> wrs = new WeakReference<Cat>(cat);
        System.out.println(wrs.get());
        cat = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(wrs.get());
    }

    @Test
    public void testWeakHashMap() throws InterruptedException {
        //normal hashmap
        Map map = new HashMap<CatName,Cat>();
        CatName name = new CatName("mm");
        map.put( name,new Cat("mm",10));
        System.out.println(map.size());
        name = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(map.size());

        //weak hashmap
        Map map1 = new WeakHashMap<CatName,Cat>();
        CatName name1 = new CatName("mm");
        map1.put( name1,new Cat("mm",10));
        System.out.println(map1.size());
        name1 = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println(map1.size());
    }


    //bad situation
    @Test
    public void testBadObsoleteObjectReferences() {
        int size = 0;
        String[] elements = new String[100];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = String.valueOf(i);
            size++;
        }
        size = 10;
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }

    //eliminate situation
    @Test
    public void testEliminateObsoleteObjectReferences() {
        int size = 0;
        String[] elements = new String[100];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = String.valueOf(i);
            size++;
        }
        size = 10;
        for (int i = 10; i < 100; i++) {
            elements[i] = null;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(elements[i]);
        }
    }

}
