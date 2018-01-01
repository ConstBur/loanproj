package cb.loanproj;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcLoanTest {
	
	private static String[] loans = {"1000", "foo", "100000000000", "random", "2000", "3000"};
	private static String[] terms = {"12", "24", "wtf", "nanana", "twenty", "48"};
	private static String[] rates = {"2.9", "3.5", "4.0", "ten", "none", "bar"};
	private static String[] errors = {"", "You entered an invalid loan amount (less than 10 million $ supported)\n",
			"You entered an invalid loan amount (less than 10 million $ supported)\nYou entered an invalid term\n",
			"You entered an invalid loan amount (less than 10 million $ supported)\nYou entered an invalid term\nYou entered an invalid interest rate (< 100% only)",
			"You entered an invalid term\nYou entered an invalid interest rate (< 100% only)",
			"You entered an invalid interest rate (< 100% only)"};

	@Test
	public void testCheckLoan() {
		CalcLoanClass calc = new CalcLoanClass();
		assertEquals("Must accept 1000", true, calc.checkLoan(loans[0]));
		assertEquals("Must refuse foo", false, calc.checkLoan(loans[1]));
		assertEquals("Must refuse 100000000000", false, calc.checkLoan(loans[2]));
		assertEquals("Must refuse random", false, calc.checkLoan(loans[3]));
		assertEquals("Must accept 2000", true, calc.checkLoan(loans[4]));
		assertEquals("Must accept 3000", true, calc.checkLoan(loans[5]));
		fail("Not yet implemented");
	}

	@Test
	public void testCheckTerm() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testCheckRate() {
		fail("Not yet implemented");
	}

	@Test
	public void testErrorPrint() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
