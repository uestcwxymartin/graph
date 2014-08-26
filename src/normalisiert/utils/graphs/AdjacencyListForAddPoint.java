package normalisiert.utils.graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.process.SplitUtil;

public class AdjacencyListForAddPoint {

	public ArrayList<ArrayList<String>> ReadArrlist(String path) {//在方形矩阵中读出每一行的权重值和x，y

		String encoding = "utf-8";
		ArrayList<ArrayList<String>> aap = new ArrayList<ArrayList<String>>();
		ArrayList<PointNode> alo = new ArrayList<PointNode>();
		ArrayList<String> as = new ArrayList<String>();
		int i = 0;
		try {
			File file = new File(path);
			Sort sort = new Sort();
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				
				while ((lineTxt = bufferedReader.readLine()) != null) {
					alo.removeAll(alo);
					String[] tokens = lineTxt.split(" ");
					for (int j = 0; j < tokens.length; j++) {
						PointNode pn = new PointNode(i, j,Integer.parseInt(tokens[j]));
						alo.add(pn);
					}
					i++;
					sort.SortArrlist(alo);
					for (int j = 0; j < 4; j++) {
						as.add(alo.get(j).y+"");
					} 
					aap.add(as);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return aap;
	}

	public int[][] getAdjacencyList(ArrayList<ArrayList<String>> aapn, int num) {

		String s = "";
		int[][] list = new int[num][];
		for (int i = 0; i < aapn.size(); i++) {// 用来将有向图变成无向图，单边变双边
			ArrayList<String> currentrow = aapn.get(i);
			int rowlength = currentrow.size();
			for (int j = 0; j < rowlength; j++) {
				int number = Integer.parseInt(currentrow.get(j));
				if (!(aapn.get(number).contains(i + "")))
					aapn.get(number).add(i + "");
			}

		}
		int t = 0;
		for (ArrayList<String> str : aapn) {// 转换成二维数组
			list[t] = new int[str.size()];// 邻接表的长度，用于初始化数组
			for (int i = 0; i < str.size(); i++) {
				list[t][i] = Integer.parseInt(str.get(i));
				// System.out.print(st + "\t");
			}
			t++;
			// System.out.println();
		}
		return list;
	}

	public static int[][] returnList(int num) {
		// TODO Auto-generated method stub
		// int num = 24;//图中点的数量
		AdjacencyListForAddPoint st = new AdjacencyListForAddPoint();
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		al = st.ReadArrlist("G:\\研一\\教研室\\无向图的大环路处理\\100point\\distanceXml_100.txt");

		/*
		 * for (int i = 0; i < a.length; i++) { System.out.print(" "+a[i]); }
		 * System.out.println(); for (PointNode pointNode : al) {
		 * System.out.print
		 * ("("+pointNode.value+" "+pointNode.x+" "+pointNode.y+") ");
		 * }System.out.println(); System.out.print(al.size()+"pointNode");
		 */
		int[][] list = new int[num][];
		list = st.getAdjacencyList(al, num);
		/*for (int k = 0; k < list.length; k++) {
			for (int k2 = 0; k2 < list[k].length; k2++) {
				System.out.print(list[k][k2] + " ");
			}
			System.out.println();
		}*/
		return list;
	}

	public static void main(String[] args) {
		int num = 48;// 图中点的数量
		returnList(num);
	}

}
