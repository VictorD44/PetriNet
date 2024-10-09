
public class Place {
	private int jetons;
 
 	public int getJetons() {
 		return this.jetons;
 	}
 	public void setJetons(int n) {
 		this.jetons=n;
 	}
 	public void addJetons(int n) {
 		this.setJetons(this.getJetons()+n);
 	}
 	public void removeJetons(int n) {
 		this.setJetons(Math.max(this.getJetons()-n,0));
 	}
}
