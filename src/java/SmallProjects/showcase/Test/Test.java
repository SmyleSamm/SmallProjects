package SmallProjects.showcase.Test;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        hashMapsTest();
    }
    public static void hashMapsTest(){
        HashMap<String, Integer> empIds = new HashMap<>();
        empIds.put("Samm", 123);
        empIds.put("Nox", 124);
        empIds.put("Kevin", 125);
        empIds.put("Carl", 126);
        empIds.put("Jesus", 127);
        empIds.put("God", 128);
        System.out.println(empIds);
        System.out.println(empIds.get("Carl"));
        System.out.println(empIds.containsValue(122));
        System.out.println(empIds.containsValue(123));
    }
}
