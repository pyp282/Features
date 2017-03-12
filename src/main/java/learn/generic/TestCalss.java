package learn.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pei on 2017/3/9.
 */
public class TestCalss {
    public static void main(String[] args) {
        List<? extends Animal> list = new ArrayList<>();
        list.add(null);
    }
}
