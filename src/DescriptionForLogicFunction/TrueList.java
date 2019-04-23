/*
 * 真值表类，功能：
 * 1.结构定义；
 * 2.初始化；
 * 3.转化成卡诺图；
 */
package DescriptionForLogicFunction;
public class TrueList {
/***********************真值表结构的定义*****************************/
	static int TrueList[]= new int[16]; //定义一个真值表的输出，参数是输出值，序号是排列号码
	static int binNum[][]=new int[5][16];//带输入的完整真值表
/*
 * 结构初始化，注入输入信息
 * 输入：要初始化的数组
 * 输出：初始化完成的数组
 */
	public static int[][] Init(int binNumTemp[][])  { 
		int temp=0;
		int m;
		for(int x=0;x<4;x++) {  //初始化第一项
			binNumTemp[0][x]=0;
		}
		
		for(int i=0;i<16;i++) {
			temp=i;
			m=3;
			while(temp!=0) {
				binNumTemp[m][i]=temp%2;
				temp=temp/2;
				m-=1;
			}
		}		
		for(int q=0;q<16;q++) {   //初始化输出值
			binNumTemp[4][q]=TrueList[q];
		}
		return binNumTemp;
	}
/*
 * 打印真值表，有横线把输入输出区分开
 */
	public static void printTureList(int TrueList[][]) {
		for(int i=0;i<16;i++)
			for(int j=0;j<5;j++) {
				System.out.print(binNum[j][i]);
				if(j==4) System.out.println("");
				else if(j==3) System.out.print("|");
				else System.out.print(" ");
			}
	}
	
/****************备用方法****************************/
	public static void init(int NO,int num) {//赋值方法，用来输入真值表输出的值
		TrueList[NO-1]=num;    
	}
	
/****************转化方法****************************/
/*
* 转化成卡诺图
* 主要克服的是卡诺图每行每列第三项和第四项交换问题
*/
	public static int[][] TrueListToKarnaughMap(int TrueListTemp[]) { //
		int MapListTemp[][]=new int[4][4];
		int x=0;
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++,x++) {
				if(i<3) {
					if(j<3) MapListTemp[i][j]= TrueList[x];
					else if(j==3) MapListTemp[i][j]= TrueList[x+1];
					else if(j==4) MapListTemp[i][j]= TrueList[x-1];
				}
				else if(i==3){
					if(j<3) MapListTemp[i][j]= TrueList[x+4];
					else if(j==3) MapListTemp[i][j]= TrueList[x+5];
					else if(j==4) MapListTemp[i][j]= TrueList[x+3];
				}
				else if(i==4) {
					if(j<3) MapListTemp[i][j]= TrueList[x-4];
					else if(j==3) MapListTemp[i][j]= TrueList[x-3];
					else if(j==4) MapListTemp[i][j]= TrueList[x-5];
				}
			}
		return MapListTemp;
	}
	
	public static void main(String args[]) {
		binNum=Init(binNum);
		printTureList(binNum);
	}
}