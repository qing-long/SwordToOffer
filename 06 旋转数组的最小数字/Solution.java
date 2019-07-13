public class Solution {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0 || null == array) {
            return 0;
        }

        int l = 0, h = array.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (array[m] <= array[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return array[l];
    }
}