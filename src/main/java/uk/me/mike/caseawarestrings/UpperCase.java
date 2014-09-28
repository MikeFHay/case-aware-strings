package uk.me.mike.caseawarestrings;

/**
 * A string containing no lower-case characters
 * @author mikefhay
 */
public final class UpperCase implements CharSequence
{

    private final String allCaps;

    public static UpperCase of(CharSequence cs)
    {
        if (cs instanceof UpperCase)
        {
            return (UpperCase) cs;
        }
        return new UpperCase(cs);
    }

    private UpperCase(CharSequence cs)
    {
        this.allCaps = cs.toString().toUpperCase();
    }

    @Override
    public int length()
    {
        return allCaps.length();
    }

    @Override
    public char charAt(int index)
    {
        return allCaps.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return allCaps.subSequence(start, end);
    }

    @Override
    public String toString()
    {
        return allCaps;
    }

    @Override
    public int hashCode()
    {
        return allCaps.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof UpperCase && ((UpperCase) obj).allCaps.equals(this.allCaps);
    }
}
