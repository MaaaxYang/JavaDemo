/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package classDir;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUMap<K,V> extends LinkedHashMap<K,V> {

    private int capactiy;

    public int getCapactiy() {
        return capactiy;
    }

    public void setCapactiy(int capactiy) {
        this.capactiy = capactiy;
    }

    public LRUMap(int capactiy, float loadFactor) {
        super(capactiy, loadFactor, true);
        this.capactiy = capactiy;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>capactiy;
    }
}
