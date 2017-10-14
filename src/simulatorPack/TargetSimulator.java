package simulatorPack;

import java.util.Scanner;

import resources.InstAndMemInitializer;
import resources.PipeLineStages;

public class TargetSimulator {
	static PipeLineStages ps;
	private static Scanner sc;
	public static void main(String[] args) {
		InstAndMemInitializer inst = new InstAndMemInitializer();
		ps = new PipeLineStages();
		inst.SetInstructionQueue("./input.txt");
		inst.initializeMemory();

		System.out.println("****** WELCOME TO APEX SIMULATOR******\n\n");
		System.out.println("What would you like to do ?\n\n");

		System.out.println("1. Initialize");
		System.out.println("2. Execute and Display");
		System.out.println("3. Display");
		System.out.println("4. Exit\n\n");

		int choice;
		int cycles;
		sc = new Scanner(System.in);
		choice = sc.nextInt();
		int i=1;
		while(i!=0){
			switch(choice){
			case 1:
				ps.initialize();
				System.out.println("Instruction and Memory Initialized \n\n");
				System.out.println("Make another choice \n");
				System.out.println("1. Initialize");
				System.out.println("2. Execute and Display");
				System.out.println("3. Display");
				System.out.println("4. Exit\n\n");
				choice = sc.nextInt();
				break;
			case 2:
				System.out.println("\tEnter the number of Cycles:\t");
				cycles = sc.nextInt();
				ps.pipeline(cycles);
				System.out.println("Make another choice \n");
				System.out.println("1. Initialize");
				System.out.println("2. Execute and Display");
				System.out.println("3. Display Memory and Register Values");
				System.out.println("4. Exit\n\n");
				choice = sc.nextInt();
				break;
			case 3:
				ps.displayAll();
				System.out.println("1. Initialize");
				System.out.println("2. Execute and Display");
				System.out.println("3. Display");
				System.out.println("4. Exit\n\n");
				choice = sc.nextInt();
				break;
			case 4:
				System.out.println("\nThank You For Your Patience !! ;)\n");
				i=0;
				break;
			default:
				i=0;
				break;
			}			
		}
	}
}
