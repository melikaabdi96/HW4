package com.company;

import javax.management.StringValueExp;
import java.util.ArrayList;
/**
 * this class holds list of votings.
 * @author Melika
 * @version 2020
 */
public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem(){

        this.votingList = new ArrayList<>();
    }

    /**
     * create a new voting
     * @param type voting's type
     * @param question voting's question
     */
    public void createVoting(int type, String question){
        Voting voting = new Voting(type,question);
        if (votingList.contains(voting)){
            votingList.add(voting);
        }else
            System.out.println("not found!");
    }

    //getter
    public void getVotingList() {
        for (int x = 0; x < votingList.size(); x++){
            votingList.get(Integer.parseInt(getVoting().getQuestion()));
        }
    }

    //getter
    public Voting getVoting(){
        for (Voting voting : votingList){
            return voting;
        }
        return null;
    }

    //printer
    public void printVoting() {
        for(Voting voting : votingList){
            System.out.println(voting);
        }
    }

    /**
     * remove a voting
     * @param type voting's type
     * @param question voting's question
     */
   public void removeVoting(int type, String question){
        Voting voting = new Voting(type,question);
        if (votingList.contains(voting)){
            votingList.remove(voting);
        }else
            System.out.println("not found!");
   }

    /**
     * add a voting
     * @param voting
     */
   public void addVoting(Voting voting){
        if (!votingList.contains(voting)){
            votingList.add(voting);
        }
   }
}
