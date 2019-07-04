public class Solution {
    public String replaceSpace(StringBuffer str) {
        /* 获取str初始尾部 */
        int p1 = str.length() - 1;

        /* 读取str中空格，并在str后填充两个空格
         * i = p1 时，在结尾的空格填充
        */
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        /* 获取str之后的尾部 */
        int p2 = str.length() - 1;

        /* p1 和 p2 向前遍历
         * 当 p1 遍历到空格时，p2 往前依次填充 0 2 %
         * 否则就填充当前 p1 位置的字符
         *
         */
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}