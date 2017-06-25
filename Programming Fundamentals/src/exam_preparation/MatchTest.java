package exam_preparation;

public class MatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "123457";
		String s1 = "tfhgfjyh";
		String s2 = "wsfewtgrehyt$^%$^%$%r";
		System.out.println(s.matches("\\d+"));
		System.out.println(s1.matches("[a-zA-Z0-9]+"));
		System.out.println(s2.matches("\\D+"));
		
		System.out.println(Character.isUpperCase('s'));
		System.out.println(Character.isLowerCase('a'));
		
		System.out.println(changeCase("P2Z4x789"));

	}
	
	public static String changeCase(String str){
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(!Character.isLetter(ch)){
				b.append(ch);
			}else{
				b.append(Character.isUpperCase(ch) ? Character.toLowerCase(ch) :  Character.toUpperCase(ch));
			}			
		}		
		return b.toString();
	}
	
	public static String reverse(String str){
		StringBuilder b = new StringBuilder(str);		
		return b.reverse().toString();
	}

}
