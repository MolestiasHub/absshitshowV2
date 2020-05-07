import java.util.ArrayList;
import java.util.Random;

public class Map {
	private Tile[][] map = null;
	private Toolz w;
	public Map(int x, int y,int z, Toolz w) {
		this.w = w;
		map = new Tile[x][y];
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[i].length;j++) {
				map[i][j] = new Tile(false,i, j, 0, 0, 0);
			}
		}
		for (int i=0;i<z;i++) {
			int[] al = w.random(x, y);
			map[al[0]][al[1]] = new Tile(true,al[0], al[1], 0, 0, 0);
		}	
		w.print(map);
	}
	
	public Map(int[][] m) {
		w = new Toolz();
		map = new Tile[m.length][m[0].length];
		
		for (int i=0;i<map.length;i++) {
			for (int j=0;j<map[i].length;j++) {
				if(m[i][j] == 1) {
					w.length.add(i);
					w.hight.add(j);
				}
				map[i][j] = new Tile(m[i][j] == 1,i, j, 0, 0, 0);
			}
		}
		w.print(map);
	}
	
	public Tile start_fin(){
		int[] a = w.random(map.length,map[0].length);
		return map[a[0]][a[1]];
	}
	 public ArrayList<Tile> check(Tile b){
		 ArrayList<Tile> close = new ArrayList<Tile>();
		 for(int i=-1;i<2;i++) {
			 int x= b.x + i;
			 if(x>=0&&x<map.length) {
				 for(int j=-1;j<2;j++) {
					 int y = b.y + j;
					 if(y>=0&&y<map[0].length&&(x!=b.x||y!=b.y)&&!map[x][y].blocked) {
						 close.add(map[x][y]);
					 }
				 }
			 }
		 }
		return close;
	  }
	 public Tile getTile(int x, int y) {
		 return map[x][y];
	 }
}
