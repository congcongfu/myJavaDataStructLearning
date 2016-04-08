package model;

public class TowersOfHanoi {
	
	private int totalDisks;
	
	/*
	 * Sets up the puzzle with the specified number of disks.
	 * 
	 * @param disks the number of disks
	 * */
	public TowersOfHanoi(int disks){
		totalDisks = disks;
	}
	
	/*
	 * Perform the initial call to moveTower to solve the puzzle,
	 * Move the disks from tower 1 to tower 3 using tower 3 
	 * */
	public void solve(){
		moveTower(totalDisks, 1, 3, 2);
	}
	
	/*
	 * Moves the specified number of disks from one tower to another
	 * by moving a subtower of n-1 disks out of the way, moving one disk
	 * then moving the subtower back, Base case of 1 disk
	 * 
	 * @param numDisks the number of disks to move
	 * @param start the starting tower
	 * @param end the  ending tower
	 * @param temp  the temporary tower
	 * */
	public void moveTower(int numDisks, int star, int end, int temp){
//		System.out.println("numDisks = "+numDisks +" star = "+star+ " end ="+end + " temp " +temp);
		if(numDisks ==1)
			moveOneDisk(star, end);
		else {
			moveTower(numDisks -1, star, temp ,end );
			moveOneDisk(star, end);
//			System.out.println("numDisks1 = "+numDisks);
			moveTower(numDisks -1, temp, end, star);
//			System.out.println("numDisks2 = "+numDisks);
		}
	}
	
	/*
	 * Print instructions to move on disk from the specified start
	 * tower to the specified end tower
	 * 
	 * @param star  the staring tower
	 * @param end the ending tower
	 * */
	public void moveOneDisk(int star, int end){
		System.out.println("Move one disk from "+star+" to " +end);
	}
	
	

}




















