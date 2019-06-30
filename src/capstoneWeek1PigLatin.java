import java.util.*;


public class capstoneWeek1PigLatin {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to the Pig Latin Translator!");
		
		do {
			System.out.print("\nEnter a word to be translated: ");
				String input = scnr.next();
			
				if (emptyInput(input)) {
					System.out.println("\nPlease try again.");
				}
				else if (noTranslate(input)) {
					System.out.println("\nWords with numbers or symbols will not be translated.");
				}
				else {
					String pigLatin = hasPunctuation(input);
					System.out.println();
					System.out.println(pigLatin);
				}
		
		} while (userContinue());
		
		System.out.println("\nGoodbye! \n(or shall we say, " + pigLatin("GoodBye") + "!)");
		scnr.close();
	}
		
	public static String pigLatin(String a) { //extended challenge met: this also translates words with contractions.
		
		String consonantString = " ";
		String rest = " ";
		String pigLatinVowel;
		String pigLatinConsonant;
		
		a = a.toLowerCase();
		
		for (int i = 0; i < a.length(); ++i) {
			if ((a.charAt(i) == 'a') || 
				(a.charAt(i) == 'e') || 
				(a.charAt(i) == 'i') || 
				(a.charAt(i) == 'o') || 
				(a.charAt(i) == 'u'))  { 
				break; 
			}
			else if ((a.charAt(i) != 'a') || 
					 (a.charAt(i) != 'e') || 
					 (a.charAt(i) != 'i') || 
					 (a.charAt(i) != 'o') || 
					 (a.charAt(i) != 'u'))  { 
				consonantString = consonantString + (a.substring(i, i + 1));
			}
		}
		
		consonantString = consonantString.substring(1);
		int consonantLength = (consonantString.length());
		if (consonantLength > 0) {
			rest = a.substring(consonantLength);
			pigLatinConsonant = (rest + consonantString + "ay");
			return pigLatinConsonant;
		}
		else {
			pigLatinVowel = a.concat("way");
			return pigLatinVowel;
		}
	}
		
	public static boolean userContinue() {
			System.out.println("\nTranslate another word? (y/n)");
			Scanner scnr = new Scanner(System.in);
			String userContinue = scnr.nextLine();
			
			if (userContinue.equalsIgnoreCase("y")) {
				return true;
			} else {
				return false;
			}	
	}
	
	public static String hasPunctuation(String a) { //extended challenge: allows for punctuation in the input
		if ((a.endsWith(".")) || 
			(a.endsWith("!")) || 
			(a.endsWith("?")) ||
			(a.endsWith(";")) ||
			(a.endsWith(":")) ||
			(a.endsWith(",")))  {
			 String userPunctuation = a.substring((a.length() - 1));
			 String rest = a.substring(0, (a.length() - 1));
			 rest = pigLatin(rest);
			 String pigLatinWithPunctuation = rest + userPunctuation;
			 return pigLatinWithPunctuation;
		} else {
			return pigLatin(a);
		}
	}
	
	public static boolean noTranslate(String a) { //extended challenge: don't translate words with numbers or symbols
		if ((a.contains("0")) || 
			(a.contains("1")) ||
			(a.contains("2")) ||
			(a.contains("3")) ||
			(a.contains("4")) ||
			(a.contains("5")) ||
			(a.contains("6")) ||
			(a.contains("7")) ||
			(a.contains("8")) ||
			(a.contains("9")) ||
			(a.contains("@")) ||
			(a.contains("#")) ||
			(a.contains("$")) ||
			(a.contains("%")) ||
			(a.contains("^")) ||
			(a.contains("&")) ||
			(a.contains("*")) ||
			(a.contains("<")) ||
			(a.contains(">")))  {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean emptyInput(String a) { //extended challenge: check that the user has actually entered text before translating
		if (a.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
			
	