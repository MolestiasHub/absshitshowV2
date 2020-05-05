public class Tile {
	int x,y;
	double g;
	double f;
	double h;
	boolean blocked;
	Tile camefrom;
	public Tile(boolean blocked,int x, int y, double h,double f, double g) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.f = f;
		this.g = g;
		this.blocked=blocked;
	}
}
