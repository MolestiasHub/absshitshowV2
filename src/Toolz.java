import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.Workbook;
import jxl.write.Number;
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
	public void xl (Tile[][] map, ArrayList<Tile> a) {
				final String EXCEL__FILE__LOCATION = "loc";
		        WritableWorkbook ex = null;
		        try {

		            ex = Workbook.createWorkbook(new File(EXCEL__FILE__LOCATION));
		            WritableSheet excelSheet = ex.createSheet("Sheet 1", 0);
		        		for (int i=0;i<map.length;i++) {
		        			for (int j=0;j<map[i].length;j++) {
		        				if(map[i][j].blocked==true) {
		        					Label label = new Label(i, j, "Block");
		        		            excelSheet.addCell(label);
		        				}
		        				else {
		        					Label label = new Label(i, j,"" + map[i][j].x +"," + map[i][j].y);
		        		            excelSheet.addCell(label);
		        				}
		        			}
		        		}
		        		for (int i=0;i<a.size();i++){
		        			Label label = new Label(a.get(i).x,a.get(i).y, "Road");
        		            excelSheet.addCell(label);
		        		}
		            
		            ex.write();


		        } catch (IOException e) {
		            e.printStackTrace();
		        } catch (WriteException e) {
		            e.printStackTrace();
		        } finally {

		            if (ex != null) {
		                try {
		                    ex.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                } catch (WriteException e) {
		                    e.printStackTrace();
		                }
		            }


		        }

		    
	}
}
