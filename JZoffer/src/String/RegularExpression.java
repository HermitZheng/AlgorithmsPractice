package String;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @author zhuqiu
 * @date 2020/3/26
 */
public class RegularExpression {

    public static void main(String[] args) {

    }

    public boolean match(char[] str, char[] pattern) {
            if ((str == null || str.length == 0) && pattern == null) {
                return true;
            } else if (pattern == null){
                return false;
            }
        int strIndex = 0;
        int patIndex = 0;
        return method(str, strIndex, pattern, patIndex);
    }

    public boolean method(char[] str, int strIndex, char[] pattern, int patIndex) {
        if (str == null && (pattern[patIndex] == '*' || pattern[patIndex] == '.')){
            return method(str, strIndex, pattern, patIndex+1);
        } else if ((strIndex >= str.length || str == null) && patIndex >= pattern.length) {
            return false;
        } else if (patIndex >= pattern.length && strIndex < str.length){
            return false;
        } else if ((strIndex >= str.length || str == null) && patIndex < pattern.length){
            return true;
        }
        if (pattern[patIndex+1] != '*') {
            if (str[strIndex] == pattern[patIndex] || pattern[patIndex] == '.') {
                return method(str, strIndex+1, pattern, patIndex +1);
            } else {
                return false;
            }
        } else {
            if (str[strIndex] == pattern[patIndex]) {
                return method(str, strIndex+1, pattern, patIndex);
            } else {
                return method(str, strIndex, pattern, patIndex + 2);
            }
        }
    }
}
