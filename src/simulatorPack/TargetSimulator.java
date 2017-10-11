package simulatorPack;

import resources.InstructionHandler;
import resources.PipeLineStages;

public class TargetSimulator {
	static PipeLineStages ps;
	
	public static void main(String[] args) {
		InstructionHandler inst = new InstructionHandler();
		inst.SetInstructionQueue("./input_20171010.txt");
		
		ps = new PipeLineStages();
		/*InstructionHandler handler = new InstructionHandler();
		//read.fetchAllInstructions("./input.txt");
		handler.SetInstructionQueue();*/
		int pointer = 4000;
		int cycles =10;
			ps.pipeline();//fetch(pointer);
	}
}
