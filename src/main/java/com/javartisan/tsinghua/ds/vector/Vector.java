package com.javartisan.tsinghua.ds.vector;

import java.util.Random;

/**
 * @author javartisan
 * @mail:javartisan@163.com
 * @description:邓俊辉数据结构之向量
 */
public class Vector<T extends Comparable<T>> {

    private Object[] elems;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public Vector() {
        super();
        this.capacity = DEFAULT_CAPACITY;
        elems = new Object[capacity];
    }

    public Vector(int inital) {
        super();
        if (inital < 0) {
            throw new IllegalArgumentException("Inital Size = " + inital);
        }
        this.capacity = inital;
        elems = new Object[capacity];
    }

    /**
     * 打算顺序
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = size - 1; i > 0; i--) {
            int index = random.nextInt(i);
            swap(i, index);
        }
    }

    /**
     * 获取相邻元素的逆序数
     *
     * @return
     */
    public int disOrderCount() {
        int i = size - 1;
        int disOrderCount = 0;
        while (i >= 1) {
            T before = (T) elems[i - 1];
            T after = (T) elems[i];
            if (before.compareTo(after) > 0) {
                disOrderCount++;
            }
            i--;
        }
        return disOrderCount;
    }

    public float loadFactor() {
        return (float) (size * 1.0 / capacity);
    }

    private void swap(int a, int b) {
        T e = (T) elems[a];
        elems[a] = elems[b];
        elems[b] = e;
    }

    public void add(T e) {
        expand();
        elems[size++] = e;
    }

    public void add(int index, T e) {
        expand();
        int high = size;
        while (high > index) {
            elems[high] = elems[high - 1];
            high--;
        }
        elems[index] = e;
        size++;
    }

    public T remove() {
        if (size < 1) {
            throw new IllegalArgumentException("Vector is empty.");
        }
        T e = (T) elems[--size];
        elems[size] = null;
        return e;
    }

    public T remove(int index) {
        if (size < 1) {
            throw new IllegalArgumentException("Vector is empty.");
        }

        if (index >= size) {
            throw new IllegalArgumentException("remove index bigger than size.");
        }
        T e = get(index);
        for (int i = index; i < size - 1; i++) {
            elems[i] = elems[i + 1];
        }
        size--;
        elems[size] = null;
        return e;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get index is an error num.");
        }
        return (T) elems[index];
    }

    public int size() {
        return size;
    }

    // 扩容策略需要权衡时间与空间复杂度
    private void expand() {
        if (size >= capacity) {
            //注意：运算符的优先级:+高于>>
            //扩容：每次扩容0.5倍
            capacity = capacity + (capacity >> 1);
            Object[] array = new Object[capacity];
            System.arraycopy(elems, 0, array, 0, size);
            elems = array;
        }
    }

    public int find(T value) {
        int i = size - 1;
        while (i >= 0) {
            T e = (T) elems[i];
            if (e.compareTo(value) == 0) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public int find(T value, int lo, int hi) {
        int i = hi - 1;
        while (i >= lo) {
            T e = (T) elems[i];
            if (e.compareTo(value) == 0) {
                return i;
            }
            i--;
        }
        return -1;
    }

    /**
     * 有序向量的去重复
     * 效率比较低。
     */
    public void sortAndDistinct() {
        sort();
        int i = 0;
        while (i < size - 1) {
            T before = (T) elems[i];
            T after = (T) elems[i + 1];
            if (before.compareTo(after) == 0) {
                // 效率低的原因是：每一次重复的话都会触发remove
                remove(i + 1);
            }
            i++;
        }
    }

    /**
     * 优化去重
     */
    public void sortAndDistinct2() {
        sort();
        int i = 0;
        while (i < size) {
            T before = (T) elems[i];
            int limit = i;
            // 计算删除区间
            for (int j = i + 1; j < size; j++) {
                T after = (T) elems[j];
                if (before.compareTo(after) == 0) {
                    limit = j + 1;

                }
            }
            if (limit > i) {
                // (i+1,limit) 删除区间
                System.arraycopy(elems, limit, elems, i + 1, size - limit);
                size = size - (limit - i - 1);
            }
            i++;
        }
    }

    private void distinct() {
        for (int i = 0; i < size; i++) {
            T e = (T) elems[i];
            int index;
            while ((index = find(e, i + 1, size)) != -1) {
                remove(index);
            }
        }
    }

    public void sort() {
        for (int i = 0; i < size; i++) {
            boolean changed = false;
            for (int j = 0; j < size - 1; j++) {
                T before = (T) elems[j];
                T after = (T) elems[j + 1];
                if (before.compareTo(after) > 0) {
                    swap(j, j + 1);
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
    }


    public int binarySearch(T e, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            int compared = e.compareTo((T) elems[mid]);
            if (compared == 0) {
                return mid;
            }
            if (compared > 0) {
                //为什么此处要+1呢?
                // 此if分支是符合的区间在右边，因此需要将mid赋值给lo
                // 但是当lo+1=hi时候，如果lo不等于mid+1的话会死循环，原因:具体 ，当lo=2，hi=3的话
                // lo+hi>>1 为2 ，即mid=2，将mid赋值给lo，lo保持原地不动，所以死循环。
                //所以最核心原因是：(lo+hi)/2!=0计算机计算时候总是向下整除
                lo = mid + 1;
            } else {
                // mid已经不等于，所以可以缩短比较空间
                hi = mid - 1;
            }
        }
        return hi - 1;
    }

    /**
     * 优化的冒泡算法
     */
    public void bubble() {
        int limit = size;
        for (int i = limit; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                T before = (T) elems[j];
                T after = (T) elems[j + 1];
                if (before.compareTo(after) > 0) {
                    swap(j, j + 1);
                    // 优化的冒泡排序算法,此处不能直接将j赋值给i，因为内层循环的终止条件以来i
                    limit = j;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(elems[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
