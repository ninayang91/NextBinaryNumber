# NextBinaryNumber
Given a number, find the next largest and smallest number with the same 1s in binary representation.

getNext:

change 0 to 1 at high position, so 01111000 -> 11111000 -> 10000000 -> 10000111; (c1-1) 1s
count 0s first, then 1s, check(c0+c1 ==0,31) int p=c0+c1

getPrev:

change 1 to 0 at high position, so 10001111 -> 00001111 -> 01111111 -> 01111100; (c0-1) 0s
count 1s first, check (c==0), then 0s, int p=c0+c1
