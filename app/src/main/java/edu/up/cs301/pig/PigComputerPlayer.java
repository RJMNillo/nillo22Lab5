package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.GameComputerPlayer;
import edu.up.cs301.game.GameFramework.actionMessage.GameAction;
import edu.up.cs301.game.GameFramework.infoMessage.GameInfo;
import edu.up.cs301.game.GameFramework.utilities.Tickable;
import java.lang.Math;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    //private PigHoldAction hold;
    //private PigRollAction roll;

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        // if not comp players turn
        //return;
        if(info instanceof PigGameState)
        {
            if(((PigGameState) info).getWhoseturn() != this.playerNum)
            {
                return;
            }
            else
            {
                int decide = ((int) (Math.random()*2+0));
                if(decide == 1)
                {
                    game.sendAction(new PigRollAction(this));
                }
                else
                {
                    game.sendAction(new PigHoldAction(this));
                }
            }
        }

    }//receiveInfo

}
