package recursion.hanoi;
public class TestHanoi {
	
	private static void solveTowers(int numberOfDisks,char startPole,char tempPole,char endPole){
		if (numberOfDisks == 1) {
			System.out.println("盘"+numberOfDisks+"由"+startPole+"移动到"+endPole);
		}else{
			solveTowers(numberOfDisks-1,startPole,endPole,tempPole);
			System.out.println("盘"+numberOfDisks+"由"+startPole+"移动到"+endPole);
			solveTowers(numberOfDisks-1,tempPole,startPole,endPole);
		}
	}
	
	public static void main(String[] args) {
		solveTowers(3,'A','B','C');
	}
}
