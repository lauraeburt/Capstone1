import java.util.*;

public class PigLatin {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Welcome to the Pig Latin Translator!");
		System.out.println();
		while (true) {
			System.out.println("Please enter a word or sentence to be translated (no punctuation or special characters, please): ");
			String word = scan.nextLine();
			String[] moreWords = word.split(" ");
			System.out.println("Please enter a word or sentence to be translated (no punctuation or special characters, please): " + word);
			System.out.println("Translation: ");
			for (int i = 0; i < moreWords.length; i++) {
				System.out.print(solve(moreWords[i]) + " ");
			}
			System.out.println();
			System.out.println("Would you like to translate another word? (y/n):");
			String response = scan.nextLine();
			if (response.charAt(0) == 'n') {
				System.out.println("Thank you for using the Pig Latin Translator!");
				break;
			}
		}
		scan.close();
	}

	public static String solve(String word) {
		String temp = word;
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		char first = temp.charAt(0);
		char second = ' ';
		if (temp.length() >= 2) {
			second = temp.charAt(1);
		}

		for (int i = 0; i < vowels.length; i++) {
			if (first == vowels[i]) {
				return word + "way";
			}
		}
		boolean vowel = false;
		for (int i = 0; i < vowels.length; i++) {
			if (second == vowels[i]) {
				vowel = true;
			}
		}
		if (vowel == false) {
			word = word.substring(2);
			word += Character.toString(first) + Character.toString(second) + "ay";
			return word;
		}
		word = word.substring(1);
		word += Character.toString(first) + "ay";

		return word;

	}

}
