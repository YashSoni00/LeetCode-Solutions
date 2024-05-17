package Hard;

public class MaxPointsonaLine {
    public static void main(String[] args) {
        // [[0,1],[0,0],[0,4],[0,-2],[0,-1],[0,3],[0,-4]]
        int[][] points2 = {{0,1},{0,0},{0,4},{0,-2},{0,-1},{0,3},{0,-4}};
        System.out.println(maxPoints(points2));
    }

    public static int maxPoints(int[][] points) {
        int count = 0;
        int len = points.length;
        if (len < 3) return len;

        // Brute Force
        for (int i=0; i<len; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j=i+1; j<len; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                // We already have 2 points with this slope
                int currSlopeCount = 2;

                for (int k=j+1; k<len; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    // This was giving some error due to divide
                    // double s1 = (double) (x2-x1)/(y2-y1);
                    // double s2 = (double) (x3-x1)/(y3-y1);

                    // So we modify it by
                    double s1 = (double) (x2-x1) * (y3-y1);
                    double s2 = (double) (x3-x1) * (y2-y1);

                    if (s1 == s2)
                        currSlopeCount++;
                }
                count = Math.max(currSlopeCount, count);
            }
        }
        return count;
    }
}