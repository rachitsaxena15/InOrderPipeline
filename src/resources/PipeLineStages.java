package resources;

import core.ConfigDetails;

public class PipeLineStages extends ConfigDetails{
	InstructionHandler inst = new InstructionHandler();
	int counter = 0;

	public void perform(){
		String instType = "";
		boolean pass;// =true;
		int i=1;
		while(i<=28){
			//fetch
			pass=true;
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
			OutputBuffer = fetchOutput;
			PC+=4;
			fetchInput = inst.getInstruction(PC);
			System.out.println("--------------"+"I"+i+"-----------------");
			System.out.println("Fetch  = "+instAtFetch);


			//decode
			if(decodeInput.equals("")){
				pass = false;
				decodeInput = OutputBuffer;
			}
			if(!decodeInput.equals("exit")){
				if(!decodeStalled&&pass){ 
					instAtDecode = decodeInput;//inst.getInstruction(PC);
					decodeInput = OutputBuffer;
					try{
						instType = instAtDecode.substring(0, instAtDecode.indexOf(" "));
					}
					catch(Exception e){

					}
				}
			} 
			else{
				instAtDecode = "exit";
			}
			System.out.println("Decode = "+instAtDecode);
			decodeOutput = instAtDecode;
			OutputBuffer = decodeOutput;

			//execute
			if(executeInput.equals("")){
				pass = false;
				executeInput=OutputBuffer;
			}
			if(!executeInput.equals("exit")){
				if(!executeStalled&&pass){
					instAtExecute = executeInput;
					executeInput = OutputBuffer;
				}
			}
			else{
				instAtExecute = "exit";
			}
			System.out.println("Execute = "+instAtExecute);
			executeOutput = instAtExecute;
			OutputBuffer = executeOutput;

			//memory
			if(memoryInput.equals("")){
				pass = false;
				memoryInput=OutputBuffer;
			}
			if(!memoryInput.equals("exit")){
				if(!memoryStalled&&pass){
					instAtMemory = memoryInput;
					memoryInput = OutputBuffer;
				}
			}
			else{
				instAtMemory = "exit";
			}
			System.out.println("Memory = "+instAtMemory);
			memoryOutput = instAtMemory;
			OutputBuffer = memoryOutput;

			//writeback
			if(wbInput.equals("")){
				pass = false;
				wbInput=OutputBuffer;
			}
			if(!wbInput.equals("exit")){
				if(!memoryStalled&&pass){
					instAtWriteBack = wbInput;
					wbInput = OutputBuffer;
				}
			}
			else{
				instAtWriteBack = "exit";
			}
			System.out.println("WriteBack = "+instAtWriteBack);
			wbOutput = instAtWriteBack;
			OutputBuffer = wbOutput;

			i++;			

		}
	}

	public void fetch(int instPointer){

		inst = new InstructionHandler();
		if(fetchQueueFree){
			fetchQueueFree=false;
			instAtFetch = inst.getInstruction(instPointer);
			//decode();
		}
		else{
			System.out.println("Fetch Stage Busy");
		}
	}

	public void decode(){
		counter++;
		String instType = "";
		if(decodeQueueFree){
			decodeQueueFree=false;
			instAtDecode = instAtFetch;
			fetchQueueFree=true;
			instAtFetch="";
			instType = instAtDecode.substring(0, instAtDecode.indexOf(" "));
			System.out.println(instType);
		}
		else{
			System.out.println("Decode Stage Busy");
		}
	}
}
