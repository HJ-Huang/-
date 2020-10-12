package Operations ;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile; 
public class FourOperations{
	private static Random random = new Random();
	public static int range;
	//p1为输入分子，q1为输入分母，对分数进行约分运算
	//p2为计算后分子，q2为计算后分母
	public static String ReductionOfFraction(int p1, int q1) {
		int temp = 1,p2,q2,i;//**初始值
		for (i = p1; i >= 1; i--) {
			if (p1 % i == 0 && q1 % i == 0) {
				temp = i;
				break;
			}
		}
		p2 = p1 / temp;// 分子
		q2 = q1 / temp;// 分母
		if (p2 == 0) {
			return "0";
		}
		if(q2==1) return p2+"";
		else  return expression(p2,q2);
		
	}
	//p1为输入分子，q1为输入分母，m为带分数整数部分，n为带分数分子部分
	//判断输入是否为假分数，如果是假分数则化为带分数
	public static String expression(int p1,int q1) {
		if(p1>=q1) {
			int m,n;
			m=p1/q1;
			//int d;
			n=p1%q1; 
			if(n==0){
				return m+"";
			}
			return m+"'"+n+"/"+q1;//** 
		}
		return p1+"/"+q1;
	}

	static long start=System.currentTimeMillis(); //获取开始时间
	 
    //要测的程序或方法
 
	
public static void main(String[] args){ 
	Scanner scan= new Scanner(System.in);//Scanner 类来获取用户的输入
	System.out.println("请定义最大运算数：");
	int range=scan.nextInt();//** 
    System.out.println("请定义运算表达式的个数：");
    int num=scan.nextInt();
  //  int [] rightcount;
    //int [] wrongcount; 
    int rightcount[]=new int[num+2];
    int wrongcount[] =new int[num+2];
 	int rightnum=0;
	int wrongnum=0;
	String[] results=new String[num];
	//int i;
	int numerator,denominator,i;
     for( i=0;i<num;i++){ 
        String subject[]=new String[2];//定义生成的题目
        int p1= (int) (random.nextInt(range));//一个分子
    	int q1= (int) (random.nextInt(range));//一个分母
    	int p2= (int) (random.nextInt(range));//另一个分子
    	int q2= (int) (random.nextInt(range));//另一个分母
		int mark;//运算符
		//a=p1,b=q1,c=p2,d=q2
    	mark= (int) (random.nextInt(4));//随机生成0~3，0表示加法，1表示减法，2表示乘法，3表示除法
		if(q1!=0&&q2!=0) {//要求分母不为0
		//mark为0，进行加法运算
		if(mark==0) {
    		numerator=p1*q2+q1*p2;
    		denominator=q1*q2;
    		subject[0]=expression(p1,q1)+' '+'+'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
    		results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为1，进行减法运算，且运算后的分子为正
		if(mark==1&&p1*q2-q1*p2>=0) {
    		numerator=p1*q2-q1*p2;
    		denominator=q1*q2;
    		subject[0]=expression(p1,q1)+' '+'-'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为1，进行减法运算，且运算后的分子为负
		if(mark==1&&p1*q2-q1*p2<0) {
    		numerator=q1*p2-p1*q2;
    		denominator=q1*q2;
    		subject[0]=expression(p2,q2)+' '+'-'+' '+expression(p1,q1)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为2，进行乘法运算
    	if(mark==2) {
    		numerator=p1*p2;
    		denominator=q1*q2;
    		subject[0]=expression(p1,q1)+' '+'×'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为3，进行除法运算，且除数分子不为0
    	if(mark==3&&p2!=0) {
    		numerator=p1*q2;
    		denominator=q1*p2;
    		subject[0]=expression(p1,q1)+' '+'÷'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为3，进行除法运算，且除数分子为0**
    	if(mark==3&&p2==0) {
    		//break;
    		p2=1;
    		numerator=p1*q2;
    		denominator=q1*p2;
    		subject[0]=expression(p1,q1)+' '+'÷'+' '+expression(p2,q2)+' '+'=';
    		System.out.println(subject[0]);
    		results[i]=ReductionOfFraction(numerator, denominator);}
    	
    	}
    	else {//分母中至少一个为0时则生成只含有整式的运算式，同时计算结果
			q1=1; q2=1;
		//mark为0，进行加法运算
		if(mark==0) {
			numerator=p1*q2+q1*p2;
			denominator=q1*q2;
			subject[0]=expression(p1,q1)+' '+'+'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为1，进行减法运算，且运算后的分子为正
		if(mark==1&&p1*q2-q1*p2>=0) {
			numerator=p1*q2-q1*p2;
			denominator=q1*q2;
			subject[0]=expression(p1,q1)+' '+'-'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为1，进行减法运算，且运算后的分子为负
		if(mark==1&&p1*q2-q1*p2<0) {
			numerator=q1*p2-p1*q2;
			denominator=q1*q2;
			subject[0]=expression(p2,q2)+' '+'-'+' '+expression(p1,q1)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为2，进行乘法运算
		if(mark==2) {
			numerator=p1*p2;
			denominator=q1*q2;
			subject[0]=expression(p1,q1)+' '+'×'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为3，进行除法运算，且除数分子不为0
		if(mark==3&&p2!=0) {
			numerator=p1*q2;
			denominator=q1*p2;
			subject[0]=expression(p1,q1)+' '+'÷'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}
		//mark为3，进行除法运算，且除数分子为0**
		if(mark==3&&p2==0) {
			//break;
			p2=1;
			numerator=p1*q2;
			denominator=q1*p2;
			subject[0]=expression(p1,q1)+' '+'÷'+' '+expression(p2,q2)+' '+'=';
			System.out.println(subject[0]);
			results[i]=ReductionOfFraction(numerator, denominator);}		
		}   
	//题目生成
	FileWriter filewriter = null;//FileWriter类按字符向流中写入数据
    try {
        File file=new File("C:\\Users\\98577\\Desktop\\Exersies.txt");//题目写入
        filewriter = new FileWriter(file, true);
    } catch (IOException e) {
		e.printStackTrace();}
	if(subject[0]!=null) {
    PrintWriter printwriter = new PrintWriter(filewriter);
    printwriter.println(i+1+"、"+subject[0]);
    printwriter.flush();
    try {
        filewriter.flush();
        printwriter.close();
        filewriter.close();
    } catch (IOException e) {
    	e.printStackTrace();
	}}
	//答案生成
	FileWriter fileanswer = null;
    try {
            File file=new File("C:\\Users\\98577\\Desktop\\Answer.txt");//答案写入
            fileanswer = new FileWriter(file, true);
        } catch (IOException e) {
        	e.printStackTrace();
		}
	if(subject[0]!=null) {
        PrintWriter printanswer = new PrintWriter(fileanswer);
        printanswer.println(i+1+"、"+results[i]);
        printanswer.flush();
        try {
            fileanswer.flush();
            printanswer.close();
            fileanswer.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }}
	}
    //运行页面反馈
     System.out.println("请在your_answers.txt输入您的答案后，输入'OK'。");
     Scanner scan1=new Scanner(System.in);
     String submit=scan1.nextLine();
	    if(submit.equals("OK")){
	 String array[]=new String[num];
    try
		{   int k=0;
		    
			FileReader fileread = new FileReader("C:\\Users\\98577\\Desktop\\Your_answers.txt");
			BufferedReader bufferedread = new BufferedReader(fileread);
			String s ;
			while((s = bufferedread.readLine())!=null) {//读取输入的答案
				array[k]=s;	k++;
				}bufferedread.close();
				fileread.close();		
			}catch(IOException e){
				System.out.println("指定文件不存在");
			}
	
    for(int j=0;j<num;j++){
     	if(array[j].equals(results[j])) {//验证答案，统计正确和错误的个数
     		
     		rightcount[j]=j+1;
     		rightnum++;
     	}
     	else {
     		
     		wrongcount[j]=j+1;
     		wrongnum++;
     	}
	 }
	//
    FileWriter filegrade = null;
    try {
        //反馈正确与错误题目的信息
            File file=new File("C:\\Users\\98577\\Desktop\\Grade.txt");
            filegrade = new FileWriter(file, true);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        PrintWriter printgrade = new PrintWriter(filegrade);
        printgrade.println(" ");
        printgrade.print("Correct:"+rightnum+"(");
       int max1=0;
       for (int j = 0; j <=num; j++) {
    	   if(rightcount[j] != 0) {
      		// printgrade.print(rightcount[j]+',');
    		   max1=j;
               }}
       for (int s = 0; s<=num; s++) {
        	   if(rightcount[s] != 0) {
          		printgrade.print(rightcount[s]);
          		if(s!=max1) {printgrade.print(',');}
       } }
        
      
        
        printgrade.println(")");
        printgrade.print("Wrong:"+wrongnum+"(");
        int max2=0;
        for (int j = 0; j <=num; j++) {
     	   if(wrongcount[j] != 0) {
     		   max2=j;
                }}
        for (int s = 0; s<=num; s++) {
         	   if(wrongcount[s] != 0) {
           		printgrade.print(wrongcount[s]);
           		if(s!=max2) {printgrade.print(',');}
        } }
        
        printgrade.print(")");
        printgrade.flush();
        try {
            filegrade.flush();
            printgrade.close();
            filegrade.close();
        } catch (IOException e) {
        	e.printStackTrace();
		}}
		System.out.println("答案对比已完成，请在Grade.txt查看答案对错！");
		long end=System.currentTimeMillis(); //获取结束时间

		System.out.println("程序运行时间： "+(end-start)+"ms");	
}
//要测的程序或方法

}
