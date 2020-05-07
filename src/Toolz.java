import java.util.ArrayList;
import java.util.Random;

public class Toolz {
	ArrayList<Integer> hight = new ArrayList<Integer>();
	ArrayList <Integer> length = new ArrayList<Integer>();
	Random r = new Random();
	public int[] random(int limx, int limy)  {
		
			
		int[] x = single(limx, length);
		int[] y = single(limy, hight);
		
		if(x[1] == 1 && y[1] == 1) {
			System.err.println("Too much blocks");
		}

		int[] ran = { x[0], y[0] };
		
		return ran;
	}
	
	private int[] single(int lim, ArrayList<Integer> closed) {
			
		int counter = 0;
		
		while (true) {
			int a = r.nextInt(lim);
			counter++;
			if(counter > 100) {
				int[] n = {a, 1};
				return n;
			}
			if(!closed.contains(a)) {
				closed.add(a);
				int[] n = {a, 0};
				return n;
			}
		}
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
	public double length (Tile start, Tile finish) {
		double l =(Math.sqrt(Math.pow((Math.abs(start.x-finish.x)),2)+Math.pow((Math.abs(start.y-finish.y)),2)));
		return l;
	}
}
