/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datenstrukturen;

/**
 * @author merlin
 */
public class Liste{
    
    private Knoten hatBug;          // Die beiden werden Sentinels genannt, enthalten
    private Knoten hatHeck;         // keine Daten und erleichtern Anfügen und Löschen.
    private Knoten kenntAktuell;    // Markierung für aktuellen Knoten
    private int zAnzahl = 0;            // Anzahl der Knoten (ohne Sentinels)
    
    
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
    
    public Object aktuellesElement()
    {
        return kenntAktuell.inhalt();
    }
    
    public int laenge()
    {
        return zAnzahl;
    }
    
    public void fuegeDavorEin(Object pInhalt)
    {
        Knoten lKnoten = new Knoten(pInhalt);
        kenntAktuell.getVorgaenger().setNachfolger(lKnoten);
        lKnoten.setVorgaenger(kenntAktuell.getVorgaenger());
        kenntAktuell.setVorgaenger(lKnoten);
        lKnoten.setNachfolger(kenntAktuell);
        zAnzahl++;
    }
    
    public void fuegeDahinterEin(Object pInhalt)
    {
        Knoten lKnoten = new Knoten(pInhalt);
        kenntAktuell.getNachfolger().setVorgaenger(lKnoten);
        lKnoten.setVorgaenger(kenntAktuell);
        lKnoten.setNachfolger(kenntAktuell.getNachfolger());
        kenntAktuell.setNachfolger(lKnoten);
        zAnzahl++;
    }
    
    public void haengeAn(Object pInhalt)
    {
        Knoten lKnoten = new Knoten(pInhalt);
        hatHeck.getVorgaenger().setNachfolger(lKnoten);
        lKnoten.setVorgaenger(hatHeck.getVorgaenger());
        lKnoten.setNachfolger(hatHeck);
        hatHeck.setVorgaenger(lKnoten);
        this.zumAnfang();
        zAnzahl++;
    }
    
    public void entferneAktuell()
    {
        if ( kenntAktuell != hatBug && kenntAktuell != hatHeck )
        {
            Knoten lVorgaenger = kenntAktuell.getVorgaenger();
            Knoten lNachfolger = kenntAktuell.getNachfolger();
            lVorgaenger.setNachfolger(lNachfolger);
            lNachfolger.setVorgaenger(lVorgaenger);
            this.zumAnfang();
            zAnzahl--;
        }
    }
}