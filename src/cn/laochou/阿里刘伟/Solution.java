package cn.laochou.阿里刘伟;

import java.util.*;

/**
 * @Author: ITLaochou
 * @Date: 2020/8/9 0009 15:36
 * @Version: 1.0
 */
public class Solution {

    public static void main(String[] args) {
        Map<String, List<String>> maps = new HashMap<>();
        maps.put("A", Arrays.asList("B", "C", "D"));
        maps.put("B", Arrays.asList("D", "E", "F"));
        List<String> result = getStudy(maps);
    }


    public static List<String> getStudy(Map<String, List<String>> maps) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for(Map.Entry<String, List<String>> entry : maps.entrySet()) {
            // 我们需要判断当前课程的依赖是否有其他的依赖.
            List<String> needCourse = entry.getValue();
            stack.addAll(needCourse);
            while (!stack.isEmpty()) {
                String top = stack.pop();
                if(!maps.containsKey(top) && !result.contains(top)) {
                    result.add(top);
                }else {
                    List<String> temp = maps.get(top);
                    stack.addAll(temp);
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
        return result;
    }

}
