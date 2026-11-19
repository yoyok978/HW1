public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        if (i == j) {
            return 0;
        }

        int[] visit = new int[m.length]; // 0 --> not visited, >0 --> (distance from i) + 1, -1 --> visited

        int current = i;
        visit[current] = 1;

        int depth = 1;

        while (!arrStale(visit)){


            for (int k = 0; k < visit.length; k++) {
                if (m[current][k] == 1 && visit[k] == 0){
                    if (k != j){
                        visit[k] = visit[current] + 1;
                    }
                    else return depth;
                }
            }


            int last = current;

            for (int k = 0; k < visit.length; k++){
                if (visit[k] == visit[last] && k != last){
                    current = k;
                    break;
                } else if (visit[k] == visit[last] + 1) {
                    current = k;
                }
            }

            visit[current] = -1;

            if (visit[current] != visit[last])
                depth++;

        }

        return -1;
    }

    public static boolean arrStale(int[] arr){
        for (int i : arr) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}