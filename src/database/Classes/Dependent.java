package database.Classes;


import database.DataStructures.Date;

import java.util.ArrayList;

/**
 * Created by Kevin on 3/2/2017.
 */
public class Dependent extends DatabaseClass{
    private String sex;
    private String name;
    private Date birthDate;
    private ArrayList<Employee> relationships;

    public Dependent(String name, Date birthDate, String sex, Employee relationship) { // forces the constraint that a dependent must have an employee
        setName(name);
        setBirthDate(birthDate);
        setSex(sex);
        relationships = new ArrayList<>();
        addRelationships(relationship);
    }


    public Dependent(String name, Date birthDate, String sex, Employee relationship, int oid) { // forces the constraint that a dependent must have an employee
        super(oid);
        setName(name);
        setBirthDate(birthDate);
        setSex(sex);
        relationships = new ArrayList<>();
        addRelationships(relationship);
    }

    public Dependent() {

    }



    public Dependent(String name, String sex, Employee relationship) {
        this(name, new Date("##/##/####"),"",relationship);
    }

    public Dependent(String name, String sex, Employee relationship,int oid) {
        this(name, new Date("##/##/####"),"",relationship,oid);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return (birthDate != null) ? birthDate.getDate() : "N/A";
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Employee> getRelationships() {
        return relationships;
    }

    public void addRelationships(Employee relationships) {
        this.relationships.add(relationships);
    }
}
