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
 * - the solution uses java list instead of array for convenience. The same algorithm would apply for a solution involving classical array
 * -  Arrays would have needed concatenation, re-allocation, copying, etc.
 * - this implementation supports any type, not just Integers. It can work with lists of strings, pojos, etc. (Ex: ["a", ["b","c"], ["d"])
 * - it is not possible to restrict the input parameters such that at each level of the nested structure an element is either an array
 * or a scalar type of the required class (Integer, String, etc) so that invalid structures are detected at compile time
 */

public final class ListFlattener {

    /* prevent instantiation, this is only a utility class */
    private ListFlattener() {
    }

    /**
     * @param list
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> flattenNestedList(List<?> list, Class<T> type) {
        requireNonNull(list, "list cannot be null");
        requireNonNull(type, "type cannot be null");

        List<T> result = new ArrayList<T>();

        for (Object o : list) {
            if (type.isInstance(o)) {
                result.add((T) o);
            } else if (o instanceof List) {
                result.addAll(ListFlattener.flattenNestedList((List<?>) o, type));
            } else {
                throw new IllegalArgumentException("invalid type found - must be instance of " + type.getCanonicalName());
            }
        }
        return result;
    }
}
