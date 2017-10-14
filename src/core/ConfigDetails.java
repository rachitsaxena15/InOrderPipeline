package core;

import java.util.ArrayList;

public class ConfigDetails {

	// Value of Architectural Registers
	public static int R0;
	public static int R1;
	public static int R2;
	public static int R3;
	public static int R4;
	public static int R5;
	public static int R6;
	public static int R7;
	public static int R8;
	public static int R9;
	public static int R10;
	public static int R11;
	public static int R12;
	public static int R13;
	public static int R14;
	public static int R15;

	// Busy bit of Each Register
	public static boolean R0Valid;
	public static boolean R1Valid;
	public static boolean R2Valid;
	public static boolean R3Valid;
	public static boolean R4Valid;
	public static boolean R5Valid;
	public static boolean R6Valid;
	public static boolean R7Valid;
	public static boolean R8Valid;
	public static boolean R9Valid;
	public static boolean R10Valid;
	public static boolean R11Valid;
	public static boolean R12Valid;
	public static boolean R13Valid;
	public static boolean R14Valid;
	public static boolean R15Valid;
	
	// Maintaining stall status of each stage
	public static boolean fetchStalled = false;
	public static boolean decodeStalled = false;
	public static boolean executeStalled = false;
	public static boolean memoryStalled = false;
	public static boolean wbStalled = false;

	// Base value of PC
	public static int PC;
	
}
