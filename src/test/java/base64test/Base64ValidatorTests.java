package base64test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/base64test/system-test-config.xml")
public class Base64ValidatorTests {
	
	@Autowired
	private Base64Validator base64Validator;
	
	@Test
	public void testIsValid() {
		assertTrue(base64Validator.isValid("TWFu"));
		assertTrue(base64Validator.isValid("jedandvatri"));
		assertTrue(base64Validator.isValid("jedandvatr="));
		assertTrue(base64Validator.isValid("jedandvatr==========================================================================="));
		assertTrue(base64Validator.isValid(""));
	}
	
	@Test
	public void testDecode() {
		assertEquals(new String(base64Validator.decode("TWFu")), "Man");
		assertEquals(base64Validator.decode("jedandvatri"), base64Validator.decode("jedandvatri="));
		assertEquals(base64Validator.decode("jedandvatr="), base64Validator.decode("jedandvatr=="));
	}

}
