package resources;

import core.ConfigDetails;

public class PipeLineStages extends ConfigDetails{
	InstructionHandler inst;
	
	public void fetch(int instPointer){
		inst = new InstructionHandler();
		if(fetchQueue == 0){
			fetchQueue=1;
			instAtFetch = inst.getInstruction(instPointer);
			decode();
		}
		else{
			System.out.println("Fetch Stage Busy");
		}
	}
	
	public void decode(){
		String instType = "";
		if(decodeQueue == 0){
			decodeQueue=1;
			instAtDecode = instAtFetch;
			fetchQueue=0;
			instAtFetch="";
			instType = instAtDecode.substring(0, instAtDecode.indexOf(" "));
			System.out.println(instType);
		}
		else{
			System.out.println("Decode Stage Busy");
		}
	}
}
