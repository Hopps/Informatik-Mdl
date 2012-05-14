/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datenstrukturen;

/**
 *
 * @author Bluekey
 */
public class BinSuchBaum<Integer> extends BinBaum{
    public BinSuchBaum()
    {
        super();
    }

    public BinSuchBaum(Integer pInhalt)
    {
        super(pInhalt);
    }

    public void fuegeEin(int pInhalt){
        if(this.inhalt()==null)
            this.setzeInhalt(pInhalt);
        else if((int)pInhalt<(int)this.inhalt()){
            if(this.linkerTeilbaum()==null){
                this.setzeLinks(new BinSuchBaum(pInhalt));
            }
            else {
                ((BinSuchBaum)linkerTeilbaum()).fuegeEin(pInhalt);
            }
        } else {
            if(this.rechterTeilbaum()==null){
                this.setzeRechts(new BinSuchBaum(pInhalt));
            }
            else {
                ((BinSuchBaum)rechterTeilbaum()).fuegeEin(pInhalt);
            }
        }
    }
}
