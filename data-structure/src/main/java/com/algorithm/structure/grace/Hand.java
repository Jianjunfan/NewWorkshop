package com.algorithm.structure.grace;

import java.util.ArrayList;
/**
 * Hand.java  
 *
 * @author: All
 * Assignment #: 
 * 
 * Brief Program Description:
 * 
 *
 */
public class Hand
{
//    private int value;
    private ArrayList<Card> hand;
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    
    public int getValue()
    {
        int value=0;
        for(int x = 0; x< hand.size(); x++)
        {
            value += (hand.get(x)).getCardValue();
        }
        return value;
    }
    
    public int getCardValueHand(int n)
    {
        return hand.get(n).getCardValue();
        
    }
    
    public void aceValue(int n)
    {
        if (n == 1)
        {
            hand.get(getSize()-1).setAceToOne(true);
        }
    }
    
    public int getSize()
    {
        return hand.size();
    }
    
    public boolean blackjack()
    {
        if (getValue() == 21)
        {
            return true;
        }
        return false;
    }
    // public ArrayList getHand()
    // {
        // return hand;
    // }
    public void hit(Card n)
    {
        hand.add(n);
    }
    public Card lastCard()
    {
        return hand.get(getSize()-1);
    }
    
    public boolean bust()
    {
        if(getValue()<=21)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public void resetHand()
    {
        while(hand.size()>0)
        {
            hand.remove(0);
        }
        //hand=new ArrayList<Card>();
    }
}
