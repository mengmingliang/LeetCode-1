这个题目是很寂寞的. 2 pointer可以做, 在网上又搜了一下，貌似可以有很多牛逼的优化，我暂时还没去看。
很郁闷的就是条件不明，原来只需要从'++'转到'--'的情况，反过来没必要关注...搞了我半天啊
```
/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
*/

/*
Thoughts:
Two pointers to check if p1 and p2 match target patern. If so, add.

Need to ask: are we only looking to change to '--' from '++'?
*/
public class Solution {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> rst = new ArrayList<String>();
        if (s == null || s.length() < 1) {
        	return rst;
        }
        char[] arr = s.toCharArray();
      	search('+','-',arr,rst);
    	return rst;
    }

    public static void search(char target, char replace, char[] arr, List<String> rst) {
    	int p1 = 0;
    	int p2 = 1;
    	while (p2 <= arr.length - 1) {
    		if (arr[p1] == target && arr[p2] == target) {
    			arr[p1] = replace;
    			arr[p2] = replace;
    			rst.add(new String(arr));
    			arr[p1] = target;
    			arr[p2] = target;
    		}
    		p1++;
    		p2++;
    	}
    }
}





```