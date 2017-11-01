/* (C) 2016, Gudrun Schiedermeier, gschied@haw-landshut.de
 * Oracle Corporation Java 1.8.0_72, Linux i386 4.4.0
 * mozart (Intel Core i7-4600U CPU/2701 MHz, 4 Cores, 11776 MB RAM)
 */
package one.prio.lib.bag;

import java.util.Iterator;

/**
 * Eine Tuete mit Elementen.
 * Geordnete Elemente wie ein TreeSet.
 * Kann Duplikate enthalten wie eine Liste.
 * Eine Tuete mit Buchstaben kann beispielweise ein A, zwei B und eine Million C enthalten.
 *
 * @param T Elementtyp. Beliebiger Referenztyp.
 * @author Gudrun Schiedermeier, gschied@haw-landshut.de
 * @version 2017-10-08
 */
public interface Bag<T> extends Iterable<T> {
  /**
   * Fuegt ein Exemplar von element ein.
   *
   * @param element Element.
   * @return Diese Tuete.
   */
  Bag<T> add(T element);

  /**
   * Fuer times Exemplare von element ein.
   *
   * @param element Element.
   * @param times   Anzahl Exemplare.
   * @return Diese Tuete.
   * @throws IllegalArgumentException wenn die Anzahl negativ ist.
   */
  Bag<T> add(T element, int times);

  /**
   * Liefert die Anzahl Exemplare eines Elementes.
   *
   * @param element Ein Element.
   * @return Anzahl Exemplare. 0, wenn das Element ueberhaupt nicht enthalten ist.
   * Nicht negativ.
   */
  int contains(T element);

  /**
   * Ein Iterator ueber alle Elemente.
   *
   * @return Iterator.
   */
  Iterator<T> iterator();

  /**
   * Entfernt ein Exemplar eines Elementes.
   *
   * @param element Ein Element.
   * @return true, wenn die Tuete geschrumpft ist;
   * false, wenn das Element nicht enthalten war.
   */
  boolean remove(T element);

  /**
   * Entfernt alle Exemplare eines Elementes.
   *
   * @param element Ein Element.
   * @return true, wenn die Tuete geschrumpft ist;
   * false, wenn das Element nicht enthalten war.
   */
  boolean removeAll(T element);

  /**
   * Liefert die Gesamtzahl aller Elemente.
   *
   * @return Anzahl Elemente. 0, wenn die Tuete leer ist. Nicht negativ.
   */
  int size();

  /**
   * Entfernt alle Elemente aus der Tuete. Nachher ist die leer.
   *
   * @return Diese Tuete.
   */
  Bag<T> clear();

}
