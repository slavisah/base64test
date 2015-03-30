package base64test;

import org.apache.commons.codec.binary.Base64;

public class Base64Validator {

	public boolean isValid(String base64String) {
		return Base64.isBase64(base64String);
	}
	
	public String decode(String base64String) {
		String decodedString = new String(Base64.decodeBase64(base64String));
		return decodedString;
	}
}
