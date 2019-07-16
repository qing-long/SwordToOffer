public class Solution {
	public int RectCover(int target) {
        if (target <= 0) {
            return -1;
        } else if (target <= 2) {
            return target;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.RectCover(0));  //-1
        System.out.println(s.RectCover(1));  //1
        System.out.println(s.RectCover(2));  //2
        System.out.println(s.RectCover(3));  //3
    }
}