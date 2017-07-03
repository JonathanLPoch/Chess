import java.awt.Color;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.actor.ActorWorld;

public class ChessGameRunner
{
	@SuppressWarnings("unchecked")

	public static void main(String[] args)
	{
		ActorWorld world = new ChessGame(new BoundedGrid(8,8));
		//add black pawns
		world.add(new Location(1,0), new Pawn("pawn1B", Color.BLACK));
		world.add(new Location(1,1), new Pawn("pawn2B", Color.BLACK));
		world.add(new Location(1,2), new Pawn("pawn3B", Color.BLACK));
		world.add(new Location(1,3), new Pawn("pawn4B", Color.BLACK));
		world.add(new Location(1,4), new Pawn("pawn5B", Color.BLACK));
		world.add(new Location(1,5), new Pawn("pawn6B", Color.BLACK));
		world.add(new Location(1,6), new Pawn("pawn7B", Color.BLACK));
		world.add(new Location(1,7), new Pawn("pawn8B", Color.BLACK));
		//add white pawns
		world.add(new Location(6,0), new Pawn("pawn1W", Color.WHITE));
		world.add(new Location(6,1), new Pawn("pawn2W", Color.WHITE));
		world.add(new Location(6,2), new Pawn("pawn3W", Color.WHITE));
		world.add(new Location(6,3), new Pawn("pawn4W", Color.WHITE));
		world.add(new Location(6,4), new Pawn("pawn5W", Color.WHITE));
		world.add(new Location(6,5), new Pawn("pawn6W", Color.WHITE));
		world.add(new Location(6,6), new Pawn("pawn7W", Color.WHITE));
		world.add(new Location(6,7), new Pawn("pawn8W", Color.WHITE));
		//add black knights
		world.add(new Location(0,1), new Knight("knight1B", Color.BLACK));
		world.add(new Location(0,6), new Knight("knight2B", Color.BLACK));
		//add white knights
		world.add(new Location(7,1), new Knight("knight1W", Color.WHITE));
		world.add(new Location(7,6), new Knight("knight2W", Color.WHITE));
		//adds queens
		world.add(new Location(0,3), new Queen("Queen1B", Color.BLACK));
		world.add(new Location(7,3), new Queen("Queen1", Color.WHITE));
		//add black bishops
		world.add(new Location(0,2), new Bishop("bishop1B", Color.BLACK));
		world.add(new Location(0,5), new Bishop("bishop2B", Color.BLACK));
		//add white bishops
		world.add(new Location(7,2), new Bishop("bishop1W", Color.WHITE));
		world.add(new Location(7,5), new Bishop("bishop2W", Color.WHITE));
		//add white rooks
		world.add(new Location(7,7), new Rook("rook1W", Color.WHITE));
		world.add(new Location(7,0), new Rook("rook1W", Color.WHITE));
		//add black rooks
		world.add(new Location(0,7), new Rook("rook1B", Color.BLACK));
		world.add(new Location(0,0), new Rook("rook1B", Color.BLACK));
		//adds kings
		world.add(new Location(0,4), new King("King1B", Color.BLACK));
		world.add(new Location(7,4), new King("King1W", Color.WHITE));
		world.show();
	}
}