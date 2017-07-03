import java.util.ArrayList;
import info.gridworld.grid.Location;
import java.awt.Color;
import info.gridworld.grid.Grid;
public class Rook extends ChessPiece
{
		//creates a Rook with the specefied name and color
		public Rook(String name, Color c)
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
					//gets horizontal locations
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
				return locs;
		}
		//generates a list of legal, capturing moves
		public ArrayList<Location> getCaptureMoves()
		{
				ArrayList<Location> locs = new ArrayList<Location>();
				int row = getLocation().getRow();
				int col = getLocation().getCol();
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


				return locs;
		}


}