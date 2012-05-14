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
    }

    


}
