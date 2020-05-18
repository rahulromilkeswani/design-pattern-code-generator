package Model;

import java.util.List;

//ClassModel used by the FreeMarker generator to generate source files
public class ClassModel {
    private String className;
    private List<FieldModel> fieldsList;
    private List<MethodModel> methodsList;
    private String interfaceName;

    public ClassModel(String className, List<FieldModel> fieldsList, List<MethodModel> methodsList) {
        this.className = className;
        this.fieldsList = fieldsList;
        this.methodsList = methodsList;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getClassName() {
        return className;
    }

    public List<FieldModel> getFieldsList() {
        return fieldsList;
    }

    public List<MethodModel> getMethodsList() {
        return methodsList;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

}
