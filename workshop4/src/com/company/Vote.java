package com.company;

import ir.huri.jcal.JalaliCalendar;

import java.util.Objects;
/**
 * this class holds person and date of voting.
 * @author Melika
 * @version 2020
 */

public class Vote {
    private Person person;
    private JalaliCalendar date;

    /**
     *
     * @param person a person
     * @param date date
     */
    public Vote(Person person, JalaliCalendar date){
        this.person = person;
        this.date = date;
    }


    //getter
    public Person getPerson() {
        return person;
    }

    //getter
    public JalaliCalendar getDate() {
        return date;
    }

    @Override
    public boolean equals(Object object){
        if(this == object)
            return true;
        if(object == null || object.getClass()!= this.getClass())
            return false;
        Vote vote = (Vote) object;
        return (Objects.equals(vote.person.getFirstname(), this.person.getFirstname()) && Objects.equals(vote.date, this.date));
    }
        //it checks if the argument is of Vote by comparing the classes of this object if(!(obj instanceof Vote)) return false

        //checking if both the object references are referring to the same object

    /**
     *
     * @return date
     */
    public JalaliCalendar hashcode() {
        //comparing
        return date;
    }
}
