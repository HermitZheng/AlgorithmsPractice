package stack;

import java.util.Scanner;

/**
 * @author zhuqiu
 * @date 2020/2/18
 */
public class Calculator {

    public static void main(String[] args) {

        String str = new String();
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入计算式：");
        if (scan.hasNext()) {
            str = scan.next();
            System.out.println("输入的数据为：" + str);
        }
        scan.close();
        if (str == "") {
            System.out.println("输入为空，程序结束。");
            return;
        }

        LinkStack numStack = new LinkStack(10);
        LinkStack operStack = new LinkStack(15);

        int result = method(str, numStack, operStack);
        System.out.println("计算结果为：" + result);
    }

    public static int method(String str, LinkStack numStack, LinkStack operStack) {

        int i = 0;
        char c;
        c = str.charAt(i);
        if (c == '-') {  // 负数处理
            numStack.push(0);
            operStack.push(c);
            i++;
        }

        for (; i < str.length(); i++) {

            c = str.charAt(i);

            if (c == '(') {  // 遇到括号
                i++;
                String inner = new String();
                while (true) {
                    char next = str.charAt(i);
                    if (next == ')') {  // 括号结束，递归运算
                        System.out.println(inner);
                        LinkStack innerNums = new LinkStack(10);
                        LinkStack innerOpers = new LinkStack(15);
                        int innerResult = method(inner, innerNums, innerOpers);
                        numStack.push(innerResult);
                        break;
                    } else {  // 拼接括号内的计算式
                        inner += String.valueOf(next);
                        i++;
                    }
                }
                continue;
            }

            if (isOper(c) == false) { // 是数字

                String resultnum = String.valueOf(c);
                // 是数字，查看下一位是否依然是数字
                while (i < str.length() - 1) {
                    char next = str.charAt(i + 1);
                    if (isOper(next)) {  // 下一位是运算符则退出
                        break;
                    } else {  // 下一位是数字
                        resultnum += String.valueOf(next);
                        i++;
                    }
                }
                numStack.push(Integer.parseInt(resultnum));
            } else {
                // 是运算符
                char[] preOpers;
                char preOper;
                if (operStack.top.next != null) {  // 判断栈内是否已有运算符
                    int value = operStack.peek();  // 获取前一个运算符
                    preOpers = Character.toChars(value);
                    preOper = preOpers[0];
//                    System.out.println(preOper);
                    if (priority(c) <= priority(preOper)) {  // 对前一项运算符进行计算
                        int num1 = numStack.pop().value;
                        int num2 = numStack.pop().value;
                        operStack.pop();
                        int result = calculate(num2, num1, preOper);
                        numStack.push(result);          // 计算结果入栈
                        operStack.push(c);              // 新运算符入栈
                    } else {
//                        operStack.push(value);  // 将pop出来的运算符还回去
                        operStack.push(c);        // 新运算符入栈
                    }
                } else {
                    operStack.push(c);
                }
            }
        }
        int result;
        String temp = new String();
        if (operStack.isEmpty()){
            return numStack.pop().value;
        }
        int flag = 0;
        int num1 = 0, num2 = 0;
        char oper = ' ';
        while (!numStack.isEmpty()) {
            int value = numStack.pop().value;
            num2 = value;
            String num = String.valueOf(value);
            temp = num.concat(temp);
            if (!operStack.isEmpty()) {
                num1 = value;
                flag++;
                oper = Character.toChars(operStack.pop().value)[0];
                String operS = String.valueOf(oper);
                temp = operS.concat(temp);
            }
        }
        if (flag < 2){
            return calculate(num2, num1, oper);
        }else {
            LinkStack tempNums = new LinkStack(10);
            LinkStack tempOpers = new LinkStack(15);
            return method(temp, tempNums, tempOpers);
        }

//        int result = numStack.peek();
//        while (numStack.top.next.next != null){     // 计算栈内剩余信息
//            int num1 = numStack.pop().value;
//            int num2 = numStack.pop().value;
//            int value = operStack.pop().value;
//            char[] preOpers = Character.toChars(value);
//            char preOper = preOpers[0];
//            result = calculate(num2, num1, preOper);
//            numStack.push(result);
//        }
    }

    public static int calculate(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }
        return res;
    }

    public static boolean isOper(char oper) {
        String opers = "+-*/()";
        if (opers.indexOf(String.valueOf(oper)) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static int priority(int oper) {
        if (oper == '(' || oper == ')') {
            return 2;
        } else if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }
}
