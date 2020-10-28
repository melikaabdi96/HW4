package com.company;

/**
 * this class holds first name and last name of voters.
 * @author Melika
 * @version 2020
 */
public class Person {
    private String firstname;
    private String lastname;

    /**
     *
     * @param firstname voter's first name
     * @param lastname voter's last name
     */
    public Person(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    //getter
    public String getFirstname() {


        return firstname;
    }

    //getter
    public String getLastname() {

        return lastname;
    }

    //setter
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    //setter
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return first name and last name
     */
    public String toString(){
        return "first name : " + firstname + " "+ "last name : " + lastname;
    }
}
