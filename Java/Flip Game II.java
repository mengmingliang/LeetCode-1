/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.

Tags: Backtracking
Similar Problems: (E) Nim Game, (E) Flip Game


*/
/*
Attemp2, from:http://www.cnblogs.com/jcliBlogger/p/4886741.html
Similar to my idea, but much more clear: no need of the isP1 flag.
Iterative idea:p1 can win, and p2 must not win at all.
Therefore, if p2's move can't win, we return true on p1's state.
For loop and the if statement works as 'OR': just need one of the p1's movement win.
*/

public class Solution {
  public static boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        String str = new String(s);
        for (int i = str.indexOf("++"); i >= 0 && i < str.length() - 1; i = str.indexOf("++")) {
           if (!canWin( s.substring(0, i) + "--" + s.substring(i + 2))) {//Just pick one way of p1's move
               return true;
           }
            str = str.substring(0, i) + "-" + str.substring(i + 1);//Help to move certain spot.
        }
        return false;
    }

}
//let k = n/2
//O(k * (k - 1) * (k - 2) ... k) = O(k!) = O((n/2)!) = O(n!)

/*
Attempt1, Failed.
Thoughts:
method checkP1Win(), inside of it:
OR all p1's win state, if one of the move wins, return true;
However, a bit of code redundancy, does not feel good about this.
Fails on "+++++++++"
*/
public class Solution {
  public static boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        boolean rst = false;
        String str = new String(s);
        for (int i = str.indexOf("++"); i >= 0 && i < str.length() - 1; i = str.indexOf("++")) {
            if (checkP1Win(s, i, true)) {
                rst = true;
                break;
            }
            str = str.substring(0, i) + "-" + str.substring(i + 1);
        }
        return rst;

    }
    public static boolean checkP1Win(String str, int x, boolean isP1) {
        String s = str.substring(0,x) + "--" + str.substring(x + 2);
        if (s.indexOf("++") == -1) {
            return isP1;
        } 
	    for (int i = s.indexOf("++"); i >= 0 && i < s.length() - 1; i = s.indexOf("++")) {
	        if (checkP1Win(s, i, !isP1)) {
	            return true;
	        }
	        s = s.substring(0, i) + "-" + s.substring(i + 1);
	    } 
	    return false;
    }


}



public class Solution {
  public static boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        boolean rst = false;
        String str = new String(s);
        for (int i = str.indexOf("++"); i >= 0 && i < str.length() - 1; i = str.indexOf("++")) {
            if (checkP1Win(s, i, true)) {
                rst = true;
                break;
            }
            str = str.substring(0, i) + "-" + str.substring(i + 1);
        }
        return rst;

    }
    public static boolean checkP1Win(String str, int x, boolean isP1) {
        String s = str.substring(0,x) + "--" + str.substring(x + 2);
        if (s.indexOf("++") == -1) {
            return isP1;
        } 
        if (isP1) {
        	String temp = s;
		    for (int i = temp.indexOf("++"); i >= 0 && i < temp.length() - 1; i = temp.indexOf("++")) {
		        if (checkP1Win(s, i, !isP1)) {
		            return true;
		        }
		        temp = temp.substring(0, i) + "-" + temp.substring(i + 1);
		    } 
		    return false;
	    } else {
	    	String temp = s;
	    	for (int i = temp.indexOf("++"); i >= 0 && i < temp.length() - 1; i = temp.indexOf("++")) {
		        if (!checkP1Win(s, i, !isP1)) {
		            return false;
		        }
		        temp = temp.substring(0, i) + "-" + temp.substring(i + 1);
		    } 
		    return true;
	    }
    }
}














