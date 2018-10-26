import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        myframe f=new myframe();
    }


}
class myframe extends JFrame
{
    JLabel L1=new JLabel("式子：");//创建无图像并且其标题为空字符串的 JLabel
    JLabel L2=new JLabel("请输入题目个数:");
    JLabel L3=new JLabel("");
    JLabel L4=new JLabel("       ");   //题目
    JLabel L5=new JLabel("");   //提示
    JLabel L6=new JLabel("四则运算系统");
    JTextField T1=new JTextField(8);//创建一个8长度的文本框
    JButton B1=new JButton("开始"); //按钮
    JButton B2=new JButton("确认");
    JButton B3=new JButton("下一题");
    JButton B4=new JButton("更换背景");
    JPanel p1=new JPanel();//JPanel:面板组件，非顶层容器
    int n=0,a,b,c,d,j,k,l,m=0,p;
    double result;
    char[]h={'+','-','*','/'},h1={'(',')','!'};
    String s1,s2;
    myframe(){
        this.setTitle("四则运算系统");
        this.setSize(500,500);//设置面板大小
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭子窗口
        this.add(p1);
        L1.setFont(new Font("宋体", Font.BOLD, 18));
        L1.setForeground(Color.red);
        L2.setFont(new Font("宋体", Font.BOLD, 16));
        B1.setFont(new Font("宋体", Font.BOLD, 16));
        B2.setFont(new Font("宋体", Font.BOLD, 16));
        B3.setFont(new Font("宋体", Font.BOLD, 16));
        B4.setFont(new Font("宋体", Font.BOLD, 14));
        L3.setFont(new Font("宋体", Font.BOLD, 10));
        L4.setFont(new Font("宋体", Font.BOLD, 18));
        L6.setFont(new Font("宋体", Font.BOLD,25));
        L6.setForeground(Color.red);
        p1.setLayout(null);
        L1.setBounds(100, 150, 140, 80);
        p1.add(L1);
        L4.setBounds(230, 150, 200, 80);
        p1.add(L4);
        L2.setBounds(100, 220, 130, 30);
        p1.add(L2);
        T1.setBounds(230, 220, 90, 30);
        p1.add(T1);
        B4.setBounds(390, 250, 100, 50);//换皮肤
        p1.add(B4);
        B1.setBounds(390, 150, 100, 50);//开始
        p1.add(B1);
        B2.setBounds(130, 360, 100, 50);//确认
        p1.add(B2);
        B2.setEnabled(false);
        B3.setBounds(220, 360,100,50);//下一题
        p1.add(B3);
        L3.setBounds(100, 250, 50, 30);
        B3.setEnabled(false);
        p1.add(L3);
        L5.setBounds(140, 300, 180, 30);
        p1.add(L5);
        L6.setBounds(150, 50, 180, 30);
        p1.add(L6);
        this.setVisible(true);//设置可见窗口
        this.setResizable(false);//设置面板不可改变大小
        this.setLocationRelativeTo(null);//此窗口将置于屏幕的中央
        B1.addActionListener(new B());//按钮设置监听器
        B2.addActionListener(new B());
        B3.addActionListener(new B());
        B4.addActionListener(new B());
    }
    class B implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(e.getSource()==B1)//按开始按钮之后
            {
                p=n=(int) Double.parseDouble(T1.getText());
                //System.out.print(n);
                if(n>5||n<1)
                {
                    //如果题目个数大于5或小于1，会弹出提示框
                    JOptionPane.showMessageDialog(null,"输入的题目个数不能大于5或者小于1","注意",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    B1.setEnabled(false);
                    B2.setEnabled(true);
                    B3.setEnabled(true);
                    L2.setText("输入答案 :");
                    L5.setText("答案不能为空！");//设置文本
                    L5.setFont(new Font("宋体", Font.BOLD, 12));
                    L5.setForeground(Color.red);
                    T1.setText(null);
                    star();
                }
            }
            if(e.getSource()==B2)//确认按钮
            {
                l=(int) Double.parseDouble(T1.getText());
                if(l==result)
                {
                    m++;
                    s2="回答正确！";
                    L5.setText(s2);
                }
                else{
                    s2="回答错误! 正确答案为:"+String.valueOf(result);
                    L5.setText(s2);
                }
                B2.setEnabled(false);
            }
            if(e.getSource()==B3)//下一题按钮
            {
                if(n==0)
                {
                    JOptionPane.showMessageDialog(null, "一共"+p+"道题目。你正确的题数为:"+m,"成绩",JOptionPane.INFORMATION_MESSAGE);
                    B1.setEnabled(true);
                    B2.setEnabled(false);
                    B3.setEnabled(false);
                    L2.setText("输入题目个数:");
                    L4.setText(null);
                    T1.setText(null);
                }
                else
                {
                    L5.setText(null);
                    T1.setText(null);
                    star();
                    B2.setEnabled(true);
                }
            }
            if(e.getSource()==B4)//换皮肤
            {
                B4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent cc) {
                        Color ch = JColorChooser.showDialog(p1, "颜色选择器",
                                p1.getBackground());
                        if (ch != null) {
                            p1.setBackground(ch);
                            p1.repaint();
                        }
                    }
                });
            }
        }
    }
    void star()
    {
        a=(int) (Math.random()*200-100);//random出来的数为0-1之间，然后取-99到99的整数
        b=(int) (Math.random()*200-100);
        c=(int) (Math.random()*200-100);
        d=(int) (Math.random()*200-100);
        j=(int) (Math.random()*4);
        k=(int) (Math.random()*4);
        if(d<0)
        {
            a=(int) (Math.random()*9+1);//随机产生一个整数 范围是0-9(包括0和9)
            s1=String.valueOf(a)+String.valueOf(h1[2]);//获取这个数进行阶乘
            L4.setText(s1);
            result=1;
            for(int i=1;i<=a;i++)//从1开始一直乘到这个数字本身
            {
                result=result*i;
            }
        }
        else
        {
            if(b>=0&&c>=0)
            {
                //将变量转换成字符串
                s1=String.valueOf(a)+String.valueOf(h[j])+String.valueOf(b)+String.valueOf(h[k])+String.valueOf(c);
                L4.setText(s1);
                System.out.println(s1);
            }
            else if(b<0&&c>=0)
            {
                //检测到b小于0，为负数，给b的左右两边加上括号运算
                s1=String.valueOf(a)+String.valueOf(h[j])+String.valueOf(h1[0])+String.valueOf(b)+String.valueOf(h1[1])+String.valueOf(h[k])+String.valueOf(c);
                L4.setText(s1);
                System.out.println(s1);
            }
            else if(b>=0&&c<0)
            {
                //检测到c小于0，为负数，给c的左右两边加上括号运算
                s1=String.valueOf(a)+String.valueOf(h[j])+String.valueOf(b)+String.valueOf(h[k])+String.valueOf(h1[0])+String.valueOf(c)+String.valueOf(h1[1]);
                L4.setText(s1);
                System.out.println(s1);
            }
            else
            {
                //检测到b、c都小于0，都为负数，给b、c的左右两边都加上括号运算
                s1=String.valueOf(a)+String.valueOf(h[j])+String.valueOf(h1[0])+String.valueOf(b)+String.valueOf(h1[1])+String.valueOf(h[k])+String.valueOf(h1[0])+String.valueOf(c)+String.valueOf(h1[1]);
                L4.setText(s1);
                System.out.println(s1);
            }
            if(k>1)  //后面的计算符为乘除，先算后面两个数;k=0时为加，k=1时为减
            {
                if(k==2)
                {
                    result=b*c;
                }
                else if(k==3)
                {
                    result=b/c;
                }
                if(j==0)
                {
                    result=result+a;
                }
                else if(j==1)
                {
                    result=a-result;
                }
                else if(j==2)
                {
                    result=a*result;
                }
                else if(j==3)
                {
                    result=a/result;
                }
            }
            else if(k<2)
            {
                if(j==0)
                {
                    result=b+a;
                }
                else if(j==1)
                {
                    result=a-b;
                }
                else if(j==2)
                {
                    result=a*b;
                }
                else if(j==3)
                {
                    result=a/b;
                }
                if(k==0)
                    result=result+c;
                if(k==1)
                    result=result-c;
            }
        }
        System.out.println(result);
        n--;
    }

}