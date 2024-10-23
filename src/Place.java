/**
 * Class that represents a place
 */
public class Place {
	private int tokens; //Tokens of the place
	private int min_token;
	
	/**
	 * Constructor of the place
	 * @param tokens
	 * @requires tokens >= min_token
	 */
	public Place(int tokens) {
		if (tokens < min_token) {
			throw new IllegalArgumentException("the number of tokens must be positive");
		}
		this.tokens = tokens;
	}
 
	/**
	 * Getter for the tokens
	 * @return tokens
	 * @ensures tokens >= min_token
	 */
 	public int getTokens() {
 		assert(this.tokens >= min_token);
 		return this.tokens;
 	}
 	
 	/**
 	 * Setter for the tokens
 	 * @param tokens
 	 * @requires tokens >= min_token
 	 */
 	public void setTokens(int tokens) {
 		if (tokens < min_token) {
 			throw new IllegalArgumentException("the number of tokens must be positive");
 		}
 		this.tokens = tokens;
 	}
 	
 	/**
 	 * useful method to add tokens directly
 	 * @param tokens (to add)
 	 * @requires tokens_added >= 0
 	 */
 	public void addTokens(int tokens_added) {
 		if (tokens_added < 0) { //tokens_added has to be positive because if it is negative we should use removeTokens(int)
 			throw new IllegalArgumentException("the number of tokens added must be positive");
 		}
 		this.setTokens(this.getTokens()+tokens_added);
 	}
 	
 	/**
 	 * useful method to remove tokens directly
 	 * @param tokens (to remove)
 	 * @requires tokens_removed <= \old(this.tokens)
 	 * @ensures this.tokens >= min_token
 	 */
 	public void removeTokens(int tokens_removed) {
 		if (tokens_removed > this.tokens) {
 			throw new IllegalArgumentException("there are not enough tokens in this place to remove this much tokens");
 		}
 		this.setTokens(this.getTokens()-tokens_removed);
 		assert(this.tokens >= min_token);
 	}
}
