package base64test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/base64test/system-test-config.xml")
public class Base64RegexValidatorTests {
	
	@Autowired
	private Base64RegexValidator base64RegexValidator;
	
	@Test
	public void testIsValid() {
		assertTrue(base64RegexValidator.isValid("TWFu"));
		assertFalse(base64RegexValidator.isValid("jedandvatri"));
		assertFalse(base64RegexValidator.isValid("jedandvatr="));
		assertFalse(base64RegexValidator.isValid("jedandvatr==========================================================================="));
		assertTrue(base64RegexValidator.isValid(""));
	}

}
