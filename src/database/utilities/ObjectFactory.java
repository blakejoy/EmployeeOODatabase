package database.utilities;

import database.Classes.DatabaseClass;
import database.Classes.Department;
import database.Classes.Project;

import java.util.HashMap;

/**
 * Created by Kevin on 3/30/2017.
 */
public class ObjectFactory {
    public ObjectFactory() {}

    public static DatabaseClass getObject(String type, HashMap<String, String> attributes) {
        switch (type.toLowerCase()) {
            case "project":
                return createNewProject(attributes);
            case "employee":
                return  createNewEmployee(attributes);
            case "dependent":
                return createNewDependent(attributes);
            case "department":
                return createNewDepartment(attributes);
            default:
                throw new IllegalArgumentException();
        }
    }


    private static DatabaseClass createNewDepartment(HashMap<String, String> attributes) {
        return new Department(attributes.get("name"), attributes.get("number"),attributes.get("location"));
    }

    private static DatabaseClass createNewProject(HashMap<String, String> attributes) {
        return new Project(attributes.get("name"), Integer.parseInt(attributes.get("number")),attributes.get("location"));
    }

    private static DatabaseClass createNewEmployee(HashMap<String, String> attribute) {
        return null; //TODO
    }

    private static DatabaseClass createNewDependent(HashMap<String, String> attribute) {
        return null; //TODO
    }




}
