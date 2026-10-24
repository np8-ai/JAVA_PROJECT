package experiment;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FragileBaseClassDemo {
    public static void run() {
        InstrumentedSet<String> inheritedSet = new InstrumentedSet<>();
        inheritedSet.addAll(Set.of("A", "B", "C"));
        System.out.println("Inheritance (instrumented base set) recorded addCount: "
                + inheritedSet.getAddCount()
                + " (Expected: 3, Actual: 6 due to virtual add() calls from addAll())");

        ComposedInstrumentedSet<String> composedSet = new ComposedInstrumentedSet<>();
        composedSet.addAll(Set.of("A", "B", "C"));
        System.out.println("Composition (wraps HashSet) recorded addCount: "
                + composedSet.getAddCount()
                + " (Correct: 3 - delegated operations are encapsulated)");
    }

    private static class InstrumentedSet<E> extends BaseSet<E> {
        private int addCount;

        @Override
        public boolean add(E element) {
            addCount++;
            return super.add(element);
        }

        @Override
        public boolean addAll(Collection<? extends E> elements) {
            addCount += elements.size();
            return super.addAll(elements);
        }

        int getAddCount() {
            return addCount;
        }
    }

    private static class BaseSet<E> extends AbstractSet<E> {
        private final Set<E> elements = new HashSet<>();

        @Override
        public Iterator<E> iterator() {
            return elements.iterator();
        }

        @Override
        public int size() {
            return elements.size();
        }

        @Override
        public boolean add(E element) {
            return elements.add(element);
        }
    }

    private static class ComposedInstrumentedSet<E> {
        private final Set<E> elements = new HashSet<>();
        private int addCount;

        public boolean add(E element) {
            addCount++;
            return elements.add(element);
        }

        public boolean addAll(Collection<? extends E> newElements) {
            addCount += newElements.size();
            return elements.addAll(newElements);
        }

        public int getAddCount() {
            return addCount;
        }
    }
}
