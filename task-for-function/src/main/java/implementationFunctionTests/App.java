package implementationFunctionTests;

/**
 *  Implementation of provided function f(x) = 1 / (x + a), x – real variable, a – real constant.
 *
 */
public class App {
    public static void main( String[] args ) {

    }

    public double implFunction(double a, double x) throws Exception {
        double fx;
        if ((x + a) == 0) {
            System.out.println("Ошибка: знаменатель функции равен нулю");
            throw new Exception();
        } else {
            fx = 1 / (x + a);
        }
        return fx;
    }

}
