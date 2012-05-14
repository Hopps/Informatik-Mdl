package datenstrukturen;

/**
 * @author merlin
 */
public class Knoten<Datentyp> {

    private Datentyp zInhalt;
    private Knoten kenntNachfolger = null;
    private Knoten kenntVorgaenger = null;

    public Knoten(){

    }

    public Knoten(Datentyp pInhalt) {
        zInhalt = pInhalt;
    }

    public void setVorgaenger(Knoten<Datentyp> pVorgaenger) {
        kenntVorgaenger = pVorgaenger;
    }

    public Knoten<Datentyp> getVorgaenger() {
        return kenntVorgaenger;
    }

    public void setNachfolger(Knoten<Datentyp> pNachfolger) {
        kenntNachfolger = pNachfolger;
    }

    public Knoten<Datentyp> getNachfolger() {
        return kenntNachfolger;
    }

    public Datentyp inhalt() {
        return zInhalt;
    }

    public void setInhalt(Datentyp pInhalt) {
        zInhalt = pInhalt;
    }
}
