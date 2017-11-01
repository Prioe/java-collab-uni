/*
 * Copyright (c) 2017-present, Michael Albertz, Thimo Schneider.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package one.prio.lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class UniqueList extends ArrayList<Integer> {

  public UniqueList(Integer... args) {
    super();
    this.addAll(Arrays.asList(args));
  }

  @Override
  public boolean add(Integer n) {
    Objects.requireNonNull(n);
    boolean elementExist = super.contains(n);
    return !elementExist && super.add(n);
  }

  @Override
  public void add(int idx, Integer n) throws IndexOutOfBoundsException, IllegalArgumentException {
    Objects.requireNonNull(n);

    if (super.contains(n)) {
      throw new IllegalArgumentException();
    }
    super.add(idx, n);
  }

  @Override
  public boolean addAll(Collection<? extends Integer> elements) {
    Objects.requireNonNull(elements);

    final int initialLength = super.size();

    elements.forEach(this::add);

    return initialLength < super.size();
  }

  public boolean addAll(int idx, Collection<? extends Integer> elements) {
    Objects.requireNonNull(elements);

    final int initialLength = super.size();
    int currentIdx = idx;

    for (int e : elements) {
      this.add(currentIdx++, e);
    }

    return initialLength < super.size();
  }

  @Override
  public Integer set(int idx, Integer element) throws IllegalArgumentException {
    Objects.requireNonNull(element);
    int elementIdx = super.indexOf(element);

    if (elementIdx >= 0 && idx != elementIdx) {
      throw new IllegalArgumentException();
    }
    return super.set(idx, element);
  }
}
