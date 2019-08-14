import com.sun.tools.javac.util.List;

import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<T> extends HashSet<T> {
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(T elem) {
        addCount++;
        return super.add(elem);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        addCount += collection.size();
        return super.addAll(collection);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        System.out.println("addCount = " + set.getAddCount());
        set.addAll(List.of("one", "two", "three"));
        System.out.println("addCount = " + set.getAddCount());
    }
}
