interface Comparator{
    public int compare(Object left, Object right);
}

public final class CompString implements Comparator
{
    public static final CompString INSTANCE = new CompString();
    private CompString(){}
    
    public int compare(Object left, Object right)
    {
        return ((String)left).compareTo((String)right);
    }
}