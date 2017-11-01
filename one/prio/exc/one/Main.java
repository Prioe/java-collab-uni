/*
 * Copyright 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

package one.prio.exc.one;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    UniqueList ul0 = new UniqueList();
    UniqueList ul1 = new UniqueList(1, 2, 3);
    UniqueList ulx = new UniqueList(1, 2, 1);
    int n = ul1.set(1, 1);
    System.out.println(ul1);
    System.out.println(n);
  }
}
