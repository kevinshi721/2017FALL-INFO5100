import java.util.Arrays;

/*
4. Write a java function to check if two strings are Anagrams or not. (Score 2)
i. The function should take two input strings.
ii. Should return a boolean ‘true’ if the inputs are Anagrams else return ‘false’. Here is the prototype you can work with
*/

public class Anagrams {

		public static void main (String[] args) {
				Anagrams a = new Anagrams();
				a.checkIfTwoStringsAreAnagrams("t h?e", "het ?");
				a.checkIfTwoStringsAreAnagrams("!!bt", "b?t!");
		}
		
		public boolean checkIfTwoStringsAreAnagrams(String s1, String s2){
		        if (s1 == null || s2 == null) {
		            	return false;
		        }
				
				if(s1.length() != s2.length()) {
						System.out.println("\""+ s1 + "\" & \"" + s2 + "\" are not anagrams");
						return false;
				
				}else {
						char[] s1Array = s1.toCharArray();
						char[] s2Array = s2.toCharArray();

						Arrays.sort(s1Array);
						Arrays.sort(s2Array);

						if	(Arrays.equals(s1Array, s2Array)) {
								System.out.println("\""+ s1 + "\" & \"" + s2 + "\" are anagrams");
						        return true;
						}else {
								System.out.println("\""+ s1 + "\" & \"" + s2 + "\" are not anagrams");
				                return false;
					}
			}
		}

}
