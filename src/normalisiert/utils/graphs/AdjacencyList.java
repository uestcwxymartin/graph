package normalisiert.utils.graphs;

import java.util.Vector;


/**
 * 计算给定邻接矩阵的邻接表
 * 
 *
 */
public class AdjacencyList {
	
	public static int[][] getAdjacencyList(int adjacencyMatrix) {
		int[][] list = new int[adjacencyMatrix][];

		int test = 0;
		for (int i = 0; i < adjacencyMatrix; i++) {
			Vector v = new Vector();
//			for (int j = i; j < adjacencyMatrix; j++) {
				/*int randedge = new java.util.Random().nextInt(100);
				if (randedge<2) {
					v.add(new Integer(j));
//					System.out.println("j"+j);
				}*/
				/*if (j==4) {
					v.add(8);
				}
				if (j==2) {
					v.add(9);
				}*/
				
//			}

			test = v.size();
//			System.out.println("v.size()"+v.size());
			list[i] = new int[v.size()+1];
			/*if (i==adjacencyMatrix-1) {
				list[i][0] = 0;
			}else
				list[i][0] = i+1;//用来保证有个大环路*/
			
			for (int j = 0; j < v.size(); j++) {
				Integer in = (Integer) v.get(j);
//				list[i][j+1] = in.intValue();//用来保证有个大环路
				list[i][j] = in.intValue();
			}
			
			
			
		}
		/*for (int j = 0; j < list.length; j++) {//用来输出邻接矩阵
			for (int j2 = 0; j2 < test+1; j2++) {
				System.out.print(list[j][j2]);
			}
			System.out.println();
		}*/
		return list;
	}
}
