package Output;
public class ${classModel.className} extends ${classModel.interfaceName}{
    private int state = 0;
    public int getState(){
        return state;
    }
    void setState(int state){
        this.state = state;
        notifyObservers();
    }
}