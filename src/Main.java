
public class Main {

	public static void main(String[] args) {
		Map mappie = new Map(10,10,3,new Toolz());
		Astarties astie = new Astarties();
		Tile a = astie.astar(mappie, mappie.start_fin(), mappie.start_fin()).get(3);
		System.out.println(a.x + " " + a.y);
		
	}
}
