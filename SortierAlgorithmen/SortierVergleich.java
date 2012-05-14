/*
 * Hier sind die verschiedenen Sortieralgorithmen implementiert.
 * Darüber hinaus werden sie bezüglich der Laufzeit verglichen.
 */
package SortierAlgorithmen;

import datenstrukturen.Liste;
import java.util.Random;

/**
 *
 * @author merlin
 */
public class SortierVergleich {

    public static void main(String[] args) {
        SortierVergleich s = new SortierVergleich();
        s.testeSortierverfahren();
    }
    private int zN = 9;
    private int[] zufallsZahlen;
    private Random hatRandom;
    private Stoppuhr hatUhr;

    public SortierVergleich() {
        zufallsZahlen = new int[zN];
        hatRandom = new Random();
        for (int i = 0; i < zN; i++) {
            zufallsZahlen[i] = hatRandom.nextInt(zN);
        }
        hatUhr = new Stoppuhr();
    }

    public void testeSortierverfahren() {
        System.out.println("BubbleSort: ");
        hatUhr.start();
        int[] lZahlenBubbleSort = this.bubbleSort(zufallsZahlen);
        hatUhr.stop();
        if (this.istSortiert(lZahlenBubbleSort)) {
            System.out.println("Funktioniert! Zeit: " + hatUhr.zeit() + "ms");
        } else {
            System.out.println("Kaputt!");
        }
        hatUhr.reset();
        
        
        hatUhr = new Stoppuhr();
        SortierListe lListe = new SortierListe();
        for ( int i = 0; i <= zufallsZahlen.length-1; i++)
        {
            lListe.haengeAn(zufallsZahlen[i]);
        }
        System.out.println("Quicksort: ");
        hatUhr.start();
        lListe.quicksort();
        hatUhr.stop();
        int[] lZahlenQuicksort = new int[zufallsZahlen.length];
        for( int i = 0; i < lListe.laenge(); i++ )
        {
            lListe.zumAnfang();
            lZahlenQuicksort[i] = (Integer)lListe.aktuellesElement();
            System.out.println((Integer)lListe.aktuellesElement());
            lListe.entferneAktuell();
        }
        if (this.istSortiert(lZahlenQuicksort)) {
            System.out.println("Funktioniert! Zeit: " + hatUhr.zeit() + "ms");
        } else {
            System.out.println("Kaputt!");
        }
        hatUhr.reset();
        //hfhd
    }

    public boolean istSortiert(int[] pZahlen) {
        boolean lSortiert = true;
        for (int i = 0; i < pZahlen.length - 1; i++) {
            if (pZahlen[i] > pZahlen[i + 1]) {
                lSortiert = false;
            }
        }
        return lSortiert;
    }

    public int[] bubbleSort(int[] pZahlen) {
        for (int i = 0; i < pZahlen.length; i++) {
            for (int j = 0; j < pZahlen.length - 1; j++) {
                if (pZahlen[j] > pZahlen[j + 1]) {
                    int lBuffer = pZahlen[j];
                    pZahlen[j] = pZahlen[j + 1];
                    pZahlen[j + 1] = lBuffer;
                }
            }
        }
        return pZahlen;
    }


    class SortierListe extends Liste {

        public SortierListe() {
            super();
        }

        public void quicksort() {
            SortierListe lLinkeListe = new SortierListe();
            SortierListe lRechteListe = new SortierListe();
            if (this.laenge() > 2) {
                this.zumAnfang();
                Integer pivot = (Integer) this.aktuellesElement();
                this.entferneAktuell(); // Pivot raus
                while (this.laenge() > 0) {
                    this.zumAnfang();
                    if ((Integer) this.aktuellesElement() <= pivot) {
                        lLinkeListe.haengeAn(this.aktuellesElement());
                        this.entferneAktuell();
                    } else if ((Integer) this.aktuellesElement() <= pivot) {
                        lRechteListe.haengeAn(this.aktuellesElement());
                        this.entferneAktuell();
                    }
                }
                if (lLinkeListe.laenge() > 0) {
                    lLinkeListe.quicksort();
                }
                if (lRechteListe.laenge() > 0) {
                    lRechteListe.quicksort();
                }
                while ( lLinkeListe.laenge() > 0)
                {
                    lLinkeListe.zumAnfang();
                    this.haengeAn(lLinkeListe.aktuellesElement());
                    lLinkeListe.entferneAktuell();
                }
                this.haengeAn(pivot);
                while ( lRechteListe.laenge() > 0)
                {
                    lRechteListe.zumAnfang();
                    this.haengeAn(lRechteListe.aktuellesElement());
                    lRechteListe.entferneAktuell();
                }
            }
        }
    }
}