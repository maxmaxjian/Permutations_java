import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int[] input;
    private List<List<Integer>> expected;
    private Solution soln = new Solution1();

    public SolutionTest(int[] input, List<List<Integer>> output) {
        this.input = input;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3}, Arrays.asList(
                        Arrays.asList(1,2,3),
                        Arrays.asList(1,3,2),
                        Arrays.asList(2,1,3),
                        Arrays.asList(2,3,1),
                        Arrays.asList(3,1,2),
                        Arrays.asList(3,2,1)
                )},
                {new int[]{1,1,2}, Arrays.asList(
                        Arrays.asList(1,1,2),
                        Arrays.asList(1,2,1),
                        Arrays.asList(2,1,1)
                )}
        });
    }

    @Test
    public void testPerm() {
        assertEquals(expected, soln.permute(input));
    }
}