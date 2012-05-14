package datenstrukturen;

import datenstrukturen.Liste;

public class SortierListe extends Liste {

        public SortierListe() {
            super();
        }

        public void quicksort() {
            SortierListe lLinkeListe = new SortierListe();
            SortierListe lRechteListe = new SortierListe();
            Integer pivot = null;
            if (this.laenge() > 0) {
                this.zumAnfang();
                pivot = (Integer) this.aktuellesElement();
                this.entferneAktuell(); // Pivot raus
                while (this.laenge() > 0) {
                    this.zumAnfang();
                    if ((Integer) this.aktuellesElement() < pivot) {
                        lLinkeListe.haengeAn(this.aktuellesElement());
                        this.entferneAktuell();
                    } else if ((Integer) this.aktuellesElement() >= pivot) {
                        lRechteListe.haengeAn(this.aktuellesElement());
                        this.entferneAktuell();
                    }
                }
            }
            if (lLinkeListe.laenge() > 0) {
                lLinkeListe.quicksort();
            }
            if (lRechteListe.laenge() > 0) {
                lRechteListe.quicksort();
            }
            while (lLinkeListe.laenge() > 0) {
                lLinkeListe.zumAnfang();
                this.haengeAn(lLinkeListe.aktuellesElement());
                lLinkeListe.entferneAktuell();
            }
            if (pivot != null) {
                this.haengeAn(pivot);
            }
            while (lRechteListe.laenge() > 0) {
                lRechteListe.zumAnfang();
                this.haengeAn(lRechteListe.aktuellesElement());
                lRechteListe.entferneAktuell();
            }
        }
    }