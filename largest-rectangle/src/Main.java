import java.util.Arrays;
import java.util.List;

class Result {
    public static long largestRectangle(List<Integer> h) {
        long size = h.size();
        long max = 0;

        for (int i = 0; i < size; i++) {
            long w = 1;
            Integer is = h.get(i);

            for (int j = i + 1; j < size; j++) {
                if (is > h.get(j)) {
                    break;
                }
                w++;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (is > h.get(j)) {
                    break;
                }
                w++;
            }

            long sum = w * is;
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

}

class Solution {
    public static void main(String[] args) {
        System.out.println(Result.largestRectangle(Arrays.asList(1, 2, 3, 4, 5)));
    }
}
