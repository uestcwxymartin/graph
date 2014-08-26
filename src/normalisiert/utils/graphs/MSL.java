package normalisiert.utils.graphs;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class MSL {
	
	static ArrayList<PointNode> result=new ArrayList<PointNode>();
	public static Map<Integer, Integer> vertexMap = new HashMap<Integer, Integer>();
    public static  ArrayList<PointNode> tree (ArrayList<PointNode> points,int number )
    
    {
    	
    	Collections.sort(points);
    	int j=1;
    for (int i=0;i<points.size();i++)
    	{
    	  Set<Integer> vertexSet = vertexMap.keySet();
    	  PointNode curr=points.get(i);
    	  
    	  if (!vertexSet.contains(curr.x) && !vertexSet.contains(curr.y))
    	  {
    		  
    		  
    		       result.add(curr);
    			     vertexMap.put(curr.x,j);
    			     vertexMap.put(curr.y,j);
    	  } 
    	  else if (vertexSet.contains(curr.x) && vertexSet.contains(curr.y)) {
    		     if (vertexMap.get(curr.x) != vertexMap.get(curr.y)) {
    		    	 result.add(curr);
    		      int n = vertexMap.get(curr.x);
    		      int m = vertexMap.get(curr.y);
    		      for (Integer v : vertexSet) {
    		       if (vertexMap.get(v) == m) {
    		        vertexMap.put(v, n);
    		       }
    		      }
    		      vertexMap.put(curr.y, n);
    		     }
    		    } else if (vertexSet.contains(curr.x)
    		      && !vertexSet.contains(curr.y)) {
    		     int n = vertexMap.get(curr.x);
    		     result.add(curr);
    		     vertexMap.put(curr.y, n);
    		    } else if (vertexSet.contains(curr.y)
    		      && !vertexSet.contains(curr.x)) {
    		     int n = vertexMap.get(curr.y);
    		     result.add(curr);
    		     vertexMap.put(curr.x, n);
    		    } 
    		
    	
    	  j++;
    
    	
    	}  	
    	return result;		
    	
    }
    
    
	public static void main(String[] args)
    {
    	ArrayList<PointNode> test=new ArrayList<PointNode>();
    	test.add(new PointNode(1,3,1));
    	test.add(new PointNode(1,2,6));
    	test.add(new PointNode(1,4,5));
    	test.add(new PointNode(2,3,5));
    	test.add(new PointNode(2,5,3));
    	test.add(new PointNode(3,4,5));
    	test.add(new PointNode(3,5,6));
    	test.add(new PointNode(3,6,4));
    	test.add(new PointNode(4,6,2));
    	test.add(new PointNode(5,6,6));
    	System.out.print(tree(test,6));
    }
}
