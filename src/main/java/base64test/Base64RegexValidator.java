package base64test;


public class Base64RegexValidator {
	/** ne prihvaca empty string */
	private final String REGEX_PATTERN = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{4})$";
	/** prihvaca empty string */
	private final String REGEX_PATTERN_EMPTY = "^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$";
	
	public boolean isValid(String base64String) {
		return base64String.matches(REGEX_PATTERN_EMPTY);
	}
}
