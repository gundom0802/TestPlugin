package testplugin.testplugin.util;

import java.util.HashSet;
import java.util.Set;

public class HotbarSetUtil {

    public static Set<String> set = new HashSet<String>();

    public Boolean getSet(String s) {

        if (set.contains(s)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setSet(String s) {
        set.add(s);
    }

    public void removeSet(String s) {
        set.remove(s);
    }
}
