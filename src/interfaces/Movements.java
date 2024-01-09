package interfaces;

import ownable.locations.abstracts.classes.Loc;

public interface Movements {
    public void run();
    public void go();
    public void goTo(Loc l);


}
