/*
 */

/*
package one.prio.exc.one.bag;

import java.util.TreeMap;
import java.util.Iterator;

public class TreeBag<T> implements Bag<T> {
  private TreeMap<Integer, T> map;

  public TreeBag () {
    this.map = new TreeMap<>();
  }

  public Bag<T> add(T element) {
    final int idx = this.map.size() + 1;
    this.map.put(idx, element);
    return this;
  }

  public Bag<T> add(T element, int times) {
    for (int i = 0; i < times; i++) {
      this.add(element);
    }
  }
  
  public int contains(T element) {
    int n = 0;
    this.map.values().forEach((T e) -> {
      if (e.equals(element)) {
        n++;
      }
    });
    return n;
  }

  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private int idx = 0;
      public boolean hasNext() {
      }
      public T next() {
        
      }
    };
  }

}
*/
