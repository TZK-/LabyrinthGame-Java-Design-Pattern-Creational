package fr.iutvalence.info.dut.m3105.labyrinthGame;

public interface LabyrinthBuilder {

	public LabyrinthBuilder setHeight(int height);

	public LabyrinthBuilder setWidth(int width);

	public LabyrinthBuilder setExitPosition(Position exitPosition);

	public LabyrinthBuilder addForbiddenCellsPositions(Position forbiddenCellsPosition);

	public Labyrinth getLabyrinth();

}
