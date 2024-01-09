package ownable;

import items.Item;

abstract public class Ownable {
    private String name;
    @Override
    public String toString(){
        return this.getName()+" of "+this.getClass();
    }
    @Override
    public int hashCode(){
        if(name != null){
            return 17 * name.hashCode();
        }else {
            return 0;
        }
    }

    public Ownable(String n) {
        this.name = n;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Ownable own =(Ownable) o;
        if(this.name.equals(own.name)
                &&this.hashCode()==own.hashCode()){
                return true;
            }
        return false;
    }

}
