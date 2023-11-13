package edu.hw5;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.SubstringChecker.isSubstring;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class Task6Test {
    @Test
    public void isWorkCorrectTest() {
        assertThat(isSubstring("ghjgjHG^%$abshj vTHDFEghj", "abs")).isEqualTo(true);
    }
    @Test
    public void oneSymbolSubstring() {
        assertThat(isSubstring("ghjgjHG^%$abshj vTHDFEghj", "s")).isEqualTo(true);
    }
    @Test
    public void symbolFromRegexSyntaxDot() {
        assertThat(isSubstring("ghjgjHG^%$abshjvTHDFEghj", ".")).isEqualTo(false);
    }
    @Test
    public void symbolFromRegexSyntaxBracket() {
        assertThat(isSubstring("ghjgjHG^[]%$absh[jvTHD]FEghj", "[]")).isEqualTo(true);
    }
    @Test
    public void symbolFromRegexSyntaxBracket2() {
        assertThat(isSubstring("[{{(((()]]]]", "())")).isEqualTo(false);
    }
    @Test
    public void symbolFromRegexSyntaxSlash() {
        assertThat(isSubstring("ghjgjHG^%$ab\\shjvTHDFEghj", "\\")).isEqualTo(true);
    }
    @Test
    public void stringIsEmpty() {
        assertThat(isSubstring("", "\\")).isEqualTo(false);
    }
    @Test
    public void stringLessThanSubstring() {
        assertThat(isSubstring("dfg", "dfgrt")).isEqualTo(false);
    }
}
