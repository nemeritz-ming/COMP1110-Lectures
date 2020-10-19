package comp1110.lectures.C05;

public class BSTSet<T> implements Set<T> {
    @Override
    public void add(T element) {

    }

    @Override
    public void remove(T element) {

    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    public Set<T> newInstance() { return new BSTSet<>(); }
}
