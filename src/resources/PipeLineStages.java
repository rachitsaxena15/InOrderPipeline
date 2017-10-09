package resources;

import core.ConfigDetails;

public class PipeLineStages extends ConfigDetails{
	InstructionHandler inst = new InstructionHandler();
	int counter = 0;
	
	public void performance(){
		Fetch fetch = new Fetch();
		Decode decode = new Decode();
		Execute exe = new Execute();
		Memory mem = new Memory();
		WriteBack wb = new WriteBack();
		
		String src1;
		String src2;
		String dest;
		String instType;
		
		boolean pass;
		int i=1;
		while(i<=28){
			pass = true;
			System.out.println("--------------"+"I"+counter+"-----------------");
			fetch.fetch();
			pass = decode.decode(pass);
			
			//get Register values after Decode Stage
			instType = decode.getInstType();
			src1 = decode.getSrc1();
			src2 = decode.getSrc2();
			dest = decode.getDest();
			
			
			pass = exe.execute(pass, instType, src1, src2, dest);
			pass = mem.memory(pass);
			pass = wb.writeBack(pass);
			
			i++;
			
		
		}
		System.out.println(R0+"==="+R6+"==="+R3);
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
