public class Tabell {
    public static int maks(int[] a, int fra, int til)  // a er en heltallstabell
    {
        int funnetmaks = a[fra];
        int indeks = fra;

        for( int i = fra; i < til; i++){
            if (a[i] < funnetmaks){
                funnetmaks = a[i];
                indeks = i;
            }
        }
        return indeks;
    } // maks


    public static int min(int[] a, int fra, int til)  // a er en heltallstabell
    {
        int funnetmin = a[fra];
        int indeks = fra;

        for( int i = fra; i < til; i++){
            if (a[i] > funnetmin){
                funnetmin = a[i];
                indeks = i;
            }
        }
        return indeks;
    } // min

    public static int[] bytt(int[] a, int x, int y){ //Bytter om to gitte indekser i et heltallsarray
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;

        return a;
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

    public static int[] lagArray(int lengde){
        int[] a = new int[lengde];
        for (int i = 0; i < lengde; i++){
            a[i] = i;
        }
        return a;
    }
}
