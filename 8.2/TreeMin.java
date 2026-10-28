// строим двоичное дерево где листья - элементы, узлы - минимумы на отрезке, корень - минимум массива
public class TreeMin {
    private int[] tree;
    private int leafCount;

    public TreeMin(int[] values) {
        leafCount = 1;
        while (leafCount < values.length) {
            leafCount *= 2; // считаем с запасом кол-во листьев, 
            // чтобы потом не проверять есть ли какой то лист
        }
        tree = new int[2 * leafCount];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = Integer.MAX_VALUE; // т.к. у нас дерево минимумов, то для min() нейтральным будет MAX_VALUE
        }
        for (int i = 0; i < values.length; i++) {
            tree[leafCount + i] = values[i];
        }
        for (int i = leafCount - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]); 
        }
    }

    public int rangeMin(int left, int right) {
        int result = Integer.MAX_VALUE;
        left += leafCount;
        right += leafCount;
        while (left < right) {
            if (left % 2 == 1) {
                result = Math.min(result, tree[left]);
                left++;
            }
            if (right % 2 == 1) {
                right--;
                result = Math.min(result, tree[right]);
            }
            left /= 2;
            right /= 2;
        }
        return result;
    }
}