// подается отсортированный массив и массив с числами
// на выходе массив с числами, которые максимально близки к числам из 2 массива
public class ApproximateSearch {
    public static int[] solve(int[] sorted, int[] queries) {
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int x = queries[q];
            int best = sorted[0];
            for (int i = 1; i < sorted.length; i++) {
                if (Math.abs(sorted[i] - x) < Math.abs(best - x)) {
                    best = sorted[i];
                }
            }
            result[q] = best;
        }
        return result;
    }
}