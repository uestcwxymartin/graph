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

	public ArrayList<ArrayList<String>> ReadArrlist(String path) {//�ڷ��ξ����ж���ÿһ�е�Ȩ��ֵ��x��y

		String encoding = "utf-8";
		ArrayList<ArrayList<String>> aap = new ArrayList<ArrayList<String>>();
		ArrayList<PointNode> alo = new ArrayList<PointNode>();
		ArrayList<String> as = new ArrayList<String>();
		int i = 0;
		try {
			File file = new File(path);
			Sort sort = new Sort();
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
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
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return aap;
	}

	public int[][] getAdjacencyList(ArrayList<ArrayList<String>> aapn, int num) {

		String s = "";
		int[][] list = new int[num][];
		for (int i = 0; i < aapn.size(); i++) {// ����������ͼ�������ͼ�����߱�˫��
			ArrayList<String> currentrow = aapn.get(i);
			int rowlength = currentrow.size();
			for (int j = 0; j < rowlength; j++) {
				int number = Integer.parseInt(currentrow.get(j));
				if (!(aapn.get(number).contains(i + "")))
					aapn.get(number).add(i + "");
			}

		}
		int t = 0;
		for (ArrayList<String> str : aapn) {// ת���ɶ�ά����
			list[t] = new int[str.size()];// �ڽӱ�ĳ��ȣ����ڳ�ʼ������
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
		// int num = 24;//ͼ�е������
		AdjacencyListForAddPoint st = new AdjacencyListForAddPoint();
		ArrayList<ArrayList<String>> al = new ArrayList<ArrayList<String>>();
		al = st.ReadArrlist("G:\\��һ\\������\\����ͼ�Ĵ�·����\\100point\\distanceXml_100.txt");

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
		int num = 48;// ͼ�е������
		returnList(num);
	}

}
