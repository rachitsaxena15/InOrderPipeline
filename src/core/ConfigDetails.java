package core;

public class ConfigDetails {
	
	//Initial values of Registers. Can be configured on demand
	public static int R0 = 0;
	public static int R1 = 1;
	public static int R2 = 2;
	public static int R3 = 3;
	public static int R4 = 4;
	public static int R5 = 5;
	public static int R6 = 6;
	public static int R7 = 7;
	public static int R8 = 8;
	public static int R9 = 9;
	public static int R10 = 10;
	public static int R11 = 11;
	public static int R12 = 12;
	public static int R13 = 13;
	public static int R14 = 14;
	public static int R15 = 15;
	
	//Set-Reset bit for each pipeline stage, indicating if an instruction can enter or not
	public static int fetchQueue = 0;
	public static int decodeQueue = 0;
	public static int executeQueue = 0;
	public static int mul1Queue = 0;
	public static int mul2Queue = 0;
	public static int integerFUQueue = 0;
	public static int memoryQueue = 0;
	public static int writeBackQueue = 0;
	
	//Maintaining status of instruction executing at each queue
	public static String instAtFetch = "";
	public static String instAtDecode = "";
	public static String instAtExecute = "";
	public static String instAtMul1 = "";
	public static String instAtMul2 = "";
	public static String instAtIntegerFU= "";
	public static String instAtMemory= "";
	public static String instAtWriteBack= "";
	
	//Address of Instruction Pointer
	public static int pointer = 4000;
}
