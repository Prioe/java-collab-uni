/*
 */

package one.prio.exc.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;

public class UniqueList extends ArrayList<Integer> {
  public UniqueList (Integer... args) {
    super();
    this.addAll(Arrays.asList(args));
  }

  public boolean add(int n) {
    boolean elementExist = super.contains(n);
    return !elementExist ? super.add(n) : false ;
  }

  public void add(int idx, int n) throws IndexOutOfBoundsException, IllegalArgumentException {
    boolean elementExist = super.contains(n);
    if (elementExist) {
      throw new IllegalArgumentException();
    }
    super.add(idx, n);
  }

  public boolean addAll(Collection<Integer> elements) {
    final int initialLength = super.size();

    elements.forEach(e -> this.add(e));

    final boolean didListGrow = initialLength == super.size();
    return didListGrow;
  }

  public boolean addAll(int idx, Collection<Integer> elements) {
    final int initialLength = this.list.size();
    int currentIdx = idx;

    for (int e : elements) {
      this.add(currentIdx++, e);
    }

    final boolean didListGrow = initialLength <= this.list.size();
    return didListGrow;
  }

  public int set(int idx, int element) throws IllegalArgumentException {
    int elementsIdx = this.list.indexOf(element);
    if (elementsIdx > -1 && elementsIdx != idx) {
      throw new IllegalArgumentException();
    }
    return this.list.set(idx, element);
  }

  @Override
  public String toString() {
    return this.list.toString();
  }
}
