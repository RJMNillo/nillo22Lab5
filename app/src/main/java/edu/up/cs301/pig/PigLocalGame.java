package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GamePlayer;
import edu.up.cs301.game.GameFramework.LocalGame;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import java.lang.Math;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @author Reggie Jan Marc Nillo, Nathan Kline
 * @version February 2020
 */
public class PigLocalGame extends LocalGame {

    /**
     * This ctor creates a new game state
     */

    private PigGameState StameGate;

    public PigLocalGame() {
        //TODO  You will implement this constructor
        //ok
        //Get the gamestate
        StameGate = new PigGameState();

    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(playerIdx == StameGate.getWhoseturn())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction)
        {

            if (StameGate.getWhoseturn() == 0)
            {
                StameGate.setPlayer0score(StameGate.getPlayer0score()+StameGate.getRunningtotal());
                StameGate.setRunningtotal(0);
                StameGate.setTurn(1);
                return true;
            }
            else
            {
                StameGate.setPlayer1score(StameGate.getPlayer1score()+StameGate.getRunningtotal());
                StameGate.setRunningtotal(0);
                StameGate.setTurn(0);
                return true;
            }
        }
        else if (action instanceof PigRollAction)
        {
            StameGate.setDieval((int) (Math.random() *6+1)) ;
            if(StameGate.getDieval() == 1)
            {
                StameGate.setRunningtotal(0);
                if(StameGate.getWhoseturn() == 0)
                {
                    StameGate.setTurn(1);
                }
                else
                {
                    StameGate.setTurn(0);
                }
            }
            else
            {
                StameGate.setRunningtotal(StameGate.getRunningtotal() + StameGate.getDieval());
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        StameGate = new PigGameState(StameGate);
        p.sendInfo(StameGate);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(StameGate.getPlayer0score() >= 50)
        {
            return "Player zero wins.";
        }
        else if(StameGate.getPlayer1score() >= 50)
        {
            return "Player one wins.";
        }
        return null;
    }

}// class PigLocalGame
