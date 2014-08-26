package normalisiert.utils.useful;

import java.util.List;

public class WeightCaclulate {

	/**
	 * @param args
	 */
	public int doWeightCaculate(List cycle,int pointNum)
	{
		int a=0,b=0,weight=0,tmp=0,begin=0,end=0;
		WeightInput wi = new WeightInput();
		int[][] list = wi.getWeightAdjacencyList(pointNum);
		/*for (int i = 0; i < cycles.size(); i++) {

			List cycle = (List) cycles.get(i);*/
		begin = Integer.parseInt((String) cycle.get(0));
		for (int j = 0; j < cycle.size(); j++) {
				
			a = Integer.parseInt((String) cycle.get(j));
				
			if (j < cycle.size() - 1) {
				b = Integer.parseInt((String) cycle.get(j+1));
			} else {
				end = Integer.parseInt((String) cycle.get(j));
				break;
			}
			if (a>b) {
				tmp=a;
				a=b;
				b=tmp;
			}
//				System.out.println("a"+a+"b"+b);
			if (a==b) {
				break;
			}
				weight+=list[a][b-1-a];
				
		}
		if (end>begin) {
			tmp=end;
			end=begin;
			begin=tmp;
		}
		if (a!=b) 			
		weight+=list[end][begin-1-end];
		return weight;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
