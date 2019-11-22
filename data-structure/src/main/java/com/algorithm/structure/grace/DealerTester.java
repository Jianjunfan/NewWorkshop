package com.algorithm.structure.grace;

import java.util.Scanner;
/**
 * Write a description of class DealerTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DealerTester
{
    public static void main(String []args)
    {
        //test Constructor
        //test getDHand
        //test selectHand
        Player p1=new Player("Grace",100);
        Dealer d1=new Dealer(p1);
        d1.getDHand().hit(d1.selectCard());
        d1.getDHand().hit(d1.selectCard());
        System.out.println(d1);
        System.out.println();
        //test yesOrNo()
        System.out.println("The total value of the card is "+d1.getDHand().getValue());
        d1.yesOrNo();
        System.out.println(d1);
        System.out.println();
        //test takeInOrder
        Scanner scan=new Scanner(System.in);
        System.out.println("Please print your command");
        String command=scan.next();
        d1.takeInOrder(command);
        System.out.println(p1);
        
    }
}
