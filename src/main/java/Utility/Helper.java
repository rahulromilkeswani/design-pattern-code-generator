package Utility;

//contains string manipulation methods to fit to the input form
public class Helper {
    public static String toMemberString(String input) {
        return input + " " + input;
    }

    public static String toParentString(String parent1, String parent2) {
        return parent1 + "," + parent2;
    }

    public static String toFieldString(String fieldName, String fieldType) {
        return fieldName + " " + fieldType;
    }
}
