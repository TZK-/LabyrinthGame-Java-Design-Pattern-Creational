package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

public class ConcreteLabyrinthBuilder implements LabyrinthBuilder {

	/**
	 * The lowest possible position. The position (0, 0) is not valid because it
	 * is the starting position, so it must start at (0, 1)
	 */
	private final static Position LOWEST_POSSIBLE_POSITION = new Position(0, 1);

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
		if (exitPosition == null)
			throw new NullPointerException("The exitPosition is null");

		this.exitPosition = exitPosition;

		return this;
	}

	@Override
	public LabyrinthBuilder addForbiddenCellsPositions(Position forbiddenCellsPosition) {
		this.forbiddenCellPositions.add(forbiddenCellsPosition);
		return this;
	}

	public Labyrinth getLabyrinth() {
		Position pos = new Position(height - 1, width - 1);

		for (Position position : this.forbiddenCellPositions) {
			if (!this.isPositionValid(position))
				throw new IllegalArgumentException(
						"The forbidden cell position must be between " + LOWEST_POSSIBLE_POSITION + " and " + pos);
		}
		if (!this.isPositionValid(this.exitPosition))
			throw new IllegalArgumentException(
					"The exit position must be  between (0, 0) and " + LOWEST_POSSIBLE_POSITION + " and " + pos);

		return new Labyrinth(this.width, this.height, this.forbiddenCellPositions, this.exitPosition);
	}

	private boolean isPositionValid(Position pos) {

		if (pos.getX() < 0 || pos.getY() < 0)
			return false;

		if (pos.getX() == 0 && pos.getY() == 0)
			return false;

		if (pos.getX() >= this.height || pos.getY() >= this.width)
			return false;

		return true;
	}
}
