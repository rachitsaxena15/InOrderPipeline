package resources;


public class DecodeLatch{


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

	public DecodeLatch(){
		
	}

	//Decode Input
	/******************************************************************
	Decode Input - Sets Input values of DECODE stage
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
	public DecodeLatch(int PCAtInput, int targetDataAtInput, int targetAddressAtInput, int literalAtInput, String instAtInput, String src1AtInput, String src2AtInput, String destAtInput, String OperationAtInput){
		DecodeLatch.PCAtInput = PCAtInput;
		DecodeLatch.targetDataAtInput = targetDataAtInput;
		DecodeLatch.targetAddressAtInput = targetAddressAtInput;
		DecodeLatch.literalAtInput = literalAtInput;
		DecodeLatch.instAtInput = instAtInput;
		DecodeLatch.src1AtInput = src1AtInput;
		DecodeLatch.src2AtInput = src2AtInput;
		DecodeLatch.destAtInput = destAtInput;
		DecodeLatch.OperationAtInput = OperationAtInput;
	}

	//Decode Output
	/******************************************************************
	Decode Output - Sets Output values of DECODE stage
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
	public DecodeLatch(String instAtOutput, String src1AtOutput, String src2AtOutput, String destAtOutput, String OperationAtOutput, int PCAtOutput, int targetDataAtOutput, int targetAddressAtOutput, int literalAtOutput){
		DecodeLatch.instAtOutput = instAtOutput;
		DecodeLatch.src1AtOutput = src1AtOutput;
		DecodeLatch.src2AtOutput = src2AtOutput;
		DecodeLatch.destAtOutput = destAtOutput;
		DecodeLatch.OperationAtOutput = OperationAtOutput;	
		DecodeLatch.PCAtOutput = PCAtOutput;
		DecodeLatch.targetDataAtOutput = targetDataAtOutput;
		DecodeLatch.targetAddressAtOutput = targetAddressAtOutput;
		DecodeLatch.literalAtOutput = literalAtOutput;
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
		DecodeLatch.targetDataAtInput = targetDataAtInput;
	}
	public int getTargetAddressAtInput() {
		return targetAddressAtInput;
	}
	public void setTargetAddressAtInput(int targetAddressAtInput) {
		DecodeLatch.targetAddressAtInput = targetAddressAtInput;
	}
	public int getLiteralAtInput() {
		return literalAtInput;
	}
	public void setLiteralAtInput(int literalAtInput) {
		DecodeLatch.literalAtInput = literalAtInput;
	}
	public String getInstAtInput() {
		return instAtInput;
	}
	public void setInstAtInput(String instAtInput) {
		DecodeLatch.instAtInput = instAtInput;
	}
	public String getSrc1AtInput() {
		return src1AtInput;
	}
	public void setSrc1AtInput(String src1AtInput) {
		DecodeLatch.src1AtInput = src1AtInput;
	}
	public String getSrc2AtInput() {
		return src2AtInput;
	}
	public void setSrc2AtInput(String src2AtInput) {
		DecodeLatch.src2AtInput = src2AtInput;
	}
	public String getDestAtInput() {
		return destAtInput;
	}
	public void setDestAtInput(String destAtInput) {
		DecodeLatch.destAtInput = destAtInput;
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
		DecodeLatch.targetDataAtOutput = targetDataAtOutput;
	}
	public int getTargetAddressAtOutput() {
		return targetAddressAtOutput;
	}
	public void setTargetAddressAtOutput(int targetAddressAtOutput) {
		DecodeLatch.targetAddressAtOutput = targetAddressAtOutput;
	}
	public int getLiteralAtOutput() {
		return literalAtOutput;
	}
	public void setLiteralAtOutput(int literalAtOutput) {
		DecodeLatch.literalAtOutput = literalAtOutput;
	}
	public String getInstAtOutput() {
		return instAtOutput;
	}
	public void setInstAtOutput(String instAtOutput) {
		DecodeLatch.instAtOutput = instAtOutput;
	}
	public String getSrc1AtOutput() {
		return src1AtOutput;
	}
	public void setSrc1AtOutput(String src1AtOutput) {
		DecodeLatch.src1AtOutput = src1AtOutput;
	}
	public String getSrc2AtOutput() {
		return src2AtOutput;
	}
	public void setSrc2AtOutput(String src2AtOutput) {
		DecodeLatch.src2AtOutput = src2AtOutput;
	}
	public String getDestAtOutput() {
		return destAtOutput;
	}
	public void setDestAtOutput(String destAtOutput) {
		DecodeLatch.destAtOutput = destAtOutput;
	}
	public String getOperationAtOutput() {
		return OperationAtOutput;
	}
	public void setOperationAtOutput(String operationAtOutput) {
		OperationAtOutput = operationAtOutput;
	}
}
