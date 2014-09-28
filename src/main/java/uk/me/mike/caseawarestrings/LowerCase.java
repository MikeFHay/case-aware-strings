package uk.me.mike.caseawarestrings;

/**
 * A string containing no upper-case characters
 * @author mikefhay
 */
public final class LowerCase implements CharSequence
{

    private final String noCaps;

    public static LowerCase of(CharSequence cs)
    {
        if (cs instanceof LowerCase)
        {
            return (LowerCase) cs;
        }
        return new LowerCase(cs);
    }

    private LowerCase(CharSequence cs)
    {
        this.noCaps = cs.toString().toLowerCase();
    }

    @Override
    public int length()
    {
        return noCaps.length();
    }

    @Override
    public char charAt(int index)
    {
        return noCaps.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return noCaps.subSequence(start, end);
    }

    @Override
    public String toString()
    {
        return noCaps.toString();
    }

    @Override
    public int hashCode()
    {
        return noCaps.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof LowerCase && ((LowerCase) obj).noCaps.equals(this.noCaps);
    }
}
