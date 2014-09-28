
package uk.me.mike.caseawarestrings;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Asserts as far as possible that classes adhere to the Value-based Class specification.
 * See <a href="http://docs.oracle.com/javase/8/docs/api/java/lang/doc-files/ValueBased.html">http://docs.oracle.com/javase/8/docs/api/java/lang/doc-files/ValueBased.html</a>
 * @author mikefhay
 */
public class ValueBasedTest
{

    @Test
    public void test()
    {
        assertValueBased(CaseInsensitive.class);
        assertValueBased(LowerCase.class);
        assertValueBased(UpperCase.class);
    }
    
    public <T> void assertValueBased(Class<T> clazz)
    {
        for (Constructor<?> constructor: clazz.getDeclaredConstructors())
        {
            assertTrue(clazz+" has a visible constructor.", Modifier.isPrivate(constructor.getModifiers()));
        }
        
        assertTrue(clazz+" is not final.", Modifier.isFinal(clazz.getModifiers()));
        
        for (Field f :clazz.getDeclaredFields())
        {
            assertTrue(clazz+" has a non-final field: "+f.getName(), Modifier.isFinal(f.getModifiers()));
        }
        
        try
        {
            assertFalse(clazz+" doesn't override toString",
                        clazz.getMethod("toString").getDeclaringClass() == Object.class);
            assertFalse(clazz+" doesn't override hashCode",
                        clazz.getMethod("hashCode").getDeclaringClass() == Object.class);
            assertFalse(clazz+" doesn't override equals",
                        clazz.getMethod("equals", Object.class).getDeclaringClass() == Object.class);
        }
        catch(NoSuchMethodException ex)
        {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}