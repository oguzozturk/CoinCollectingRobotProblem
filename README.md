# CoinCollectingRobotProblem
Coin-collecting robot problem in Java

Each cell has an integer value between -5 and 5. 
If the value of a cell is positive, 
then the robot gains that amount of coins when it visits that cell. 
If the value of the cell is negative, then the robot pays that amount of coins if it visits that cell and if it has enough coin.
But if it has not collected that amount of coins in the previous cells, 
then the robot cannot visit a cell with negative value. 
Also there are some cells on the board that are always inaccessible for the robot.  
Again the robot starts at (1,1), it can only move towards right and down and it stops at (n,m). 
Following corresponds to an example board, where inaccessible cells are shown by X’s and values of cells are shown 
by integers between -5 and 5:  

0 -1  5  4  0  0
1  2  0  X  4  0 
3  1  3 -1  X  5 
0  0 -2  3 -1  5 
X  X  X  0  1  1  

I implement the following steps 
a) Given an n x m board with all the values and accessiblity information, describe an algorithm that finds the following: 
i. Maximum number of coins the robot bring to cell (n,m). 
ii. A path from (1,1) to (n,m) that results in maximum coin collection. 
b) Apply algorithm for any n x m board.  
c) Give time and space complexity of your algorithm. 
d) Input file format should be as follows. 
The first line will contain two integers n and m. What follows will be the n lines, 
each line corresponds to each row of board (that includes integer values between -5 and 5, and X’s). 
All the values will be seperated with tabs (\t). Output file format should be as follows. 
First line should include an integer value for the number of coins collected by the robot. 
What follows will be the n lines, each line corresponds to each row of the output board, 
where the path is shown with P. As an example, for the following input:

 5 6 
 0  1 -2  5 X 4 
 2 -2  2  4 X 0
 3  1  0 -1 1 1
 3 -1 -2  X 2 5
 X  X -5  0 1 1  
 
Contents of the output file will be the following:  
14
P  1 -2 5 X 4
P  P  P P X 0 
3  1  0 P P 1 
3 -1 -2 X P P
X  X -5 0 1 P
