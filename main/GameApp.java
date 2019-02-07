package main;

import lib.Coordinates;
import lib.GameOfLife;
import lib.Grid;

/**
 * GameApp is a simple tool to check functionality of the Game of Life as well as print
 * a visual representation to the console. Please modify this as necessary to check that game rules
 * are consistently enforced and results match expected output.
 *
 * @author Daniel Lake
 *
 */

public class GameApp {
	
	public static void main(String[] args) {
		
		// Initialise new GameOfLife
		GameOfLife game = new GameOfLife();
		
		// Create coordinates for game
		Coordinates cell1 = new Coordinates(1,0);
		Coordinates cell2 = new Coordinates(0,0);
		Coordinates cell3 = new Coordinates(-1,0);
		
		// Add coordinates to game as cells
		game.addCell(cell1);
		game.addCell(cell2);
		game.addCell(cell3);
		
		// Intialise new Grid with GameOfLife cells
		Grid grid = new Grid(game.getLiveCells());
		
		// Print current game state to console
		grid.printGrid(game.getLiveCells());
		
		// Play turn for GameOfLife
		game.playTurn();
		
		grid.printGrid(game.getLiveCells());
		
		game.playTurn();
		
		grid.printGrid(game.getLiveCells());
		
		game.playTurn();
		
		grid.printGrid(game.getLiveCells());
	}
}
