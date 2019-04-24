package LogicCircuitModule;
public class BS201A {
	public static int input[]= {0,0,0,0,0,0,0,0,0,0};
	public static int led[]= {0,0,0,0,0,0,0,0}; //D.P-g
	
	public static void updateLed() {
		int temp[]= {7,10,9,8,5,4,2,3};
		if(input[0]==0&&input[5]==0) {
			for(int i=0;i<8;i++) {
				if(input[temp[i]]==1) led[i]=1;
			}
		}
	}

	public static void printLed(int led[]) {
		char tmp[]= {'a','x','f','b','x','g','x','e','c','x','d','D','E'};
		char flag=tmp[0];
		int i=0;
		while(flag!='E') {
			if(tmp[i+1]!='x') {
				
			}
		}
	}
}
