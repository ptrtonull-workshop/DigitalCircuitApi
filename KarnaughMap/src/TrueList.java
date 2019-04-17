public class TrueList {
	static int TrueList[]= new int[16]; //定义一个真值表，参数是输出值，序号是排列号码
	static String[]simple= {"A","B","C","D","A\'","B\'","C\'","D\'"};
	
	public static String returnStr(int num,int TrueOrFalse) {
		if(TrueOrFalse==1) {
			return simple[num-1];
		}
		else return simple[num*2-1];
	}
	
	public static void init(int NO,int num) {//赋值方法
		TrueList[NO-1]=num;    
	}
	
	public static int[][] turnToKarnaughMap(int TrueListTemp[]) {
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
	
	public static SingleLinkedList TrueListToLK(int TrueListTemp[]) {
		SingleLinkedList SL=null;
		int list[] =new int [4];
		int temp=0;
		int TrueListTempValue[][]=new int [16][4];
		
		SingleLinkedList SLForTrueList=new SingleLinkedList();
		SingleLinkedList.Node SNForTrueList;
		SNForTrueList = SLForTrueList.back();
		
		
		for(int x=0;x<4;x++) {  //初始化第一项
			TrueListTempValue[0][x]=0;
		}
		
		for(int i=0;i<16;i++) {	//为接下去的15项赋值
			for(int a=0;a<4;a++) list[a]=0;
			temp=i;
			int m=0;
			while(temp/2!=0) {
				list[m]=temp%2;
				temp=i/2;
				m++;
			}
			for(int j=0;j<4;j++) {
				TrueListTempValue[i][j]=list[j];
			}
		}
		for(int u=0;u<16;u++) {
			if(TrueList[u]==1) {
				if(SNForTrueList==null) {
					for(int j=0;j<4;j++) {
						SLForTrueList.addNext(SLForTrueList,returnStr(j,TrueListTempValue[u][j]));
					}
				}
			}
		}
		return SL;
	}
}
