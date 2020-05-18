package Output;
public abstract class ${classModel.className}{
    public ${classModel.className}(){}
    public abstract void interpret(<#list classModel.fieldsList as field>${field.type} ${field.name?uncap_first}</#list>);
    public boolean add(${classModel.className} e){
        return false;
    }

}