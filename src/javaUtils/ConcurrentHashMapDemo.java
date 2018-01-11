package javaUtils;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public void run()
    {
        concurrentHashMapTest();
    }

    public void concurrentHashMapTest(){
        ConcurrentHashMap<String,Integer> concurrentHashMap = new ConcurrentHashMap<>();

        concurrentHashMap.put("test",123);
        concurrentHashMap.put("test",666565);
        concurrentHashMap.put("XXX",9999);
        Integer value = concurrentHashMap.get("test");
        System.out.println("value："+ value);

        Integer absentVal = concurrentHashMap.computeIfAbsent("key",(_key)->9);
        System.out.println("absentVal："+ absentVal);
        Integer presentVal = concurrentHashMap.computeIfPresent("test",(_key,_value)->6);
        System.out.println("presentVal："+ presentVal);
    }


}
