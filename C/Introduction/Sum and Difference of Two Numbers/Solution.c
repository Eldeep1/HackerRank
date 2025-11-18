#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

int main()
{
    int firstInt;
    int secondInt;
    float firstFloat;
    float secondFloat;
    
    scanf("%d %d",&firstInt,&secondInt);
    scanf("%f %f",&firstFloat,&secondFloat);
    
    printf("%d %d\n",firstInt+secondInt,firstInt-secondInt);
    printf("%.1f %.1f\n",firstFloat+secondFloat,firstFloat-secondFloat);
    
    return 0;
}