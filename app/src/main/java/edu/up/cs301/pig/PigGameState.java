package edu.up.cs301.pig;

import edu.up.cs301.game.GameFramework.infoMessage.GameState;
import java.lang.Math;

public class PigGameState extends GameState
{
    //bruh moment
    private int whoseturn;
    private int player0score;
    private int player1score;
    private int runningtotal;
    private int dieval;

    public PigGameState()
    {
        whoseturn = ((int) (Math.random()*2 +0));
        player0score = 0;
        player1score = 0;
        runningtotal = 0;
        dieval = 0;
    }

  public PigGameState(PigGameState currentState)
  {
      whoseturn = currentState.whoseturn;
      player0score = currentState.player0score;
      player1score = currentState.player1score;
      runningtotal = currentState.runningtotal;
      dieval = currentState.dieval;
  }

    //getter methods
    public int getWhoseturn()
    {
        return whoseturn;
    }

    public int getPlayer0score()
    {
        return player0score;
    }

    public int getPlayer1score()
    {
        return player1score;
    }

    public int getRunningtotal()
    {
        return runningtotal;
    }

    public int getDieval()
    {
        return dieval;
    }

    //setters
    public void setTurn(int nextTurn)
    {
        whoseturn = nextTurn;
    }

    public void setPlayer0score(int addScore)
    {
        player0score = addScore;
    }

    public void setPlayer1score(int addScore)
    {
        player1score = addScore;
    }

    public void setRunningtotal(int addTotal)
    {
        runningtotal = addTotal;
    }

    public void setDieval(int dieface)
    {
        dieval = dieface;
    }
}
