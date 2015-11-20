package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

public class ConcreteLabyrinthBuilder implements LabyrinthBuilder {

	private final static Position LOWEST_POSITION_POSSIBLE = new Position(0, 0);

	private int width;

	private int height;

	private Position exitPosition;

	private Set<Position> forbiddenCellPositions;

	public ConcreteLabyrinthBuilder() {
		this.forbiddenCellPositions = new HashSet<>();
		this.width = 0;
		this.height = 0;
		this.exitPosition = null;
	}

	@Override
	public LabyrinthBuilder setHeight(int height) {
		if (height <= 0)
			throw new IllegalArgumentException("The height must be higher than zero");
		this.height = height;
		return this;
	}

	@Override
	public LabyrinthBuilder setWidth(int width) {
		if (width <= 0)
			throw new IllegalArgumentException("The width must be higher than zero");
		
		this.width = width;
		return this;
	}

	@Override
	public LabyrinthBuilder setExitPosition(Position exitPosition) {
		if(exitPosition == null)
			throw new NullPointerException("The exit position is not set");
		
		if(exitPosition.getX() <= 0 || exitPosition.getY() <= 0)
			throw new IllegalArgumentException(
					"The exit position must be higher than " + LOWEST_POSITION_POSSIBLE);
		
		this.exitPosition = exitPosition;
		return this;
	}

	@Override
	public LabyrinthBuilder addForbiddenCellsPositions(Position forbiddenCellsPosition) {
		if (forbiddenCellsPosition.getX() < 0 || forbiddenCellsPosition.getY() < 0)
			throw new IllegalArgumentException(
					"The forbidden cell position must be higher or equal than " + LOWEST_POSITION_POSSIBLE);
		this.forbiddenCellPositions.add(forbiddenCellsPosition);
		return this;
	}

	public Labyrinth getLabyrinth() {
		Position pos = new Position(this.height, this.width);
		
		for (Position position : this.forbiddenCellPositions) {
			if (position.getY() > this.width - 1 || position.getX() > this.height - 1)
				throw new IllegalArgumentException(
						"The forbidden cell position must be between " + LOWEST_POSITION_POSSIBLE + " and" + pos);
		}

		if (this.exitPosition.getY() > this.width - 1 || this.exitPosition.getX() > this.height - 1)
			throw new IllegalArgumentException(
					"The exit position must be  between " + LOWEST_POSITION_POSSIBLE + " and " + pos);

		return new Labyrinth(this.width, this.height, this.forbiddenCellPositions, this.exitPosition);
	}
}
