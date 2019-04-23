/*
 * 74HC138芯片
 */
package LogicCircuitModule;
import DescriptionForLogicFunction.OperationSymbol;
import DescriptionForLogicFunction.TrueList;
public class Module74HC138 {
/*************输入输出信号初始化*******************/
	int outPut[]= {0,0,1,0,0,0,0,0}; //输出信号 对应[Y0到Y7]
	int inPut[]= {0,0,0};            //输出信号 对应[A0到A2]
	static int S[]= {0,0,0};         //控制信号 对应[S1到S3]
	static int binNum[][]=new int[3][8];
	
	public static int G5(int stemp[]) {
		OperationSymbol os=new OperationSymbol();
		stemp[0]=S[0];
		stemp[1]=os.not(S[1]);
		stemp[2]=os.not(S[2]);
		return os.many(stemp, "and");
	}
/*
 * 初始化函数，
 */
	public static void init() {  
		int tmp,m;
		for(int i=0;i<8;i++) {
			tmp=i;
			m=2;
			while(tmp!=0) {
				binNum[m][i]=tmp%2;
				tmp=tmp/2;
				m-=1;
			}
		}
	}
	public static int[] output(int g5,int atemp[]) {
		int output[]= {0,0,0,0,0,0,0,0};
		int temp[]= {0,0,0};
		
		OperationSymbol os=new OperationSymbol();
		if(g5==1) {
			for(int m=0;m<8;m++) {
				for(int n=0;n<3;n++) {}
				//output[m]=os.ExclusiveNor(atemp[2-n],binNum(m));
			}
		}
		return output;
	}
	public static void main(String args[]) {
		TrueList tl=new TrueList();
		binNum=tl.Init(binNum);
		for(int i=0;i<8;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(binNum[j][i]+" ");
				if(j==2) System.out.println(" ");
			}
		}
	}
}
