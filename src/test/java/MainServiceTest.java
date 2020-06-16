import exception.EmptyArrayException;
import exception.NegativeValueInArrayException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.MainService;

public class MainServiceTest {
    private MainService underTest;
    @Before
    public void init(){
        underTest = new MainService();
    }
    @Test
    public void shouldProcessSucceedAndTotalWaterShouldBe25(){
        int[] array = new int[] {7,0,4,2,5,0,6,4,0,5};
        int result = underTest.getTotalWater(array, 0);
        Assert.assertEquals(25,result);
    }
    @Test
    public void shouldBeTotalWaterZeroIfArraySizeIsOne(){
        int[] array = new int[] {7};
        int result = underTest.getTotalWater(array, 0);
        Assert.assertEquals(0,result);
    }

    @Test(expected = EmptyArrayException.class)
    public void shouldThrowEmptyArrayExceptionIfArrayIsEmpty(){
        int[] array = new int[0];
        underTest.getTotalWater( array, 0);
    }
    @Test(expected = NegativeValueInArrayException.class)
    public void shouldThrowNegativeValueInArrayExceptionIfArrayHasGotAnyNegativeValue(){
        int[] array = new int[] {7,0,4,2,-5,0,6,4,0,5};
        underTest.getTotalWater( array, 0);
    }
}
