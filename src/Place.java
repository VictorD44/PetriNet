
public class Place {
	private int tokens;
	
	public Place(int tokens) {
		this.tokens=tokens;
	}
 
 	public int getTokens() {
 		return this.tokens;
 	}
 	public void setTokens(int n) {
 		this.tokens=n;
 	}
 	public void addTokens(int n) {
 		this.setTokens(this.getTokens()+n);
 	}
 	public void removeTokens(int n) {
 		this.setTokens(Math.max(this.getTokens()-n,0));
 	}
}
