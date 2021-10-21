package utilities;
import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name="InputData")
    public Object[][] getDataforEditField()
    {
        //2 sets of data, "hello" , "!@#$$"
        Object[][] obj=new Object[][]
                {
                        {"hello"}, {"@#$%"}
                };

        return obj;

    }

    @DataProvider(name="SingleData")
    public Object[][] getDataForSingleField()
    {
        Object[][] obj=new Object[][]
                {
                        {"hello"}
                };

        return obj;

    }
}
