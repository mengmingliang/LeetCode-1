/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/

/*
Thoughts:
Each spot has 3 direction to go for larget element, and another 3 directions to go for smaller element.
If match, return true;
If target is greater than mid, move start to large element around mid
	if target > (i+1,j+1) : start = (i+1, j+1)
	if target > (i,j+1) : start = (i, j+1)
	if target > (i+1,j) : start = (i+1, j)
If target is less than mid, move end to small element around mid
	if target < (i-1,j-1) : end = (i-1,j-1) 
	if target < (i,j-1) : end = (i, j-1)
	if target < (i-1,j) : end = (i-1, j)
init:
start = 0
end = m*n - 1;
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
    }
}