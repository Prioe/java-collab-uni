/*
 */

package one.prio.lib;

import one.prio.lib.bag.Bag;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class TreeBag<T> implements Bag<T> {
  private Map<T, Integer> map = new TreeMap<>();


  @Override
  public String toString() {
    return this.map.toString();
  }

  /**
   * Fuegt ein Exemplar von element ein.
   *
   * @param element Element.
   * @return Diese Tuete.
   */
  @Override
  public Bag<T> add(T element) {

    Integer amountOrNull = this.map.get(element);
    
    this.map.put(element, amountOrNull == null ? 1 : ++amountOrNull);
    return this;
  }

  /**
   * Fuer times Exemplare von element ein.
   *
   * @param element Element.
   * @param times   Anzahl Exemplare.
   * @return Diese Tuete.
   * @throws IllegalArgumentException wenn die Anzahl negativ ist.
   */
  @Override
  public Bag<T> add(T element, int times) {
    for (int i = 0; i < times; i++) {
      this.add(element);
    }
    return this;
  }

  /**
   * Liefert die Anzahl Exemplare eines Elementes.
   *
   * @param element Ein Element.
   * @return Anzahl Exemplare. 0, wenn das Element ueberhaupt nicht enthalten ist.
   * Nicht negativ.
   */
  @Override
  public int contains(T element) {
    if(this.map.containsKey(element)){
      return this.map.get(element);
    }
    return 0;
  }

  /**
   * Ein Iterator ueber alle Elemente.
   *
   * @return Iterator.
   */
  @Override
  public Iterator<T> iterator() {
    return null;
  }

  /**
   * Entfernt ein Exemplar eines Elementes.
   *
   * @param element Ein Element.
   * @return true, wenn die Tuete geschrumpft ist;
   * false, wenn das Element nicht enthalten war.
   */
  @Override
  public boolean remove(T element) {
    return false;
  }

  /**
   * Entfernt alle Exemplare eines Elementes.
   *
   * @param element Ein Element.
   * @return true, wenn die Tuete geschrumpft ist;
   * false, wenn das Element nicht enthalten war.
   */
  @Override
  public boolean removeAll(T element) {
    return false;
  }

  /**
   * Liefert die Gesamtzahl aller Elemente.
   *
   * @return Anzahl Elemente. 0, wenn die Tuete leer ist. Nicht negativ.
   */
  @Override
  public int size() {
    return 0;
  }

  /**
   * Entfernt alle Elemente aus der Tuete. Nachher ist die leer.
   *
   * @return Diese Tuete.
   */
  @Override
  public Bag<T> clear() {
    return null;
  }
}
