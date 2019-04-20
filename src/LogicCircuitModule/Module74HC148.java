package LogicCircuitModule;
import DescriptionForLogicFunction.OperationSymbol;
public class Module74HC148 {
	static int input[]= {0,0,1,1,1,1,1,1,1};
	
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
		public static int Y0Nor(int inputtemp[]) {//
			OperationSymbol  os=new OperationSymbol();
			int outPut=0;
			//outPut=osBase.nor()
			return outPut;
		}
	}
	

	public static void main(String args[]) {
		instructions i=new instructions();
		System.out.println(i.YsNor(input));
	}

}
