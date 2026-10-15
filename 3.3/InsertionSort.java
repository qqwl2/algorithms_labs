import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sorting<T> {
    @Override
    public void sort(List<T> nums) {
        for (int i = 1; i < nums.size(); i++) {
            T key = nums.get(i);
            int j = i - 1;
            while (j >= 0 && nums.get(j).compareTo(key) > 0) {
                nums.set(j + 1, nums.get(j));
                j--;
            }
            nums.set(j + 1, key);
        }
    }
}