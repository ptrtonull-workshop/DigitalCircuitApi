package LogicCircuitModule;
import DescriptionForLogicFunction.OperationSymbol;

public class Module74HC148 {
	static int input[]= {0,0,0,0,0,0,0,0,1};// 0-7 I0µ½I7£¬8£ºS
	static int output[]= {0,0,0};
	
	static class instructions{
		public static int YexNor(int inputtemp[]) {
			int yesnor=0;
			OperationSymbol os=new OperationSymbol();
			yesnor= os.nand(YsNor(inputtemp),os.not(inputtemp[0]));
			return os.not(yesnor);
		}
		
		public static int YsNor(int inputtemp[]) {
			int ysnor;
			OperationSymbol os=new OperationSymbol();
			inputtemp[0]=os.not(inputtemp[0]);
			return os.not(os.many(inputtemp,"and"));
		}
	}
	
	static class outPut{
		public static int Y0Nor(int inputtemp[]) {
			int outPutTemp;
			OperationSymbol  os=new OperationSymbol();
			int list[][]= {{inputtemp[1],os.not(inputtemp[2]),os.not(inputtemp[4]),os.not(inputtemp[6])},
						   {inputtemp[3],os.not(inputtemp[4]),os.not(inputtemp[6])},
					       {inputtemp[6],os.not(inputtemp[6])},
					       {inputtemp[7]}};
			outPutTemp=os.many(list[0], "and");
			for(int i=1;i<4;i++) {
				outPutTemp = os.or(os.many(list[0],"and"),outPutTemp);
			}
			return os.and(outPutTemp,inputtemp[0]);
		}
			
		public static int Y1Nor(int inputtemp[]) {
			int outPutTemp;
			OperationSymbol os=new OperationSymbol();
			int list[][]= {{inputtemp[2],os.not(inputtemp[4]),os.not(inputtemp[5])},{inputtemp[3],os.not(inputtemp[4]),os.not(inputtemp[5])},
						   {inputtemp[6]},{inputtemp[7]}};
			outPutTemp=os.many(list[0],"and");
			for(int i=1;i<4;i++) {
				outPutTemp = os.or(os.many(list[0],"and"),outPutTemp);
			}
			return os.and(outPutTemp,inputtemp[0]);
			
		}
		public static int Y2Nor(int inputtemp[]) {//
			int outPutTemp;
			OperationSymbol os=new OperationSymbol();
			int tmp[]=new int [4];
			for(int i=0;i<4;i++) {
				tmp[i]=inputtemp[i+4];
			}
			outPutTemp=os.many(tmp,"or");
			return os.and(outPutTemp,inputtemp[0]);
		}
	}
	
	public static void main(String args[]) {
		instructions i=new instructions();
		OperationSymbol os=new OperationSymbol();
		outPut o=new outPut();
		output[0]=o.Y0Nor(input);
		output[1]=o.Y1Nor(input);
		output[2]=o.Y2Nor(input);
		for(int ix=2;ix>=0;ix--) {
			System.out.print(os.not(output[ix])+" ");
		}
		System.out.println("");
		for(int ix=0;ix<9;ix++) {
			System.out.print(os.not(input[ix])+" ");
		}
		System.out.println("");
	}
}



