package resources;

import operations.ArithmeticOperations;
import core.ConfigDetails;

public class PipeLineStages extends ConfigDetails {

	InstAndMemInitializer inst;
	FetchStage fetch;
	DecodeStage decode;
	ExecuteStage ex;
	MemoryStage mem;
	WriteBackStage wb;
	ArithmeticOperations operations;
	PSW psw;

	public void pipeline() {
		initialize();
		operations = new ArithmeticOperations();
		int i = 0;
		while (i <= 30) {
			System.out.println("--------------------I" + i
					+ "------------------");

			/***************************** Fetch **************************/
			System.out.print("Fetch\t::\t");
			if (fetchStalled) {
				System.out.println(fetch.getInstAtInput());
			} else {
				inst = new InstAndMemInitializer();
				fetch.setPCAtInput(PC);
				// If fetch finds no instruction, let current instruction pass,
				// and initialize fetch with default values
				if (inst.getInstruction(PC) == null) {
					fetch.setInstAtInput("");
					fetch.setPCAtInput(PC);
					// Update Decode Input
					decode = new DecodeStage(fetch.getPCAtOutput(),
							fetch.getTargetDataAtOutput(),
							fetch.getTargetAddressAtOutput(),
							fetch.getLiteralAtOutput(),
							fetch.getInstAtOutput(), fetch.getSrc1AtOutput(),
							fetch.getSrc2AtOutput(), fetch.getDestAtOutput(),
							fetch.getOperationAtOutput());

					// Update Fetch Output
					fetch = new FetchStage("", "", "", "", "", PC, 0, 0, 0);
				} else {
					fetch.setInstAtInput(inst.getInstruction(PC));
					fetch.setPCAtInput(PC);

					// Update Decode Input
					decode = new DecodeStage(fetch.getPCAtOutput(),
							fetch.getTargetDataAtOutput(),
							fetch.getTargetAddressAtOutput(),
							fetch.getLiteralAtOutput(),
							fetch.getInstAtOutput(), fetch.getSrc1AtOutput(),
							fetch.getSrc2AtOutput(), fetch.getDestAtOutput(),
							fetch.getOperationAtOutput());
					// Update Fetch Output
					fetch = new FetchStage(fetch.getInstAtInput(),
							fetch.getSrc1AtInput(), fetch.getSrc2AtInput(),
							fetch.getDestAtInput(),
							fetch.getOperationAtInput(), fetch.getPCAtInput(),
							fetch.getTargetDataAtInput(),
							fetch.getTargetAddressAtInput(),
							fetch.getLiteralAtInput());
				}
				System.out.println(fetch.getInstAtInput());
			}

			/***************************** Decode **************************/
			System.out.print("Decode\t::\t");
			String instArr[];
			int res;
			if (decodeStalled) {
				// Print balnk new line
				System.out.println(decode.getInstAtInput());
			} else {
				System.out.println(decode.getInstAtInput());
				if (!decode.getInstAtInput().equals("")) {
					instArr = decode.getInstAtInput().split(",");

					switch (decode.getInstAtInput().split(",")[0].trim()) {

					case "ADD":
						decode.setOperationAtInput(instArr[0]);
						decode.setDestAtInput(instArr[1]);
						decode.setSrc1AtInput(instArr[2]);
						decode.setSrc2AtInput(instArr[3]);
						psw.setPswFree(false);
						break;
					case "SUB":
						decode.setOperationAtInput(instArr[0]);
						decode.setDestAtInput(instArr[1]);
						decode.setSrc1AtInput(instArr[2]);
						decode.setSrc2AtInput(instArr[3]);
						psw.setPswFree(false);
						break;
					case "MUL":
						decode.setOperationAtInput(instArr[0]);
						decode.setDestAtInput(instArr[1]);
						decode.setSrc1AtInput(instArr[2]);
						decode.setSrc2AtInput(instArr[3]);
						psw.setPswFree(false);
						break;
					case "MOVC":
						decode.setOperationAtInput(instArr[0]);
						decode.setDestAtInput(instArr[1]);
						decode.setSrc1AtInput(instArr[2]);
						decode.setSrc2AtInput("");
						break;
					case "STORE":
						decode.setOperationAtInput(instArr[0]);
						decode.setSrc1AtInput(instArr[1]);
						decode.setSrc2AtInput(instArr[2]);
						decode.setLiteralAtInput(operations
								.getValueFromRegister(instArr[3]));
						res = operations.add(decode.getSrc1AtInput(),
								decode.getLiteralAtInput());
						decode.setTargetAddressAtInput(res);
						break;
					case "LOAD":
						decode.setOperationAtInput(instArr[0]);
						decode.setDestAtInput(instArr[1]);
						decode.setSrc1AtInput(instArr[2]);
						res = operations.add(decode.getSrc1AtInput(),
								instArr[3]);
						decode.setTargetDataAtInput(res);
						break;
					case "BNZ":
						decode.setOperationAtInput(instArr[0]);
						decode.setLiteralAtInput(operations
								.getValueFromRegister(instArr[1]));
						break;
					case "HALT":
						decode.setOperationAtInput(instArr[0]);
						break;
					case "JUMP":
						decode.setOperationAtInput(instArr[0]);
						decode.setSrc1AtInput(instArr[1]);
						decode.setLiteralAtInput(operations
								.getValueFromRegister(instArr[2]));
						// decode.setPCAtInput(operations.add(decode.getSrc1AtInput(),
						// decode.getLiteralAtInput()));
						break;
					default:
						break;
					}
				}

				updateRegisterValidity(decode.getDestAtOutput(), false);

				// Update Execute Input
				ex = new ExecuteStage(decode.getPCAtOutput(),
						decode.getTargetDataAtOutput(),
						decode.getTargetAddressAtOutput(),
						decode.getLiteralAtOutput(), decode.getInstAtOutput(),
						decode.getSrc1AtOutput(), decode.getSrc2AtOutput(),
						decode.getDestAtOutput(), decode.getOperationAtOutput());

				// Update Decode Output
				decode = new DecodeStage(decode.getInstAtInput(),
						decode.getSrc1AtInput(), decode.getSrc2AtInput(),
						decode.getDestAtInput(), decode.getOperationAtInput(),
						decode.getPCAtInput(), decode.getTargetDataAtInput(),
						decode.getTargetAddressAtInput(),
						decode.getLiteralAtInput());
			}

			/***************************** Execute **************************/
			System.out.print("Execute\t::\t");
			if (executeStalled) {
				// System.out.print(ex.getInstAtInput());
			} else {
				System.out.println(ex.getInstAtInput());
				// updateRegisterValidity(ex.getDestAtInput(), false);

				// Perform Add
				if (ex.getOperationAtInput().equals("ADD")) {
					ex.setTargetDataAtInput(operations.add(ex.getSrc1AtInput(),
							ex.getSrc2AtInput()));
				}
				// Perform Subtract
				else if (ex.getOperationAtInput().equals("SUB")) {
					ex.setTargetDataAtInput(operations.sub(ex.getSrc1AtInput(),
							ex.getSrc2AtInput()));
				}
				// Perform Multiply
				else if (ex.getOperationAtInput().equals("SUB")) {
					ex.setTargetDataAtInput(operations.mul(ex.getSrc1AtInput(),
							ex.getSrc2AtInput()));
				}
				// Perform Move
				else if (ex.getOperationAtInput().equals("MOVC")) {
					ex.setTargetDataAtInput(operations.move(ex.getSrc1AtInput()));
				}

				// Perform JUMP
				else if (ex.getOperationAtInput().equals("JUMP")) {
					fetch.setPCAtInput((operations.add(ex.getSrc1AtInput(),
							ex.getLiteralAtInput())) - 4);
				}

				// Check for BNZ
				else if (ex.getOperationAtInput().equals("BNZ")) {
					// calculate PC address
					PC = (ex.getPCAtInput() + ex.getLiteralAtInput()) - 4;
				}
				// Stall on Halt
				else if (ex.getOperationAtInput().equals("HALT")) {
					// Decode input becomes empty
					fetch = new FetchStage("", "", "", "", "", 0, 0, 0, 0);
					fetch = new FetchStage(0, 0, 0, 0, "", "", "", "", "");
					decode = new DecodeStage(0, 0, 0, 0, "", "", "", "", "");
					decode = new DecodeStage("", "", "", "", "", 0, 0, 0, 0);
					// fetchStalled = true;
					// decodeStalled = true;
				}

				// Stalling Logic for Flow Dependencies
				if (!(checkRegisterValidity(decode.getSrc1AtOutput()) && checkRegisterValidity(decode
						.getSrc2AtOutput()))) {
					fetchStalled = true;
					decodeStalled = true;
				}

				// Stalling logic for Branching instruction
				if (decode.getOperationAtOutput().equals("BNZ")) {
					if (!psw.isPswFree()) {
						fetchStalled = true;
						decodeStalled = true;
					}
				}

				// Update memory Input
				mem = new MemoryStage(ex.getPCAtOutput(),
						ex.getTargetDataAtOutput(),
						ex.getTargetAddressAtOutput(), ex.getLiteralAtOutput(),
						ex.getInstAtOutput(), ex.getSrc1AtOutput(),
						ex.getSrc2AtOutput(), ex.getDestAtOutput(),
						ex.getOperationAtOutput());
				// Update Execute Output
				ex = new ExecuteStage(ex.getInstAtInput(), ex.getSrc1AtInput(),
						ex.getSrc2AtInput(), ex.getDestAtInput(),
						ex.getOperationAtInput(), ex.getPCAtInput(),
						ex.getTargetDataAtInput(),
						ex.getTargetAddressAtInput(), ex.getLiteralAtInput());
			}

			/**************************** Memory ***************************/
			System.out.print("Memory\t::\t");
			if (memoryStalled) {
				System.out.println(mem.getInstAtInput());
			} else {
				System.out.println(mem.getInstAtInput());

				if (mem.getOperationAtInput().equals("STORE")) {
					inst.writeToMemory(mem.getTargetAddressAtInput(),
							operations.getValueFromRegister(mem
									.getSrc1AtInput()));
				} else if (mem.getOperationAtInput().equals("LOAD")) {
					operations.updateToRegister(mem.getDestAtInput(),
							mem.getTargetDataAtInput());
				}
				// Update WB Input
				wb = new WriteBackStage(mem.getPCAtOutput(),
						mem.getTargetDataAtOutput(),
						mem.getTargetAddressAtOutput(),
						mem.getLiteralAtOutput(), mem.getInstAtOutput(),
						mem.getSrc1AtOutput(), mem.getSrc2AtOutput(),
						mem.getDestAtOutput(), mem.getOperationAtOutput());

				// Update Memory Output
				mem = new MemoryStage(mem.getInstAtInput(),
						mem.getSrc1AtInput(), mem.getSrc2AtInput(),
						mem.getDestAtInput(), mem.getOperationAtInput(),
						mem.getPCAtInput(), mem.getTargetDataAtInput(),
						mem.getTargetAddressAtInput(), mem.getLiteralAtInput());
			}

			/***************************** Write Back **************************/
			System.out.print("Write Back\t::\t");
			if (wbStalled) {
				System.out.println(wb.getInstAtInput());
			} else {
				System.out.println(wb.getInstAtInput());
				// Write to Reg
				operations.updateToRegister(wb.getDestAtInput(),
						wb.getTargetDataAtInput());
				System.out.println("========="+wb.getDestAtInput()+"---"+fetchStalled+"==="+decodeStalled);
				// Update Register validity to true
				updateRegisterValidity(wb.getDestAtInput(), true);

				//Handle BNZ
				switch (wb.getOperationAtInput()) {
				case "ADD":
					if ((decode.getInstAtOutput().equals("ADD"))
							|| (decode.getInstAtOutput().equals("SUB"))
							&& (decode.getInstAtOutput().equals("MUL"))) {

					} else if ((ex.getInstAtOutput().equals("ADD"))
							|| (ex.getInstAtOutput().equals("SUB"))
							&& (ex.getInstAtOutput().equals("MUL"))) {

					}

					else if ((mem.getInstAtOutput().equals("ADD"))
							|| (mem.getInstAtOutput().equals("SUB"))
							&& (mem.getInstAtOutput().equals("MUL"))) {

					} else {
						psw.setPswFree(true);
					}
					break;
				case "SUB":
					if ((decode.getInstAtOutput().equals("ADD"))
							|| (decode.getInstAtOutput().equals("SUB"))
							&& (decode.getInstAtOutput().equals("MUL"))) {

					} else if ((ex.getInstAtOutput().equals("ADD"))
							|| (ex.getInstAtOutput().equals("SUB"))
							&& (ex.getInstAtOutput().equals("MUL"))) {

					}

					else if ((mem.getInstAtOutput().equals("ADD"))
							|| (mem.getInstAtOutput().equals("SUB"))
							&& (mem.getInstAtOutput().equals("MUL"))) {

					} else {
						psw.setPswFree(true);
					}
					break;
				case "MUL":
					if ((decode.getInstAtOutput().equals("ADD"))
							|| (decode.getInstAtOutput().equals("SUB"))
							&& (decode.getInstAtOutput().equals("MUL"))) {

					} else if ((ex.getInstAtOutput().equals("ADD"))
							|| (ex.getInstAtOutput().equals("SUB"))
							&& (ex.getInstAtOutput().equals("MUL"))) {

					}

					else if ((mem.getInstAtOutput().equals("ADD"))
							|| (mem.getInstAtOutput().equals("SUB"))
							&& (mem.getInstAtOutput().equals("MUL"))) {

					} else {
						psw.setPswFree(true);
					}
					break;
				default:
					break;
				}

				//Remove Stall Logic
				switch (decode.getOperationAtOutput()) {
				case "ADD":
					if (checkRegisterValidity(decode.getSrc1AtOutput())
							&& checkRegisterValidity(decode.getSrc2AtOutput())) {
						fetchStalled = false;
						decodeStalled = false;
					}
					break;
				case "SUB":
					if (checkRegisterValidity(decode.getSrc1AtOutput())
							&& checkRegisterValidity(decode.getSrc2AtOutput())) {
						fetchStalled = false;
						decodeStalled = false;
					}
					break;
				case "MUL":
					if (checkRegisterValidity(decode.getSrc1AtOutput())
							&& checkRegisterValidity(decode.getSrc2AtOutput())) {
						fetchStalled = false;
						decodeStalled = false;
					}
					break;
				case "STORE":
					if (checkRegisterValidity(decode.getSrc1AtOutput())
							&& checkRegisterValidity(decode.getSrc2AtOutput())) {
						fetchStalled = false;
						decodeStalled = false;
					}
					break;
				case "LOAD":
					if (!checkRegisterValidity(decode.getSrc1AtOutput())) {
						fetchStalled = false;
						decodeStalled = false;
					}
					break;
				case "JUMP":
					if (checkRegisterValidity(decode.getSrc1AtInput())) {
						fetchStalled = false;
						decodeStalled = false;
					}
				case "BNZ":
					if (psw.isPswFree()) {
						fetchStalled = false;
						decodeStalled = false;
					}/*
					 */
				default:
					break;
				}

				// Update WB Output
				wb = new WriteBackStage(wb.getInstAtInput(),
						wb.getSrc1AtInput(), wb.getSrc2AtInput(),
						wb.getDestAtInput(), wb.getOperationAtInput(),
						wb.getPCAtInput(), wb.getTargetDataAtInput(),
						wb.getTargetAddressAtInput(), wb.getLiteralAtInput());

				// Increment PC value only if there is no stall at any stage
				if ((!(fetchStalled || decodeStalled || executeStalled
						|| memoryStalled || wbStalled))
						|| ex.getInstAtInput().equals("BNZ")
						|| ex.getInstAtInput().equals("BZ")) {
					PC += 4;
				}
			}
			i++;
			
		}

		// System.out.println(R0 + "====" + R3 + "-----" + R6);

	}

	void initialize() {

		// Initialize Input and Output of each stage with default values
		fetch = new FetchStage(0, 0, 0, 0, "", "", "", "", "");
		fetch = new FetchStage("", "", "", "", "", 0, 0, 0, 0);

		decode = new DecodeStage(0, 0, 0, 0, "", "", "", "", "");
		decode = new DecodeStage("", "", "", "", "", 0, 0, 0, 0);

		ex = new ExecuteStage(0, 0, 0, 0, "", "", "", "", "");
		ex = new ExecuteStage("", "", "", "", "", 0, 0, 0, 0);

		mem = new MemoryStage(0, 0, 0, 0, "", "", "", "", "");
		mem = new MemoryStage("", "", "", "", "", 0, 0, 0, 0);

		wb = new WriteBackStage(0, 0, 0, 0, "", "", "", "", "");
		wb = new WriteBackStage("", "", "", "", "", 0, 0, 0, 0);

		// Initialize PSW Flags to false
		psw = new PSW(false, false, false, true);

		// Initialize value of PC
		PC = 4000;

		// Initialize value of each Architectural Register with default value
		R0 = 0;
		R1 = 0;
		R2 = 0;
		R3 = 0;
		R5 = 0;
		R6 = 0;
		R7 = 0;
		R8 = 0;
		R9 = 0;
		R10 = 0;
		R11 = 0;
		R12 = 0;
		R13 = 0;
		R14 = 0;
		R15 = 0;

		// Initialize usability status of each register to true by default
		R0Valid = true;
		R1Valid = true;
		R2Valid = true;
		R3Valid = true;
		R4Valid = true;
		R5Valid = true;
		R6Valid = true;
		R7Valid = true;
		R8Valid = true;
		R9Valid = true;
		R10Valid = true;
		R11Valid = true;
		R12Valid = true;
		R13Valid = true;
		R14Valid = true;
		R15Valid = true;

		// Initialize zero Flag to false by default
		zeroFlag = false;

		// Initialize last arithmetic PC value to 65535 as this value should be
		// larger than the PC of last arithmetic instruction
		lastArithmeticPC = 65536;

	}

	boolean checkRegisterValidity(String registerName) {
		boolean retValue;
		switch (registerName) {
		case "R0":
			retValue = R0Valid;
			break;
		case "R1":
			retValue = R1Valid;
			break;
		case "R2":
			retValue = R2Valid;
			break;
		case "R3":
			retValue = R3Valid;
			break;
		case "R4":
			retValue = R4Valid;
			break;
		case "R5":
			retValue = R5Valid;
			break;
		case "R6":
			retValue = R6Valid;
			break;
		case "R7":
			retValue = R7Valid;
			break;
		case "R8":
			retValue = R8Valid;
			break;
		case "R9":
			retValue = R9Valid;
			break;
		case "R10":
			retValue = R10Valid;
			break;
		case "R11":
			retValue = R11Valid;
			break;
		case "R12":
			retValue = R12Valid;
			break;
		case "R13":
			retValue = R13Valid;
			break;
		case "R14":
			retValue = R14Valid;
			break;
		case "R15":
			retValue = R15Valid;
			break;
		default:
			retValue = true;
		}

		return retValue;
	}

	void updateRegisterValidity(String registerName, boolean status) {

		switch (registerName) {
		case "R0":
			R0Valid = status;
			break;
		case "R1":
			R1Valid = status;
			break;
		case "R2":
			R2Valid = status;
			break;
		case "R3":
			R3Valid = status;
			break;
		case "R4":
			R4Valid = status;
			break;
		case "R5":
			R5Valid = status;
			break;
		case "R6":
			R6Valid = status;
			break;
		case "R7":
			R7Valid = status;
			break;
		case "R8":
			R8Valid = status;
			break;
		case "R9":
			R9Valid = status;
			break;
		case "R10":
			R10Valid = status;
			break;
		case "R11":
			R11Valid = status;
			break;
		case "R12":
			R12Valid = status;
			break;
		case "R13":
			R13Valid = status;
			break;
		case "R14":
			R14Valid = status;
			break;
		case "R15":
			R15Valid = status;
			break;
		default:
			break;
		}
	}

}
