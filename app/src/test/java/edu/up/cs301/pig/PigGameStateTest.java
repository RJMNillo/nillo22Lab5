package edu.up.cs301.pig;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class PigGameStateTest {

    @Test
    public void getWhoseturn() throws Exception
    {
        PigGameState StameGate = new PigGameState();
        int testTurn = StameGate.getWhoseturn();
        Random randcheck = new Random();
        int randNum = randcheck.nextInt(2);
        assertEquals("getWhoseturn not in sync",randNum,testTurn,1);

        //I did two cases because if if the turn is not one, then the other turn is 0. The Turn is determined by
        //The constructor, doing a random from 0 and 1.
        //I should also check if the copy still works as well.
        PigGameState etatSemaG = new PigGameState(StameGate);

        assertEquals("Copy constructor not in sync",testTurn,etatSemaG.getWhoseturn());
    }

    @Test
    public void getPlayer0score() throws Exception
    {
        //Statement of copy constructor equality is on getWhoseTurnTest.
        PigGameState StameGate = new PigGameState();
        //Things should be initialized at zero for now...
        int test0score = StameGate.getPlayer0score();
        assertEquals("Constructor not in sync",0,test0score);
        PigGameState etatSemaG = new PigGameState(StameGate);
        test0score = etatSemaG.getPlayer0score();
        assertEquals("Copy Constructor not in sync",0,test0score);
    }

    @Test
    public void getPlayer1score() throws Exception
    {
        PigGameState StameGate = new PigGameState();
        //Things should be initialized at zero for now...
        int test1score = StameGate.getPlayer1score();
        assertEquals("Constructor not in sync",0,test1score);
        PigGameState etatSemaG = new PigGameState(StameGate);
        test1score = etatSemaG.getPlayer1score();
        assertEquals("Copy Constructor not in sync",0,test1score);
    }

    @Test
    public void getRunningtotal() throws Exception
    {
        //The initial running total is 0
        PigGameState StameGate = new PigGameState();
        int testruntotal = StameGate.getRunningtotal();
        assertEquals("Constructor is not in sync",0,testruntotal);
        PigGameState etatSemaG = new PigGameState(StameGate);
        testruntotal = etatSemaG.getRunningtotal();
        assertEquals("Copy Constructor is not in sync",0,testruntotal);
    }

    @Test
    public void getDieval() throws Exception
    {
        //Initially at 0
        PigGameState StameGate = new PigGameState();
        int testVal = StameGate.getDieval();
        assertEquals("Constructor is not in sync",0,testVal);
        PigGameState etatSemaG = new PigGameState(StameGate);
        testVal = etatSemaG.getDieval();
        assertEquals("Copy Constructor is not in sync",0,testVal);
    }

    //SETTER METHOD TESTING
    //Make a new instance, and use set.
    //The getter methods are fine..

    @Test
    public void setTurn() throws Exception
    {
        PigGameState StameGate = new PigGameState();
        int expected = 1;
        StameGate.setTurn(expected);
        assertEquals("Constructor not in sync",expected,StameGate.getWhoseturn());
        PigGameState etatSemaG = new PigGameState(StameGate);
        assertEquals("Copy Constructor not in sync",expected,etatSemaG.getWhoseturn());
    }

    @Test
    public void setPlayer0score()
    {
        PigGameState StameGate = new PigGameState();
        int expected = 50;
        StameGate.setPlayer0score(expected);
        assertEquals("Constructor not in sync",expected,StameGate.getPlayer0score());
        PigGameState etatSemaG = new PigGameState(StameGate);
        assertEquals("Copy Constructor not in sync",expected,etatSemaG.getPlayer0score());
    }

    @Test
    public void setPlayer1score() throws Exception
    {
        PigGameState StameGate = new PigGameState();
        int expected = 50;
        StameGate.setPlayer1score(expected);
        assertEquals("Constructor not in sync",expected,StameGate.getPlayer1score());
        PigGameState etatSemaG = new PigGameState(StameGate);
        assertEquals("Copy Constructor not in sync",expected,etatSemaG.getPlayer1score());
    }

    @Test
    public void setRunningtotal()
    {
        PigGameState StameGate = new PigGameState();
        int[] testChecks = {3,1,7,76};
        for(int i = 0; i < testChecks.length; i++)
        {
            StameGate.setRunningtotal(testChecks[i]);
            int TestTotal = StameGate.getRunningtotal();
            assertEquals("Set not in sync",testChecks[i],TestTotal);
            PigGameState etatSemaG = new PigGameState(StameGate);
            TestTotal = etatSemaG.getRunningtotal();
            assertEquals("Copy not in sync",testChecks[i],TestTotal);
        }
    }

    @Test
    public void setDieval() throws Exception
    {
        PigGameState StameGate = new PigGameState();
        int[] testChecks = {1,2,3,4,5,6};
        for(int i = 0; i < testChecks.length; i++)
        {
            StameGate.setDieval(testChecks[i]);
            int TestTotal = StameGate.getDieval();
            assertEquals("Set not in sync",testChecks[i],TestTotal);
            PigGameState etatSemaG = new PigGameState(StameGate);
            TestTotal = etatSemaG.getDieval();
            assertEquals("Copy not in sync",testChecks[i],TestTotal);
        }
    }
}