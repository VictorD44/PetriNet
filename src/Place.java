/**
 * Class that represents a place
 */
public class Place {
	private int tokens; //Tokens of the place
	
	/**
	 * Constructor of the place
	 * @param tokens
	 */
	public Place(int tokens) {
		this.tokens = tokens;
	}
 
	/**
	 * Getter for the tokens
	 * @return tokens
	 */
 	public int getTokens() {
 		return this.tokens;
 	}
 	
 	/**
 	 * Setter for the tokens
 	 * @param tokens
 	 */
 	public void setTokens(int n) {
 		this.tokens = n;
 	}
 	
 	/**
 	 * useful method to add tokens directly
 	 * @param tokens (to add)
 	 */
 	public void addTokens(int n) {
 		this.setTokens(this.getTokens()+n);
 	}
 	
 	/**
 	 * useful method to remove tokens directly
 	 * @param tokens (to remove)
 	 */
 	public void removeTokens(int n) {
 		this.setTokens(Math.max(this.getTokens()-n, 0));
 	}
}
