public class Solution {
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
		    count++;
		    n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.NumberOf1(0)); //0000
        System.out.println(s.NumberOf1(1)); //0001
        System.out.println(s.NumberOf1(5)); //0101
        System.out.println(s.NumberOf1(31)); //11111
        System.out.println(s.NumberOf1(171)); //10101011
        System.out.println(s.NumberOf1(-1)); //10101011
	}
}