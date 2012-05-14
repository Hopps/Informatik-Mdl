/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datenstrukturen;

/**
 * @author merlin
 */
public class Liste<Datentyp> {
    
    private Knoten<Datentyp> hatBug;          // Die beiden werden Sentinels genannt, enthalten
    private Knoten<Datentyp> hatHeck;         // keine Daten und erleichtern Anfügen und Löschen.
    private Knoten<Datentyp> kenntAktuell;    // Markierung für aktuellen Knoten
    private int zAnzahl;            // Anzahl der Knoten (ohne Sentinels)
    
    
    public Liste()
    {
        hatBug = new Knoten();
        hatHeck = new Knoten();
        hatBug.setNachfolger(hatHeck);
        hatHeck.setVorgaenger(hatBug);
        kenntAktuell = hatBug;
        zAnzahl = 0;
    }
    
    public void zumAnfang()
    {
        if ( zAnzahl > 0)
        {
            kenntAktuell = hatBug.getNachfolger();
        }
        else
        {
            kenntAktuell = hatBug;
        }
    }
    
    public void zumEnde()
    {
        if ( zAnzahl > 0)
        {
            kenntAktuell = hatHeck.getVorgaenger();
        }
        else
        {
            kenntAktuell = hatHeck;
        }
    }
    
    public void vor()
    {
        if ( kenntAktuell != hatHeck )
        {
            kenntAktuell = kenntAktuell.getNachfolger();
        }
    }
    
    public void zurueck()
    {
        if ( kenntAktuell != hatBug )
        {
            kenntAktuell = kenntAktuell.getVorgaenger();
        }
    }
    
    public Datentyp aktuellesElement()
    {
        return kenntAktuell.inhalt();
    }
    
    public int laenge()
    {
        return zAnzahl;
    }
    
    public void fuegeDavorEin(Datentyp pInhalt)
    {
        Knoten<Datentyp> lKnoten = new Knoten(pInhalt);
        kenntAktuell.getVorgaenger().setNachfolger(lKnoten);
        lKnoten.setVorgaenger(kenntAktuell.getVorgaenger());
        kenntAktuell.setVorgaenger(lKnoten);
        lKnoten.setNachfolger(kenntAktuell);
        zAnzahl++;
    }
    
    public void fuegeDahinterEin(Datentyp pInhalt)
    {
        Knoten<Datentyp> lKnoten = new Knoten(pInhalt);
        kenntAktuell.getNachfolger().setVorgaenger(lKnoten);
        lKnoten.setVorgaenger(kenntAktuell);
        lKnoten.setNachfolger(kenntAktuell.getNachfolger());
        kenntAktuell.setNachfolger(lKnoten);
        zAnzahl++;
    }
    
    public void haengeAn(Datentyp pInhalt)
    {
        Knoten<Datentyp> lKnoten = new Knoten(pInhalt);
        hatHeck.getVorgaenger().setNachfolger(lKnoten);
        lKnoten.setVorgaenger(hatHeck.getVorgaenger());
        lKnoten.setNachfolger(hatHeck);
        hatHeck.setVorgaenger(lKnoten);
        zAnzahl++;
    }
    
    public void entferneAktuell()
    {
        if ( kenntAktuell != hatBug && kenntAktuell != hatHeck )
        {
            kenntAktuell.getVorgaenger().setNachfolger(kenntAktuell.getNachfolger());
            kenntAktuell.getNachfolger().setVorgaenger(kenntAktuell.getVorgaenger());
            zAnzahl--;
        }
    }
}