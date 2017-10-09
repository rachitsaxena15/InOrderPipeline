package resources;

import core.ConfigDetails;

public class Fetch extends ConfigDetails {

	InstructionHandler inst;
	
	public void fetch(){
		inst = new InstructionHandler();
		if (fetchInput==null) {
			instAtFetch = "exit";
		}
		else if(fetchInput.equals("")){
			fetchInput = inst.getInstruction(PC);
			instAtFetch = fetchInput;
		} 
		if(!instAtFetch.equals("exit")){
			if(!fetchStalled){
				instAtFetch = fetchInput;//inst.getInstruction(PC);
			}
		}
		else{
			instAtFetch = "exit";
		}
		fetchOutput = instAtFetch;
		BufferOutput = fetchOutput;
		PC+=4;
		fetchInput = inst.getInstruction(PC);
		System.out.println("Fetch  = "+instAtFetch);
	}

}
