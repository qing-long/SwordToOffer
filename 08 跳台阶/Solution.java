public class Solution {
	public int JumpFloor(int target) {
		if (target <= 2) {
		    return target;
		}
		int[] jf = new int[target + 1];
		jf[1] = 1;
		jf[2] = 2;
		for (int i = 3; i <= target; i++) {
		    jf[i] = jf[i - 1] + jf[i - 2];
		}
		return jf[target];
	}
	
	public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.JumpFloor(4));
    }
}