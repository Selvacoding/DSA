import java.util.*;

public class Interval {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int newStart = intervals[0][0];
        int newEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= newEnd) {
                newEnd = Math.max(newEnd, intervals[i][1]);
            } else {
                result.add(new int[] { newStart, newEnd });
                newStart = intervals[i][0];
                newEnd = intervals[i][1];
            }
        }

        result.add(new int[] { newStart, newEnd });

        // return result.toArray(new int[result.size()][]);
        return result.toArray(int[][]::new);
    }
    public static void main(String[] args) {
        int[][] intervals ={{1,3},{2,6},{8,10},{15,18}};
        int[][] arr = merge(intervals); //Output: [[1,6],[8,10],[15,18]]
        for (int[] interval : arr) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
