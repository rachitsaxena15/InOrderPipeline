package resources;

import operations.ArithmeticOperations;
import core.ConfigDetails;

public class PipeLineStages extends ConfigDetails {

	InstructionHandler inst;
	FetchStage fetch;
	DecodeStage decode;
	ExecuteStage ex;
	MemoryStage mem;
	WriteBackStage wb;
	ArithmeticOperations operations;

	public void pipeline() {
		initialize();
		operations = new ArithmeticOperations();
		int i = 0;
		while (i <= 9) {
			System.out.println("--------------------I" + i + "------------------");

			/*****************************Fetch **************************/
			if (fetchStalled) {
				System.out.println("Fetch : Stall Instruction : " + fetch.getInstAtInput());
			} else {
				inst = new InstructionHandler();
				fetch.setPCAtInput(PC);
				if (inst.getInstruction(PC) == null) {
					fetch.setInstAtInput("");
					System.out.println("Fetch : " + fetch.getInstAtInput());

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
					System.out.println("Fetch : " + fetch.getInstAtInput());

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
			}

			/***************************** Decode **************************/
			String instArr[];
			if (decodeStalled) {
				System.out.println("Decode : Stall Instruction :" + decode.getInstAtInput());
			} else {
				System.out.println("Decode : " + decode.getInstAtInput());
				if (!decode.getInstAtInput().equals("")) {
					instArr = decode.getInstAtInput().split(",");
					// instType = instArr[0];

					switch (decode.getInstAtInput().split(",")[0].trim()) {

					case "ADD":
						decode.setOperationAtInput(instArr[0]);
						decode.setDestAtInput(instArr[1]);
						decode.setSrc1AtInput(instArr[2]);
						decode.setSrc2AtInput(instArr[3]);
						break;
					case "MOVC":
						decode.setOperationAtInput(instArr[0]);
						decode.setDestAtInput(instArr[1]);
						decode.setSrc1AtInput(instArr[2]);
						decode.setSrc2AtInput("");
						break;
					default:
						break;
					}
				}

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
			if (executeStalled) {
				System.out.println("Execute : " + ex.getInstAtInput());
			} else {
				System.out.println("Execute : " + ex.getInstAtInput());
				updateRegisterValidity(ex.getDestAtInput(), false);

				if (ex.getOperationAtInput().equals("ADD")) {
					ex.setTargetDataAtInput(operations.add(ex.getSrc1AtInput(),
							ex.getSrc2AtInput()));
				} else if (ex.getOperationAtInput().equals("MOVC")) {
					ex.setTargetDataAtInput(operations.move(ex.getSrc1AtInput()));
				}

				// Stalling Logic
				if (!(checkRegisterValidity(decode.getSrc1AtOutput()) && checkRegisterValidity(decode
						.getSrc2AtOutput()))) {
					fetchStalled = true;
					decodeStalled = true;
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
			if (memoryStalled) {
				System.out.println("Memory = " + mem.getInstAtInput());
			} else {
				System.out.println("Memory = " + mem.getInstAtInput());
				// ToDo - memory task

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

			/***************************** Write Back**************************/
			if (wbStalled) {
				System.out.println("WriteBack = " + wb.getInstAtInput());
			} else {
				System.out.println("WriteBack = " + wb.getInstAtInput());
				operations.updateToRegister(wb.getDestAtInput(),
						wb.getTargetDataAtInput());
				// register ka status true kardo
				updateRegisterValidity(wb.getDestAtInput(), true);

				if (checkRegisterValidity(decode.getSrc1AtOutput())
						&& checkRegisterValidity(decode.getSrc2AtOutput())) {
					fetchStalled = false;
					decodeStalled = false;
				}

				// Update WB Output
				wb = new WriteBackStage(wb.getInstAtInput(),
						wb.getSrc1AtInput(), wb.getSrc2AtInput(),
						wb.getDestAtInput(), wb.getOperationAtInput(),
						wb.getPCAtInput(), wb.getTargetDataAtInput(),
						wb.getTargetAddressAtInput(), wb.getLiteralAtInput());
				if (!(fetchStalled || decodeStalled || executeStalled
						|| memoryStalled || wbStalled)) {
					PC += 4;
				}
			}
			i++;
		}

		System.out.println(R0 + "====" + R3 + "-----" + R6);

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
			R1Valid = false;
			break;
		case "R2":
			R2Valid = false;
			break;
		case "R3":
			R3Valid = false;
			break;
		case "R4":
			R4Valid = false;
			break;
		case "R5":
			R5Valid = false;
			break;
		case "R6":
			R6Valid = false;
			break;
		case "R7":
			R7Valid = false;
			break;
		case "R8":
			R8Valid = false;
			break;
		case "R9":
			R9Valid = false;
			break;
		case "R10":
			R10Valid = false;
			break;
		case "R11":
			R11Valid = false;
			break;
		case "R12":
			R12Valid = false;
			break;
		case "R13":
			R13Valid = false;
			break;
		case "R14":
			R14Valid = false;
			break;
		case "R15":
			R15Valid = false;
			break;
		default:
			break;
		}
	}

}
