package lib;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A coordinate contains a pair of two integers, X and Y,
 * these act as coordinates for a grid reference.
 * A coordinate has eight neighbours in vertical, horizontal and diagonal directions.
 * 
 * @author Daniel Lake
 *
 */

public class Coordinates {
	
	// Variables
	
	// Coordinates of cell
	private int x;
	private int y;
	
	// Direction integers
	private int center = 0;
	private int top = -1;
	private int bottom = 1;
	private int left = -1;
	private int right = 1;

	// Constructors
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	// Get/Set Methods
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	private Coordinates getTop() {
		return neighbour(center, top);
	}

	private Coordinates getTopLeft() {
		return neighbour(left, top);
	}

	private Coordinates getTopRight() {
		return neighbour(right, top);
	}
	
	private Coordinates getLeft() {
		return neighbour(left, center);
	}

	private Coordinates getRight() {
		return neighbour(right, center);
	}
	
	private Coordinates getBottom() {
		return neighbour(center, bottom);
	}

	private Coordinates getBottomLeft() {
		return neighbour(left, bottom);
	}

	private Coordinates getBottomRight() {
		return neighbour(right, bottom);
	}
	
	// Methods
	
	// Calculates coords of neighbour by adding or subtracting direction integers from x/y
	private Coordinates neighbour(int dirX, int dirY) {
		return new Coordinates(x + dirX, y + dirY);
	}
	
	// Returns neighbours for use in applying GameOfLife rules
	public Set<Coordinates> neighbourCoordinates() {
		
		HashSet<Coordinates> neighbours = new HashSet<Coordinates>();
		
		neighbours.add(getTop());
		neighbours.add(getTopLeft());
		neighbours.add(getTopRight());
		neighbours.add(getLeft());
		neighbours.add(getRight());
		neighbours.add(getBottom());
		neighbours.add(getBottomLeft());
		neighbours.add(getBottomRight());
		
		return neighbours;
	}
	
	
	// Override Default Methods
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates compare = (Coordinates) obj;
		if (x != compare.x)
			return false;
		if (y != compare.y)
			return false;
		return true;
	}
}
