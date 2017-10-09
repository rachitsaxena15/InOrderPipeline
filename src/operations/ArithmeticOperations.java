package operations;

import core.ConfigDetails;

public class ArithmeticOperations extends ConfigDetails{
	
	public void add(String dest, String src1, String src2){
		int res = getValueFromRegister(src1)+getValueFromRegister(src2);
		updateToRegister(dest, res);
		System.out.println("\t"+dest +" ===== "+ res);
	}
	
	public void move(String dest, String src1){
		int res = getValueFromRegister(src1);
		updateToRegister(dest, res);
		System.out.println("\t"+dest +" ===== "+ res);
	}

	void updateToRegister(String dest, int res){
		switch (dest) {
		case "R1":
			R1 = res;
			break;
		case "R2":
			R2 = res;
			break;
		case "R3":
			R3 = res;
			break;
		case "R4":
			R4 = res;
			break;
		case "R5":
			R5 = res;
			break;
		case "R6":
			R6 = res;
			break;
		case "R7":
			R7 = res;
			break;
		case "R8":
			R8 = res;
			break;
		case "R9":
			R9 = res;
			break;
		case "R10":
			R10 = res;
			break;
		case "R11":
			R11 = res;
			break;
		case "R12":
			R12 = res;
			break;
		case "R13":
			R13 = res;
			break;
		case "R14":
			R14 = res;
			break;
		case "R15":
			R15 = res;
			break;
		default:
			break;
		}
	}
	
	int getValueFromRegister(String reg){
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
}
