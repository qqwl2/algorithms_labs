import java.util.*;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

    private List<int[]> heap = new ArrayList<>();
    private int[] operationToIndex;
    private long counter = 0;
    private long lastOperation = 0;

    public PriorityQueueImpl() {
        operationToIndex = new int[100001];
        Arrays.fill(operationToIndex, -1);
    }

    private void swap(int i, int j) {
        int[] a = heap.get(i);
        int[] b = heap.get(j);
        heap.set(i, b);
        heap.set(j, a);
        operationToIndex[b[1]] = i;
        operationToIndex[a[1]] = j;
    }

    private void moveUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(parent)[0] >= heap.get(i)[0]) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    private void moveDown(int i) {
        int n = heap.size();
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;
            if (left < n && heap.get(left)[0] > heap.get(largest)[0])
                largest = left;
            if (right < n && heap.get(right)[0] > heap.get(largest)[0])
                largest = right;
            if (largest == i)
                break;
            swap(i, largest);
            i = largest;
        }
    }

    @Override
    public void enqueue(Integer value) {
        counter++;
        heap.add(new int[] { value, (int) counter });
        operationToIndex[(int) counter] = heap.size() - 1;
        moveUp(heap.size() - 1);
    }

    @Override
    public Integer dequeueMax() {
        if (heap.isEmpty())
            return null;
        int[] top = heap.get(0);
        lastOperation = top[1];
        operationToIndex[top[1]] = -1;
        int[] last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            operationToIndex[last[1]] = 0;
            moveDown(0);
        }
        return top[0];
    }

    @Override
    public void increment(long operation, Integer addition) {
        int index = operationToIndex[(int) operation];
        if (index == -1)
            return;
        heap.get(index)[0] += addition;
        if (addition >= 0)
            moveUp(index);
        else
            moveDown(index);
    }

    public long lastOperation() {
        return lastOperation;
    }
}