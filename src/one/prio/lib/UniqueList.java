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

  /**
   * Erhält eine beliebige Anzahl ganzer Zahlen und initialisiert die Liste damit. Ignoriert Duplikate, das heißt
   * Elemente, die schon weiter vorne vorgekommen sind.
   *
   * @param elements Elemente.
   */
  public UniqueList(Integer... elements) {
    super();
    this.addAll(Arrays.asList(elements));
  }

  /**
   * Erhält ein Element und fügt es hinten an. Ignoriert Duplikate. Liefert true, wenn diese Liste wächst und false
   * ansonsten.
   *
   * @param n Neues Element.
   * @return wurde Element hinzugefügt.
   */
  @Override
  public boolean add(Integer n) {
    Objects.requireNonNull(n);
    boolean elementExist = super.contains(n);
    return !elementExist && super.add(n);
  }

  /**
   * Erhält einen Index und ein Element und schiebt das Element am Index ein. Die vorhandenen Elemente machen Platz
   * und rücken nach hinten. Liefert nichts
   *
   * @param idx Index an dem das Element hinzugefügt wird.
   * @param n   Neues Element.
   * @throws IndexOutOfBoundsException wenn der gewählte Index zu hoch oder zu niedrig ist.
   * @throws IllegalArgumentException  wenn das Element schon vorhanden ist.
   */
  @Override
  public void add(int idx, Integer n) throws IndexOutOfBoundsException, IllegalArgumentException {
    Objects.requireNonNull(n);

    if (super.contains(n)) {
      throw new IllegalArgumentException();
    }
    super.add(idx, n);
  }

  /**
   * Erhält eine Collection mit ganzen Zahlen und fügt deren Elemente alle nacheinander hinten an diese Liste an.
   * Lässt Duplikate weg. Liefert true, wenn diese
   * Liste wächst und false ansonsten.
   *
   * @param elements Elemente.
   * @return hat sich die Länge der Liste geändert.
   */
  @Override
  public boolean addAll(Collection<? extends Integer> elements) {
    Objects.requireNonNull(elements);

    final int initialLength = super.size();

    elements.forEach(this::add);

    return initialLength < super.size();
  }

  /**
   * Erhält einen Index und eine Collection mit ganzen Zahlen und fügt deren Elemente am Index ein. Die vorhandenen
   * Elemente machen Platz und rücken nach
   * hinten.
   *
   * @param idx Index an dem die Elemente hinzugefügt werden.
   * @param elements Elemente.
   * @return hat sich die Länge der Liste geändert.
   */
  public boolean addAll(int idx, Collection<? extends Integer> elements) {
    Objects.requireNonNull(elements);

    final int initialLength = super.size();
    int currentIdx = idx;

    for (int e : elements) {
      this.add(currentIdx++, e);
    }

    return initialLength < super.size();
  }

  /**
   * Erhält einen Index und ein Element und ersetzt das Element am Index   * @param idx
   * @param element Element
   * @return das ursprüngliche Element am Index.
   * @throws IndexOutOfBoundsException wenn der gewählte Index zu hoch oder zu niedrig ist.
   * @throws IllegalArgumentException  wenn das Element schon vorhanden ist.
   */
  @Override
  public Integer set(int idx, Integer element) throws IllegalArgumentException, IndexOutOfBoundsException {
    Objects.requireNonNull(element);
    int elementIdx = super.indexOf(element);

    if (elementIdx >= 0 && idx != elementIdx) {
      throw new IllegalArgumentException();
    }
    return super.set(idx, element);
  }
}
