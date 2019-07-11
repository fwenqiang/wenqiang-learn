package com.wq.collection.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set hashSet =new HashSet<String>();
        hashSet.add("方梦圆");
        hashSet.add("范文强");

        hashSet.add("eric");
        hashSet.add("maggie");

        Iterator iterator = hashSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        //hashSet.toArray();

        System.out.println(hashSet);
    }
}
