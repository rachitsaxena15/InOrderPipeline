package resources;

public class PSW {
	
	static boolean carry;
	static boolean negative;
	static boolean zero;
	static boolean pswFree;
	
	public PSW(){
		
	}
	/******************************************************************
	PSW Constructor - Initializes PSW flags to a given value
	@param boolean carry
	@param boolean negative
	@param boolean zero
	@param boolean pswFree
	
	******************************************************************/
	public PSW(boolean carry, boolean negative, boolean zero, boolean pswFree){
		PSW.carry = carry;
		PSW.negative = negative;
		PSW.zero = zero;
		PSW.pswFree = pswFree;
	}
	
	public boolean isCarry() {
		return carry;
	}
	public void setCarry(boolean carry) {
		PSW.carry = carry;
	}
	public boolean isNegative() {
		return negative;
	}
	public void setNegative(boolean negative) {
		PSW.negative = negative;
	}
	public boolean isZero() {
		return zero;
	}
	public void setZero(boolean zero) {
		PSW.zero = zero;
	}
	public boolean isPswFree() {
		return pswFree;
	}
	public void setPswFree(boolean pswFree) {
		PSW.pswFree = pswFree;
	}
	
}
