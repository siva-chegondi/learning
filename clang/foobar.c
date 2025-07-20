#include <stdio.h>
/* 22
 * 16 23
 * 11 17 24
 * 7  12 18 25
 * 4  8  13 19 26
 * 2  5  9  14 20 27 
 * 1  3  6  10 15 21 28
 */

#define SUM(x) (((x) * (x+1)) / 2)

int getNumber(int x, int y) {

    int z = x > y ? x : y;
    if (x == y) { z = x + y; } else { z++; }
    int zVal = SUM(z) + ((x + 1)*(y - 1));
    return zVal;
}

int main() {

    int val, x, y;

    printf("Provide x and y coordinates\n");
    scanf("%d %d", &x, &y);

    val = getNumber(x, y);
    printf("Value at %d and %d coordinates is %d\n", x, y, val);
    return 0;
}