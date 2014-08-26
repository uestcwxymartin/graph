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
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
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
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
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
		al = st.ReadArrlist("G:\\研一\\教研室\\无向图的大环路处理\\24point1\\weight_24.txt");

		st.SortArrlist(al);
		for (PointNode pointNode : al) {
			System.out.print(pointNode.value+" "+pointNode.x+" "+pointNode.y+" ");
		}
	}*/

}
