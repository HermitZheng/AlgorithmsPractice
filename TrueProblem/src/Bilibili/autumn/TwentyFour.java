package Bilibili.autumn;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/8/13
 */
public class TwentyFour {

    char[] ops = {'+', '-', '*', '/'};

    /**
     * @param arr int整型一维数组
     * @return bool布尔型
     */
    public boolean judgePoint24 (int[] arr) {
        // write code here
        int a = arr[0], b = arr[1], c = arr[2], d = arr[3];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (model_1(a, b, c, d, ops[i], ops[j], ops[k]) == 24) {
                        return true;
                    }
                    if (model_2(a, b, c, d, ops[i], ops[j], ops[k]) == 24) {
                        return true;
                    }
                    if (model_3(a, b, c, d, ops[i], ops[j], ops[k]) == 24) {
                        return true;
                    }
                    if (model_4(a, b, c, d, ops[i], ops[j], ops[k]) == 24) {
                        return true;
                    }
                    if (model_5(a, b, c, d, ops[i], ops[j], ops[k]) == 24) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public double model_1(double a, double b, double c, double d, char op1, char op2, char op3) {
        double res_1 = calculate(a, b, op1);
        double res_2 = calculate(res_1, c, op2);
        return calculate(res_2, d, op3);
    }

    public double model_2(double a, double b, double c, double d, char op1, char op2, char op3) {
        double res_1 = calculate(a, b, op2);
        double res_2 = calculate(res_1, c, op1);
        return calculate(res_2, d, op3);
    }

    public double model_3(double a, double b, double c, double d, char op1, char op2, char op3) {
        double res_1 = calculate(a, b, op3);
        double res_2 = calculate(res_1, c, op2);
        return calculate(res_2, d, op1);
    }

    public double model_4(double a, double b, double c, double d, char op1, char op2, char op3) {
        double res_1 = calculate(a, b, op2);
        double res_2 = calculate(res_1, c, op3);
        return calculate(res_2, d, op1);
    }

    public double model_5(double a, double b, double c, double d, char op1, char op2, char op3) {
        double res_1 = calculate(a, b, op1);
        double res_2 = calculate(res_1, c, op3);
        return calculate(res_2, d, op2);
    }

    public double calculate(double a, double b, char ops) {
        switch (ops) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a * b;
            case '/':
                return a * 1.0 / b;
            default:
        }
        return 0;
    }
}
