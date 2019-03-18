package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator calc;
    private Display display = new DisplayStub();

    @Before
    public void setUp() throws Exception {
        calc = new Calculator(display);
    }


    @Test
    public void getNumber() throws Exception{
        display.setDisplayNumber("0");
        double number = calc.getNumber();
        assert number == 0;
    }

    @Test
    public void setNumber() {
        double number = 42;
        calc.setNumber(number);
        assertEquals("42.0", display.getDisplayNumber());
    }

    @Test
    public void digit() {
        assertEquals("0", display.getDisplayNumber());
        calc.digit("1");
        assertEquals("1", display.getDisplayNumber());
        calc.digit("2");
        assertEquals("12", display.getDisplayNumber());
    }

    @Test
    public void clear() {
        calc.digit("1");
        assertTrue(calc.isLastButtonWasDigit());
        calc.clear();
        assertFalse(calc.isLastButtonWasDigit());
        assertEquals(0D, calc.getNumber(), 0.000001D);
    }

    @Test
    public void comma() {
        display.setDisplayNumber("0.2");
        calc.comma();
        assertEquals("0.2", display.getDisplayNumber());
    }
    @Test
    public void percent(){
        calc.digit("10");
        calc.operator("*");
        calc.digit("10");
        calc.percent();
        assertEquals("1", display.getDisplayNumber(), 0.0000001D);

    }

    @Test
    public void operator() {
        calc.digit("2");
        calc.operator("+");
        calc.digit("3");
        calc.operator("+");
        assertEquals(5D, calc.getNumber(), 0.000001D);
        calc.digit("3");
        calc.operator("-");
        assertEquals(8D, calc.getNumber(), 0.000001D);
        calc.digit("1");
        calc.enter();
        assertEquals(7D, calc.getNumber(), 0.000001D);
    }

    @Test
    public void enter() {
        calc.digit("2");
        calc.operator("+");
        calc.digit("2");
        assertEquals(4D, calc.getNumber(), 0.000001D);
    }

    @Test
    public void sqrt() {
        calc.digit("4");
        calc.sqrt();
        assertEquals(2D, calc.getNumber(), 0.000001D);
    }
    private static class DisplayStub implements Display {
        private String displayNumber = "0";
        @Override
        public String getDisplayNumber() {
            return displayNumber;
        }

        @Override
        public void setDisplayNumber(String displayNumber) {
            this.displayNumber = displayNumber;

        }
    }
}