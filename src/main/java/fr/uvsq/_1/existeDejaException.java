package fr.uvsq._1;

public class existeDejaException extends Exception{

    /**
     * id de l'exeption
     */
    private static final long serialVersionUID = 3931273041226247298L;
    
    public existeDejaException() {
        super("l'objet existe deja");
    }
}
