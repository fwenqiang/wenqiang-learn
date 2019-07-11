package com.wq.collection.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set treeSet =new TreeSet<String>();
        treeSet.add("eric");
        treeSet.add("方梦圆");
        treeSet.add("maggie");
        treeSet.add("范文强");

        Iterator iterator = treeSet.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

       //treeSet.toArray();
    }
}
