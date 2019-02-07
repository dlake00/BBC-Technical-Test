package lib;

import java.util.Set;

/**
 * A grid is intialised by minimum and maximum values on an X and Y axis.
 * These values are used to define a grid area in which cell coordinates can be mapped onto.
 * The resulting grid can be printed in console to provide a visual representation 
 * of cells that are alive or dead.
 * 
 * @author Daniel Lake
 *
 */

public class Grid {
	
	// Variables
	private int minX;
	private int minY;
	private int maxX;
	private int maxY;
	
	// Constructors
    public Grid() {
    	
        this.minX = 0;
        this.maxX = 0;
        this.minY = 0;
        this.maxY = 0;
    }
    
    public Grid(Set<Coordinates> coords) {
		
    	// Gets first item in set to ensure graph starts at first live cell
		Coordinates coord = coords.iterator().next();
		
		// Initialises grid starting coordinates
        this.minX = coord.getX();
        this.maxX = coord.getX();
        this.minY = coord.getY();
        this.maxY = coord.getY();
    }
    
    // Methods
    
    /**
     * Loops through a set of coordinates and uses a comparison of whether the current value of x or y
     * is larger or smaller than the intial min and max x/y values, when a greater extreme is found,
     * the variable is reassigned.
     * 
     * Once the minimum and maximum values have been found, a 2D grid can be drawn using the four most extreme
     * coordinates (x,y) (-x,-y) (-x,y) (x,-y) and the game state is displayed by placing 0s for
     * dead or unused cells and 1s for live cells.
     * 
     * @param coords the set of coordinates in which to determine min and max X/Y values
     */
    public void printGrid(Set<Coordinates> coords) {
    	
        for(Coordinates coord : coords) {
            if(coord.getX() < this.minX)
                this.minX = coord.getX();
            if(coord.getX() > this.maxX)
                this.maxX = coord.getX();     
            if(coord.getY() < this.minY)
                this.minY = coord.getY();             
            if(coord.getY() > this.maxY)
                this.maxY = coord.getY();
        }
        
        for(int gridY = this.maxY; gridY >= this.minY; gridY--) {
            for(int gridX = this.minX; gridX <= this.maxX; gridX++) {
            	
                int x = gridX;
                int y = gridY;
                
                if(coords.stream().filter(c -> c.getX() == x && c.getY() == y).findFirst().orElse(null) != null)
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}