import java.util.ArrayList;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
public class Bishop extends ChessPiece
{
		//creates a Bishop with the specified name and color
		private Location Xloc = new Location(0,0);
		public Bishop(String name, Color c)
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
				int col2 = getLocation().getCol();
				//gets diagonal, upper left
				for(int x=row;x>=0;x--)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)==null)
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2--;
				}
				col2=col;
				//gets diagonal, upper right
				for(int x=row;x>=0;x--)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)==null)
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2++;
				}
				col2=col;
				//gets diagonal, lower left
				for(int x=row;x<9;x++)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)==null)
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2++;
				}
				col2=col;
				//gets diagonal, lower right
				for(int x=row;x<9;x++)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)==null)
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2--;
				}
				col2=col;
				return locs;
		}
		//generates a list of legal, capturing moves
		public ArrayList<Location> getCaptureMoves()
		{
				ArrayList<Location> locs = new ArrayList<Location>();
				int row = getLocation().getRow();
				int col = getLocation().getCol();
				int col2 = getLocation().getCol();
				//gets diagonal, upper left
				for(int x=row;x>=0;x--)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&& Xloc!=getLocation())
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2--;
				}
				col2=col;
				//gets diagonal, upper right
				for(int x=row;x>=0;x--)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&& Xloc!=getLocation())
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2++;
				}
				col2=col;
				//gets diagonal, lower left
				for(int x=row;x<9;x++)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&& Xloc!=getLocation())
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2++;
				}
				col2=col;
				//gets diagonal, lower right
				for(int x=row;x<9;x++)
				{
						Xloc = new Location(x,col2);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&& Xloc!=getLocation())
						locs.add(Xloc);
						if(getGrid().isValid(Xloc)&&getGrid().get(Xloc)!=null&&!Xloc.equals(getLocation()))
						break;
						col2--;
				}
				col2=col;
				return locs;
		}


}