package per.yang.lock;

import com.google.common.base.Strings;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }


    public void testMoney(){
        BigDecimal zero = BigDecimal.ZERO;
        System.out.println(zero);
    }

    public void testStringFormatter(){
        String smsTemplate = "您的%s机票订单报销凭证已经寄出，快递公司：%s，快递单号：%s，请注意查收。%s";

        String res = String.format(smsTemplate, "----------", "EMS", "11111111222", "");
        System.out.println(res);

    }

    public void testTrim(){
        String trim = StringUtils.trim(Strings.nullToEmpty(null));
        System.out.println(trim);
    }

    public void testClone(){

    }
}
