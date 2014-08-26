package normalisiert.utils.graphs;
import java.util.ArrayList;
import java.util.Collections;

public class Mst {

	/**
	 * @param args
	 */
	

	@SuppressWarnings("rawtypes")
	
		public static void main(String[] args)
		{
			ArrayList<PointNode> l = new ArrayList<PointNode>();
			l.add(new PointNode(1,3,1));
			l.add(new PointNode(1,2,6));
			l.add(new PointNode(1,4,5));
			l.add(new PointNode(2,3,5));
			l.add(new PointNode(2,5,3));
			l.add(new PointNode(3,4,5));
			l.add(new PointNode(3,5,6));
			l.add(new PointNode(3,6,4));
			l.add(new PointNode(4,6,2));
			l.add(new PointNode(5,6,6));
			Collections.sort(l);
//			for(int i = 0 ;i<l.size();i++)
//				System.out.println(l.get(i));
			for(int i = 0 ;i<l.size();i++)
				Shuzu.check(l.get(i));
			Shuzu.show();
		}
	

}
