import java.util.HashMap;
import java.util.Map;

class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int row = matrix.length;
    int col = matrix[0].length;

    int result = 0;
    for (int beginR = 0; beginR < row; ++beginR) {
      int[] line = new int[col];

      for (int endR = beginR; endR < row; ++endR) {
        for (int c = 0; c < col; ++c) {
          line[c] += matrix[endR][c];
        }

        Map<Integer, Integer> prefixSumToCount = new HashMap<>();
        prefixSumToCount.put(0, 1);

        int prefixSum = 0;
        for (int c = 0; c < col; ++c) {
          prefixSum += line[c];
          result += prefixSumToCount.getOrDefault(prefixSum - target, 0);

          prefixSumToCount.put(prefixSum, prefixSumToCount.getOrDefault(prefixSum, 0) + 1);
        }
      }
    }

    return result;
  }
}
