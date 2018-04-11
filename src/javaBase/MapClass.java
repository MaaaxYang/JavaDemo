package javaBase;

import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ThreadPoolExecutor;

public class MapClass {

    public static void main(String[] args){
        LinkedHashMap linkedHashMap = new LinkedHashMap(16,0.75f,true);
        linkedHashMap.put(1,1);
        linkedHashMap.put(2,2);
        linkedHashMap.put(3,3);
        Set set1 = linkedHashMap.keySet();
        linkedHashMap.get(2);
        Set set2 = linkedHashMap.keySet();
        System.out.println("");

        TreeMap treeMap = new TreeMap();
        treeMap.put(1,1);
        treeMap.put(2,2);
        treeMap.put(3,3);
        treeMap.get(2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor();
        executor.execute();
    }
}
