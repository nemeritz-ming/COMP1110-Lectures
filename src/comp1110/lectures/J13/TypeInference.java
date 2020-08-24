package comp1110.lectures.J13;

import java.util.function.IntFunction;

public class TypeInference {
    public static class ThingHolder<T> {
        T value;

        public ThingHolder(T value) {
            this.value = value;
        }

        public static <U> ThingHolder<U> makeHolder(U value) {
            return new ThingHolder<>(value);
        }
    }

    public static void main(String[] args) {
        ThingHolder<String> holder = new ThingHolder<>("Hello");
        var h = new ThingHolder<>("Hi");
        var i = ThingHolder.makeHolder("G'Day");
        var j = ThingHolder.makeHolder(42);
        var k = ThingHolder.makeHolder(42.2);
       // var mystery = null;
        // var mystery;
        //var increment = x -> x + 1;
       // var increment = x -> (int) x + 1;
        IntFunction increment = x -> x + 1;
    }

}
