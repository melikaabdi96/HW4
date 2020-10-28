package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
/**
 * this class call methods and run program.
 * @author Melika
 * @version 2020
 */

public class Main {
    private static Scanner input;
    private static VotingSystem votingSystem;

    public static void main(String[] args) {
        String in[];


        Voting classVoting = new Voting(1,"Select the options that you prefer for the makeup class's time :");
        Voting examVoting = new Voting(0,"Select one day for exam's day : ");

        VotingSystem votingSystem = new VotingSystem();
        votingSystem.addVoting(classVoting);
        votingSystem.addVoting(examVoting);

        JalaliCalendar jalaliCalendar = new JalaliCalendar();


        input = new Scanner(System.in);

        do {
            System.out.println("Enter your first name : ");
            String firestname = input.nextLine();

            System.out.println("Enter your last name : ");
            String lastname = input.nextLine();

            Person person = new Person(firestname, lastname);

            printOperations();
            String operation = input.nextLine();
            in = operation.split(" ");

            //checking the first word of input
            switch (in[0]) {
                //contact should become firt
                case "class": {
                    switch (in[1]) {
                        //add contact
                        case "a": {
                            Vote vote = new Vote(person, jalaliCalendar.getDateByDiff(0));
                            System.out.println("Choose :");
                            System.out.println("9:11 13:15 15:17 17:19");
                            String choise = input.nextLine();
                            ArrayList<String> myVote = new ArrayList<>();
                            String[] myChoise = choise.split(" ");
                            for (int x = 0 ; x < myChoise.length; x++) {
                                myVote.add(myChoise[x]);
                            }
                            classVoting.vote(vote, myVote);

                            break;
                        }
                        case "b": {
                            System.out.println(classVoting.getVoters());
                            break;
                        }
                        case "c": {
                            System.out.println(classVoting.getChoices());
                            break;

                        }
                        case "d": {
                            classVoting.printvotes();
                            break;
                        }
                        case "e": {
                            System.out.println("Enter your new choice :");
                            String newChoice = input.nextLine();
                            classVoting.createPoll(newChoice);
                            System.out.println("done!");
                            break;
                        }
                    }
                }break;
                case "exam": {
                    switch (in[1]) {
                        case "a": {
                            Vote vote = new Vote(person, jalaliCalendar.getDateByDiff(0));
                            System.out.println("Choose :");
                            System.out.println("monday tuesday wednseday Friday");
                            String choise = input.nextLine();
                            ArrayList<String> myVote = new ArrayList<>();
                            String[] myChoise = choise.split(" ");
                            for (int x= 0; x < myChoise.length; x++) {
                                myVote.add(myChoise[x]);
                            }
                            examVoting.vote(vote, myVote);

                            break;
                        }
                        case "b": {
                            System.out.println(examVoting.getVoters());
                            break;
                        }
                        case "c": {
                            System.out.println(examVoting.getChoices());
                            break;

                        }
                        case "d": {
                            examVoting.printvotes();
                            break;
                        }
                        case "e": {
                            System.out.println("Enter your new choice :");
                            String newChoice = input.nextLine();
                            examVoting.createPoll(newChoice);
                            break;
                        }
                        case "f": {
                            if (examVoting.getType() == 0) {
                                Vote vote = new Vote(person, jalaliCalendar.getDateByDiff(0));
                                Random random = new Random();
                                String cases = "Monday tuesday wednseday Friday";
                                int r = random.nextInt(4);
                                ArrayList<String> myVote = new ArrayList<>();
                                String[] myChoise = cases.split(" ");
                                myVote.add(myChoise[r]);
                                System.out.println(myChoise[r]);
                                classVoting.vote(vote, myVote);
                            }
                                break;
                        }
                    }
                }break;
                case "other": {
                    switch (in[1]){
                        case "a": {
                            System.out.println("Enter voting's question :");
                            String question = input.nextLine();
                            System.out.println("Enter voting's type");
                            int type = input.nextInt();
                            votingSystem.removeVoting(type, question);
                            break;
                        }
                        case "b":{
                            System.out.println("Enter voting's question :");
                            String question = input.nextLine();
                            System.out.println("Enter voting's type");
                            int type = input.nextInt();
                            votingSystem.createVoting(type, question);
                            break;
                        }
                        case "c":{
                            votingSystem.printVoting();
                            break;
                        }
                    }
                }break;
                case "exit": {
                    break;
                }
                default:
                    return;
            }
        } while (!Objects.equals(in[0], "exit"));

    }

    private static void printOperations() {
        System.out.println("Enter class or exam if you want vote and choose one of below operations");
        System.out.println("class: \n a)vote b)voters c)choices d)votes e)new choice");
        System.out.println("exam: \n a)vote b)voters c)choices d)votes e)new choice f)random");
        System.out.println("other: \n a)remove a voting b)add a voting c)all votings ");
        System.out.println("exit");
    }
    // write your code here
}
