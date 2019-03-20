package practice.model;

public class Location {
	
	private int step;
	private int x;
	private int y;
	
	public Location() {
		super();
	}

	public Location(int x, int y,int step) {
		this.x = x;
		this.y = y;
		this.step=step;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int sum() {
		return this.x+this.y;
	}
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj== this) return true;
		if(!(obj instanceof Location)) return false;
		Location location = (Location) obj;
		return location.x==x && location.y==y && location.step==step;
	}

	@Override
	//The 17 and 31 hash code idea is from the classic Java book – effective Java : item 9
	public int hashCode() {
		  int result = 17;
	      result = 31 * result + x;
	      result = 31 * result + y;
	      result = 31 * result + step;
	      return result;
	}


	@Override
	public String toString() {
		return "Location=<x="+this.x+",y="+this.y+">";
	}


	
	
	
	
	
	

	
	

}
