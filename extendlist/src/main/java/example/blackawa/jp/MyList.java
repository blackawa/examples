package example.blackawa.jp;

import java.util.ArrayList;

public class MyList<E extends MyElement> extends ArrayList<E> {
    /**
     * すべての要素がdisabledか調べる.
     *
     * @return すべての要素がdisabledならtrue
     */
    public boolean isDisabled() {
        return !isEmpty() && stream().allMatch(elm -> elm.getStatus() == Status.DISABLED);
    }
}
