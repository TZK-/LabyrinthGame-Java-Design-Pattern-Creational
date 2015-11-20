package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class LabyrinthReader {

	public static Labyrinth readLabyrinth(Reader reader) throws IOException {
		LabyrinthBuilder labyrinthBuilder = new ConcreteLabyrinthBuilder();

		BufferedReader bufferedReader = new BufferedReader(reader);

		String currentLine;
		StringBuilder lines = new StringBuilder();
		Integer height = 0;
		Integer width = null;
		
		while ((currentLine = bufferedReader.readLine()) != null) {
			height++;
			if (width == null)
				width = currentLine.length();
			lines.append(currentLine);
		}

		bufferedReader.close();
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				
				char currentChar = lines.charAt(row * width + col);
				switch(currentChar){
					case 'X':
						labyrinthBuilder.addForbiddenCellsPositions(new Position(row, col));
						break;
					case 'S':
						labyrinthBuilder.setExitPosition(new Position(row, col));
						break;
					default:
						break;
				}
			}
			
		}
		
		labyrinthBuilder.setHeight(height);
		labyrinthBuilder.setWidth(width);

		return labyrinthBuilder.getLabyrinth();
	}
}
