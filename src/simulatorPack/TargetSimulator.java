package simulatorPack;

import resources.InstAndMemInitializer;
import resources.PipeLineStages;

public class TargetSimulator {
	static PipeLineStages ps;

	public static void main(String[] args) {
		InstAndMemInitializer inst = new InstAndMemInitializer();
		inst.SetInstructionQueue("./input.txt");
		inst.initializeMemory();

		ps = new PipeLineStages();
		ps.pipeline();//fetch(pointer);
	}
}
