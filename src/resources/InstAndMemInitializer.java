package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class InstructionHandler {

	static HashMap<Integer, String> hm;
	static HashMap<Integer, Integer> memory;
	
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

	public void initializeMemory(){
		memory = new HashMap<>();
		int i=0;
		while(i<4000){
			memory.put(i, 0);
			i+=4;
		}
	}
	
	public void writeToMemory(int address, int value){
		memory.put(address, value);
	}
	
	public int readFromMemory(int address){
		return memory.get(address);
	}
	
	public String getInstruction(int pointer){
		return hm.get(pointer);
	}
}
