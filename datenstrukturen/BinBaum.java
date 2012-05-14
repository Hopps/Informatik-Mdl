package datenstrukturen;

/**
 *
 * @author merlin
 */
public class BinBaum<Datentyp> {
    
    private BinBaum<Datentyp> linkerTB = null;
    private BinBaum<Datentyp> rechterTB = null;
    private Datentyp zInhalt = null;
    
    public BinBaum()
    {
    }
    
    public BinBaum(Datentyp pInhalt)
    {
        zInhalt = pInhalt;
    }
    
    public void setzeLinks(BinBaum pLinks)
    {
        linkerTB = pLinks;
    }
    
    public void setzeRechts(BinBaum pRechts)
    {
        rechterTB = pRechts;
    }
    
    public BinBaum<Datentyp> linkerTeilbaum()
    {
        return linkerTB;
    }
    
    public BinBaum<Datentyp> rechterTeilbaum()
    {
        return rechterTB;
    }
    
    public boolean istBlatt()
    {
        return ( linkerTB == null && rechterTB == null );
    }
    
    public Datentyp inhalt()
    {
        return zInhalt;
    }
    
    public void setzeInhalt(Datentyp pInhalt)
    {
        zInhalt = pInhalt;
    }
    
    public boolean istLeer()
    {
        return ( zInhalt == null );
    }
}
