/*
 */

package one.prio.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Arrays;

public class UniqueList extends ArrayList<Integer> {

  public UniqueList (Integer... args) {
    super();
    this.addAll(Arrays.asList(args));
  }

  @Override
  public boolean add(Integer n) {
    boolean elementExist = super.contains(n);
    return !elementExist && super.add(n);
  }

  @Override
   public void add(int idx, Integer n) throws IndexOutOfBoundsException, IllegalArgumentException {
     if (super.contains(n)) {
       throw new IllegalArgumentException();
     }
     super.add(idx, n);
   }

  @Override
  public boolean addAll(Collection<? extends Integer> elements) {
    final int initialLength = super.size();

    elements.forEach(this::add);

    return initialLength == super.size();
  }

  public boolean addAll(int idx, Collection<? extends Integer> elements) {
    final int initialLength = super.size();
    int currentIdx = idx;

    for (int e : elements) {
      this.add(currentIdx++, e);
    }

    return initialLength <= super.size();
  }

  @Override
   public Integer set(int idx, Integer element) throws IllegalArgumentException {
     if (super.contains(element)) {
      throw new IllegalArgumentException();
     }
     return super.set(idx, element);
   }
}
