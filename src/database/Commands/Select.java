package database.Commands;

import database.Classes.DatabaseClass;
import database.utilities.ClassesContainer;
import database.utilities.ExpressionEvaluator;
import database.utilities.OutputManager;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;

/**
 * Created by Kevin on 3/25/2017.
 */
public class Select implements Command{
    private String searchKey;
    private String fromKey;
    private ClassesContainer container;
    private String expression;
    private ExpressionEvaluator evaluator;
    protected HashSet<DatabaseClass> classes;
    private OutputManager outputManager;

    public Select(ClassesContainer container) {
        this.container = container;
    }

    public Select(String expression) {
        this.expression = expression;
        this.evaluator = new ExpressionEvaluator(expression);
        this.outputManager = new OutputManager();
    }

    @Override
    public void executeCommand() {
        try {
            classes = evaluator.getRecords();
        } catch (InvocationTargetException | IllegalAccessException e) {
            System.err.println("An error occurred while executing your select command due to: " + e.getMessage());
        }
    }

    @Override
    public void returnResults() {
        try {
            for (DatabaseClass databaseClass : classes) {
                outputManager.displayFullRecord(databaseClass);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("Error while outputing results due to: " + e.getMessage());
        }
    }
}
