#include<stdio.h>
#include<stdlib.h>

char getrandomSignal();                      //��ȡ������������
int randomnum(double,double);             //��ȡ���������
int getResult(int,int,int,char,char);           //������㺯��
int produceTest();                        //��Ŀ���ɺ���


void main()
{
         int i;
         int n,a,right=0;
         double percent;
         printf("\t\t\t\t------Сѧ����������--------\t\t\t\t\n");

      loop:printf("��������Ŀ�ĸ���(���������1��������):");
         scanf("%d",&n);
         if (n<=0)//�ж����������Ƿ���ڻ����0
         {
             printf("�û�����������ٴ�����\n");
             goto loop;
         }
         for(i=0;i<n;i++)//ѭ�������Ŀ
         {
                   a=produceTest();
                   right=right+a;
         }
         printf("��ϰ������\n");
         printf("��ȷ������Ϊ:%d\n",right);
         percent=((double)right*100.00)/(double)n;
         printf("��ȷ��:%0.2f %%\n",percent);
         system("pause");//�����������

}


char getrandomSignal()
{
    char signal[4]={'+','-','*','/'};
    return signal[rand()%4];
}


int randomnum(double start, double end)
{
    return (int)(start+(end-start)*rand()/(RAND_MAX+ 1.0));//��ȡ�����
}


int getResult(int num1,int num2,int num3,char signal,char signal2)
{
    int res;

    switch(signal)
    {
    case '+':  //��һ�������Ϊ�Ӻŵ�����
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
    case '-':       //��һ�������Ϊ���ŵ�����
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
    case '*':      //��һ�������Ϊ�˺ŵ�����
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
    case '/':      //��һ�������Ϊ���ŵ�����
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
        printf("���������\n");
    }


    return res;
}




int produceTest()//��Ŀ����
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
    fflush(stdin);   //������뻺����
      if(getResult(num1,num2,num3,signal,signal2)<0){
        printf("������Ϊ��������������ĿҪ��\n");

    }else{
    if(getResult(num1,num2,num3,signal,signal2)==get)
        {
        printf("��Ĵ���ȷ!\n");
        a=1;
        }
    else
    {
        printf("�𰸴���!\n");
        printf("��ȷ�Ĵ���: %d\n",getResult(num1,num2,num3,signal,signal2));
        a=0;
    }
    }
    return a;
}
