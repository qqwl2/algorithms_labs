import java.util.Arrays;

public class HasDuplicate {
    public boolean hasDuplicate(int[] x) {
        Arrays.sort(x);
        for (int i = 1; i < x.length; i++) {
            if (x[i] == x[i - 1]) return true;
        }
        return false;
    }
}

