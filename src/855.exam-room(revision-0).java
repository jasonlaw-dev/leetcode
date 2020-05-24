import java.util.TreeSet;

/*
 * @lc app=leetcode id=855 lang=java
 *
 * [855] Exam Room
 * 
 * TreeSet to store the seated indices
 * for each interval, check if it is greatest, then we find a mid point
 * use tree set to store available interval, e.g. [-1, N]
 * use a tree set to store occupied places
 * 
 */

// N = 9
// interval = -1, 9
// target = 4

// _ _ 2 _ x _ _ 7
// diffA = 2, 4
// [-1,0][0,3][3,7][7,8]
// [-1,0][0,3][3,7][7,8]


// @lc code=start
class ExamRoom {

    TreeSet<Integer> taken = new TreeSet<>();
    TreeSet<int[]> intervals;
    int N;

    public ExamRoom(int N) {
        this.N = N;
        taken.add(-1);
        taken.add(N);
        intervals = new TreeSet<>((a, b) -> {
            int distA;
            int distB;
            if (a[0] == -1 || a[1] == N) {
                distA = a[1] - a[0] - 1;
            } else {
                distA = (a[1] - a[0]) / 2;
            }
            if (b[0] == -1 || b[1] == N) {
                distB = b[1] - b[0] - 1;
            } else {
                distB = (b[1] - b[0]) / 2;
            }
            return distA == distB ? a[0] - b[0] : distB - distA;
        });
        intervals.add(new int[]{ -1, N});
    }
    
    public int seat() {
        int[] interval = intervals.first();
        int res;
        if (interval[0] == -1) {
            res = 0;
        } else if (interval[1] == N) {
            res = N - 1;
        } else {
            res = (interval[1] + interval[0]) / 2;
        }
        taken.add(res);
        intervals.remove(interval);
        intervals.add(new int[] {interval[0], res});
        intervals.add(new int[] {res, interval[1]});
        // printMap();
        return res;
    }
    
    public void leave(int p) {
        int prev = taken.lower(p);
        int next = taken.higher(p);
        intervals.remove(new int[] {prev, p});
        intervals.remove(new int[] {p, next});
        intervals.add(new int[] {prev, next});
        taken.remove(p);
    }
    private void printMap() {
        for (int[] entry : intervals) {
            System.out.print("[" + entry[0] + "," + entry[1] + "],");
        }
        System.out.println();
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
// @lc code=end

