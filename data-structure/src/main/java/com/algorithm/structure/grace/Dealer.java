package com.algorithm.structure.grace;

import java.util.Scanner;
/**
 * Dealer.java  
 *
 * @author:
 * Assignment #: Beuluh Lee
 * 
 * Brief Program Description:
 * 
 *
 */
public class Dealer
{
    private Shoe shoe = new Shoe(4);
    private Hand dealerHand = new Hand();
    private Player p1;
    public Dealer(Player p)
    {
        p1=p;
        shoe = new Shoe(4);    
        shoe.shuffleShoe();
        dealerHand = new Hand();
    }

    public Card selectCard()
    {
        return shoe.dealCard();
    }

    public boolean takeInOrder(String s)
    {
        if(s.equals("hit") || s.equals("Hit")){
            p1.getHand().hit(selectCard());
            return true;
        }
        else
        {
            return false;

        }
    }

    public boolean yesOrNo(){
        if(dealerHand.getValue()<17){
            dealerHand.hit(selectCard());
            return true;
        }
        else{
            return false;
        }
    }

    public Hand getDHand()
    {
        return dealerHand;
    }

    public String toString()
    {
        String h = "";
        for(int x=1; x<dealerHand.getSize(); x++){
            h += ((getDHand())).getCardValueHand(x) +"\n"; //maybe might work?
        }
        return "Dealer's Card except for the first card\n"+h;
    }

    public String revealString()
    {
        String h="";
        for(int x=0; x<dealerHand.getSize(); x++){
            h += ((getDHand())).getCardValueHand(x) +"\n"; //maybe might work?
        }
        return "Dealer's Card \n"+h;
    }

    public void start()
    {
        Scanner scan=new Scanner(System.in);
        int round=0;
        while(p1.getChips()>0)
        {

            round++;
            boolean player=false;
            boolean dealer=false;
            boolean playerTurn=true;
            System.out.println("ROUND "+round);
            System.out.println("Current chips: "+p1.getChips());
            p1.getHand().resetHand();
            getDHand().resetHand();
            while(player==false && dealer==false)
            {
                System.out.println("How many chips do you wanna bet?");
                int tempChip=scan.nextInt();
                if(tempChip>p1.getChips())
                {
                    System.out.println("Insufficient amount...please enter an amount that is less or equal to "+p1.getChips());
                    tempChip=scan.nextInt();
                }
                (p1.getHand()).hit(selectCard());
                (p1.getHand()).hit(selectCard());
                (getDHand()).hit(selectCard());
                (getDHand()).hit(selectCard());
                System.out.println(toString());
                System.out.println(p1);
                if(p1.getHand().blackjack())
                {
                    if(getDHand().lastCard().getCardValue()==10)
                    {
                        if(getDHand().blackjack())
                        {
                            System.out.println("PUSH, it is a tie");
                            player=true;
                            dealer=true;
                        }
                        else
                        {
                            System.out.println("YAY, you won because you have a black jack and the dealer does not");
                            p1.setChips(p1.getChips()+tempChip);
                            System.out.println("New chips number: "+p1.getChips());
                            player=true;
                        }
                    }
                    else if(getDHand().lastCard().isAce())
                    {
                        System.out.println("Do you want to buy insurance?");
                        String insurance=scan.next();
                        if(insurance.equals("yes")||insurance.equals("Yes"))
                        {
                            System.out.println("How much insurance do you want? (up to half of what you bet");
                            int newInsurance=scan.nextInt();

                            if(getDHand().blackjack())
                            {
                                System.out.println("YAY you won because both you and the dealer have black Jack");
                                p1.setChips(p1.getChips()+tempChip+(2*newInsurance));
                                System.out.println("New number of chips: "+p1.getChips());
                                player=true;
                            }
                            else
                            {
                                p1.setChips(p1.getChips()-newInsurance);
                            }
                        }

                    }

                }
                else
                {
                    if(getDHand().lastCard().getCardValue()==10)
                    {
                        if(getDHand().blackjack())
                        {
                            System.out.println("SORRY you lost because you don't have black jack but the dealer does.");
                            p1.setChips(p1.getChips()-tempChip);
                            System.out.println("New number of chips: "+p1.getChips());
                            dealer=true;
                        }
                    }
                    else if(getDHand().lastCard().isAce())
                    {
                        System.out.println("Do you want to buy insurance?");
                        String insurance=scan.next();
                        if(insurance.equals("yes")||insurance.equals("Yes"))
                        {
                            System.out.println("How much insurance do you want? (up to half of what you bet)");
                            int newInsurance=scan.nextInt();

                            if(getDHand().blackjack())
                            {
                                System.out.println("Round ends...U LOST");
                                p1.setChips(p1.getChips()-tempChip+(2*newInsurance));
                                dealer=true;
                            }
                            else
                            {
                                p1.setChips(p1.getChips()-newInsurance);
                                System.out.println("New amount of chips: "+p1.getChips());
                            }

                        }

                    }

                }
                if(!player && !dealer)
                {
                    System.out.println("Do you want double down?");
                    String doubleDown=scan.next();
                    if(doubleDown.equals("yes"))
                    {
                        tempChip=p1.doubleDown(tempChip);
                        System.out.println("New betting amount: "+tempChip);
                        p1.getHand().hit(selectCard());
                        System.out.println(p1);
                        if(p1.getHand().bust())
                        {
                            System.out.println("Sorry you lost, you busted.");
                            p1.setChips(p1.getChips()-tempChip);
                            dealer=true;
                        }
                        playerTurn=false;
                    }
                }

                while(!p1.getHand().bust() &&!getDHand().bust()&& !player && !dealer)                
                {
                    String command="";

                    if(playerTurn)
                    {
                        System.out.println("This is your card: \n"+p1);
                        System.out.println("Please print your command");
                        command=scan.next();
                        takeInOrder(command);
                        System.out.println("Your order was "+command+":\n"+p1);
                        if(p1.fiveCharlie()||p1.getHand().getValue()==21)
                        {
                            if(getDHand().blackjack())
                            {
                                System.out.println("SORRY you lost...although you have five hand charlie or total value of 21, the dealer has black jack");
                                p1.setChips(p1.getChips()-tempChip);
                                dealer=true;
                            }
                            System.out.println("YAY you won...you have five card charlie or a total value of 21");
                            p1.setChips(p1.getChips()+tempChip);
                            player=true;
                        }

                        playerTurn=false;

                    }
                    if(!playerTurn)
                    {                  
                        yesOrNo();
                        System.out.println(revealString());
                        if(getDHand().getValue()>21)
                        {
                            System.out.println("YAY you won...the dealer busted");
                            p1.setChips(p1.getChips()+tempChip);
                            player=true;
                        }
                        if(command.equals("stand"))
                        {
                            playerTurn=false;

                        }
                        else
                        {
                            playerTurn=true;
                        }
                    }
                    if(!player && !dealer)
                    {
                        if(command.equals("stand") &&!yesOrNo())
                        {
                            System.out.println("CHECKING..."+p1.getHand().getValue());
                            System.out.println("CHECKING..."+getDHand().getValue());
                           if(p1.getHand().getValue() == getDHand().getValue()){
                                System.out.println("PUSH...you and the dealer has the same value");
                                player=true;
                                dealer=true;
                            }
                            else if(p1.getHand().getValue() <getDHand().getValue()){
                                System.out.println("SORRY you lost, both of you stood but dealer has a higher hand ");
                                p1.setChips(p1.getChips()-tempChip);
                                dealer=true;
                            }
                            else 
                            {
                                System.out.println("YAY you won, both of you stood but you have a higher hand");
                                p1.setChips(p1.getChips()+tempChip);
                                player=true;
                            }

                        }
                    }
                    if(!player && !dealer)
                    {
                        if(p1.getHand().getValue()>21)
                        {

                            p1.setChips(p1.getChips()-tempChip);
                            System.out.println("SORRY you lost, you busted ");
                            dealer=true;
                        }
                        else if(getDHand().getValue()>21)
                        {
                            System.out.println("YAY you won, the dealer busted");
                            p1.setChips(p1.getChips()+tempChip);
                            player=true;
                        }
                    }

                }
            }

        }
       
       

    }
}

