/*
 * Copyright (c) 2017-present, Michael Albertz, Thimo Schneider.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package one.prio.lib;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class UniqueListTest {
  private UniqueList ul;

  @Before
  public void initialize() {
    ul = new UniqueList(1, 2, 3);
  }

  @Test
  public void testConstructor_passingNoArguments_shouldCreateAnEmptyList() throws Exception {
    UniqueList ul0 = new UniqueList();
    assertArrayEquals(new Integer[]{}, ul0.toArray());
  }

  @Test
  public void testConstructor_passingAUniqueArray_shouldDuplicateTheArray() throws Exception {
    UniqueList ul0 = new UniqueList(1, 2, 3);
    assertArrayEquals(new Integer[]{1, 2, 3}, ul0.toArray());
  }

  @Test
  public void testConstructor_passingANonUniqueArray_shouldRemoveTheDuplicates() throws Exception {
    UniqueList ul0 = new UniqueList(1, 2, 1);
    assertArrayEquals(new Integer[]{1, 2}, ul0.toArray());
  }

  @Test
  public void testAdd_addingNonExistentElement_shouldAppendElement() throws Exception {
    assertTrue(ul.add(4));
    assertArrayEquals(new Integer[]{1, 2, 3, 4}, ul.toArray());
  }

  @Test
  public void testAdd_addingDuplicate_shouldNotAlterList() throws Exception {
    assertFalse(ul.add(2));
    assertArrayEquals(new Integer[]{1, 2, 3}, ul.toArray());
  }

  @Test
  public void testAdd_addingAUniqueElementAtAValidIndex_shouldInsertTheElement() throws Exception {
    ul.add(0, 4);
    assertArrayEquals(new Integer[]{4, 1, 2, 3}, ul.toArray());

  }

  @Test
  public void testAdd_addingAUniqueElementAtListLength_shouldAppendTheElement() throws Exception {
    ul.add(3, 4);
    assertArrayEquals(new Integer[]{1, 2, 3, 4}, ul.toArray());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testAdd_addingAtAnInvalidIndex_shouldThrowOutOfBounds() throws Exception {
    ul.add(10, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAdd_addingADuplicateElement_shouldThrowIllegalArgument() throws Exception {
    ul.add(0, 3);
  }

  @Test
  public void testAddAll_addingUniqueElements_shouldAppendElements() throws Exception {
    assertTrue(ul.addAll(Arrays.asList(4, 5, 6)));
    assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, ul.toArray());
  }

  @Test
  public void testAddAll_addingDuplicateElements_shouldOmitTheDuplicates() throws Exception {
    assertTrue(ul.addAll(Arrays.asList(2, 3, 4)));
    assertArrayEquals(new Integer[]{1, 2, 3, 4}, ul.toArray());
  }

  @Test
  public void testAddAll_addingOnlyDuplicateElements_shouldNotMutateTheList() throws Exception {
    assertFalse(ul.addAll(Arrays.asList(1, 2, 3)));
    assertArrayEquals(new Integer[]{1, 2, 3}, ul.toArray());
  }

  @Test
  public void testAddAll_addingUniqueElementsAtAValidIndex_shouldInsertTheElements() throws Exception {
    assertTrue(ul.addAll(1, Arrays.asList(4, 5, 6)));
    assertArrayEquals(new Integer[]{1, 4, 5, 6, 2, 3}, ul.toArray());
  }

  @Test
  public void testAddAll_addingAnEmptyList_shouldNotMutateTheList() throws Exception {
    assertFalse(ul.addAll(1, Collections.emptyList()));
    assertArrayEquals(new Integer[]{1, 2, 3}, ul.toArray());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testAddAll_addingElementsAtAnInvalidIndex_shouldThrowOutOfBounds() throws Exception {
    ul.addAll(-1, Arrays.asList(4, 5, 6));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddAll_addingDuplicateElementsAtAValidIndex_shouldThrowIllegalArgument() throws Exception {
    ul.addAll(1, Arrays.asList(2, 3, 4));
  }


  @Test
  public void testSet_settingAnElementAtAValidIndex_shouldReplaceTheElementAtTheIndex() throws Exception {
    assertEquals((int) ul.set(0, 4), 1);
    assertArrayEquals(ul.toArray(), new Integer[]{4, 2, 3});
  }

  @Test
  public void testSet_settingAnDuplicateElementAtAValidIndex_shouldNotMutateTheList() throws Exception {
    assertEquals((int) ul.set(0, 1), 1);
    assertArrayEquals(ul.toArray(), new Integer[]{1, 2, 3});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testSet_settingAnElementsAtAnInvalidIndex_shouldThrowOutOfBounds() throws Exception {
    ul.set(3, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSet_settingADuplicateElementsAtAValidIndex_shouldThrowIllegalArgument() throws Exception {
    ul.set(1, 1);
  }

}
