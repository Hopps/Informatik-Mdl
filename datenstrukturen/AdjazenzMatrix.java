package datenstrukturen;

/**
 *
 * @author merlin
 */
public class AdjazenzMatrix {
    
    private int zN;
    private int[][] adjaMa;
    
    public AdjazenzMatrix(int pN)
    {
        zN = pN;
        adjaMa = new int[zN][zN];
        for ( int i = 0; i < zN; i++)
        {
            for ( int j = 0; j < zN; j++)
            {
                adjaMa[i][j] = -1; // Keine Verbindung
            }
        }
    }
    
    public void set(int pStartknoten, int pZielknoten, int pWert)
    {
        adjaMa[pStartknoten][pZielknoten] = pWert;
    }
    
    public int get(int pStartknoten, int pZielknoten)
    {
        return adjaMa[pStartknoten][pZielknoten];
    }
    
    public int[] nachbarKnoten(int pKnoten)
    {
        int lAnzahl = 0;
        for ( int i = 0; i < zN; i++ )
        {
            if ( adjaMa[pKnoten][i] > -1 ) {
                lAnzahl++;
            }
        }
        int[] lReturn = new int[lAnzahl];
        for ( int j = 0; j < lAnzahl; j=j )
        for ( int i = 0; i < zN; i++ )
        {
            if ( adjaMa[pKnoten][i] > -1 ) {
                lReturn[j] = i;
                j++;
            }
        }
        return lReturn;
    }
    
    public void listeAlleKnoten(int pStartknoten)
    {
        this.durchlaufe(pStartknoten, new int[zN]);
    }
    private void durchlaufe(int pStartknoten, int[] pBesucht) {
        if ( pBesucht[pStartknoten] != 1 ) {
            System.out.println(pStartknoten);
        }
        pBesucht[pStartknoten] = 1;
        int[] lNachbar = this.nachbarKnoten(pStartknoten);
        for ( int i = 0; i < lNachbar.length; i++ )
        {
            if ( pBesucht[lNachbar[i]] != 1 )
            {
                this.durchlaufe(lNachbar[i], pBesucht);
            }
        }
    }
}