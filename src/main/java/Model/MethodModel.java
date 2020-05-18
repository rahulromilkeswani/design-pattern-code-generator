package Model;

//defines a methodModel which is a part of the classModel
public class MethodModel {
    private String methodName;
    private String methodReturnType;

    public MethodModel(String methodName, String methodReturnType) {
        this.methodName = methodName;
        this.methodReturnType = methodReturnType;
    }

    public String getName() {
        return methodName;
    }

    public String getType() {
        return methodReturnType;
    }
}
