package datenstrukturen;

/**
 * @author merlin
 */
public class Knoten{

    private Object zInhalt;
    private Knoten kenntNachfolger = null;
    private Knoten kenntVorgaenger = null;

    public Knoten(){

    }

    public Knoten(Object pInhalt) {
        zInhalt = pInhalt;
    }

    public void setVorgaenger(Knoten pVorgaenger) {
        kenntVorgaenger = pVorgaenger;
    }

    public Knoten getVorgaenger() {
        return kenntVorgaenger;
    }

    public void setNachfolger(Knoten pNachfolger) {
        kenntNachfolger = pNachfolger;
    }

    public Knoten getNachfolger() {
        return kenntNachfolger;
    }

    public Object inhalt() {
        return zInhalt;
    }

    public void setInhalt(Object pInhalt) {
        zInhalt = pInhalt;
    }
}
