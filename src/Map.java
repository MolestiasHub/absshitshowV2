import java.util.ArrayList;
import java.util.Random;

public class Map {
	private Tile[][] map = null;
	private Toolz w;
	public Map(int x, int y,int z, Toolz w) {
		this.w = w;
		map = new Tile[y][x];
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[i].length;j++) {
				map[i][j] = new Tile(false,i, j, 0, 0, 0);
				}
		}
		for (int i=0;i<z;i++) {
			int[] al = w.random(x, y);
			map[al[0]][al[1]] = new Tile(true,al[0], al[1], 0, 0, 0);
		}	
		int[] a = w.random(x, y);
		Tile start = new Tile(false, a[0], a[1], 0, 0, 0);
		int[] b = w.random(x, y);
		Tile finish = new Tile(false, b[0], b[1], 0, 0, 0);
		System.out.println(start.x+" " + start.y);
		System.out.println(finish.x +" "+ finish.y);
		w.print(map);
	}
	public Tile start_fin(){
		int[] a = w.random(map.length,map[0].length);
		return map[a[0]][a[1]];
	}
	 public ArrayList<Tile> check(Tile b){
		 ArrayList<Tile> close = new ArrayList<Tile>();
		 for(int i=-1;i<2;i++) {
			 int x= b.x - i;
			 if(x>0&&x<map.length) {
				 for(int j=-1;j<2;j++) {
					 int y = b.y - j;
					 if(y>0&&y<map[0].length&&x!=0&&y!=0&&!map[x][y].blocked) {
					 close.add (map[x][y]);
					 }
				 }
			 }
		 }
		return close;
	  }
}
