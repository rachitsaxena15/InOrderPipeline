package resources;

import core.ConfigDetails;

public class Memory extends ConfigDetails{
	
	public boolean memory(boolean pass){
		if(memoryInput.equals("")){
			pass = false;
			memoryInput=BufferOutput;
		}
		if(!memoryInput.equals("exit")){
			if(!memoryStalled&&pass){
				instAtMemory = memoryInput;
				memoryInput = BufferOutput;
			}
		}
		else{
			instAtMemory = "exit";
		}
		System.out.println("Memory = "+instAtMemory);
		memoryOutput = instAtMemory;
		BufferOutput = memoryOutput;
		
		return pass;
	}	
}
