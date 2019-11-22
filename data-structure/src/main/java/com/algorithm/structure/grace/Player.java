package com.algorithm.structure.grace;

;
/**
 * Player.java  
 *
 * @author:Grace Fan
 * Assignment #:
 * 
 * Brief Program Description: 
 * This is the player class.  This class includes all player’s decisions.
 * The main purpose of this class is to ask the player what they want to do based on the hand class. 
 * Based on the player’s response, this class will send orders to the dealer and the hand on what to do next. 

 * 
 *
 */
public class Player
{
    private String order;
    private int insurance;
    private int chip;
    private Hand playerHand=new Hand();
    private String name;
    private boolean player=false;
    //Constructor
    public Player(String n, int c)
    {
        name=n;
        chip=c;
    }
    //Double down method which doubled the bet amount. Double down method would only be used 
    //when the player believes that he/she has a higher chance of winning the game. 
    public int doubleDown(int b)
    {
        b*=2;
        return b;
    }
    //Five Card Charlie: This method is created to test if the player has 5 cards and 
    //the total value of the hand is still under 22, the player would win automatically.
    public boolean fiveCharlie()
    {
        if(playerHand.getSize()==5 && playerHand.getValue()<22)
        {
            player=true;
        }
        return player;
    }
    //getChips: returns players number of chips
    public int getChips()
    {
        return chip;
    }
    //getHand: returns player's hand
    public Hand getHand()
    {
        return playerHand;
    }
    //This returns the player's hand
      public String toString()
      {
        String h = "";
        for(int x=0; x<playerHand.getSize(); x++){
            h += ((getHand())).getCardValueHand(x) +"\n"; //maybe might work?
        }
        return "Player's card \n" +h;
    }
    //This takes in a parameter and set the orginal numbers of chips into the new one. 
    public void setChips(int c)
    {
        chip=c;
    }
   
}

