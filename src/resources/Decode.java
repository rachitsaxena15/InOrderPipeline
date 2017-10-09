package resources;

import core.ConfigDetails;

public class Decode extends ConfigDetails{

	InstructionHandler inst;
	static String instType;
	static String src1;
	static String src2;
	static String dest;
	
	public boolean decode(boolean pass){

		inst = new InstructionHandler();
		String instArr[];
		if(decodeInput.equals("")){
			pass = false;
			decodeInput = BufferOutput;
		}
		if(!decodeInput.equals("exit")){
			if(!decodeStalled&&pass){ 
				instAtDecode = decodeInput;//inst.getInstruction(PC);
				decodeInput = BufferOutput;
				if(instAtDecode!=null){
					instArr= instAtDecode.split(",");
					instType = instArr[0];
					
					switch(instType){
					
					case "ADD":
						dest = instArr[1];
						src1 = instArr[2];
						src2 = instArr[3];
						break;
					case "MOVC":
						dest = instArr[1];
						src1 = instArr[2];
						src2 = null;
						break;
					default:
						dest = null;
						src1 = null;
						src2 = null;
						break;
					}
				}
			}
		} 
		else{
			instAtDecode = "exit";
		}
		
		System.out.println("Decode = "+instAtDecode);
		decodeOutput = instAtDecode;
		BufferOutput = decodeOutput;
		
		return pass;
	}
	
	public String getInstType(){
		return instType;
	}
	
	public String getSrc1(){
		return src1;
	}
	
	public String getSrc2(){
		return src2;
	}
	
	public String getDest(){
		return dest;
	}
	
}
