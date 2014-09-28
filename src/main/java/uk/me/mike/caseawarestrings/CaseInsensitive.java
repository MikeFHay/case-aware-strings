/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.me.mike.caseawarestrings;

/**
 * Like String, but equals, hashCode and compareTo all work case-insensitively.
 * Case information is retained, so toString will return the original 
 * @author User
 */
public final class CaseInsensitive implements CharSequence, Comparable<CaseInsensitive>
{

    public static int caseInsensitiveHashcode(String cs)
    {
        int hash = 0;
        int len = cs.length();
        for (int i = 0; i < len; i++)
        {
            char c = Character.toUpperCase(cs.charAt(i));
            hash = 31 * hash + c;
        }
        return hash;
    }
    
    private final String value;

    /**
     * @return a case-insensitive version of the input CharSeuence
     */
    public static CaseInsensitive of(CharSequence value)
    {
        if (value instanceof CaseInsensitive)
        {
            return (CaseInsensitive) value;
        }
        return new CaseInsensitive(value);
    }

    private CaseInsensitive(CharSequence value)
    {
        this.value = value.toString();
    }

    public int length()
    {
        return value.length();
    }

    public char charAt(int index)
    {
        return value.charAt(index);
    }

    public CharSequence subSequence(int start, int end)
    {
        return CaseInsensitive.of(value.subSequence(start, end));
    }

    @Override
    public boolean equals(Object object)
    {
        return (object instanceof CaseInsensitive) && 
                ((CaseInsensitive) object).value.equalsIgnoreCase(value);
    }

    @Override
    public int hashCode()
    {
        return caseInsensitiveHashcode(value);
    }

    @Override
    public String toString()
    {
        return value;
    }

    public int compareTo(CaseInsensitive other)
    {
        return String.CASE_INSENSITIVE_ORDER.compare(this.value, other.value);
    }
}
