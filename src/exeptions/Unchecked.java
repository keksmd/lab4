package exeptions;

public class Unchecked extends RuntimeException{
    Unchecked(){
        super();
    }
    Unchecked(String m){
        super(m);
    }
}
