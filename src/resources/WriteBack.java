package resources;

import core.ConfigDetails;

public class WriteBack extends ConfigDetails{
	
	public boolean writeBack(boolean pass){
		if(wbInput.equals("")){
			pass = false;
			wbInput=BufferOutput;
		}
		if(!wbInput.equals("exit")){
			if(!memoryStalled&&pass){
				instAtWriteBack = wbInput;
				wbInput = BufferOutput;
			}
		}
		else{
			instAtWriteBack = "exit";
		}
		System.out.println("WriteBack = "+instAtWriteBack);
		wbOutput = instAtWriteBack;
		BufferOutput = wbOutput;
		
		return pass;
	}

}
