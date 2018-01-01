package cb.loanproj;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalcLoanTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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
	public void testToStringStringStringString() {
		fail("Not yet implemented");
	}

}
