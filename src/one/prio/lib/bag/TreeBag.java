/*
 */

package one.prio.lib.bag;

import java.util.Map;
import java.util.Set;
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
    Integer amountOrNull = this.map.get(element);
    this.map.put(element, amountOrNull == null ? times : amountOrNull + times);
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
    return this.map.getOrDefault(element, 0);
  }

  /**
   * Ein Iterator ueber alle Elemente.
   *
   * @return Iterator.
   *  */
  @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Iterator<Map.Entry<T, Integer>> entryIterator = TreeBag.this.map.entrySet().iterator();
            private Map.Entry<T, Integer> currentEntry = entryIterator.next();
            private int currentIdx = 0;

            @Override
            public boolean hasNext() {
              return !(this.currentEntry.getValue() <= this.currentIdx) || this.entryIterator.hasNext();
            }

            @Override
            public T next() {
              if (this.currentEntry.getValue() <= this.currentIdx) {
                this.currentEntry = this.entryIterator.next();
                this.currentIdx = 0;
              }
              this.currentIdx++;
              return this.currentEntry.getKey();
            }

            @Override
            public void remove() {
                TreeBag.this.remove(this.currentEntry.getKey());
            }
        };
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
    if(!this.map.containsKey(element)) return false;

    int currentAmount = this.map.get(element);
    if(currentAmount <= 1){
      this.map.remove(element);
    } else {
      this.map.put(element, currentAmount - 1);
    }
    return true;
  }

  /**
   * Entfernt alle Exemplare eines Elementes.
   *
   * @param element Ein Element.
   * @return true, wenn die Tuete geschrumpft ist;
   * false, wenn das Element nicht enthalten war.
   */
  @Override
  public boolean removeAll(T element)
  {
    if (!this.map.containsKey(element)) return false;
    this.map.remove(element);
    return true;
  }

  /**
   * Liefert die Gesamtzahl aller Elemente.
   *
   * @return Anzahl Elemente. 0, wenn die Tuete leer ist. Nicht negativ.
   */
  @Override
  public int size()
  {
    int sum = 0;
    for (int value : this.map.values()) {
      sum += value;
    }
    return sum;
  }

  /**
   * Entfernt alle Elemente aus der Tuete. Nachher ist die leer.
   *
   * @return Diese Tuete.
   */
  @Override
  public Bag<T> clear()
  {
    this.map.clear();
    return this;
  }
}
