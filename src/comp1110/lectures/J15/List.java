package comp1110.lectures.J15;

public interface List<T> {
    public void add(T value);
    public T remove(int index);
    public int size();
    public T get(int index);
    public void reverse();
}
