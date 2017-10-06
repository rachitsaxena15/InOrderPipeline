package core;

public class ConfigDetails {
	
	//Initial values of Registers. Can be configured on demand
	public static int R0 = 0;
	public static int R1 = 0;
	public static int R2 = 0;
	public static int R3 = 0;
	public static int R4 = 0;
	public static int R5 = 0;
	public static int R6 = 0;
	public static int R7 = 0;
	public static int R8 = 0;
	public static int R9 = 0;
	public static int R10 = 0;
	public static int R11 = 0;
	public static int R12 = 0;
	public static int R13 = 0;
	public static int R14 = 0;
	public static int R15 = 0;
	
	//Set-Reset bit for each pipeline stage, indicating if an instruction can enter or not
	public static boolean fetchQueueFree = true;
	public static boolean decodeQueueFree = true;
	public static boolean executeQueueFree = true;
	public static boolean mul1QueueFree = true;
	public static boolean mul2QueueFree = true;
	public static boolean integerFUQueueFree = true;
	public static boolean memoryQueueFree = true;
	public static boolean writeBackQueueFree = true;
	
	public static boolean fetchStalled = false;
	public static boolean decodeStalled = false;
	public static boolean executeStalled = false;
	public static boolean memoryStalled = false;
	public static boolean wbStalled = false;
	
	public static String InputBuffer = "";
	public static String OutputBuffer ="";
	
	public static int PC = 4000;
	
	//Maintaining status of instruction executing at each queue
	public static String fetchInput ="";
	public static String instAtFetch = "";
	public static String fetchOutput ="";
	
	public static String decodeInput ="";
	public static String instAtDecode = "";
	public static String decodeOutput ="";
	
	public static String executeInput ="";
	public static String instAtExecute = "";
	public static String executeOutput ="";
	
	public static String instAtMul1 = "";
	public static String instAtMul2 = "";
	
	public static String memoryInput ="";
	public static String instAtMemory= "";
	public static String memoryOutput ="";
	
	public static String wbInput ="";
	public static String instAtWriteBack= "";
	public static String wbOutput="";
	
	//Address of Instruction Pointer
	public static int pointer = 4000;
}
