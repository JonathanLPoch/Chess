import java.util.ArrayList;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import java.awt.Color;
public abstract class ChessPiece extends Actor implements Chess
{
	
		private String pieceName;
		private Color color;
		public int turnCount = 1;
		public abstract ArrayList<Location> getCaptureMoves();
		//sets color of piece
		public void setColor(Color c)
		{
			color = c;
		}
		//returns color assigned to piece
		public Color getColor()
		{
			return color;
		}
		//moves a chosen piece to the desired, legal location in list locs
		public void move(int x, int y)
		{
				Location loc = new Location(x,y);
				ArrayList<Location> locs = getNormalMoves();
				for(Location l:locs)
				{
						if(loc.compareTo(l)==0)
						{
								moveTo(loc);

								return;
						}
				}
		}
		//moves a chosen piece to the desired location in locs that is occupied by a piece of the opposite color and removes that piece from the board
		public void capture(ChessPiece target)
		{
				Location loc = target.getLocation();
				ArrayList<Location> locs = getCaptureMoves();
				for(Location l:locs)
				{
						if(loc.compareTo(l)==0)
						{
								target.removeSelfFromGrid();

								return;
						}
				}
		}
		//returns a piece's assigned name
		public String getName()
		{
				return pieceName;
		}
		//assigns a name to a piece
		public void setName(String s)
		{
				pieceName = s;
		}

}