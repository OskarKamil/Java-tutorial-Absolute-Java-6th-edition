package chapter4;

public class Sub3 {

    public double salary(int hours, double hourly) {
        return hours * hourly;
    }

    public double salary(double hourly, int hours) {
        return hours * hourly;
    }

    /* Overloading a method name. There are 2 methods with the same name, but with different parameter list. First is: int, double. the other one is double, int. Compiler will try to match the method invokation with the method definition. If there is no perfect match, compiler will automatically do a type cast. In this case, if invokation is salary(2, 5). Then there will be an error cuz both of the methods are not perfect match and either of them would match if done type casting. This is allowed however avoided due to confusion. */
    public double salary(int hours, double hourly, int bonus) {
        return hours * hourly + bonus;
    }
    /* Another overloading. This time this method have different number of parameters. If your call method has 3 arguments, it will choose this method, however if not, it will choose one of methods 1 or 2. */

}
