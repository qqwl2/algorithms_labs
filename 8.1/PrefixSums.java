// заранее считаем все суммы и потом просто вычисляем необходимую
public class PrefixSums {
    private long[] sums;

    public PrefixSums(int[] arr) {
        sums = new long[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            sums[i + 1] = sums[i] + arr[i];
        }
    }

    public long rangeSum(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}