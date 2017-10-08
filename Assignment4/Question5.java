
public class Question5 {

	public static void main(String[] args) {
		Question5 roman = new Question5();
		System.out.println(roman.intToRoman(2999));
		System.out.println(roman.intToRoman(4999));
	}
	
	public String intToRoman(int num) {
		String unit[] = {"","Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ","Ⅵ","Ⅶ","Ⅷ","Ⅸ"};
        String ten[] = {"","X","XX","XXX","XL","L","L","LX","LXX","LXXX","XC"};
        String hund[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thou[] = {"","M","MM","MMM"};
        
        if (num > 3999) {
        	return "invalid number";
        }
        else {
        	return thou[num/1000] + hund[num%1000/100] + ten[num%100/10] + unit[num%10];   	
        }
	}
}