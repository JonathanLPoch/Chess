import java.util.ArrayList;
import info.gridworld.grid.Location;
import java.awt.Color;
public class Queen extends ChessPiece
{
		private Location Xloc = new Location(0,0);
		//creates a Queen with the specefied name and color
		public Queen(String name, Color c)
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
				Location currentLocation = new Location(row,col);
				//get horizontal locations
				for(int c=col;c>=0;c--)
				{
						Location loc = new Location(row,c);
						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null&&!loc.equals(getLocation()))
						  break;
				  	if(getGrid().isValid(loc)&&getGrid().get(loc)==null)
								locs.add(loc);

				}
				for(int c=col;c<getGrid().getNumCols();c++)
				{
						Location loc = new Location(row,c);
						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null&&!loc.equals(getLocation()))
						  break;
				  	if(getGrid().isValid(loc)&&getGrid().get(loc)==null)
								locs.add(loc);

				}
				//gets vertical locations
				for(int r=row;r>=0;r--)
				{
						Location loc = new Location(r,col);
						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null&&!loc.equals(getLocation()))
						  break;
						if(getGrid().isValid(loc)&&getGrid().get(loc)==null)
								locs.add(loc);

				}
				for(int r=row;r<getGrid().getNumRows();r++)
				{
						Location loc = new Location(r,col);
						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null&&!loc.equals(getLocation()))
						  break;
						if(getGrid().isValid(loc)&&getGrid().get(loc)==null)
								locs.add(loc);

				}
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
				Location currentLocation = new Location(row,col);
				//gets horizontal locations
				for(int c=col+1;c<getGrid().getNumCols();c++)
				{
						Location loc = new Location(row,c);

						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null)
							{	locs.add(loc); break;}


				}
				for(int c=col-1;c>=0;c--)
				{
						Location loc = new Location(row,c);

						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null)
							{	locs.add(loc); break;}

				}
				//gets vertical locations
				for(int r=row+1;r<getGrid().getNumRows();r++)
				{
						Location loc = new Location(r,col);

						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null)
							{	locs.add(loc); break;}

				}
				for(int r=row-1;r>=0;r--)
				{
						Location loc = new Location(r,col);

						if(getGrid().isValid(loc)&&getGrid().get(loc)!=null)
								{	locs.add(loc); break;}

				}
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