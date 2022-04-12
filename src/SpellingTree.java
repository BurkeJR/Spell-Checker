/**
 * SpellingTree that stores words in a tree structure. 
 * @author BURKEJR19
 *
 */
public class SpellingTree {
	private SpellingNode root;
	
	/**
	 * creates a SpellingTree. root is assigned to ' '.
	 */
	public SpellingTree() {
		setRoot(new SpellingNode(' '));
	}
	
	/**
	 * adds given word to the tree. returns true if successful, returns false if
	 * word is already in the tree.
	 * @param word
	 * @return
	 */
	public boolean addWord(String word) {
		word = word.replaceAll("\\p{Punct}", "");
		SpellingNode pos = getRoot();
		char[] c = word.toCharArray();
		for(int i = 0; i < c.length; i++) {
			pos.addChild(c[i]);
			pos = pos.getChildAt(c[i]);
			if(i == c.length - 1) {
				if(pos.isCorrectWord()) {
					return false;
				}
				pos.setCorrectWord(true);
			}
		}
		return true;
	}
	
	/**
	 * returns true if the given word exists in the tree, false otherwise.
	 * @param word
	 * @return
	 */
	public boolean checkWord(String word) {
		word = word.replaceAll("\\p{Punct}", "");
		SpellingNode pos = getRoot();
		SpellingNode child;
		char[] c = word.toCharArray();
		for(int i = 0; i < c.length; i++) {
			child = pos.getChildAt(c[i]);
			if(child == null) {
				return false;
			}
			pos = child;
		}
		return pos.isCorrectWord();
	}
	
	/**
	 * recursive function. prints all words in given subtree in alphabetical order.
	 * @param subWord
	 * @param c
	 */
	public void printWords(String subWord, SpellingNode c) {
		if(c != root) {
			subWord += c.getValue();
			if(c.isCorrectWord()) {
				System.out.println(subWord);
			}
		}
		SpellingNode child;
		for(char i = 'A'; i <= 'Z'; i++) {		
			child = c.getChildAt(i);
			if(child != null) {
				printWords(subWord, child);
			}
		}
	}

	public SpellingNode getRoot() {
		return root;
	}

	public void setRoot(SpellingNode root) {
		this.root = root;
	}
}
