import java.util.ArrayList;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
public class King extends ChessPiece
{		//creates a King with the specefied name and color
		public King(String name, Color c)
		{
				setName(name);
				setColor(c);
				super.setColor(c);
		}
		//generates a list of legal, non-capturing moves
		public ArrayList<Location> getNormalMoves()
		{
				ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(getLocation());
				return locs;
		}
		//generates a list of legal, capturing moves
		public ArrayList<Location> getCaptureMoves()
		{
				ArrayList<Location> locs = getGrid().getOccupiedAdjacentLocations(getLocation());
				return locs;
		}
}