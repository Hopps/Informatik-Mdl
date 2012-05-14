package datenstrukturen;

public class TestCase {

    BinBaum baum;

    public TestCase() {

    }

    public static void main(String[] args) {
        TestCase tc = new TestCase();
        tc.erstelleBaum();
    }

    private void erstelleBaum() {
        baum = new BinBaum(5);
        baum.setzeLinks(new BinBaum(4));
        baum.setzeRechts(new BinBaum(7));
        baum.linkerTeilbaum().setzeLinks(new BinBaum(8));
        baum.linkerTeilbaum().setzeRechts(new BinBaum(10));
        baum.rechterTeilbaum().setzeLinks(new BinBaum(3));
        baum.linkerTeilbaum().rechterTeilbaum().setzeRechts(new BinBaum(2));
        System.out.println("Preorder");
        preorder(baum);
        System.out.println("Inorder");
        inorder(baum);
        System.out.println("Postorder");
        postorder(baum);
    }

    private void preorder(BinBaum pKnoten) {
        System.out.println(pKnoten.inhalt());
        if(pKnoten.linkerTeilbaum()!=null)
            preorder(pKnoten.linkerTeilbaum());
        if(pKnoten.rechterTeilbaum()!=null)
            preorder(pKnoten.rechterTeilbaum());
    }

    private void inorder(BinBaum pKnoten) {
        if(pKnoten.linkerTeilbaum()!=null)
            inorder(pKnoten.linkerTeilbaum());
        System.out.println(pKnoten.inhalt());
        if(pKnoten.rechterTeilbaum()!=null)
            inorder(pKnoten.rechterTeilbaum());
    }

    private void postorder(BinBaum pKnoten) {
        if(pKnoten.linkerTeilbaum()!=null)
            postorder(pKnoten.linkerTeilbaum());
        if(pKnoten.rechterTeilbaum()!=null)
            postorder(pKnoten.rechterTeilbaum());
        System.out.println(pKnoten.inhalt());
    }



}
