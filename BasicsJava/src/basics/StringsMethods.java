package basics;

class CountVowels {
	static int countVowels(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c
			== 'u' || c == 'A' || c == 'E' || c == 'O' || c == 'I'
			|| c == 'U') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "abcbea";
		System.out.println(countVowels(s));
	}
}

class CharacterCount {
	static int characterCount(String s, String t) {
		int count = 0;
		char key = t.charAt(0);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == key)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "How are you";
		String t ="o";
		System.out.println(characterCount(s,t));
	}
}

class Reverse {
	static String reverse(String s) {
		String t = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			t = t + s.charAt(i);
		}
		return t;
	}
	
	public static void main(String[] args) {
		String s = "TAPACADEMY";
		System.out.println(reverse(s));
	}
}


class SpaceCount {
	static int spaceCount(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		String s = "How are you";
		spaceCount(s);
	}
}


class WordCount {
	static int wordCount(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				count++;
			}
		}
		return count + 1;
	}
	
	public static void main(String[] args) {
		String s = "How are you";
		wordCount(s);
	}
}

class PrintAllSubstring {
	static void printAllSubstring(String st) {
		int n = st.length();
		for (int len = 1; len < n; len++) {
			for (int s = 0; s <= (n - len); s++) {
				for (int e = s; e <= (s + len) - 1; e++) {
					System.out.println(st.charAt(e));
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "tapacademy";
		printAllSubstring(s);
	}
}

class PrintAllSubstringWithPostion {
	static void printAllSubstring(String st, int k) {
		int n = st.length();
		for (int s = 0; s <= (n - k); s++) {
			for (int e = s; e <= (s + k) - 1; e++) {
				System.out.println(st.charAt(e));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String s = "tapacademy";
		int k = 3;
		printAllSubstring(s,k);
	}
}


public class StringsMethods {
	
}
