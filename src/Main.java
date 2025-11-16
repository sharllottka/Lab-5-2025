import functions.*;
import functions.basic.Cos;
import functions.basic.Exp;
import functions.basic.Log;
import functions.basic.Sin;
import functions.Function;
import functions.meta.Composition;


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        double EPS = 1e-9;

        double[] vals1 = {0, 1, 4, 9, 16};
        double[] vals2 = {0, 3, 6, 10, 19};
        TabulatedFunction func1 = new ArrayTabulatedFunction(0, 5, vals1);
        TabulatedFunction func2 = new ArrayTabulatedFunction(0, 5, vals2);
        TabulatedFunction func3 = new ArrayTabulatedFunction(0, 5, vals1);
        System.out.println("Вывод через ArrayTabulatedFunction:");
        System.out.println("func1 = " + func1);
        System.out.println("func2 = " + func2);
        System.out.println("func3 = " + func3);
        System.out.println();

        TabulatedFunction func4 = new LinkedListTabulatedFunction(0, 5, vals1);
        TabulatedFunction func5 = new LinkedListTabulatedFunction(0, 5, vals2);
        System.out.println("Вывод через LinkedListTabulatedFunction:");
        System.out.println("func4 = " + func4);
        System.out.println("func5 = " + func5);
        System.out.println();

        System.out.println("Проверка equals:");
        System.out.println("Сравнение func1 и func3: " + func1.equals(func3));
        System.out.println("Сравнение func1 и func2: " + func1.equals(func2));
        System.out.println("Сравнение func1 и func4: " + func1.equals(func4));
        System.out.println("Сравнение func1 и func5: " + func1.equals(func5));
        System.out.println();

        System.out.println("Проверка hashCode:");
        System.out.println("func1 = " + func1.hashCode());
        System.out.println("func2 = " + func2.hashCode());
        System.out.println("func3 = " + func3.hashCode());
        System.out.println("func4 = " + func4.hashCode());
        System.out.println("func5 = " + func5.hashCode());
        System.out.println();
        System.out.println("Вывод hashCode функций с изменёнными точками на 0.001:");
        func1.setPointY(1, func1.getPointY(1) + 0.001);
        func2.setPointY(2, func2.getPointY(1) + 0.001);
        func3.setPointY(3, func3.getPointY(1) + 0.001);
        func4.setPointY(4, func4.getPointY(1) + 0.001);
        func5.setPointY(0, func5.getPointY(1) + 0.001);
        System.out.println("func1 = " + func1.hashCode());
        System.out.println("func2 = " + func2.hashCode());
        System.out.println("func3 = " + func3.hashCode());
        System.out.println("func4 = " + func4.hashCode());
        System.out.println("func5 = " + func5.hashCode());
        System.out.println();

        TabulatedFunction funcClone1 = (TabulatedFunction) func1.clone();
        TabulatedFunction funcClone2 = (TabulatedFunction) func5.clone();
        System.out.println("Проверка Clone:");
        System.out.println("Копия func1:" + funcClone1);
        System.out.println("Копия func5:" + funcClone2);
        System.out.println();
        System.out.println("Сравнение исходной и клонированной функций:");
        System.out.println("funcClone1: " + func1.equals(funcClone1));
        System.out.println("funcClone2: " + func5.equals(funcClone2));
        System.out.println();
        System.out.println("Проверка hashCode у копий функций:");
        System.out.println("funcClone1: " + funcClone1.hashCode());
        System.out.println("funcClone2: " + funcClone2.hashCode());
        System.out.println();
        func1.setPointY(1, func1.getPointY(1) + 3);
        func5.setPointY(0, func1.getPointY(1) + 6);
        System.out.println("Проверка на глубокое клонирование:");
        System.out.println("Изменённая func1: " + func1);
        System.out.println("Копия func1: " + funcClone1);
        System.out.println("Изменённая func5: " + func5);
        System.out.println("Копия func5: " + funcClone2);
    }
}
