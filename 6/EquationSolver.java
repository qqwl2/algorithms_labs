//надо решить уравнение x^2 - x + sqrt(x) = a
// бинарным поиском ищем ближайшее число
public class EquationSolver {
    public static double solve(double a) {
        double low = 0;
        double high = Math.max(1, a);
        for (int i = 0; i < 200; i++) {
            double middle = (low + high) / 2;
            double value = middle * middle - middle + Math.sqrt(middle);
            if (value < a) {
                low = middle;
            } else {
                high = middle;
            }
        }
        return (low + high) / 2;
    }
}
