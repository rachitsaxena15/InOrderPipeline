package resources;

import operations.ArithmeticOperations;
import core.ConfigDetails;

public class Execute extends ConfigDetails{
	ArithmeticOperations operation;
	
	public boolean execute(boolean pass, String instType, String src1, String src2, String dest){
		operation = new ArithmeticOperations();
		if(executeInput.equals("")){
			pass = false;
			executeInput=BufferOutput;
		}
		if(!executeInput.equals("exit")){
			if(!executeStalled&&pass){
				instAtExecute = executeInput;
				executeInput = BufferOutput;
				
				if(instType.equals("ADD")){
					operation.add(dest, src1, src2);
				}
				else if(instType.equals("MOVC")){
					operation.move(dest, src1);
				}
			}
		}
		else{
			instAtExecute = "exit";
		}
		System.out.println("Execute = "+instAtExecute);
		executeOutput = instAtExecute;
		BufferOutput = executeOutput;
		
		return pass;
	}

}
