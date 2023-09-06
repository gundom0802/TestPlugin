package testplugin.testplugin.util;

import java.util.HashSet;
import java.util.Set;

public class HotbarSetUtil {

    public static Set<String> set = new HashSet<String>();

    public static Boolean getSet(String s) {

        return set.contains(s);
    }

    public static void setSet(String s) {
        set.add(s);
    }

    public static void removeSet(String s) {
        set.remove(s);
    }
}
