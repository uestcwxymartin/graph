package normalisiert.utils.useful;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.process.SplitUtil;

public class SmallTwoPoint {

	/**
	 * @param args
	 * 输入距离的对角矩阵，输出最小的两条边的位置
	 */
	/**
	 * @param filePathIn
	 * @param filePathOut
	 * @param sizeOfPoint
	 */
	/**
	 * @param filePathIn
	 * @param filePathOut
	 * @param sizeOfPoint
	 */
	@SuppressWarnings("unchecked")
	public void findTwoSmallPoint(String filePathIn,String filePathOut) {
		int i = 0;
		long minum = 0, secoMinum = 0;
		ArrayList<Integer> minPosition = new ArrayList<Integer>();
		ArrayList<Integer> secoMinPosition = new ArrayList<Integer>();
		ArrayList<Integer> tmpposion = new ArrayList<Integer>();
		long tmp = 0;
		try {
			String encoding = "utf-8";
			File fileHou = new File(filePathIn);
//			File fileQian = new File(filePathQian);
			if (fileHou.isFile() && fileHou.exists()) { // 判断文件是否存在
				InputStreamReader readHou = new InputStreamReader(
						new FileInputStream(fileHou), encoding);// 考虑到编码格式
				BufferedReader bufferedReaderHou = new BufferedReader(readHou);
				String lineTxt = null;
				ArrayList<HashMap<Long, Long>> twoPoint = new ArrayList<HashMap<Long,Long>>();//用來存放兩個最小值
				while ((lineTxt = bufferedReaderHou.readLine()) != null) {
					SplitUtil su = new SplitUtil();
					String[] tokens = su.split(lineTxt, ' ');
//					list[i] = new long[tokens.length];
//					HashMap<Integer, ArrayList<Long>> hmSmallPoint = new HashMap<Integer, ArrayList<Long>>();
					HashMap<Long, Long> hmTmp = new HashMap<Long, Long>();
					for (int j = 0; j < tokens.length; j++) {
						// list[i][j] =Integer.parseInt(tokens[j]);//先注释掉
						/*
						 * int a = Integer.parseInt(tokens[j]); int sizeofpoint
						 * = list[a].length; list[a][sizeofpoint]=i;
						 */
						// System.out.println("list[i][j-1]"+list[i][j-1]);
						if (j == 0) {// 初始化两个最小值
							if (Integer.parseInt(tokens[0]) < Integer.parseInt(tokens[1])) {
								secoMinum = Integer.parseInt(tokens[1]);
								minum = Integer.parseInt(tokens[1]);
							} else {
								secoMinum = Integer.parseInt(tokens[0]);
								minum = Integer.parseInt(tokens[0]);
							}//挑选前两个点中较大的点作为初始值
						}
						if (secoMinum >= Integer.parseInt(tokens[j])) {
							if (j<i&&i!=0) {
								hmTmp = twoPoint.get(j);
								if(hmTmp.containsKey(Long.parseLong(tokens[j])))
								continue;
							}
							if (minum > Integer.parseInt(tokens[j])) {//最小值比当前值大
								tmp = minum;// 暂存最小值给次小值
								minum = Integer.parseInt(tokens[j]);
								secoMinum = tmp;
								tmpposion = (ArrayList<Integer>)minPosition.clone();// 暂存最小值的位置给次小值位置
								/*if (i == sizeOfPoint - 2||i==sizeOfPoint-1)minPosition = j;
								else*/ 
								minPosition.removeAll(minPosition);//将存储最小位置的邻接矩清空，用于存储新的数据
								if (j>=i) {
									minPosition.add(j+1);
								}else minPosition.add(j);
								secoMinPosition = tmpposion;
							} else if (minum == Integer.parseInt(tokens[j])) {//最小值和当前值相等
								if (j>=i) {
									minPosition.add(j+1);
								}else minPosition.add(j);
							}else if (secoMinum == Integer.parseInt(tokens[j])) {//次小值和当前值相等
								if (j>=i) {
									secoMinPosition.add(j+1);
								}else secoMinPosition.add(j);
							} else{
								secoMinum = Integer.parseInt(tokens[j]);
								/*if (i == sizeOfPoint - 2||i==sizeOfPoint-1)secoMinPosition = j;
								else*/ 
								secoMinPosition.removeAll(secoMinPosition);//将存储次小位置的邻接矩清空，用于存储新的数据
								if (j>=i) {
									secoMinPosition.add(j+1);
								}else secoMinPosition.add(j);
							}
						}
					}
					HashMap<Long, Long> pointMap = new HashMap<Long, Long>();
					pointMap.put(minum, minum);pointMap.put(secoMinum, secoMinum);
					twoPoint.add(pointMap);
					String lineOut = "";
					for (int k = 0; k < minPosition.size(); k++) {
						lineOut += minPosition.get(k)+" ";
					}
					for (int k = 0; k < secoMinPosition.size(); k++) {
						lineOut += secoMinPosition.get(k)+" ";
					}
					writeToTwotxt(lineOut,filePathOut);//写最小两个点的位置给txt文档
					i++;
				}
				readHou.close();
			} else {
				System.out.println("找不到指定的文件3");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
	}

	/*private ArrayList<Integer> ProcessPoint() {
		// TODO Auto-generated method stub
		// int[] list = new int[sizeOfPoint-1];
		ArrayList<Integer> al = new ArrayList<Integer>();
		try {
			String encoding = "utf-8";
			File file = new File(
					"G:\\研一\\教研室\\无向图的大环路处理\\daoShuDiYiGeDian_1.txt");
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					SplitUtil su = new SplitUtil();
					String[] tokens = su.split(lineTxt, ' ');
					// list[i] = new long[tokens.length];
					for (int j = 0; j < tokens.length; j++) {
						// list[j] =Integer.parseInt(tokens[j]);//先注释掉
						al.add(Integer.parseInt(tokens[j]));
					}
				}
				// System.out.println("i\t"+i);
				read.close();
			} else {
				System.out.println("找不到指定的文件1");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return al;
	}*/

	/*private ArrayList<Integer> ProcessPoint2() {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<Integer>();
		try {
			String encoding = "utf-8";
			File file = new File(
					"G:\\研一\\教研室\\无向图的大环路处理\\daoShuDiERGeDian_2.txt");
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					SplitUtil su = new SplitUtil();
					String[] tokens = su.split(lineTxt, ' ');
					// list[i] = new long[tokens.length];
					for (int j = 0; j < tokens.length; j++) {
						// list[j] =Integer.parseInt(tokens[j]);//先注释掉
						al.add(Integer.parseInt(tokens[j]));
					}
				}
				// System.out.println("i\t"+i);
				read.close();
			} else {
				System.out.println("找不到指定的文件2");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return al;
	}*/

	public void writeToTwotxt(String a,String pathOut) {
		try {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(
							new File(pathOut),true));

			writer.write(a);
			writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void writeToLastPointTxt(String a, String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					path), true));
			writer.write(a);
			// writer.write("\r\n");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallTwoPoint stp = new SmallTwoPoint();
		stp.findTwoSmallPoint("G:\\研一\\教研室\\无向图的大环路处理\\100point\\distanceXml_100.txt", "G:\\研一\\教研室\\无向图的大环路处理\\100point\\distanceTwoSmallPointXml_100.txt");
	}

}
