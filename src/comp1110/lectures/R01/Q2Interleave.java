package comp1110.lectures.R01;

    public class Q2Interleave {

        /**
         * This function takes two arrays of strings and returns a new array of strings where
         * the elements from a and be are interleaved.
         * For example:
         *    a = {"a", "b", "c", "d"}
         *    b = {"e", "f", "g", "h"}
         * the result will be
         *        {"a", "e", "b", "f", "c", "g", "d", "h"}
         * in the case where one array is longer than the other, the remaining elements
         * will be added to the end of the result:
         *    a = {"a", "b", "c"}
         *    b = {"e"}
         * the result will be
         *        {"a", "e", "b", "c"}
         */
        public static String[] interleave(String[] a, String[] b) {
            String[] result = new String[a.length+b.length];
            int ai = 0;
            int bi = 0;
            int ri = 0;
            while (ai < a.length || bi < b.length) {
                if (ai < a.length)
                    result[ri++] = a[ai++];
                if (bi < b.length)
                    result[ri++] = b[bi++];
            }
            return result;
        }
    }

