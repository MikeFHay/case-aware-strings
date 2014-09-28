package uk.me.mike.caseawarestrings;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 *
 * @author mikefhay
 */
@RunWith(Theories.class)
public class CaseInsensitiveTest
{

    public static char[] charset = randomChars();
    @DataPoints
    public static CaseInsensitive[] randomStrings = randomData();
    
    public static char[] randomChars()
    {
        int n = 10;
        char[] chars = new char[n];
        Random r = new Random();
        for (int i = 0; i < n; i++)
        {
            chars[i] = (char) r.nextInt(Character.MAX_VALUE);
        }
        System.out.println(Arrays.toString(chars));
        return chars;
    }
    
    public static CaseInsensitive[] randomData()
    {
        int n = 100;
        int stringLength = 2;
        CaseInsensitive[] shortVals = new CaseInsensitive[n];
        for (int i = 0; i < n; i++)
        {
            shortVals[i] = CaseInsensitive.of(RandomStringUtils.random(stringLength, charset));
//            shortVals[i] = new CaseInsensitive(RandomStringUtils.random(stringLength));
        }
        return shortVals;
    }
    
    @Theory
    public void equalsHashCode(CaseInsensitive a, CaseInsensitive b)
    {
        assumeThat(a, not(sameInstance(b)));
        for (Locale l : Locale.getAvailableLocales())
        {
            Locale.setDefault(l);
            if (a.equals(b))
            {
                System.out.println("Hit on " + a + " and " + b);
                assertEquals(b, a);
                assertEquals(a + " has different hashcode than " + b,
                             a.hashCode(), b.hashCode());
            }
        }
    }
}
