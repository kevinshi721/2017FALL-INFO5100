
public class Question1 {

	public static void main(String[] args) {
		System.out.println(generateLicenseKey("2-4A0r7-4k",4));
		System.out.println(generateLicenseKey("2-4A0r7-4k",3));
		System.out.println(generateLicenseKey("2-4A0r7-4k",2));
	}

	public static String generateLicenseKey(String s, int k) {
		String result = "";
		String sWoDash = s.replace("-","");
		
		int length = 0;
		for(int i = sWoDash.length() - 1; i >= 0; i--) {
			char c = sWoDash.charAt(i);
			if(length == k) {
				result = "-" + result;
				length = 0;
			}
			result = Character.toUpperCase(c) + result;
			length ++;
		}
		return result;	
	}

}
