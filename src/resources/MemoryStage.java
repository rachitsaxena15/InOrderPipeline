package resources;

public class MemoryStage {

	
	static int PCAtInput;
	static int targetDataAtInput;
	static int targetAddressAtInput;
	static int	literalAtInput;
	static String instAtInput;
	static String src1AtInput;
	static String src2AtInput;
	static String destAtInput;
	static String OperationAtInput;

	static int PCAtOutput;
	static int targetDataAtOutput;
	static int targetAddressAtOutput;
	static int	literalAtOutput;
	static String instAtOutput;
	static String src1AtOutput;
	static String src2AtOutput;
	static String destAtOutput;
	static String OperationAtOutput;

	public MemoryStage(){
		
	}
	
	//Memory Input
	/******************************************************************
	Memory Input - Sets Input values of MEMORY stage
	@param	int PCAtOutput
	@param	int targetDataAtOutput
	@param	int targetAddressAtOutput
	@param	int literalAtOutput
	@param	String instAtOutput
	@param	String src1AtOutput
	@param	String src2AtOutput 
	@param	String destAtOutput
	@param	String OperationAtOutput
	@return void
	******************************************************************/
	public MemoryStage(int PCAtInput, int targetDataAtInput, int targetAddressAtInput, int literalAtInput, String instAtInput, String src1AtInput, String src2AtInput, String destAtInput, String OperationAtInput){
		MemoryStage.PCAtInput = PCAtInput;
		MemoryStage.targetDataAtInput = targetDataAtInput;
		MemoryStage.targetAddressAtInput = targetAddressAtInput;
		MemoryStage.literalAtInput = literalAtInput;
		MemoryStage.instAtInput = instAtInput;
		MemoryStage.src1AtInput = src1AtInput;
		MemoryStage.src2AtInput = src2AtInput;
		MemoryStage.destAtInput = destAtInput;
		MemoryStage.OperationAtInput = OperationAtInput;
	}

	//Memory Output
	/******************************************************************
	Memory Output - Sets Output values of Memory stage
	@param	String instAtOutput
	@param	String src1AtOutput
	@param	String src2AtOutput 
	@param	String destAtOutput
	@param	String OperationAtOutput
	@param	int PCAtOutput
	@param	int targetDataAtOutput
	@param	int targetAddressAtOutput
	@param	int literalAtOutput
	@return void
	******************************************************************/
	public MemoryStage(String instAtOutput, String src1AtOutput, String src2AtOutput, String destAtOutput, String OperationAtOutput, int PCAtOutput, int targetDataAtOutput, int targetAddressAtOutput, int literalAtOutput){
		MemoryStage.instAtOutput = instAtOutput;
		MemoryStage.src1AtOutput = src1AtOutput;
		MemoryStage.src2AtOutput = src2AtOutput;
		MemoryStage.destAtOutput = destAtOutput;
		MemoryStage.OperationAtOutput = OperationAtOutput;	
		MemoryStage.PCAtOutput = PCAtOutput;
		MemoryStage.targetDataAtOutput = targetDataAtOutput;
		MemoryStage.targetAddressAtOutput = targetAddressAtOutput;
		MemoryStage.literalAtOutput = literalAtOutput;
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
		MemoryStage.targetDataAtInput = targetDataAtInput;
	}
	public int getTargetAddressAtInput() {
		return targetAddressAtInput;
	}
	public void setTargetAddressAtInput(int targetAddressAtInput) {
		MemoryStage.targetAddressAtInput = targetAddressAtInput;
	}
	public int getLiteralAtInput() {
		return literalAtInput;
	}
	public void setLiteralAtInput(int literalAtInput) {
		MemoryStage.literalAtInput = literalAtInput;
	}
	public String getInstAtInput() {
		return instAtInput;
	}
	public void setInstAtInput(String instAtInput) {
		MemoryStage.instAtInput = instAtInput;
	}
	public String getSrc1AtInput() {
		return src1AtInput;
	}
	public void setSrc1AtInput(String src1AtInput) {
		MemoryStage.src1AtInput = src1AtInput;
	}
	public String getSrc2AtInput() {
		return src2AtInput;
	}
	public void setSrc2AtInput(String src2AtInput) {
		MemoryStage.src2AtInput = src2AtInput;
	}
	public String getDestAtInput() {
		return destAtInput;
	}
	public void setDestAtInput(String destAtInput) {
		MemoryStage.destAtInput = destAtInput;
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
		MemoryStage.targetDataAtOutput = targetDataAtOutput;
	}
	public int getTargetAddressAtOutput() {
		return targetAddressAtOutput;
	}
	public void setTargetAddressAtOutput(int targetAddressAtOutput) {
		MemoryStage.targetAddressAtOutput = targetAddressAtOutput;
	}
	public int getLiteralAtOutput() {
		return literalAtOutput;
	}
	public void setLiteralAtOutput(int literalAtOutput) {
		MemoryStage.literalAtOutput = literalAtOutput;
	}
	public String getInstAtOutput() {
		return instAtOutput;
	}
	public void setInstAtOutput(String instAtOutput) {
		MemoryStage.instAtOutput = instAtOutput;
	}
	public String getSrc1AtOutput() {
		return src1AtOutput;
	}
	public void setSrc1AtOutput(String src1AtOutput) {
		MemoryStage.src1AtOutput = src1AtOutput;
	}
	public String getSrc2AtOutput() {
		return src2AtOutput;
	}
	public void setSrc2AtOutput(String src2AtOutput) {
		MemoryStage.src2AtOutput = src2AtOutput;
	}
	public String getDestAtOutput() {
		return destAtOutput;
	}
	public void setDestAtOutput(String destAtOutput) {
		MemoryStage.destAtOutput = destAtOutput;
	}
	public String getOperationAtOutput() {
		return OperationAtOutput;
	}
	public void setOperationAtOutput(String operationAtOutput) {
		OperationAtOutput = operationAtOutput;
	}
	
}
