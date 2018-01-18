package algorithms;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2017/12/29.
 */
public class DFS {
    public void depthFirstSearch(){
        Stack<Map<String,Object>> nodeStack = new Stack<>();
        Map<String,Object> node = new HashMap<>();
        node.put("A",
                Arrays.asList(
                        new HashMap<String,Object>().put("B",
                        Arrays.asList(new HashMap<String,Object>().put("D",
                                Arrays.asList(new HashMap<String,Object>().put("F",
                                        Arrays.asList(new HashMap<String,Object>().put("G",null))))))),
                        new HashMap<String,Object>().put("C",
                        Arrays.asList(new HashMap<String,Object>().put("E",null)))
                )
        );
        nodeStack.push(node);

        while (!nodeStack.isEmpty()){
            node = nodeStack.peek();
            System.out.println("当前节点：" + node.keySet().stream().findFirst().get());
            Collection<Map<String,Object>> children = getChildren(node);
            if (children!=null && !children.isEmpty()){
                for (Map child : children){
                    nodeStack.push(child);
                }
            }
        }
    }

    public Collection<Map<String,Object>> getChildren(Map<String,Object> node)
    {
        if (node==null){
            return null;
        }
        List<Map<String,Object>> list = new ArrayList<>();
        for(Object obj:node.values()) {
            if (obj instanceof Collection){
                list.addAll((Collection)obj);
            }
        }
        return list;
    }

}
