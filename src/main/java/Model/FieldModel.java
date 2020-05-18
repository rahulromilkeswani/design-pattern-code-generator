package Model;

//Defines a fieldmodel which is a part of the classModel
public class FieldModel {
    private String fieldName;
    private String fieldType;

    public FieldModel(String fieldName, String fieldType) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
    }

    public String getName() {
        return fieldName;
    }

    public String getType() {
        return fieldType;
    }
}
