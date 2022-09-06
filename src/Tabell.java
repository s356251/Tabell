import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

import static java.util.Objects.isNull;

public class Tabell {
    private Tabell() {}   // privat standardkonstruktør - hindrer instansiering

    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    public static void bytt(int[] a, int x, int y){ //Bytter om to gitte indekser i et heltallsarray
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    public static void bytt(char[] c, int x, int y){
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }
    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }
    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);

        if (isNull(fra)){
            throw new NullPointerException("fra (" + fra + ") - nullverdi");
        }

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }
    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
    public static int min(int[] a, int fra, int til) {

        fratilKontroll(a.length,fra,til);

        if (fra == til) {
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }

        if (isNull(fra)){
            throw new NullPointerException("fra (" + fra + ") - nullverdi");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int minverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                m = i;                // indeks til største verdi oppdateres
                minverdi = a[m];     // største verdi oppdateres
            }
        }
        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }
    public static int[] minmaks(int[] a){
        int maks = maks(a, 0, a.length);
        int min = min(a, 0, a.length);

        int[] b = {min, maks};
        return b;
    }

    public static int[] sorter(int[] a){
        for (int i = 0; i < a.length; i++){
            int min = min(a, 0, i);

        }
        return a;
    }

    public static int[] lagArray(int lengde) {
        int[] a = new int[lengde];
        for (int i = 0; i < lengde; i++) {
            a[i] = i;
        }
        return a;
    }
    public static void skriv(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        StringBuilder ut = new StringBuilder();
        for (int i = fra; i < til; i++){
            ut.append(a[i]).append(" ");
        }
        System.out.print(ut);
    }

    //1.2.2
    public static void skriv(int[] a){
        skriv(a, 0, a.length);
    }
    public static void skrivln(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        StringBuilder ut = new StringBuilder();
        for (int i = fra; i < til; i++){
            ut.append(a[i]).append(" ");
        }
        ut.append("\n");
        System.out.print(ut);
    }
    public static void skrivln(int[] a){
        skrivln(a, 0, a.length);
    }

    public static void skriv(char[]c, int fra, int til){
        fratilKontroll(c.length, fra, til);
        StringBuilder ut = new StringBuilder();
        for (int i = fra; i < til; i++){
            ut.append(c[i]).append(" ");
        }
        System.out.print(ut);
    }
    public static void skriv(char[]c){
        skriv(c, 0, c.length);
    }
    public static void skrivln(char[]c, int fra, int til){
        fratilKontroll(c.length, fra, til);
        StringBuilder ut = new StringBuilder();
        for (int i = fra; i < til; i++){
            ut.append(c[i]).append(" ");
        }
        ut.append("\n");
        System.out.print(ut);
    }
    public static void skrivln(char[]c){
        skrivln(c, 0, c.length);
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    //1.2.4
    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;           // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a, 1, n);                  // leter i a[1:n>
        }
        else if (m == n - 1)                   // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);              // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks
}
