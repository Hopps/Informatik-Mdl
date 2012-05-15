/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datenstrukturen;

/**
 *
 * @author Bluekey
 */
public class BinSuchBaum<Integer> extends BinBaum {

    public BinSuchBaum() {
        super();
    }

    public BinSuchBaum(Integer pInhalt) {
        super(pInhalt);
    }

    public void fuegeEin(int pInhalt) {
        if (this.inhalt() == null) {
            this.setzeInhalt(pInhalt);
        } else if ((int) pInhalt < (int) this.inhalt()) {
            if (this.linkerTeilbaum() == null) {
                this.setzeLinks(new BinSuchBaum(pInhalt));
                this.linkerTeilbaum().setzeVater(this);
            } else {
                ((BinSuchBaum) linkerTeilbaum()).fuegeEin(pInhalt);
            }
        } else {
            if (this.rechterTeilbaum() == null) {
                this.setzeRechts(new BinSuchBaum(pInhalt));
                this.rechterTeilbaum().setzeVater(this);
            } else {
                ((BinSuchBaum) rechterTeilbaum()).fuegeEin(pInhalt);
            }
        }
    }

    public void loesche(int pInhalt) {
        if ((int) this.inhalt() != pInhalt) {
            if (this.linkerTeilbaum() != null) {
                ((BinSuchBaum) this.linkerTeilbaum()).loesche(pInhalt);
            }
            if (this.rechterTeilbaum() != null) {
                ((BinSuchBaum) this.rechterTeilbaum()).loesche(pInhalt);
            }
        } else if ((int) this.inhalt() == pInhalt) {
            if (this.istBlatt()) {
                this.setzeInhalt(null);
                if (this.vater().rechterTeilbaum() == this) {
                    this.vater().setzeRechts(null);
                }
                if (this.vater().linkerTeilbaum() == this) {
                    this.vater().setzeLinks(null);
                }
            } else if (this.linkerTeilbaum() != null && this.rechterTeilbaum() == null) {
                this.setzeInhalt(this.linkerTeilbaum().inhalt());
                this.setzeRechts(this.linkerTeilbaum().rechterTeilbaum());
                this.rechterTeilbaum().setzeVater(this);
                this.setzeLinks(this.linkerTeilbaum().linkerTeilbaum());
                this.linkerTeilbaum().setzeVater(this);
            } else if (this.rechterTeilbaum() != null && this.linkerTeilbaum() == null) {
                this.setzeInhalt(this.rechterTeilbaum().inhalt());
                this.setzeLinks(this.rechterTeilbaum().linkerTeilbaum());
                this.linkerTeilbaum().setzeVater(this);
                this.setzeRechts(this.rechterTeilbaum().rechterTeilbaum());
                this.rechterTeilbaum().setzeVater(this);
            } else if (this.rechterTeilbaum() != null && this.linkerTeilbaum() != null) {
                BinBaum lRechts = this.rechterTeilbaum();
                this.setzeInhalt(this.linkerTeilbaum().inhalt());
                this.setzeRechts(this.linkerTeilbaum().rechterTeilbaum());
                this.rechterTeilbaum().setzeVater(this);
                this.setzeLinks(this.linkerTeilbaum().linkerTeilbaum());
                this.linkerTeilbaum().setzeVater(this);
                BinBaum lTB = this.rechterTeilbaum();
                while (lTB.rechterTeilbaum() != null) {
                    lTB = lTB.rechterTeilbaum();
                }
                lTB.setzeRechts(lRechts);
                lTB.rechterTeilbaum().setzeVater(lTB);
            }
        }
    }
}
