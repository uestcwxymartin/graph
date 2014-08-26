package normalisiert.utils.graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import com.process.SplitUtil;

public class Sort {

	public ArrayList<PointNode> ReadArrlist(String path) {

		String encoding = "utf-8";
		ArrayList<PointNode> alo = new ArrayList<PointNode>();
		int i = 0;
		try {

			File file = new File(path);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					SplitUtil su = new SplitUtil();
					String[] tokens = su.split(lineTxt, ' ');
					for (int j = 0; j < tokens.length; j++) {
						PointNode pn = new PointNode(i, j,Integer.parseInt(tokens[j]));
						alo.add(pn);
					}
					i++;
				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return alo;
	}

	@SuppressWarnings("unchecked")
	public void SortArrlist(ArrayList<PointNode> al) {
		Collections.sort(al);
	}

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort st = new Sort();
		ArrayList<PointNode> al = new ArrayList<PointNode>();
		al = st.ReadArrlist("G:\\��һ\\������\\����ͼ�Ĵ�·����\\24point1\\weight_24.txt");

		st.SortArrlist(al);
		for (PointNode pointNode : al) {
			System.out.print(pointNode.value+" "+pointNode.x+" "+pointNode.y+" ");
		}
	}*/

}
