package lib;

import java.util.HashSet;
import java.util.Set;

/**
 * A game of life is defined by these rules:
 * 
 * When there are no live cells, on the next turn there will be no live cells.
 * When a live cell has fewer than two neighbours, the cell will die.
 * when a live cell has more than three neighbours, the cell will die.
 * When a live cell has two or three neighbours, the cell will survive.
 * When an empty/dead cell has three neighbours, a cell will be gain life.
 * 
 * @author Daniel Lake
 *
 */

public class GameOfLife {
	
	// Variables
	private Set<Coordinates> liveCells = new HashSet<Coordinates>();

	// Constructor
	public GameOfLife() {
	}
	
	// Methods
	public Set<Coordinates> getLiveCells() {
		return liveCells;
	}

	public void addCell(Coordinates newCell) {
		liveCells.add(newCell);
	}
	
	/**
	 * Loops through the set of coordinates it is initially seeded with,
	 * counts the neightbours and if neighbours = 2 or 3 alive cells, the cell survives and 
	 * is added to the next turn. Once finished, current live cells are overwritten
	 * by the next turn set.
	 */
	public void playTurn() {
		Set<Coordinates> nextTurn = new HashSet<Coordinates>();
		
		for (Coordinates coord : liveCells) {
			int count = liveCellCount(coord.neighbourCoordinates());
			if (count == 2 || count == 3)
				nextTurn.add(coord);
			
			processDeadNeighbours(coord, nextTurn);
		}
		liveCells = nextTurn;
	}

	/**
	 * Loops through the deadCheck set and counts the number of live cells neighbouring each cell,
	 * if neighbours = 3 then the cell will become live next turn and is added to the next turn
	 * set.
	 * 
	 * @param deadCheck a set of coordinates for current live cells at start of turn
	 * @param nextTurn a set of coordinates for cells that will be alive next turn
	 */
	private void processDeadNeighbours(Coordinates deadCheck, Set<Coordinates> nextTurn) {
		
		for (Coordinates neighbour : deadNeighbours(deadCheck)) {
			int liveNeighborCount = liveCellCount(neighbour.neighbourCoordinates());
			
			if (liveNeighborCount == 3)
				nextTurn.add(neighbour);
		}
	}
	
	/**
	 * Loops through the neighbour cells of each cell in the deadCheck set and if the current live cells
	 * set does not contain the neighbour cell, it is considered dead and added to the dead neighbour set.
	 * 
	 * @param deadCheck a set of coordinates for current live cells at start of turn
	 * @return returns a set of dead cells that are next to live cells
	 */
	private Set<Coordinates> deadNeighbours(Coordinates deadCheck) {
		
		Set<Coordinates> deadNeighbours = new HashSet<Coordinates>();
		
		for (Coordinates neighbour : deadCheck.neighbourCoordinates()) {
			if (!liveCells.contains(neighbour))
				deadNeighbours.add(neighbour);
		}
		return deadNeighbours;
	}
	
	/**
	 * Loops through a set of coordinates that neighbour the current live cells at the start of the turn,
	 * counts whether the cells are alive or not and returns that number.
	 * 
	 * @param aliveCheck
	 * @return the count of live cell neighbours
	 */
	private int liveCellCount(Set<Coordinates> aliveCheck) {
		
		int count = 0;
		
		for (Coordinates neighbour : aliveCheck) {
			if (liveCells.contains(neighbour))
				count++;
		}
		return count;
	}
}
