/**********************************************************************
* 版权所有 (C)2015, Zhou Zhaoxiong。
*
* 文件名称：GdbDebug.c
* 文件标识：无
* 内容摘要：Gdb命令演示程序
* 其它说明：无
* 当前版本：V1.0
* 作    者：Zhou Zhaoxiong
* 完成日期：20151008
*
**********************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
 
// 数据类型重定义
typedef unsigned char       UINT8;
typedef signed   int        INT32;
typedef unsigned int        UINT32;
 
// 函数声明
void Sleep(UINT32 iCountMs);
void PrintInfo(void);
INT32 main();
 
/**********************************************************************
* 功能描述：主函数
* 输入参数：无
* 输出参数：无
* 返 回 值：无
* 其它说明：无
* 修改日期        版本号     修改人            修改内容
* -------------------------------------------------------------------
* 20151008       V1.0     Zhou Zhaoxiong      创建
***********************************************************************/
INT32 main()
{

    // 在屏幕上输出消息
    PrintInfo();   

    return 0;
}
 
/**********************************************************************
 
* 功能描述： 在屏幕上输出消息
 
* 输入参数： 无
 
* 输出参数： 无
 
* 返 回 值： 无
 
* 其它说明： 无
 
* 修改日期            版本号            修改人           修改内容
 
* ----------------------------------------------------------------------
 
* 20151008            V1.0        Zhou Zhaoxiong        创建
 
************************************************************************/
void PrintInfo(void)
{
    UINT32 iLoopFlag = 0;
    UINT32 iSum      = 0;
    UINT32 iLen      = 0;
    UINT8 *pCtrStr   = NULL;
	pCtrStr = "Hello, World!"; 
    iLen = strlen(pCtrStr);
 
    // 打印消息iLen次
    for (iLoopFlag = 0; iLoopFlag < iLen; iLoopFlag ++)      
    {
        printf("PrintInfo: hello, world!\n");
 
        iSum = iSum + iLoopFlag;
 
        // 每10s打印一次
        Sleep(10 * 1000);   
    }
 
    return;
}
 
/**********************************************************************
* 功能描述： 程序休眠
* 输入参数： iCountMs-休眠时间(单位:ms)
* 输出参数： 无
* 返 回 值： 无
* 其它说明： 无
* 修改日期          版本号       修改人              修改内容
* ------------------------------------------------------------------
* 20151008         V1.0     Zhou Zhaoxiong          创建
********************************************************************/
void Sleep(UINT32 iCountMs)
{
    struct timeval t_timeout = {0};
 
    if (iCountMs < 1000)
    {
        t_timeout.tv_sec = 0;
        t_timeout.tv_usec = iCountMs * 1000;
    }
    else
    {
        t_timeout.tv_sec = iCountMs / 1000;
        t_timeout.tv_usec = (iCountMs % 1000) * 1000;
    }
    
    // 调用select函数阻塞程序
    select(0, NULL, NULL, NULL, &t_timeout);   
}
