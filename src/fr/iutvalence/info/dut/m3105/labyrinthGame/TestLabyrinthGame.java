package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Test application for labyrinth game
 * 
 */
public class TestLabyrinthGame {
	
	public final static File LABYRINTH_FILE = new File("labyrinth1.txt");
	
	/**
	 * Application's main
	 * 
	 * @param args
	 *            command-line arguments (none expected here)
	 */
	public static void main(String[] args) {
		/*
			Set<Position> blockPositions = new HashSet<Position>();
			blockPositions.add(new Position(2, 0));
			blockPositions.add(new Position(3, 0));
			blockPositions.add(new Position(0, 1));
			blockPositions.add(new Position(0, 2));
			blockPositions.add(new Position(1, 2));
			blockPositions.add(new Position(3, 2));
			blockPositions.add(new Position(3, 3));
		
			LabyrinthBuilder labyrinthBuilder = new ConcreteLabyrinthBuilder().setHeight(4).setWidth(4)
					.setExitPosition(new Position(3, 1));
	
			for (Position position : blockPositions) {
				labyrinthBuilder.addForbiddenCellsPositions(position);
			}
		*/
		
		Reader reader;
		try {
			reader = new FileReader(LABYRINTH_FILE);
			new LabyrinthGame(LabyrinthReader.readLabyrinth(reader), RobotArtificialIntelligence.createRobot(args[0])).play();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
