interface ListSearcher {
    public int search(Object[] tab, Object value);
}

public class BinarneWyszuk implements ListSearcher{
    private final Comparator _comparator;
    public BinarneWyszuk(Comparator comparator){
        _comparator = comparator;
    }
    public int search(Object[] tab, Object value){
        int length=0;
        for(int i = 0; i<tab.length; i++){
            if(tab[i]!=null) //sprawdzam ile NAPRAWDE jest el. w tablicy
                length++;
        }
        int lower = 0;
        int upper = length;
        int index=0, cmp=0;
        while(lower<=upper && (cmp=_comparator.compare(value, tab[index=(lower+upper)/2]))!=0)
            if(cmp<0) 
                upper = index-1;
            else
                lower = index+1;
        return lower<=upper && cmp==0 ? index: -(lower+1);
    }
}