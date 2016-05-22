import java.lang.*;
import java.util.*;

public class Slownik{
    
    String[] slownik;
    String[] pom;
    int size = 0;
    int sizePom = 0;
    int maxPom = 5;
    public Slownik(){
        pom = new String[maxPom];
    }
    public void zerujPom(){
        for (int i = 0; i < pom.length; i++){
            pom[i] = null;
        }
        sizePom = 0;
    }
    public void zerujSlownik(){
        for (int i = 0; i < slownik.length; i++){
            slownik[i] = null;
        }
        size = 0;
    }
    public boolean sprawdzSlowo(String s){
        int i;
        boolean spr = false;
        for (i = 0; i < sizePom; i++){
            if (pom[i].equals(s) == true) {
                spr = true;
            }
        }
        for (i = 0; i < size-1; i++){
            if (slownik[i].equals(s) == true){
                spr = true;
            }
        }
        if(spr==true){
            System.out.println("Slowo juz jest wpisane\n");
        }
        return spr;
    }
    public void dodajSlowo(String s){
        if (sprawdzSlowo(s) == false){
            if (sizePom != maxPom){
                pom[sizePom] = s;
                sizePom++;
            } 
            else{
                scal();
                pom[sizePom] = s;
                sizePom++;
            }
        } 
    }
    public void sortuj(){
        ListSorter ls = new InsertSort(CompString.INSTANCE);
        pom = (String[]) ls.sort(pom);
    }
   public void scal(){
        sortuj();
        String[] temp = new String[size + sizePom];
        int i = 0, j = 0, l = 0;
        while (l < temp.length) {
            if (i == size) {
                // Resztę pobieramy z pomocniczej.
                while (j < sizePom) {
                    temp[l] = pom[j];
                    j++;
                    l++;
                }
                
                break;
            } else if (j == sizePom) {
                // Resztę pobieramy ze słownika.
                while (i < size) {
                    temp[l] = slownik[i];
                    i++;
                    l++;
                }
                
                break;
            } else if (slownik[i].compareTo(pom[j]) < 0) {
                temp[l] = slownik[i];
                i++;
            } else {
                temp[l] = pom[j];
                j++;
            }
            l++;
        }
        
        slownik = new String[temp.length];
        for(i=0; i<temp.length;i++){
            slownik[i]=temp[i];
        }
        size=temp.length;
        zerujPom();
    }
    public void pokazPom() {
        sortuj();
        System.out.println("Pomocnicza: ");
        for (int i = 0; i < sizePom; i++) {
            System.out.println((i+1) +". "+pom[i]);
        }
        System.out.println("");
    }
    public void pokazSlownik() {
        System.out.println("Slownik: ");
        for (int i = 0; i < size; i++) {
            System.out.println((i+1) + ". "+slownik[i]);
        }
        System.out.println("");
    }
    public void znajdzSlowo(String s){
        int index;
        ListSearcher ls = new BinarneWyszuk(CompString.INSTANCE);
        index = ls.search(slownik, (Object)s)+1;
        if(index<0)
            System.out.println("Slowo \""+s+"\" nie jest wpisane");
        else
            System.out.println("Index slowa "+s+" to: " +index);
    }
    public static void main(String[] args) {
        Slownik s = new Slownik();
        s.dodajSlowo("ruszofy");
        s.dodajSlowo("gura");
        s.dodajSlowo("papiesz");
        s.dodajSlowo("chuśtawka");
        s.dodajSlowo("przczoła");
        
        s.dodajSlowo("pjuro");
        s.dodajSlowo("cherbata");
        s.pokazSlownik();
        s.pokazPom();
        System.out.println("Sprobuje wpisac przczoła: ");
        s.dodajSlowo("przczoła");
        s.dodajSlowo("husteczka");
        s.dodajSlowo("wziąść");
        
        s.dodajSlowo("tszmiel");
        s.dodajSlowo("biórko");
        s.dodajSlowo("przenica");
        s.pokazSlownik();
        s.pokazPom();
        s.znajdzSlowo("czfartek");
        s.znajdzSlowo("pjuro");
    }
}
