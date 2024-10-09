
public class Place {
	private int tokens;
	
	public Place(int jetons) {
		
	}
 
 	public int getTokens() {
 		return this.tokens;
 	}
 	public void setTokens(int n) {
 		this.tokens=n;
 	}
 	public void addJetons(int n) {
 		this.setTokens(this.getTokens()+n);
 	}
 	public void removeJetons(int n) {
 		this.setTokens(Math.max(this.getTokens()-n,0));
 	}
}
