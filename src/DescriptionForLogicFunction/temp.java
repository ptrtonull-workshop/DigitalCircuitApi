package DescriptionForLogicFunction;

public class temp {
	public static SingleLinkedList TrueListToLK(int TrueListTemp[]) { //TrueList.java
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
		/*
		for(int u=0;u<16;u++) {
			if(TrueList[u]==1) {
				if(SNForTrueList==null) {
					for(int j=0;j<4;j++) {
						SLForTrueList.addNext(SLForTrueList,returnStr(j,TrueListTempValue[u][j]));
					}
				}
			}
		}*/
		return SL;
	}

}
