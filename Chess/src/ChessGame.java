import info.gridworld.actor.*;
import info.gridworld.grid.*;
import java.util.ArrayList;
import java.awt.Color;

import javax.swing.*;

//FROM http://pastebin.com/M9WYM2Pe

public class ChessGame extends ActorWorld
{

	private int totalturns = 1;
    private boolean aclicked=false;
    private ArrayList<Location> locs = new ArrayList<Location>();
    private ChessPiece a = null;
   //creates new ChessGame with no parameter
    public ChessGame()
    {
    }
    //creates new ChessGame with a Grid parameter
    public ChessGame(Grid<Actor> grid)
    {
        super(grid);
    }

	//determines if the location clicked is valid
    public boolean locationClicked(Location loc)
    {
        Grid<Actor> gr = getGrid();
        ChessPiece act = (ChessPiece)gr.get(loc);
				ArrayList<Location> kingPos = new ArrayList<Location>();
				ArrayList<Location> enemyPos = new ArrayList<Location>();
				ArrayList<Location> enemyMoves = new ArrayList<Location>();
				boolean isCheckMate=true;
        Location move=null;
        boolean valid=false;
        
        if (act == null)
        {
            if (aclicked)
            {
                for (Location moveloc : locs)
                {
                    if (loc.equals(moveloc))
                    {
                    //	if(totalturns%2==1 && act.getColor()==Color.WHITE)
                       	 	valid=true;
                    }
                }
                if (valid)//if valid, move the selected piece
                {
					//if(act instanceof King)
						//JOptionPane.showMessageDialog(null, "Check");

					a.moveTo(loc);
                    a.turnCount++;//added
					totalturns++;
                    valid=false;
					//check for kings

                }
                else//if not valid, inform the player that they are trying to make an invalid move
                {
                    JOptionPane.showMessageDialog(null, "Invalid move");
                }
                aclicked=false;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Select a piece");
            }
        }
        else
        {
            if (!aclicked)
            {
                a=(ChessPiece)gr.get(loc);
                aclicked=true;
                locs= a.getNormalMoves();
    	for(int i = 0; i<a.getCaptureMoves().size(); i++)//added
    	{//added
    		locs.add(a.getCaptureMoves().get(i));//added
    	}//added
            }
            else
            {
                if (a.getColor().equals(act.getColor()))//if a player attempts to capture a piece of his own color, he is informed that he cannot take his own teammate
                {
                    JOptionPane.showMessageDialog(null, "You Cannot Take Your Teammates");
                    aclicked=false;
                }
                else
                {
                    for (Location moveloc : locs)
                    {
                        if (loc.equals(moveloc))
                        {
                            valid=true;
                        }
                    }
										//prevents taking of king unless in checkmate
                    if (valid)
                    {//determines if king is in check mate and may therefore be captured
												if(act instanceof King)
												{
														kingPos=act.getNormalMoves();
														enemyPos = act.getGrid().getOccupiedLocations();
														for(Location kingMoves:kingPos)
														{
																for(Location moves:enemyPos)
																{
																		enemyMoves=((ChessPiece)act.getGrid().get(moves)).getCaptureMoves();
																		if(enemyMoves.indexOf(kingMoves)<0)
																		{
																					isCheckMate = false;
																		}

																}
														}
														if (isCheckMate)
														{
																	JOptionPane.showMessageDialog(null, "Checkmate");valid=false;
														}
														else
														{
														JOptionPane.showMessageDialog(null, "Check");
														valid=false;
														}

												}
										}

                    if (valid)
                    {

                        a.moveTo(loc);
                        a.turnCount++;//added
						totalturns++;
                        valid=false;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Invalid move");
                    }
                    aclicked=false;
                }
            }
        }
        return true;
    }
    //processes key presses as well as mouse clicks to select locations on the board
    public boolean keyPressed(String description, Location loc)
    {
        if (description.equals("SPACE"))
            return locationClicked(loc);
        else if (description.equals("ENTER"))
            return locationClicked(loc);
        else
            return false;
    }
}