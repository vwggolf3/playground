package com.gabrielpop.playground;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Created by Gabriel on 16/02/17.
 * <p>
 * <p>
 * ### REQUIREMENT ###
 * Write some code, that will flatten an array of arbitrarily nested arrays of integers
 * into a flat array of integers.
 * e.g. [[1,2,[3]],4] -> [1,2,3,4].
 * important that you still have a strong grasp of the fundamentals.
 * Please submit code as close as possible to what you’d commit to production or push to an open source project.
 * Some test cases are expected. We’d recommend you use whatever language you feel strongest in (it doesn’t have to be one we use).
 * <p>
 * ### SOLUTION ###
 * - the solution uses java list instead of array. The same algorithm would apply for a solution involving classical array
 * -  Arrays would have needed concatenation, re-allocation, copying, etc.
 * - this implementation (IntegerListFlattener) supports just Integers. The class ListFlattener supports any type. It can work with lists of strings, pojos, etc. (Ex: ["a", ["b","c"], ["d"])
 * - it is not possible to restrict the input parameters such that at each level of the nested structure an element is either an array
 * or a scalar type of the required class (Integer, String, etc) so that invalid structures are detected at compile time
 */

public final class IntegerListFlattener {

    /* prevent instantiation, this is only a utility class */
    private IntegerListFlattener() {
    }

    /**
     * @param list
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Integer> flattenNestedList(List list) {
        requireNonNull(list, "list cannot be null");

        List<Integer> result = new ArrayList<Integer>();

        for (Object o : list) {
            if (o instanceof Integer) {
                result.add((Integer) o);
            } else if (o instanceof List) {
                result.addAll(IntegerListFlattener.flattenNestedList((List) o));
            } else {
                throw new IllegalArgumentException("invalid type found - must be instance of " + Integer.class.getCanonicalName());
            }
        }
        return result;
    }
}
