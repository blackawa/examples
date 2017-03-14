package example.blackawa.jp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MyListTest {
    private <T extends MyElement> MyList<T> generateList(Status... s) {
        MyList<T> res = new MyList<>();
        for (int i = 0; i < s.length; i++) {
            res.add((T) new MyElement(s[i], i));
        }
        return res;
    }

    /* isDisabled */

    @Test
    public void 全要素がDISABLEDならtrue() {
        MyList<MyElement> elms = generateList(Status.DISABLED, Status.DISABLED, Status.DISABLED);
        assertThat(elms.isDisabled(), is(true));
    }

    @Test
    public void ACTIVATEDな要素があればfalse() {
        MyList<MyElement> elms = generateList(Status.DISABLED, Status.ACTIVATED, Status.DISABLED);
        assertThat(elms.isDisabled(), is(false));
    }

    @Test
    public void 空リストならfalse() {
        MyList<MyElement> elms = generateList();
        assertThat(elms.isDisabled(), is(false));
    }
}
