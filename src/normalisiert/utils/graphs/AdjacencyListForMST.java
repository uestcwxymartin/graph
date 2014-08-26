package normalisiert.utils.graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import normalisiert.utils.useful.AdjacencyListNew;

public class AdjacencyListForMST {
	ArrayList<ArrayList<String>> aap = new ArrayList<ArrayList<String>>();
	ArrayList<PointNode> blo = new ArrayList<PointNode>();

	public ArrayList<PointNode> ReadArrlist(String path, int num) {// 在方形矩阵中读出每一行的权重值和x，y

		String encoding = "utf-8";
		ArrayList<PointNode> alo = new ArrayList<PointNode>();
		// ArrayList<PointNode> blo = new ArrayList<PointNode>();
		Sort sort = new Sort();
		ArrayList<PointNode> cy = new ArrayList<PointNode>();

		int i = 0;
		try {
			File file = new File(path);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					String[] tokens = lineTxt.split(" ");

					for (int j = 0; j < tokens.length; j++) {
						PointNode pn = new PointNode(i, j,
								Integer.parseInt(tokens[j]));
						if (j >= i) {
							alo.add(pn);
							blo.add(pn);// 全局权重排列
						}
					}
					i++;
					/*
					 * ArrayList<String> as = new ArrayList<String>(); for (int
					 * j = 0; j < 5; j++) { as.add(blo.get(j).y + ""); }
					 * aap.add(as);
					 */
				}
				sort.SortArrlist(blo);
				read.close();
				System.out.println("alo" + alo);
				cy = MSL.tree(alo, num);
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		System.out.println("cy" + cy);
		return cy;
	}

	public ArrayList<ArrayList<String>> mstAddEdge(ArrayList<PointNode> mst,
			int num) {
		ArrayList<ArrayList<String>> mstAllo = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < num; i++) {
			ArrayList<String> mstEdge = new ArrayList<String>();
			mstAllo.add(mstEdge);
		}
		int a[] = new int[num];
		PointNode pn = new PointNode(0, 0, 0);
		for (int i = 0; i < mst.size(); i++) {
			pn = (PointNode) mst.get(i);
			// System.out.println("pn"+pn);
			a[pn.x]++;
			a[pn.y]++;
			if (!(mstAllo.get(pn.x).contains(pn.y + "")))
				mstAllo.get(pn.x).add(pn.y + "");
			// System.out.println("mstallo"+mstAllo);
		}
		int k = 0;
		while (!checkJieDianDuShu(a)) {
			if ((!(mstAllo.get(	blo.get(k).x).contains(blo.get(k).y + ""))))
			{
				if (a[blo.get(k).x]+1 > 4&&a[blo.get(k).y]+1 > 4) {
					k++;continue;
				}
				mstAllo.get(blo.get(k).x).add(blo.get(k).y + "");
				a[blo.get(k).x]++;
				a[blo.get(k).y]++;
			}
			k++;
		}
		/*
		 * for (int i = 0; i < a.length; i++) { if (a[i]==1) {
		 * System.out.println
		 * ("i "+i+" "+aap.get(i).get(1)+" aap.get(i).get(1)"); for (int j = 0;
		 * j < 4; j++) { if (!(mstAllo.get(i).contains(aap.get(i).get(j) + "")))
		 * mstAllo.get(i).add(aap.get(i).get(j) + ""); } //
		 * mstAllo.get(i).remove(""); } }
		 */
		return mstAllo;

	}

	private boolean checkJieDianDuShu(int a[]) {
		boolean check = true;
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
			if (a[i] <= 2) {
				check = false;
			}
		}
		System.out.println();

		return check;
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

//	public static int[][] returnList(int num) {
		// TODO Auto-generated method stub
		// int num = 24;//图中点的数量
//		AdjacencyListForMST st = new AdjacencyListForMST();
		AdjacencyListNew st = new AdjacencyListNew();
//		ArrayList<PointNode> al = new ArrayList<PointNode>();
//		ArrayList<ArrayList<String>> aas = new ArrayList<ArrayList<String>>();
//		al = st.ReadArrlist(
//				"G:\\研一\\教研室\\无向图的大环路处理\\48point\\distanceXml_48.txt", num);

		/*
		 * for (int i = 0; i < a.length; i++) { System.out.print(" "+a[i]); }
		 * System.out.println(); for (PointNode pointNode : al) {
		 * System.out.print
		 * ("("+pointNode.value+" "+pointNode.x+" "+pointNode.y+") ");
		 * }System.out.println(); System.out.print(al.size()+"pointNode");
		 */
//		aas = st.mstAddEdge(al, num);
//		System.out.println(aas + "aas");
//		int[][] list = new int[num][];
//		list = 
//		st.getAdjacencyList(aas, num);

		// list = st.getAdjacencyList(al, num);
//		for (int k = 0; k < list.length; k++) {
//			for (int k2 = 0; k2 < list[k].length; k2++) {
//				System.out.print(list[k][k2] + " ");
//			}
//			System.out.println();
//		}
//		return list;
//	}

	/*public static void main(String[] args) {
		int num = 48;// 图中点的数量
		returnList(num);
	}*/

}
