package simulatorPack;

import resources.InstructionHandler;
import resources.PipeLineStages;

public class TargetSimulator {
	static PipeLineStages ps;
	
	public static void main(String[] args) {
		InstructionHandler inst = new InstructionHandler();
		inst.SetInstructionQueue("./input.txt");
		
		ps = new PipeLineStages();
		int cycles = 10;
		/*for(int i=0;i<cycles;i++){
			ps.fetch(pointer);
			pointer+=4;
		}*/
		ps.perform();
		
	}
}
