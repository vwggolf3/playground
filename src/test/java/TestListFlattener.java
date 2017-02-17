import com.gabrielpop.playground.IntegerListFlattener;
import com.gabrielpop.playground.ListFlattener;
import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Gabriel on 16/02/17.
 * Validates functionality of IntegerListFlattener and ListFlattener
 */

public class TestListFlattener {


    @Test
    public void testFlatteningWith2NestingLevels() {

        List<Integer> flattened = ListFlattener.flattenNestedList(ImmutableList.of(
                ImmutableList.of(1, 2, ImmutableList.of(3, 4),
                        5)), Integer.class);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertEquals("expected " + expected + " but got " + flattened, expected, flattened);

    }

    @Test
    public void testFlatteningWith3NestingLevels() {

        List<Integer> flattened = ListFlattener.flattenNestedList(ImmutableList.of(
                ImmutableList.of(1, 2, ImmutableList.of(3, ImmutableList.of(4)),
                        5)), Integer.class);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        Assert.assertEquals("expected " + expected + " but got " + flattened, expected, flattened);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testFlatteningWithEmptyList() {
        ListFlattener.flattenNestedList(ImmutableList.of(
                ImmutableList.of(1, 2, ImmutableList.of(3),
                        "")), Integer.class);
    }

    @Test(expected = NullPointerException.class)
    public void testFlatteningWithNulls() {
        ListFlattener.flattenNestedList(ImmutableList.of(
                ImmutableList.of(1, null, ImmutableList.of(3),
                        4)), Integer.class);
    }

    @Test
    public void testIntegerFlatteningWith3NestedLevels() {
        List<Integer> flattenedList = IntegerListFlattener.flattenNestedList(ImmutableList.of(1, 2, 3, ImmutableList.of(4)));
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        Assert.assertEquals("expected " + expected + " but got " + flattenedList, expected, flattenedList);

    }
}
