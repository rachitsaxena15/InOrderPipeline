package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class InstructionHandler {

	static HashMap<Integer, String> hm;

	public void SetInstructionQueue(String fileLocation){
		File file = new File(fileLocation);
		int j=4000;

		hm = new HashMap<Integer, String>();
		if (file.exists()) {
			int baseValue=4000;
			BufferedReader br = null;
			String text = null;
			try{
				br = new BufferedReader(new FileReader(file));
				while ((text = br.readLine()) != null) {
					hm.put(baseValue, text.trim());
					baseValue+=4;
				}
				br.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else
			System.out.println("Instruction File not found");
		/*for(int key : hm.keySet()){
			System.out.println(key+"="+hm.get(key));			
		}*/

		for(int i=0;i<hm.keySet().size();i++){
			System.out.println(j + "=" + hm.get(j));
			j+=4;
		}
	}

	public String getInstruction(int pointer){
		return hm.get(pointer);
	}
	
	public void add(int src1, int src2, int dest){
		
	}
	
	public void store() {
		// TODO Auto-generated method stub

	}
	
	public void load() {
		// TODO Auto-generated method stub

	}
	
	public void multiply() {
		// TODO Auto-generated method stub

	}
	
	public void movc() {
		// TODO Auto-generated method stub

	}
	
	public void sub() {
		// TODO Auto-generated method stub

	}
	
	public void bz() {
		// TODO Auto-generated method stub

	}
	
	public void bnz() {
		// TODO Auto-generated method stub

	}

}
