interface ListSorter{
    public Object[] sort(Object[] tab);
}

public class InsertSort implements ListSorter
{
    private final Comparator _comparator;
    public InsertSort(Comparator comparator)
    {
        _comparator = comparator;
    }
    public Object[] sort(Object[] tab)
    {
        int length=0;
        for(int i = 0; i<tab.length; i++){
            if(tab[i]!=null) //sprawdzam ile NAPRAWDE jest el. w tablicy
                length++;
        }
        for(int i = 0; i< length; i++){
            Object value = tab[i], temp;
            int j;
            for(j = i; j>0 && _comparator.compare(value, temp=tab[j-1])<0; j--)
                tab[j]=temp;
            tab[j]=value;
        }
        return tab;
    }
}