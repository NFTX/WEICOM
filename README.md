# WEICOM
Weird Competition - challenge from Code Chef

Solved by NFTX.

Solution available in https://github.com/NFTX/WEICOM


Chef is attending a chess competition. There are n people take part in. Each pair of people compete once. Winner earns 1 point, loser earns 0 point. A game never ends with a draw. After all games are over, Organizer decide to award prize to each participant. The prize of each participant is the square of his points. What is all possible total money the organizer will pay for all participants? Given k, determine if there is at least one scenario that the total money the organizers will pay is exactly k? If there's any, output one of them.

 
Input

First line contains an integer T denotes the number of test cases. The T following lines, each line contains two integers n, k.

 
Output

For each test case, if there isn't a such scenario, output -1.

otherwise print n lines, each line contains n characters. j-th character in i-th line is "1" if i-th participant wins j-th participant, otherwise "0". (i-th character in i-th line is always "0")

 
Constraints

    1 ≤ T ≤ 100
    1 ≤ n ≤ 103
    The sum of n over all test cases is at most 104
    1 ≤ k ≤ 109

Subtasks:

    Subtask #1 (10 points): n ≤ 5
    Subtask #2 (30 points): n ≤ 50
    Subtask #3 (60 points): original constrains 

 
Example

Input:

	3
	2 1
	3 6
	4 10

Output:

	01
	00
	-1
	0100
	0011
	1001
	1000
