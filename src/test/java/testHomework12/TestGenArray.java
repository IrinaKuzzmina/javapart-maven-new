package testHomework12;

import homework12.GenArray;
import homework12.GenArrayGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.regex.Pattern;

public class TestGenArray {
    String[] array = {
            "First element",
            "Second element",
            "Third element",
            "Fourth element",
            "Fifth element",
            "Sixth element"
    };

    String[] array1 = {
            "First element",
            "Second element",
            "Third element",
            "Fourth element",
            "Fifth element",
            "Sixth element"
    };

    //Test constructor
    GenArray<String> stringGenArray = new GenArray<String>(array);

    GenArray<String> stringGenArray1 = new GenArray<String>(array1);

    @Test
    public void testToString() {
        Assert.assertEquals(stringGenArray.toString(), "GenArray{genArray=[First element, Second element, Third element, Fourth element, Fifth element, Sixth element]}");
    }

    @Test
    public void testGet() {
        String arrayElement = stringGenArray.get(1);
        Assert.assertEquals(arrayElement, "Second element");
    }

    @Test
    public void testSet() {
        stringGenArray1.set(2, "Changed third element");
        String changedElement = stringGenArray1.get(2);
        Assert.assertEquals(changedElement, "Changed third element");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testException() {
        stringGenArray1.set(6, "Not exisiting element");
    }

    @Test
    public void testRandomNumber(){
        String regex = "999\\d{6}[50]";
        GenArrayGenerator genArrayGenerator = new GenArrayGenerator();
        String convertedNumber = Long.toString(genArrayGenerator.generateNumber());
        Assert.assertEquals(Pattern.matches(regex,convertedNumber), true);
    }

}
