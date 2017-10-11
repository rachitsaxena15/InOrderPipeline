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
		int i=0;
		while(i<=15){
			System.out.println("--------------------I"+i+"--------------");

			// Fetch
			if (fetchStalled) {
				return;
			} else {
				inst = new InstructionHandler();
				fetch.setPCAtInput(PC);
				if(inst.getInstruction(PC)==null){
					fetch.setInstAtInput("");
					System.out.println("Fetch : "+fetch.getInstAtInput());
					
					// Update Decode Input
					decode = new DecodeStage(fetch.getPCAtOutput(),
							fetch.getTargetDataAtOutput(),
							fetch.getTargetAddressAtOutput(),
							fetch.getLiteralAtOutput(), fetch.getInstAtOutput(),
							fetch.getSrc1AtOutput(), fetch.getSrc2AtOutput(),
							fetch.getDestAtOutput(), fetch.getOperationAtOutput());

					// Update Fetch Output
					fetch = new FetchStage("", "", "", "", "", PC, 0, 0, 0);
				}
				else{
					fetch.setInstAtInput(inst.getInstruction(PC));
					System.out.println("Fetch : "+fetch.getInstAtInput());

					// Update Decode Input
					decode = new DecodeStage(fetch.getPCAtOutput(),
							fetch.getTargetDataAtOutput(),
							fetch.getTargetAddressAtOutput(),
							fetch.getLiteralAtOutput(), fetch.getInstAtOutput(),
							fetch.getSrc1AtOutput(), fetch.getSrc2AtOutput(),
							fetch.getDestAtOutput(), fetch.getOperationAtOutput());

					// Update Fetch Output
					fetch = new FetchStage(fetch.getInstAtInput(),
							fetch.getSrc1AtInput(), fetch.getSrc2AtInput(),
							fetch.getDestAtInput(), fetch.getOperationAtInput(),
							fetch.getPCAtInput(), fetch.getTargetDataAtInput(),
							fetch.getTargetAddressAtInput(), fetch.getLiteralAtInput());

				}

				// Decode
				String instArr[];
				if (decodeStalled) {
					return;
				} else {
					System.out.println("Decode : " + decode.getInstAtInput());
					if (!decode.getInstAtInput().equals("")) {
						instArr = decode.getInstAtInput().split(",");
						// instType = instArr[0];

						switch (decode.getInstAtInput().split(",")[0]) {

						case "ADD":
							decode.setOperationAtInput(instArr[0]);
							//decode.setInstAtInput(instArr[1]);
							decode.setSrc1AtInput(instArr[2]);
							decode.setSrc2AtInput(instArr[3]);
							break;
						case "MOVC":
							//decode.setInstAtInput(instArr[1]);
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

				// Execute
				if (executeStalled) {
					return;
				} else {
					System.out.println("Execute : " + ex.getInstAtInput());
					if (ex.getOperationAtInput().equals("ADD")) {
						ex.setTargetDataAtInput(operations.add(ex.getSrc1AtInput(),
								ex.getSrc2AtInput()));
					} else if (ex.getOperationAtInput().equals("MOVC")) {
						ex.setTargetDataAtInput(operations.move(ex.getSrc1AtInput()));
					}

					// Update memory Input
					mem = new MemoryStage(ex.getPCAtOutput(),
							ex.getTargetDataAtOutput(), ex.getTargetAddressAtOutput(),
							ex.getLiteralAtOutput(), ex.getInstAtOutput(),
							ex.getSrc1AtOutput(), ex.getSrc2AtOutput(),
							ex.getDestAtOutput(), ex.getOperationAtOutput());
					// Update Execute Output
					ex = new ExecuteStage(ex.getInstAtInput(), ex.getSrc1AtInput(),
							ex.getSrc2AtInput(), ex.getDestAtInput(),
							ex.getOperationAtInput(), ex.getPCAtInput(),
							ex.getTargetDataAtInput(), ex.getTargetAddressAtInput(),
							ex.getLiteralAtInput());
				}

				// Memory
				if (memoryStalled) {
					return;
				} else {
					System.out.println("Memory = " + mem.getInstAtInput());
					// ToDo - memory task

					// Update WB Input
					wb = new WriteBackStage(mem.getPCAtOutput(),
							mem.getTargetDataAtOutput(),
							mem.getTargetAddressAtOutput(), mem.getLiteralAtOutput(),
							mem.getInstAtOutput(), mem.getSrc1AtOutput(),
							mem.getSrc2AtOutput(), mem.getDestAtOutput(),
							mem.getOperationAtOutput());

					// Update Memory Output
					mem = new MemoryStage(mem.getInstAtInput(), mem.getSrc1AtInput(),
							mem.getSrc2AtInput(), mem.getDestAtInput(),
							mem.getOperationAtInput(), mem.getPCAtInput(),
							mem.getTargetDataAtInput(), mem.getTargetAddressAtInput(),
							mem.getLiteralAtInput());
				}

				// WriteBack
				if (wbStalled) {
					return;
				} else {
					System.out.println("WriteBack = " + wb.getInstAtInput());
					operations.updateToRegister(wb.getDestAtInput(),
							wb.getTargetDataAtInput());
					
					//register ka status true kardo

					// Update WB Output
					wb = new WriteBackStage(wb.getInstAtInput(), wb.getSrc1AtInput(),
							wb.getSrc2AtInput(), wb.getDestAtInput(),
							wb.getOperationAtInput(), wb.getPCAtInput(),
							wb.getTargetDataAtInput(), wb.getTargetAddressAtInput(),
							wb.getLiteralAtInput());
					if(!(fetchStalled||decodeStalled||executeStalled||memoryStalled||wbStalled)){
						PC+=4;
					}
				}

				i++;
			}
		}

	}

	void initialize() {
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
	}

}
