import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;

public class Demo2 {
    public static void main(String[] args){
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("aaa","");
        concurrentHashMap.put("bbb","");
        concurrentHashMap.put("ccc","");
        Spliterator spliterator = concurrentHashMap.keySet().spliterator();
        spliterator.forEachRemaining(t->{
            System.out.println(String.valueOf(t));
        });
    }
}
