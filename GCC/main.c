/***************************
 *
 *Copyright @deli
 *
 *File name: main.c 
 *
 *Version: v1.0
 *
 *Author: Deli
 *
 *Date: 20151112
 *
 * **************************/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/***************************
 *
 *Function: main
 *
 *Input parameter: none
 * 
 *Output parameter: none 
 *
 *Return value: 0 -- Done
 *
 *History
 *-------------------------------
 *Date     Version  Author Change
 *-------------------------------
 *20151112 v1.0     Deli   Create
 *
 * */

int main()
{
	printf("Hello, world!\n");

	int i = 5/0;
	printf("i ===>%d \n",i);

	int iLen = strlen(str);
	printf("str length is %d \n", iLen);

	return 0;

}
