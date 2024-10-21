import static org.junit.jupiter.api.Assertions.assertEquals;  
import org.junit.jupiter.api.Test;  
  
public class SolutionTest {  
  
    @Test  
    public void testCompareVersion_EqualVersions() {  
        Solution solution = new Solution();  
        assertEquals(0, solution.compareVersion("1.01", "1.001"));  
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"));  
    }  
  
    @Test  
    public void testCompareVersion_Version1GreaterThanVersion2() {  
        Solution solution = new Solution();  
        assertEquals(1, solution.compareVersion("1.2", "1.1"));  
        assertEquals(1, solution.compareVersion("1.10", "1.2"));  
        assertEquals(1, solution.compareVersion("2.0", "1.999.999"));  
    }  
  
    @Test  
    public void testCompareVersion_Version1LessThanVersion2() {  
        Solution solution = new Solution();  
        assertEquals(-1, solution.compareVersion("1.0", "1.1"));  
        assertEquals(-1, solution.compareVersion("0.1", "1.1"));  
        assertEquals(-1, solution.compareVersion("1.1", "1.1.1"));  
    }  
  
    @Test  
    public void testCompareVersion_DifferentLengths() {  
        Solution solution = new Solution();  
        assertEquals(1, solution.compareVersion("1.2.3", "1.2"));  
        assertEquals(-1, solution.compareVersion("1.2", "1.2.3"));  
        assertEquals(0, solution.compareVersion("1", "1.0"));  
        assertEquals(0, solution.compareVersion("1.0", "1"));  
    }  
  
    @Test  
    public void testCompareVersion_LeadingZeros() {  
        Solution solution = new Solution();  
        assertEquals(0, solution.compareVersion("1.001", "1.1.0000")); // Note: This might be controversial as "1.1.0000" should be treated as "1.1"  
        // But since we are ignoring leading zeros within the same segment, and comparing based on segments,  
        // the above case will still return 0 because "1.001" is effectively "1.0.1" and "1.1.0000" is "1.1.0",  
        // and we only compare up to the length of the shorter version string when segments differ in count.  
        // For clarity, a better test case might be:  
        assertEquals(0, solution.compareVersion("1.001", "1.001"));  
        assertEquals(0, solution.compareVersion("1.0001", "1.1.0.0")); // This will also return 0 because "1.0001" is "1.0.01" and we stop at "1.1"  
        // But again, to avoid confusion, stick with clear cases:  
        assertEquals(0, solution.compareVersion("1.00", "1.0"));  
    }  
  
    // Note: The last test case in the leading zeros section might be a bit tricky because it depends on how  
    // you handle versions with different segment counts. The implementation provided will stop comparing  
    // at the length of the shorter version string. If you want to handle it differently (e.g., by padding  
    // with zeros or treating missing segments as zero), you might need to adjust the implementation.  
}