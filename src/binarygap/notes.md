#### Algorithm:
~~~
     1. Initially maxGap = 0, leftIndex = 0 and rightIndex = 0;
     2. Isolate the rightmost set bit.  x = (n & -n)
     3. K = log2(x) would give the position of the set bit. rightIndex = K
     4. maxGap = Max(maxGap, rightIndex - leftIndex - 1);
     5. leftIndex = rightIndex;
     6. Unset the rightmost set bit. y = ( n & n-1).
     7. Repeat from step 1 with y (the new number got at 6).
~~~