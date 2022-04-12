import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author BURKEJR19
 *
 */
public class SpellChecker {
	public static SpellingTree myTree;
	
	public static void main(String[] args) throws FileNotFoundException {		
		myTree = new SpellingTree();
		
		readWords("Dictionary.txt");
		
		System.out.println("Dictionary: ");
		myTree.printWords("", myTree.getRoot());
		
		System.out.println("\nTesting Words:");
		int count = checkWords("Testing.txt");
		System.out.println("\nMisspelled word count: " + count);
		
	}
	
	/**
	 * adds words to myTree from the given file
	 * @param fileName
	 * @throws FileNotFoundException 
	 */
	public static void readWords(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		while(in.hasNext()) {
			myTree.addWord(in.next());
		}
		
		in.close();
	}
	
	/**
	 * checks to see if words in the  given file are in
	 * myTree, and if not, prints the misspelled word.
	 * returns the amount of misspelled words 
	 * @param fileName
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static int checkWords(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner in = new Scanner(f);
		int count = 0;
		
		while(in.hasNext()) {
			String word = in.next();
			if(!myTree.checkWord(word)) {
				System.out.println(word);
				count++;
			}
		}
		
		in.close();
		return count;
	}
	
}
