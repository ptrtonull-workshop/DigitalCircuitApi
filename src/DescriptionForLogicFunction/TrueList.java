package DescriptionForLogicFunction;
public class TrueList {
	/*
	 * 初始化选项
	 */
	static int TrueList[]= new int[16]; //定义一个真值表，参数是输出值，序号是排列号码
	static int binNum[][]=new int[5][16];
	static String[]simple= {"A","B","C","D","A\'","B\'","C\'","D\'"};
	
	public static void  Init()  {		//初始化真值表
		int temp=0;
		int m;
		for(int x=0;x<4;x++) {  //初始化第一项
			binNum[0][x]=0;
		}
		
		for(int i=0;i<16;i++) {
			temp=i;
			m=3;
			while(temp!=0) {
				binNum[m][i]=temp%2;
				temp=temp/2;
				m-=1;
			}
		}
			
		for(int q=0;q<16;q++) {   //初始化输出值
			binNum[4][q]=TrueList[q];
		}
	}
	public static void printTureList(int TrueList[][]) {
		for(int i=0;i<16;i++)
			for(int j=0;j<5;j++) {
				System.out.print(binNum[j][i]);
				if(j==4) System.out.println("");
				else if(j==3) System.out.print("|");
				else System.out.print(" ");
			}
	}
	
	/*
	 * 一些备用方法
	 */
	public static String returnStr(int num,int TrueOrFalse) {
		if(TrueOrFalse==1) {
			return simple[num-1];
		}
		else return simple[num*2-1];
	}
	
	public static void init(int NO,int num) {//赋值方法
		TrueList[NO-1]=num;    
	}
	
	/*
	 * 转化方法
	 */
	public static int[][] TrueListToKarnaughMap(int TrueListTemp[]) { //转化成卡诺图
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
		Init();
		printTureList(binNum);
	}
}