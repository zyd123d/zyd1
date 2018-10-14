#include<stdio.h>
#include<stdlib.h>

char getrandomSignal();                      //获取随机运算符函数
int randomnum(double,double);             //获取随机数函数
int getResult(int,int,int,char,char);           //结果计算函数
int produceTest();                        //题目生成函数


void main()
{
         int i;
         int n,a,right=0;
         double percent;
         printf("\t\t\t\t------小学生四则运算--------\t\t\t\t\n");

      loop:printf("请输入题目的个数(请输入大于1的正整数):");
         scanf("%d",&n);
         if (n<=0)//判断输入数字是否大于或等于0
         {
             printf("用户输入错误，请再次输入\n");
             goto loop;
         }
         for(i=0;i<n;i++)//循环输出题目
         {
                   a=produceTest();
                   right=right+a;
         }
         printf("练习结束！\n");
         printf("正确的数量为:%d\n",right);
         percent=((double)right*100.00)/(double)n;
         printf("正确率:%0.2f %%\n",percent);
         system("pause");//按任意键结束

}


char getrandomSignal()
{
    char signal[4]={'+','-','*','/'};
    return signal[rand()%4];
}


int randomnum(double start, double end)
{
    return (int)(start+(end-start)*rand()/(RAND_MAX+ 1.0));//获取随机数
}


int getResult(int num1,int num2,int num3,char signal,char signal2)
{
    int res;

    switch(signal)
    {
    case '+':  //第一个运算符为加号的运算
        switch(signal2){
        case '+':
            res=num1+num2+num3;break;
        case '-':
            res=num1+num2-num3;break;
        case '*':
            res=num1+(num2*num3);break;
        case '/':
            res=num1+(num2/num3);break;
        }
    break;
    case '-':       //第一个运算符为减号的运算
        switch(signal2){
        case '+':
        res=num1-num2+num3;break;
        case '-':
        res=num1-num2-num3;break;
        case '*':
        res=num1-(num2*num3);break;
        case '/':
        res=num1-(num2/num3);break;
        }
    break;
    case '*':      //第一个运算符为乘号的运算
        switch(signal2){
        case '+':
        res=num1*num2+num3;break;
        case '-':
        res=num1*num2-num3;break;
        case '*':
        res=num1*num2*num3;break;
        case '/':
        res=num1*num2/num3;break;
        }
    break;
    case '/':      //第一个运算符为除号的运算
        switch(signal2){
        case '+':
        res=num1/num2+num3;break;
        case '-':
        res=num1/num2-num3;break;
        case '*':
        res=num1/num2*num3;break;
        case '/':
        res=num1/num2/num3;break;
        }
    break;
     default:
        printf("运算符错误！\n");
    }


    return res;
}




int produceTest()//题目生成
{
    int get;
    int num1,num2,num3,a;
    char signal,signal2;

    srand((unsigned)time(NULL));
    signal=getrandomSignal();
    signal2=getrandomSignal();
    num1=randomnum(1,100);
    num2=randomnum(1,100);
    num3=randomnum(1,100);
if(signal=='-')
    {
        if(num1<num2 )
        {
            int temp;
            temp=num1;
            num1=num2;
            num2=temp;
        }else if(num1<num3)
        {
            int temp2;
            temp2=num1;
            num1=num3;
            num3=temp2;
        }
    }


    printf("%d%c%d%c%d=",num1,signal,num2,signal2,num3);
    scanf("%d",&get);
    fflush(stdin);   //清空输入缓冲区
      if(getResult(num1,num2,num3,signal,signal2)<0){
        printf("输出结果为负数，不符合题目要求\n");

    }else{
    if(getResult(num1,num2,num3,signal,signal2)==get)
        {
        printf("你的答案正确!\n");
        a=1;
        }
    else
    {
        printf("答案错误!\n");
        printf("正确的答案是: %d\n",getResult(num1,num2,num3,signal,signal2));
        a=0;
    }
    }
    return a;
}
