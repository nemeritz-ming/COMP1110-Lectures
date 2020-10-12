package comp1110.lectures.A05;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetTest {
    private static final boolean HASH_SET = false;
    @Test
    public void testAdd() {
        // only assume that size() works, and toString() works
        Set<String> set = HASH_SET ? new HashSet<>() : new BSTSet<>();
        assertTrue(set.size() == 0);
        set.put("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.put("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.put("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.put("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.put("Cindy");
        assertTrue(set.size() == 3);
        set.put("Cindy");
        assertTrue(set.size() == 3);
    }

    @Test
    public void testAddNull() {
        // only assume that size() works, and toString() works
        Set<String> set = HASH_SET ? new HashSet<>() : new BSTSet<>();
        assertTrue(set.size() == 0);
        set.put(null);
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("null"));
        set.put(null);
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("null"));
        set.put("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("null, Bob") || set.toString().equals("Bob, null"));
        set.put("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("null, Bob") || set.toString().equals("Bob, null"));
        set.put("Cindy");
        assertTrue(set.size() == 3);
        set.put("Cindy");
        assertTrue(set.size() == 3);
    }


    @Test
    public void testContains() {
        // only assume that size() works, toString() works, and add() works
        Set<String> set = HASH_SET ? new HashSet<>() : new BSTSet<>();
        assertTrue(set.size() == 0);
        set.put("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        assertTrue(set.contains("Alice"));
        assertFalse(set.contains("Bob"));
        set.put("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.put("Bob");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertFalse(set.contains("Cindy"));

        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.put("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.put("Cindy");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertTrue(set.contains("Cindy"));
        assertTrue(set.size() == 3);
        set.put("Cindy");
        assertTrue(set.size() == 3);
    }

    @Test
    public void testRemove() {
        // only assume that size() works, toString() works, add() works and contains() works
        Set<String> set = HASH_SET ? new HashSet<>() : new BSTSet<>();
        assertTrue(set.size() == 0);
        set.put("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        assertTrue(set.contains("Alice"));
        assertFalse(set.contains("Bob"));
        set.remove("Alice");
        set.remove("Bob");
        set.remove("Cindy");
        assertTrue(set.size() == 0);
        set.put("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.put("Alice");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.put("Bob");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertFalse(set.contains("Cindy"));

        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));
        set.put("Bob");
        assertTrue(set.size() == 2);
        assertTrue(set.toString().equals("Alice, Bob") || set.toString().equals("Bob, Alice"));

        // set.remove("Alice");
        set.remove("Bob");
        set.remove("Cindy");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.put("Bob");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertFalse(set.contains("Cindy"));

        set.put("Cindy");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertTrue(set.contains("Cindy"));
        assertTrue(set.size() == 3);
        set.put("Cindy");
        assertTrue(set.size() == 3);
        // set.remove("Alice");
        set.remove("Bob");
        set.remove("Cindy");
        assertTrue(set.size() == 1);
        assertTrue(set.toString().equals("Alice"));
        set.put("Bob");
        set.put("Cindy");
        assertTrue(set.contains("Alice"));
        assertTrue(set.contains("Bob"));
        assertTrue(set.contains("Cindy"));
    }
}
