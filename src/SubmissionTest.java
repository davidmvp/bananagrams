import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SubmissionTest {
	private Submission s;
	private Submission s1;
	private File content;
	@Before
	public void setUp() throws Exception {
	   s = new Submission(5);
	   s1 = new Submission(3);
	}

	@Test
	public void testbaseScore() {
		Assert.assertEquals(50, s.baseScore());
		Assert.assertEquals(50, s1.baseScore());
	}
	

	@Test
	public void testGetDaysLate() {
		Assert.assertEquals(5, s.getDaysLate());
		Assert.assertEquals(3, s1.getDaysLate());
	}

	@Test
	public void testFinalScore() {
		Assert.assertEquals(0, s.finalScore());
		Assert.assertEquals(20, s1.finalScore());
	}

	@Test
	public void testGetContent() {
		Assert.assertEquals("Welcome!", s.getContent());
	}

}
