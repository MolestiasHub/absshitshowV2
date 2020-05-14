import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		Toolz w = new Toolz();
		Map mappie = new Map(10,10,5,new Toolz());
		
		/*int[][] preset = {
			{0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 0, 0, 1, 0, 1, 0, 1, 0},
			{0, 1, 1, 0, 1, 0, 1, 0, 1, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
			{0, 1, 0, 0, 1, 0, 1, 0, 0, 1},
			{0, 1, 1, 0, 1, 1, 1, 1, 0, 1},
			{0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
			{0, 0, 0, 0, 0, 0, 1, 1, 0, 0},
			{0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
		};*/
//		Map mappie = new Map(preset);
		
		Astarties astie = new Astarties();
		
		Tile start = mappie.start_fin(); 
		Tile finish = mappie.start_fin();
		 
			

		/*Tile start = mappie.getTile(0, 0);
		Tile finish = mappie.getTile(0, 9);*/
		
		System.out.println(start + " " + finish);
		ArrayList<Tile> a = astie.astar(mappie, start, finish);
		System.out.println(Arrays.deepToString(a.toArray()));
		w.xl(mappie.returner(), a);
		
	}
}
