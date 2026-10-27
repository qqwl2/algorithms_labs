// функция для поиска f(result) = (result / w) * (result / h)
// бинарным поиском ищем подходящий result
public class DiplomaBox {
    public static long solve(long count, long width, long height) {
        long low = 0;
        long high = Math.max(width, height) * count;
        while (low < high) {
            long middle = (low + high) / 2;
            long columns = middle / width;
            long rows = middle / height;
            long capacity = columns * rows;
            if (capacity >= count) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return low;
    }
}
