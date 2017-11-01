/*
 * Copyright (c) 2017-present, Michael Albertz, Thimo Schneider.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package one.prio.lib;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class UniqueListTest {

  @Test
  public void constructor() throws Exception {
    UniqueList ul0 = new UniqueList();
    assertArrayEquals(ul0.toArray(), new Integer[0]);
    UniqueList ul1 = new UniqueList(1, 2, 3);
    assertArrayEquals(ul1.toArray(), new Integer[]{1, 2, 3});
    UniqueList ul2 = new UniqueList(1, 2, 1);
    assertArrayEquals(ul2.toArray(), new Integer[]{1, 2});
  }

  @Test
  public void add() throws Exception {
    UniqueList ul1 = new UniqueList(1, 2, 3);
    assertTrue(ul1.add(4));
    assertArrayEquals(ul1.toArray(), new Integer[]{1, 2, 3, 4});

    UniqueList ul2 = new UniqueList(1, 2, 3);
    assertFalse(ul2.add(2));
    assertArrayEquals(ul2.toArray(), new Integer[]{1, 2, 3});
  }

  @Test
  public void add1() throws Exception {
    UniqueList ul1 = new UniqueList(1, 2, 3);
    ul1.add(0, 4);
    assertArrayEquals(ul1.toArray(), new Integer[]{4, 1, 2, 3});

    UniqueList ul2 = new UniqueList(1, 2, 3);
    ul2.add(3, 4);
    assertArrayEquals(ul2.toArray(), new Integer[]{1, 2, 3, 4});

  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void add1OutOfBounds() throws Exception {
    UniqueList ul = new UniqueList(1, 2, 3);
    ul.add(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void add1IllegalArgument() throws Exception {
    UniqueList ul = new UniqueList(1, 2, 3);
    ul.add(0, 3);
  }

  @Test
  public void addAll() throws Exception {
    UniqueList ul1 = new UniqueList(1, 2, 3);
    assertTrue(ul1.addAll(Arrays.asList(4, 5, 6)));
    assertArrayEquals(ul1.toArray(), new Integer[]{1, 2, 3, 4, 5, 6});

    UniqueList ul3 = new UniqueList(1, 2, 3);
    assertTrue(ul3.addAll(Arrays.asList(2, 3, 4)));
    assertArrayEquals(ul3.toArray(), new Integer[]{1, 2, 3, 4});

    UniqueList ul2 = new UniqueList(1, 2, 3);
    assertFalse(ul2.addAll(Arrays.asList(1, 2, 3)));
    assertArrayEquals(ul2.toArray(), new Integer[]{1, 2, 3});
  }

  @Test
  public void addAll1() throws Exception {
    UniqueList ul1 = new UniqueList(1, 2, 3);
    assertTrue(ul1.addAll(1, Arrays.asList(4, 5, 6)));
    assertArrayEquals(ul1.toArray(), new Integer[]{1, 4, 5, 6, 2, 3});

    UniqueList ul2 = new UniqueList(1, 2, 3);
    assertFalse(ul2.addAll(1, Collections.emptyList()));
    assertArrayEquals(ul2.toArray(), new Integer[]{1, 2, 3});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void addAll1OutOfBounds() throws Exception {
    UniqueList ul = new UniqueList(1, 2, 3);
    ul.addAll(-1, Arrays.asList(4, 5, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void addAll1IllegalArgument() throws Exception {
    UniqueList ul = new UniqueList(1, 2, 3);
    ul.addAll(1, Arrays.asList(2, 3, 4));
  }


  @Test
  public void set() throws Exception {
    UniqueList ul = new UniqueList(1, 2, 3);
    assertEquals((int) ul.set(0, 4), 1);
    assertArrayEquals(ul.toArray(), new Integer[]{4, 2, 3});

    ul = new UniqueList(1, 2, 3);
    assertEquals((int) ul.set(0, 1), 1);
    assertArrayEquals(ul.toArray(), new Integer[]{1, 2, 3});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void setOutOfBounds() throws Exception {
    UniqueList ul = new UniqueList(1, 2, 3);
    ul.set(3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setIllegalArgument() throws Exception {
    UniqueList ul = new UniqueList(1, 2, 3);
    ul.set(1, 1);
  }

}
