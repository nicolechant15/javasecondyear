import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Collection {
    public static void main(String[] args) {
        List<String> spices = new ArrayList<>();
        spices.add("paprika");
        spices.add("cinnamon");
        spices.add("cardamon");
        spices.add("pepper");
        spices.add("cinnamon");
        System.out.println("С дублями:");
        System.out.println(spices);
        System.out.println("Без дублей:");
        Set<String> set = new HashSet<>(spices);
        spices.clear();
        spices.addAll(set);
        System.out.println(spices);
    }
}
