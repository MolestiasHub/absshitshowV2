import java.util.ArrayList;
public class Astarties {
	Toolz t = new Toolz();
	public ArrayList<Tile> astar(Map w, Tile start, Tile finish){
		
		ArrayList<Tile> openset = new ArrayList<Tile>();
		ArrayList<Tile> closedset = new ArrayList<Tile>();
		ArrayList<Tile> path = new ArrayList<Tile>();

		openset.add(start);
		start.g=0;
		start.h=t.length(start, finish);
		start.f=start.g+start.h;
		Tile x = start;
		/*while(!openset.isEmpty()) {
			for(Tile i : openset) {
				if (Double.compare(i.f, x.f)==-1) {
					i=x;
				}
			}*/
				if (x==finish) {
					return path;
				}
			openset.remove(x);
			closedset.add(x);
			ArrayList<Tile> neigh = w.check(x);
			
			
			for(int i = 0;i<neigh.size();i++) {
				if (neigh.size()>i) {
				Tile y = neigh.get(i);
				
				if (closedset.contains(y)) {
					continue;
				}
				double temp = x.g + t.length(x, y);
				boolean better =false;
				System.out.println("y" +y.g);
				System.out.println(temp);
				System.out.println(x.g);
				if (!openset.contains(y)) {
					openset.add(y);
					better = true;
					}
				
				else {
					if(y.g < temp) {
						better = true;
					}
					else {
						better = false;
					}
					}
				if (better) {
					y.camefrom = x;
					y.g=temp;
					y.h=t.length(finish, y);
					y.f=y.g+y.h;
					
				}
				}
		}
		
		path = goback(start, finish, path);
		return path;
		}
		
	
	public ArrayList<Tile> goback(Tile x, Tile finish, ArrayList<Tile> path) {
		Tile cur = finish;
		int k = 0;
		while (cur != x) {
			path.add(cur);
			cur = cur.camefrom;
			k++;
			System.out.println(k);
		}
		return path;
		
	}
	
	
}
