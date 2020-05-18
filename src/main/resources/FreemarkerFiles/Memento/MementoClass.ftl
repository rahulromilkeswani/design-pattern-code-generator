package Output;
public class ${classModel.className}{
    private String state;
    public ${classModel.interfaceName} create${classModel.interfaceName}(){
        ${classModel.interfaceName} ${classModel.interfaceName?uncap_first} = new ${classModel.interfaceName}();
        ${classModel.interfaceName?uncap_first}.setState(state);
        return ${classModel.interfaceName?uncap_first};
    }
    void restore(${classModel.interfaceName} ${classModel.interfaceName?uncap_first}){
        state = ${classModel.interfaceName?uncap_first}.getState();
    }
    public String getState(){
        return state;
    }
    void setState(String state){
        this.state = state;
    }
    public class ${classModel.interfaceName}{
        private String state;
        private String getState(){
            return state;
        }
        void setState(String state){
        this.state = state;
        }
    }
}