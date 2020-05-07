import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class Astarties {
	Toolz t = new Toolz();
	public ArrayList<Tile> astar(Map w, Tile start, Tile finish) throws Exception{
		
		ArrayList<Tile> openset = new ArrayList<Tile>();
		ArrayList<Tile> closedset = new ArrayList<Tile>();
		ArrayList<Tile> path = new ArrayList<Tile>();

		openset.add(start);
		start.g=0;
		start.h=t.length(start, finish);
		start.f=start.g+start.h;
		while(!openset.isEmpty()) {
			Tile x = openset.get(0);
			/*for(Tile i : openset) {
				if (Double.compare(i.f, x.f)==-1) {
					i=x;
				}
			}*/
			if (x==finish) {
				return getPath(x);
			}
			openset.remove(x);
			closedset.add(x);
			for(Tile y : w.check(x)) {
				
				if (closedset.contains(y)) {
					continue;
				}
				double temp = x.g + t.length(x, y);
				boolean better = false;
				if (!openset.contains(y)) {
					openset.add(y);
					better = true;
				} else {
					better = temp < y.g;
				}
				if (better) {
					y.camefrom = x;
					y.g=temp;
					y.h=t.length(finish, y);
					y.f=y.g+y.h;
				}
			}
		}
		
		throw new Exception("GOVNO");
	}
	public ArrayList<Tile> getPath(Tile finish){
		Tile cur = finish;
		ArrayList<Tile> res = new ArrayList<>();
		while(true) {
			res.add(cur);
			if(cur.camefrom == null) {
				break;
			}
			cur=cur.camefrom;
		}
		
		Collections.reverse(res);
		
		return res;
	}
}
