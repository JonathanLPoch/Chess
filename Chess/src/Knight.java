import java.util.ArrayList;
import info.gridworld.grid.Location;
import java.awt.Color;
public class Knight extends ChessPiece
{		//creates a knight with the specefied name and color
		public Knight(String name, Color c)
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
				//gets empty locations one L away
				Location loc = new Location (row+2, col+1);
				if(row+2<8&& col+1<8)
				{
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				if(row+2<8&& col-1>=0)
				{
					loc = new Location (row+2, col-1);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				if(row+1<8&& col+2<8)
				{
						loc = new Location (row+1, col+2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				if(row-1>=0&& col+2<8)
				{
						loc = new Location (row-1, col+2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				if(row-2>=0&& col-1>=0)
				{
						loc = new Location (row-2, col-1);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				if(row-2>=0&& col+1<8)
				{
						loc = new Location (row-2, col+1);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				if(row-1>=0&& col-2>=0)
				{
						loc = new Location (row-1, col-2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				if(row+1<8&& col-2>=0)
				{
						loc = new Location (row+1, col-2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) ==null)
								locs.add(loc);
				}
				return locs;
		}
		//generates a list of legal, capturing moves
		public ArrayList<Location> getCaptureMoves()
		{
				ArrayList<Location> locs = new ArrayList<Location>();
				int row = getLocation().getRow();
				int col = getLocation().getCol();
				//gets occupied locations at end of L
				Location loc = new Location (row+2, col+1);
				if(row+2<8&& col+1<8)
				{
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				if(row+2<8&& col-1>=0)
				{
					loc = new Location (row+2, col-1);
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				if(row+1<8&& col+2<8)
				{
						loc = new Location (row+1, col+2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				if(row-1>=0&& col+2<8)
				{
						loc = new Location (row-1, col+2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				if(row-2>=0&& col-1>=0)
				{
						loc = new Location (row-2, col-1);
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				if(row-2>=0&& col+1<8)
				{
						loc = new Location (row-2, col+1);
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				if(row-1>=0&& col-2>=0)
				{
						loc = new Location (row-1, col-2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				if(row+1<8&& col-2>=0)
				{
						loc = new Location (row+1, col-2);
						if(getGrid().isValid(loc)&&getGrid().get(loc) !=null)
								locs.add(loc);
				}
				return locs;
		}


}