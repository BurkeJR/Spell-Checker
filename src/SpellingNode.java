/**
 * SpellingNode containing the character of the node, a list of the node's children,
 * and a boolean telling if ending at this node results in a correct word
 * @author BURKEJR19
 *
 */
public class SpellingNode {
	private char value;
	private SpellingNode[] children;
	private boolean correctWord;
	
	/**
	 * creates a SpellingNode with given value.
	 * children list elements all set to null.
	 * correctWord set to false.
	 * @param value
	 */
	public SpellingNode(char value) {
		this.setValue(value);
		children = new SpellingNode[26];
		this.setCorrectWord(false);
	}

	/**
	 * adds child to array. returns true if successful, false if this child already exists
	 * @param val
	 * @return
	 */
	public boolean addChild(char val) {
		val = Character.toUpperCase(val);
		int index = val - 65;
		if(children[index] != null) {
			return false;
		}
		
		children[index] = new SpellingNode(val);
		return true;
	}
	
	/**
	 * returns child that is of the given value. returns null if the child doesn't exist
	 * @param val
	 * @return
	 */
	public SpellingNode getChildAt(char val) {
		val = Character.toUpperCase(val);
		return children[val - 65];
	}
	
	/**
	 * return correctWord
	 * @return
	 */
	public boolean isCorrectWord() {
		return correctWord;
	}

	/**
	 * set correctWord
	 * @param correctWord
	 */
	public void setCorrectWord(boolean correctWord) {
		this.correctWord = correctWord;
	}

	/**
	 * returns value
	 * @return
	 */
	public char getValue() {
		return value;
	}

	/**
	 * set value. is always made uppercase
	 * @param value
	 */
	public void setValue(char value) {
		this.value = Character.toUpperCase(value);
	}
	
	

}
