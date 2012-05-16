package datenstrukturen;

public class TestCase {

    BinBaum baum;
    BinSuchBaum sBaum;

    public TestCase() {
    }

    public static void main(String[] args) {
        TestCase tc = new TestCase();
        //tc.erstelleBaum();
        tc.adjama();

    }

    private void erstelleBaum() {
        /*
         * baum = new BinBaum(5); baum.setzeLinks(new BinBaum(4));
         * baum.setzeRechts(new BinBaum(7));
         * baum.linkerTeilbaum().setzeLinks(new BinBaum(8));
         * baum.linkerTeilbaum().setzeRechts(new BinBaum(10));
         * baum.rechterTeilbaum().setzeLinks(new BinBaum(3));
         * baum.linkerTeilbaum().rechterTeilbaum().setzeRechts(new BinBaum(2));
         * System.out.println("Preorder"); preorder(baum);
         * System.out.println("Inorder"); inorder(baum);
         * System.out.println("Postorder");
        postorder(baum);
         */
        sBaum = new BinSuchBaum(5);
        sBaum.fuegeEin(4);
        sBaum.fuegeEin(8);
        sBaum.fuegeEin(10);
        sBaum.fuegeEin(16);
        sBaum.fuegeEin(2);
        sBaum.fuegeEin(9);

        //System.out.println("Preorder");
        //preorder(sBaum);
        System.out.println("Inorder");
        inorder(sBaum);

        sBaum.loesche(10);
        inorder(sBaum);
        //System.out.println("Postorder");
        //postorder(sBaum);

    }

    private void preorder(BinBaum pKnoten) {
        System.out.println(pKnoten.inhalt());
        if (pKnoten.linkerTeilbaum() != null) {
            preorder(pKnoten.linkerTeilbaum());
        }
        if (pKnoten.rechterTeilbaum() != null) {
            preorder(pKnoten.rechterTeilbaum());
        }
    }

    private void inorder(BinBaum pKnoten) {
        if (pKnoten.linkerTeilbaum() != null) {
            inorder(pKnoten.linkerTeilbaum());
        }
        System.out.println(pKnoten.inhalt());
        if (pKnoten.rechterTeilbaum() != null) {
            inorder(pKnoten.rechterTeilbaum());
        }
    }

    private void postorder(BinBaum pKnoten) {
        if (pKnoten.linkerTeilbaum() != null) {
            postorder(pKnoten.linkerTeilbaum());
        }
        if (pKnoten.rechterTeilbaum() != null) {
            postorder(pKnoten.rechterTeilbaum());
        }
        System.out.println(pKnoten.inhalt());
    }

    public void adjama() {
        AdjazenzMatrix a = new AdjazenzMatrix(4);
        a.set(0, 1, 1);
        a.set(0, 3, 1);
        a.set(1, 0, 1);
        a.set(1, 2, 1);
        a.set(2, 2, 1);
        a.set(3, 0, 1);
        a.set(3, 1, 1);
        a.set(3, 2, 1);

        /**int[] nachbar = a.nachbarKnoten(3);
        for (int i = 0; i < nachbar.length; i++) {
            System.out.println(nachbar[i]);
        }*/
        
        a.listeAlleKnoten(0);
    }
}