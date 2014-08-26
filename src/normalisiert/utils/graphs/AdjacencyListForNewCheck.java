package normalisiert.utils.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.process.SplitUtil;


public class AdjacencyListForNewCheck {

	/**
	 * @param args
	 */
	public int[][] getAdjacencyList(ArrayList<PointNode> pn,int num) {
		
//		ArrayList<ArrayList<Integer>> tmplist = new ArrayList<ArrayList<Integer>>();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		ArrayList<ArrayList<String>> nodelist = new ArrayList<ArrayList<String>>();
		PointNode node = new PointNode(0, 0, 0);
		String s = "";
		for (int j = 0; j < pn.size(); j++) {
			node = pn.get(j);
//			list[node.x][m]=node.y;
			s = hm.get(node.x);
			if (s==null) {
				s = node.y+"";
			}else	s += " "+node.y;
//			System.out.println("s"+s);
			hm.put(node.x, s);
		}
		int[][] list = new int[num][];
		String str1 = "";
		for (int i = 0; i < num; i++) {
//			System.out.println("hm.get(i)"+hm.get(i));
			str1 = hm.get(i);
//			System.out.println(str1+"str1");
			if (str1==null) {
				str1="-1";
			}
        	String []tokens=str1.split(" ");
//        	list[i] = new int[tokens.length];//邻接表的长度，用于初始化数组
        	
        	ArrayList<String> row = new ArrayList<String>(Arrays.asList(tokens));
			nodelist.add(row);
        	/*for(int j=0;j<tokens.length;j++)
        	{
        		list[i][j] =Integer.parseInt(tokens[j]);
        	}*/
		}
		ArrayList<Integer> fuyi = new ArrayList<Integer>();
		for (int i = 0; i < nodelist.size(); i++) {//用来将有向图变成无向图，单边变双边
			ArrayList<String> currentrow = nodelist.get(i);
			int rowlength = currentrow.size();
			for (int j = 0; j < rowlength; j++) {
				int number = Integer.parseInt(currentrow.get(j));
				if (number==-1) {
					fuyi.add(i);//将需要删除-1的行号加入到fuyi的list中
					continue;
				}
				if (!(nodelist.get(number).contains(i + "")))
					nodelist.get(number).add(i + "");
			}

		}
		for (Integer integer : fuyi) {//删除-1
			nodelist.get(integer).remove(0);
		}
		int t = 0;
		for (ArrayList<String> str : nodelist) {//转换成二维数组
			list[t] = new int[str.size()];//邻接表的长度，用于初始化数组
			for (int i = 0; i < str.size(); i++) {
				list[t][i] = Integer.parseInt(str.get(i));
//				System.out.print(st + "\t");
			}t++;
//			System.out.println();
		}
		return list;
	}

	public static int[][] returnList() {
		// TODO Auto-generated method stub
		int num = 24;//图中点的数量
		Sort st = new Sort();
		ArrayList<PointNode> al = new ArrayList<PointNode>();
		al = st.ReadArrlist("G:\\研一\\教研室\\无向图的大环路处理\\24point1\\weight_24.txt");

		st.SortArrlist(al);
		DeleteEdge de = new DeleteEdge();//删除边，到节点度数（n+1）/2
		int a[] =de.doDeleteEdge(al,num);//节点度数数组
		/*for (int i = 0; i < a.length; i++) {
			System.out.print(" "+a[i]);
		}
		System.out.println();
		for (PointNode pointNode : al) {
			System.out.print("("+pointNode.value+" "+pointNode.x+" "+pointNode.y+") ");
		}System.out.println();
		System.out.print(al.size()+"pointNode");*/
		AdjacencyListForNewCheck alfnc = new AdjacencyListForNewCheck();//中间结果转换为二维数组
		int[][] list = new int[num][];
		list = alfnc.getAdjacencyList(al, num);
		for (int k = 0; k < list.length; k++) {
			for (int k2 = 0; k2 < list[k].length; k2++) {
				System.out.print(list[k][k2]+" ");
			}System.out.println();
		}
		return list;
	}
		public static void main(String[] args) {
			returnList();
	}

}
