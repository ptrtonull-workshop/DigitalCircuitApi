/*
 * 运算符类
 */
package DescriptionForLogicFunction;
public class OperationSymbol {  
/*************初级逻辑门*****************/
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
		
/**************初级组合逻辑门*************/
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
		//return or(and(a,not(b)),and(not(a),b));  从内部逻辑门组成来表示，缺点是比较复杂
		if(a==b) return 0;   //采用真值表性质：不同出0，相同出1
		else return 1;
	}
	public static int ExclusiveNor(int a,int b) {  //同或
		//return or(and(a,b),and(not(a),not(b));
		if(a==b) return 1;
		else return 0;
	}
	
/**************中级输入增强逻辑门*************/
/*
 * 两个参数：一个是以数组形式存在的输入信息，一个是模式选择
 * and：多个变量相与
 * or：  多个变量相或
 */
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
/**************扩展逻辑门*****************/
/*
 * transform gate 传输门
 * 只有两个控制端符合C=1，C'=0
 * 数据才会杯被传输到输出端
 */
	public static int TG(int input,int controlOne,int controlTwoNor) {
		int output=0;
		if(controlOne==1&&controlTwoNor==0) {
			output = input;
		}
		return output;
	}
}
