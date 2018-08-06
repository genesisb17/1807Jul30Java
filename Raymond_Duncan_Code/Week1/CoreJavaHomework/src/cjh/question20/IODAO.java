package cjh.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IODAO {

	void serializeObject(Object obj) {
		//TODO: Implement serialize function
		return;
	}
	
	List<Personnage> readPersonnages() {
		ArrayList<Personnage> personnages = new ArrayList<Personnage>();
		try(BufferedReader br = new BufferedReader(new FileReader("src/files/Data.txt"))){
			String line = null;
			while((line = br.readLine()) != null) {
				String[] personnageInfo = line.split(":");
				Personnage p = new Personnage();
				p.setFirstName(personnageInfo[0]);
				p.setLastName(personnageInfo[1]);
				p.setAge(Integer.parseInt(personnageInfo[2]));
				p.setHomeState(personnageInfo[3
				                              ]);
				personnages.add(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personnages;
	}
}
