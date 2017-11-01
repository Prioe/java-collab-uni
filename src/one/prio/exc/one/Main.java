/*
 * Copyright 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package one.prio.exc.one;

import one.prio.lib.bag.TreeBag;
import one.prio.lib.UniqueList;

public class Main {
  public static void main(String[] args) {
    System.out.println("Aufgabe 1, Praktikum Programmieren 3:");
    System.out.println();
    UniqueList ul0 = new UniqueList();
    UniqueList ul1 = new UniqueList(1, 2, 3);
    UniqueList ul2 = new UniqueList(1, 2, 1);

    System.out.println("ul0: " + ul0);
    System.out.println("ul1: " + ul1);
    System.out.println("ul2: " + ul2);

    TreeBag<Integer> tb0 = new TreeBag<>();

    System.out.println("tb0<init>: " + tb0);

    tb0.add(1);
    System.out.println("tb0<add1>: " + tb0);

    tb0.add(1);
    System.out.println("tb0<addDuplicate>: " + tb0);

    tb0.add(2, 5);
    System.out.println("tb0<add2x5>: " + tb0);

    tb0.add(1, 500);
    System.out.println("tb0<addDuplicatex500>: " + tb0);

    tb0.remove(1);
    System.out.println("tb0<remove1>: " + tb0);

    tb0.removeAll(2);
    System.out.println("tb0<removeAll>: " + tb0);


    System.out.println("size:" + tb0.size());

    System.out.println("tb0<contain>: " + tb0.contains(1));
    System.out.println("tb0<containNothingThere>: " + tb0.contains(5));

  }
}
