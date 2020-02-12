package come.home.global.util;

public class StringUtil {
	
	public static boolean isEmpty(String str) {
		return (str == null || "".equals(str)) ? true : false;
	}
	
	public static boolean isNotEmpty(String str) {
		return (str == null || "".equals(str)) ? false : true;
	}
}
