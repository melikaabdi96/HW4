package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
/**
 * this class holds information about a voting.
 * @author Melika
 * @version 2020
 */

public class Voting {
    private  int type;
    private String question;
    private ArrayList<Person> voters;
    private HashMap<String, HashSet<Vote>> choices;
    private int count;

    /*private HashSet<Vote> hashSet;
    private ArrayList<String> candidate;*/

    /**
     *
     * @param type voting's type
     * @param question voting's question
     */
    public Voting(int type, String question){
        this.type = type;
        this.question = question;
        this.voters = new ArrayList<>();
        this.choices = new HashMap<>();
        this.count = 0;

    }

    //setter
    public void setQuestion(String question) {
        this.question = question;
    }

    //getter
    public String getQuestion() {
        return question;
    }

    //getter
    public int getType() {
        return type;
    }
    //counter
    public void counter(){
        count += 1;
    }

    /**
     * add a new choice to voting
     * @param choice
     */
    public void createPoll(String choice){
        HashSet<Vote> h = new HashSet<>();
        if (!choices.containsKey(choice)){
            choices.putIfAbsent(choice,h);
        }
        //choices.computeIfAbsent(choice, getChoices().Function<? super String, ? extends HashSet<Vote>>) new HashSet<Vote>());
    }

    /**
     * register a vote
     * @param vote
     * @param myVote
     */
    public void vote (Vote vote, ArrayList<String> myVote){
            if (this.type == 1){
                    for(String choice : myVote){
                        if (choices.keySet().contains(choice)){
                            choices.get(choice).add(vote);}
                        if(!voters.contains(vote.getPerson())) {
                            voters.add(vote.getPerson());
                        }
                    }
                } else if (this.type == 0){
                if (myVote.size() == 1) {
                    for (String choice : myVote) {
                        if (choices.keySet().contains(choice)) {
                            choices.get(choice).add(new Vote(vote.getPerson(), vote.getDate()));
                        }
                        if (!voters.contains(vote.getPerson())) {
                            voters.add(vote.getPerson());
                        }
                    }

                }else{
                    System.out.println("just one!");
                }

            }
    }

    //getter
    public ArrayList<Person> getVoters() {
        return voters;
    }

    //getter
    public HashMap<String, HashSet<Vote>> getChoices() {
        return choices;
    }

    public void printvotes(){
        for (Map.Entry<String, HashSet<Vote>> poll : choices.entrySet()){
            System.out.println (poll);
            System.out.println();
        }
    }


}
