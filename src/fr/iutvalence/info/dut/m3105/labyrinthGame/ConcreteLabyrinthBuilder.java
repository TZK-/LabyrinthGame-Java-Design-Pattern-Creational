package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

public class ConcreteLabyrinthBuilder implements LabyrinthBuilder {

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
		if (exitPosition.getX() < 0 || exitPosition.getY() < 0)
			throw new IllegalArgumentException("The exit position must be higher or equal than (0, 0) ");

		this.exitPosition = exitPosition;

		return this;
	}

	@Override
	public LabyrinthBuilder addForbiddenCellsPositions(Position forbiddenCellsPosition) {
		if (exitPosition.getX() < 0 || exitPosition.getY() < 0)
			throw new IllegalArgumentException("The forbidden cell position must be higher or equal than (0, 0) ");
		this.forbiddenCellPositions.add(forbiddenCellsPosition);
		return this;
	}

	public Labyrinth getLabyrinth() {
		for (Position position : this.forbiddenCellPositions)
			if (position.getX() > this.width || position.getY() > this.height)
				throw new IllegalArgumentException("The forbidden cell position must be between (0, 0) and ("
						+ this.width + ", " + this.height + ")");

		if (exitPosition.getX() > this.width || exitPosition.getY() > this.height)
			throw new IllegalArgumentException("The exit position must be  between (0, 0) and (" + this.width + ", "
					+ this.height + ")");

		return new Labyrinth(this.width, this.height, this.forbiddenCellPositions, this.exitPosition);
	}
}
