package operations;

import core.ConfigDetails;

public class ArithmeticOperations extends ConfigDetails{
	
	public int add(String src1, String src2){
		int res = getValueFromRegister(src1) + getValueFromRegister(src2);
		return res;
	}
	
	public int sub(String src1, String src2){
		int res = getValueFromRegister(src1) - getValueFromRegister(src2);
		return res;
	}
	
	public int mul(String src1, String src2){
		int res = getValueFromRegister(src1) * getValueFromRegister(src2);
		return res;
	}
	
	public int add(String src1, int literal){
		int res = getValueFromRegister(src1)+literal;
		return res;
	}
	
	public int add(int src1, int literal){
		int res = src1+literal;
		return res;
	}
	
	public int move(String src1){
		int res = getValueFromRegister(src1);
		return res;
	}
	
	public int getValueFromRegister(String reg){
		if(reg.equals("R0"))
			return R0;
		else if(reg.equals("R1"))
			return R1;
		else if(reg.equals("R2"))
			return R2;
		else if(reg.equals("R3"))
			return R3;
		else if(reg.equals("R4"))
			return R4;
		else if(reg.equals("R5"))
			return R5;
		else if(reg.equals("R6"))
			return R6;
		else if(reg.equals("R7"))
			return R7;
		else if(reg.equals("R8"))
			return R8;
		else if(reg.equals("R9"))
			return R9;
		else if(reg.equals("R10"))
			return R10;
		else if(reg.equals("R11"))
			return R11;
		else if(reg.equals("R12"))
			return R12;
		else if(reg.equals("R13"))
			return R13;
		else if(reg.equals("R14"))
			return R14;
		else if(reg.equals("R15"))
			return R15;
		else if(reg.contains("#")){
			return Integer.parseInt(reg.trim().replace("#", ""));	
		}
		else
			return 0;
	}
	
	public void updateToRegister(String dest, int result){
		switch (dest) {
		case "R0":
			R0 = result;
			break;
		case "R1":
			R1 = result;
			break;
		case "R2":
			R2 = result;
			break;
		case "R3":
			R3 = result;
			break;
		case "R4":
			R4 = result;
			break;
		case "R5":
			R5 = result;
			break;
		case "R6":
			R6 = result;
			break;
		case "R7":
			R7 = result;
			break;
		case "R8":
			R8 = result;
			break;
		case "R9":
			R9 = result;
			break;
		case "R10":
			R10 = result;
			break;
		case "R11":
			R11 = result;
			break;
		case "R12":
			R12 = result;
			break;
		case "R13":
			R13 = result;
			break;
		case "R14":
			R14 = result;
			break;
		case "R15":
			R15 = result;
			break;
		default:
			break;
		}
	}
}
