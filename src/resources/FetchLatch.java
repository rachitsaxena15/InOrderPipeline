package resources;

public class FetchLatch {

	static int PCAtInput;
	static int targetDataAtInput;
	static int targetAddressAtInput;
	static int literalAtInput;
	static String instAtInput;
	static String src1AtInput;
	static String src2AtInput;
	static String destAtInput;
	static String OperationAtInput;

	static int PCAtOutput;
	static int targetDataAtOutput;
	static int targetAddressAtOutput;
	static int literalAtOutput;
	static String instAtOutput;
	static String src1AtOutput;
	static String src2AtOutput;
	static String destAtOutput;
	static String OperationAtOutput;

	static boolean stall;

	public FetchLatch() {

	}

	// Update Fetch Input
	/******************************************************************
	 * Fetch Input - Sets Input values of Fetch Stage
	 * 
	 * @param int PCAtOutput
	 * @param int targetDataAtOutput
	 * @param int targetAddressAtOutput
	 * @param int literalAtOutput
	 * @param String
	 *            instAtOutput
	 * @param String
	 *            src1AtOutput
	 * @param String
	 *            src2AtOutput
	 * @param String
	 *            destAtOutput
	 * @param String
	 *            OperationAtOutput
	 * @return void
	 ******************************************************************/
	public FetchLatch(int PCAtInput, int targetDataAtInput,
			int targetAddressAtInput, int literalAtInput, String instAtInput,
			String src1AtInput, String src2AtInput, String destAtInput,
			String OperationAtInput) {
		FetchLatch.PCAtInput = PCAtInput;
		FetchLatch.targetDataAtInput = targetDataAtInput;
		FetchLatch.targetAddressAtInput = targetAddressAtInput;
		FetchLatch.literalAtInput = literalAtInput;
		FetchLatch.instAtInput = instAtInput;
		FetchLatch.src1AtInput = src1AtInput;
		FetchLatch.src2AtInput = src2AtInput;
		FetchLatch.destAtInput = destAtInput;
		FetchLatch.OperationAtInput = OperationAtInput;
	}

	/******************************************************************
	 * Fetch Output - Sets Output values of Fetch Stage
	 * 
	 * @param String
	 *            instAtOutput
	 * @param String
	 *            src1AtOutput
	 * @param String
	 *            src2AtOutput
	 * @param String
	 *            destAtOutput
	 * @param String
	 *            OperationAtOutput
	 * @param int PCAtOutput
	 * @param int targetDataAtOutput
	 * @param int targetAddressAtOutput
	 * @param int literalAtOutput
	 * @return void
	 ******************************************************************/
	public FetchLatch(String instAtOutput, String src1AtOutput,
			String src2AtOutput, String destAtOutput, String OperationAtOutput,
			int PCAtOutput, int targetDataAtOutput, int targetAddressAtOutput,
			int literalAtOutput) {
		FetchLatch.instAtOutput = instAtOutput;
		FetchLatch.src1AtOutput = src1AtOutput;
		FetchLatch.src2AtOutput = src2AtOutput;
		FetchLatch.destAtOutput = destAtOutput;
		FetchLatch.OperationAtOutput = OperationAtOutput;
		FetchLatch.PCAtOutput = PCAtOutput;
		FetchLatch.targetDataAtOutput = targetDataAtOutput;
		FetchLatch.targetAddressAtOutput = targetAddressAtOutput;
		FetchLatch.literalAtOutput = literalAtOutput;
	}

	public boolean isStall() {
		return stall;
	}

	public void setStall(boolean stall) {
		FetchLatch.stall = stall;
	}

	public int getPCAtInput() {
		return PCAtInput;
	}

	public void setPCAtInput(int pCAtInput) {
		PCAtInput = pCAtInput;
	}

	public int getTargetDataAtInput() {
		return targetDataAtInput;
	}

	public void setTargetDataAtInput(int targetDataAtInput) {
		FetchLatch.targetDataAtInput = targetDataAtInput;
	}

	public int getTargetAddressAtInput() {
		return targetAddressAtInput;
	}

	public void setTargetAddressAtInput(int targetAddressAtInput) {
		FetchLatch.targetAddressAtInput = targetAddressAtInput;
	}

	public int getLiteralAtInput() {
		return literalAtInput;
	}

	public void setLiteralAtInput(int literalAtInput) {
		FetchLatch.literalAtInput = literalAtInput;
	}

	public String getInstAtInput() {
		return instAtInput;
	}

	public void setInstAtInput(String instAtInput) {
		FetchLatch.instAtInput = instAtInput;
	}

	public String getSrc1AtInput() {
		return src1AtInput;
	}

	public void setSrc1AtInput(String src1AtInput) {
		FetchLatch.src1AtInput = src1AtInput;
	}

	public String getSrc2AtInput() {
		return src2AtInput;
	}

	public void setSrc2AtInput(String src2AtInput) {
		FetchLatch.src2AtInput = src2AtInput;
	}

	public String getDestAtInput() {
		return destAtInput;
	}

	public void setDestAtInput(String destAtInput) {
		FetchLatch.destAtInput = destAtInput;
	}

	public String getOperationAtInput() {
		return OperationAtInput;
	}

	public void setOperationAtInput(String operationAtInput) {
		OperationAtInput = operationAtInput;
	}

	public int getPCAtOutput() {
		return PCAtOutput;
	}

	public void setPCAtOutput(int pCAtOutput) {
		PCAtOutput = pCAtOutput;
	}

	public int getTargetDataAtOutput() {
		return targetDataAtOutput;
	}

	public void setTargetDataAtOutput(int targetDataAtOutput) {
		FetchLatch.targetDataAtOutput = targetDataAtOutput;
	}

	public int getTargetAddressAtOutput() {
		return targetAddressAtOutput;
	}

	public void setTargetAddressAtOutput(int targetAddressAtOutput) {
		FetchLatch.targetAddressAtOutput = targetAddressAtOutput;
	}

	public int getLiteralAtOutput() {
		return literalAtOutput;
	}

	public void setLiteralAtOutput(int literalAtOutput) {
		FetchLatch.literalAtOutput = literalAtOutput;
	}

	public String getInstAtOutput() {
		return instAtOutput;
	}

	public void setInstAtOutput(String instAtOutput) {
		FetchLatch.instAtOutput = instAtOutput;
	}

	public String getSrc1AtOutput() {
		return src1AtOutput;
	}

	public void setSrc1AtOutput(String src1AtOutput) {
		FetchLatch.src1AtOutput = src1AtOutput;
	}

	public String getSrc2AtOutput() {
		return src2AtOutput;
	}

	public void setSrc2AtOutput(String src2AtOutput) {
		FetchLatch.src2AtOutput = src2AtOutput;
	}

	public String getDestAtOutput() {
		return destAtOutput;
	}

	public void setDestAtOutput(String destAtOutput) {
		FetchLatch.destAtOutput = destAtOutput;
	}

	public String getOperationAtOutput() {
		return OperationAtOutput;
	}

	public void setOperationAtOutput(String operationAtOutput) {
		OperationAtOutput = operationAtOutput;
	}

}
