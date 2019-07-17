public class Solution {
	public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return  base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = - exponent;
            isNegative = true;
        }
        double power = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            power = base * power;
        }
        return isNegative ? 1 / power : power;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.Power(2, -3)); //0.125
        System.out.println(s.Power(2, 3)); //8
    }
}