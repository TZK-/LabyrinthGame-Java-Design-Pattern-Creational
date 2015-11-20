package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LabyrinthReader {

	public static Labyrinth readLabyrinth(Reader reader){
		LabyrinthBuilder labyrinthBuilder = new ConcreteLabyrinthBuilder();
		
		BufferedReader br = new BufferedReader(reader);
		
		String line;
		try {
			while((line = br.readLine()) != null){
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return labyrinthBuilder.getLabyrinth();
	}
}
