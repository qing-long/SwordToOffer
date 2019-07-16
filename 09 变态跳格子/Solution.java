public class Solution {
	public int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.JumpFloorII(0));  // -1
        System.out.println(s.JumpFloorII(1));  // 1
        System.out.println(s.JumpFloorII(2));  // 2
        System.out.println(s.JumpFloorII(3));  // 4
        System.out.println(s.JumpFloorII(4));  // 8
        System.out.println(s.JumpFloorII(5));  // 16
    }
}