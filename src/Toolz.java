import java.util.ArrayList;
import java.util.Random;

public class Toolz {
	ArrayList<Integer> hight = new ArrayList<Integer>();
	ArrayList <Integer> length = new ArrayList<Integer>();
	Random r = new Random();
	public int[] random(int limx, int limy) {
		
			
		int[] ran = new int[2];
			while (true) {
				int a = r.nextInt(limx);
				if(!hight.contains(a)) {
					hight.add(a);
					ran[0]=a;
					break;
				}
			}
			while (true) {
				int b = r.nextInt(limy);
				if(!length.contains(b)) {
					length.add(b);
					ran[1]=b;
					break;
				}
			}
	
			return ran;
	}
	public void print(Tile[][] map) {
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[i].length;j++) {
				if(map[i][j].blocked==true) {
					System.out.print("X,X ");
				}
				else {
				System.out.print(map[i][j].x+ "," +map[i][j].y + " ");
				}
			}
			System.out.println();
		}
		
	}
}
