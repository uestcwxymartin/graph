package com.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DistanceAdjenst {

	/**
	 * @param args
	 */
	public void CalauteDistance(String address) {
		long[][] list = new long[115475][2];
		long[] distance = new long[115475];
		int i =0;
//        list[i] = new long[120000];
        ReadLine rl = new ReadLine();
        list = rl.readTxtFile(address);
        long minum = 0,secoMinum=0,minPosition=0,secoMinPosition = 0;
        
        try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("G:\\��һ\\������\\����ͼ�Ĵ�·����\\distance.txt"), true));
			for (int j = 0; j < list.length; j++) {
				for (int k = j+1; k < list.length; k++) {
					if (k>=115475-j) {
						break;
					}
//					System.out.println("k"+k);
					distance[k-1]=(long) 
							(Math.sqrt(Math.pow((list[j][0]-list[k][0]),2)+Math.pow((list[j][1]-list[k][1]),2)));
					if (k==j+1) {//��ʼ��������Сֵ
						secoMinum=distance[k-1];
						minum = distance[k-1];
					}
					if (secoMinum>distance[k-1]) {
						if (minum>distance[k-1]) {
							minum = distance[k-1];
							minPosition = k;
						}else
						{
							secoMinum = distance[k-1];
							secoMinPosition = k;
						}
					
					}
					//����������������쳣״��
					if (distance[k-1]==0) {
						System.out.println("j"+j);
						System.out.println("1---2\t"+list[j][0]+"-----"+list[k][0]+"-----"+list[j][1]+"-----"+list[k][1]);
						System.out.println("(list[j][0]-list[k][0])^2"+((list[j][0]-list[k][0])^2)+"(list[j][1]-list[k][1])^2)"+((list[j][1]-list[k][1])^2));
					}//end
					String str = Long.toString(distance[k-1]);
//					writer.write(str+" ");
				}
				writer.write(minum+" "+secoMinum+" "+minPosition+" "+secoMinPosition);
				i++;
				writer.write("   This is end of point"+j);
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "G:\\��һ\\������\\����ͼ�Ĵ�·����\\usa115475.tsp.txt";
//		String txtPath = "G:\\��һ\\������\\����ͼ�Ĵ�·����\\properties.txt";
		DistanceAdjenst da = new DistanceAdjenst();
//		int a[] = new int[3];
		/*for (int i = 0; i < tu.readTxtForNo(txtPath).length; i++) {
			
			a[i]=Integer.parseInt(tu.readTxtForNo(txtPath)[i]);
		}*/
//		da.CalauteDistance(filePath,a[0],a[1]);
		da.CalauteDistance(filePath);
//		tu.writeTxtForNo(txtPath, a[0], a[1]);

	}

}
