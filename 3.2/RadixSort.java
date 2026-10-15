import java.math.BigInteger;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        if (nums.size() < 2) {
            return;
        }

        int size = nums.size();
        String[] str_nums = new String[size];
        for (int i = 0; i < size; i++) {
            str_nums[i] = nums.get(i).toString();
        }

        for (int pos = 19; pos >= 0; pos--) {
            // раскидываем количество цифр в разряде
            int[] cf = new int[10];
            for (String s : str_nums)
                cf[s.charAt(pos) - '0']++;

            // пихаем в р позиции с которых будем пихать числа с определенной цифрой на конце
            int[] p = new int[10];
            for (int i = 1; i < 10; i++)
                p[i] = p[i - 1] + cf[i - 1]; 

            // распихиваем числа по подготовленным индексам
            String[] b = new String[size];
            for (String s : str_nums) {
                int d = s.charAt(pos) - '0';
                b[p[d]++] = s; // p[d] - дает индекс по которому надо класть в b
            }
            System.arraycopy(b, 0, str_nums, 0, size);
        }

        // обратно в List
        for (int i = 0; i < size; i++)
            nums.set(i, new BigInteger(str_nums[i]));
    }
}