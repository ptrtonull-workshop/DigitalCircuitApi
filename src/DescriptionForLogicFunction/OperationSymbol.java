package DescriptionForLogicFunction;

public class OperationSymbol {  //运算符
	int A,B;
	public static int and(int a,int b) {  //同
		if(a==1&&b==1) return 1;
		else return 0;
	}
	public static int or(int a,int b) { //或
		if(a==0&&b==0) return 0;
		else return 1;
	}
	public static int not(int a) { //非
		if(a==1) return 0;
		else return 1;
	}
		
	
	
	public static int nand(int a,int b) { //与非
		return not(and(a,b));
	}
	public static int nor(int a,int b) { //或非
		return not(or(a,b));
	}
	public static int AndNor(int a,int b,int c,int d) { //与或非
		return not(or(and(a,b),and(c,d)));
	}
		
	public static int ExclusiveOr(int a,int b) { //异或
		//return or(and(a,not(b)),and(not(a),b));
		if(a==b) return 0;
		else return 1;
	}
	public static int ExclusiveNor(int a,int b) {  //同或
		//return or(and(a,b),and(not(a),not(b));
		if(a==b) return 1;
		else return 0;
	}
	
	
	public static int manyAnd(int inputtemp[]) {
		int manyand=inputtemp[0];
		for(int i=1;i<inputtemp.length;i++) {
			manyand= and(inputtemp[i],manyand);
		}
		return manyand;
	}
	
	public static int manyOr(int inputtemp[]) {
		int manyor=inputtemp[0];
		for(int i=1;i<inputtemp.length;i++) {
			manyor= or(inputtemp[i],manyor);
		}
		return manyor;
	}
	
	public static int many(int inputtemp[],String choose) {
		int many=inputtemp[0];
		for(int i=1;i<inputtemp.length;i++) {
			switch(choose) {
				case("and"): many= and(inputtemp[i],many);break;
				case("or"): many = or(inputtemp[i],many);break;
				default : many=-1;  //错误提示
			}
		}
		if(many==-1) System.out.println("没有这一项");
		return many;
	}
	
	public static void main(String args[]) {
		int input []=new int[3];
		input[0]=0;
		input[1]=1;
		input[2]=1;
		System.out.println(many(input,"and"));
		
	}
	
}
