import java.util.ArrayList;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
public class Pawn extends ChessPiece
{		//creates a Pawn with the specefied name and color
		public Pawn(String name, Color c)
		{
				setName(name);
				setColor(c);
				super.setColor(c);
		}
		//generates a list of legal, non-capturing moves
		public ArrayList<Location> getNormalMoves()
		{
				ArrayList<Location> locs = new ArrayList<Location>();
				int row = getLocation().getRow();
				int col = getLocation().getCol();
				//gets empty forward locations
				if(getColor() == Color.BLACK)
				{
						Location loc = new Location (row+1, col);
						if(getGrid().isValid(loc)&&getGrid().get(loc) == null)
							locs.add(loc);
						if(turnCount == 1)//if is first turn may move 2
						{
							loc = new Location(row+2,col);
							locs.add(loc);
						}
				}
				else if(getColor() == Color.WHITE)
				{

						Location loc = new Location (row-1, col);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
							locs.add(loc);
						if(turnCount == 1)//if is first turn may move 2
						{
							loc = new Location(row-2,col);
							locs.add(loc);
						}
				}

				return locs;
		}
		//generates a list of legal, capturing moves
		public ArrayList<Location> getCaptureMoves()
		{
				ArrayList<Location> locs = new ArrayList<Location>();
				int row = getLocation().getRow();
				int col = getLocation().getCol();
				//gets occupied forward diagonal locations
				if(getColor() == Color.BLACK)
				{

					Location loc = new Location (row+1, col+1);

					if(getGrid().isValid(loc)&&getGrid().get(loc) != null /*&& get(loc).getColor() == Color.WHITE*/)
						locs.add(loc);
					loc = new Location (row+1, col-1);
					if(getGrid().isValid(loc)&&getGrid().get(loc)!= null)
						locs.add(loc);

				}

				else if(getColor() == Color.WHITE)
				{
					Location loc = new Location (row-1, col+1);
					if(getGrid().isValid(loc)&&getGrid().get(loc) != null)
								locs.add(loc);
					loc = new Location (row-1, col-1);
					if(getGrid().isValid(loc)&&getGrid().get(loc)!= null)
								locs.add(loc);

				}
				return locs;
		}




}