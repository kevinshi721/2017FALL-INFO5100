/*
3. Write a Java function to remove vowels in a string. (Score 2)
i. The function should take a string as input.
ii. Should return the input string after omitting the vowels. Here is the prototype you can work with
*/

public class Vowel {

		public static void main (String[] args) {
				Vowel test = new Vowel();
				System.out.println(test.removeVowelsFromString("abcadefgf"));
		}
		
		public String removeVowelsFromString(String input){
		        if (input == null) {
		            	return null;
		        }
				String result = input.replaceAll("[AEIOUaeiou]","");	
				return result;
		}
}
