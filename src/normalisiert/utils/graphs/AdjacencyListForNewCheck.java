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
//        	list[i] = new int[tokens.length];//�ڽӱ�ĳ��ȣ����ڳ�ʼ������
        	
        	ArrayList<String> row = new ArrayList<String>(Arrays.asList(tokens));
			nodelist.add(row);
        	/*for(int j=0;j<tokens.length;j++)
        	{
        		list[i][j] =Integer.parseInt(tokens[j]);
        	}*/
		}
		ArrayList<Integer> fuyi = new ArrayList<Integer>();
		for (int i = 0; i < nodelist.size(); i++) {//����������ͼ�������ͼ�����߱�˫��
			ArrayList<String> currentrow = nodelist.get(i);
			int rowlength = currentrow.size();
			for (int j = 0; j < rowlength; j++) {
				int number = Integer.parseInt(currentrow.get(j));
				if (number==-1) {
					fuyi.add(i);//����Ҫɾ��-1���кż��뵽fuyi��list��
					continue;
				}
				if (!(nodelist.get(number).contains(i + "")))
					nodelist.get(number).add(i + "");
			}

		}
		for (Integer integer : fuyi) {//ɾ��-1
			nodelist.get(integer).remove(0);
		}
		int t = 0;
		for (ArrayList<String> str : nodelist) {//ת���ɶ�ά����
			list[t] = new int[str.size()];//�ڽӱ�ĳ��ȣ����ڳ�ʼ������
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
		int num = 24;//ͼ�е������
		Sort st = new Sort();
		ArrayList<PointNode> al = new ArrayList<PointNode>();
		al = st.ReadArrlist("G:\\��һ\\������\\����ͼ�Ĵ�·����\\24point1\\weight_24.txt");

		st.SortArrlist(al);
		DeleteEdge de = new DeleteEdge();//ɾ���ߣ����ڵ������n+1��/2
		int a[] =de.doDeleteEdge(al,num);//�ڵ��������
		/*for (int i = 0; i < a.length; i++) {
			System.out.print(" "+a[i]);
		}
		System.out.println();
		for (PointNode pointNode : al) {
			System.out.print("("+pointNode.value+" "+pointNode.x+" "+pointNode.y+") ");
		}System.out.println();
		System.out.print(al.size()+"pointNode");*/
		AdjacencyListForNewCheck alfnc = new AdjacencyListForNewCheck();//�м���ת��Ϊ��ά����
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
