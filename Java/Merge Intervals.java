扫描线+Count无敌手。注意start end把interval给合起来。
count==0的时候，就是每次start end双数抵消的时候，就应该是一个interval的结尾。写个例子就知道了。

```
/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

Tags: Array, Sort
Similar Problems: (H) Insert Interval, (E) Meeting Rooms (M) Meeting Rooms II

*/

/*
Thoughts:
Again use scan line. Quite similar to Meeting Rooms, flight schedules... etc
This one: when count ==0, make sure to keep track start and end, add into the rst
When writing out example, whenever count==0, that indicates an end of a interval.
*/


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
	class Point {
		int pos;
		int flag;
		public Point(int pos, int flag) {
			this.pos = pos;
			this.flag = flag;
		}
	}

    public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> rst = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
        	return rst;
        }
        PriorityQueue<Point> queue = new PriorityQueue<Point>(
        	new Comparator<Point>(){
        		public int compare(Point a, Point b){
        			return (a.pos - b.pos);
        		}
        	}
        );
        for (Interval range : intervals) {
        	queue.add(new Point(range.start, 1));
        	queue.add(new Point(range.end, -1));
        }
        int count = 0;
        int start = 0;
        int end = 0;
        while (!queue.isEmpty()) {
        	Point p = queue.poll();
        	if (count == 0) {
        		start = p.pos;
        	}
        	count += p.flag;
        	while(!queue.isEmpty() && p.pos == queue.peek().pos) {
        		p = queue.poll();
        		count += p.flag;
        	}
        	if (count == 0) {
        		end = p.pos;
        		rst.add(new Interval(start, end));
        	}
        }
        return rst;
    }
}








```