package prac3;


import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.function.UnaryOperator;

public class ThreadSafeList<E> implements List<E>{

    private final Semaphore semaphore = new Semaphore(1);
    private List<E> list = new ArrayList<>();

    public void setList(List<E> list) {
        this.list = list;
    }

    public List<E> getList() {
        return list;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        try {
            semaphore.acquire();
            list.replaceAll(operator);
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sort(Comparator<? super E> c) {
        try {
            semaphore.acquire();
            list.sort(c);
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        try {
            semaphore.acquire();
            var result = list.spliterator();
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int size() {
        try {
            semaphore.acquire();
            var result = list.size();
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            var result = list.isEmpty();
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            var result = list.contains(o);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        try {
            semaphore.acquire();
            var result = list.iterator();
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            var result = list.toArray();
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        try {
            semaphore.acquire();
            var result = list.toArray(a);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(E e) {
        try {
            semaphore.acquire();
            var result = list.add(e);
            semaphore.release();
            return result;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            var result = list.remove(o);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            var result = new HashSet<>(list).containsAll(c);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire();
            var result = list.addAll(c);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            semaphore.acquire();
            var result = list.addAll(index, c);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            var result = list.removeAll(c);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            var result = list.retainAll(c);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E get(int index) {
        try {
            semaphore.acquire();
            var result = list.get(index);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E set(int index, E element) {
        try {
            semaphore.acquire();
            var result = list.set(index, element);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(int index, E element) {
        try {
            semaphore.acquire();
            list.add(index, element);
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E remove(int index) {
        try {
            semaphore.acquire();
            var result = list.remove(index);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int indexOf(Object o) {
        try {
            semaphore.acquire();
            var result = list.indexOf(o);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            semaphore.acquire();
            var result = list.lastIndexOf(o);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        try {
            semaphore.acquire();
            var result = list.listIterator();
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        try {
            semaphore.acquire();
            var result = list.listIterator(index);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        try {
            semaphore.acquire();
            var result = list.subList(fromIndex, toIndex);
            semaphore.release();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
