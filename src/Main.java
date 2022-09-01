public class Main {
    public static void main(String[] args){


    }
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


}
