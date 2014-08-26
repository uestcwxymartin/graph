package normalisiert.utils.useful;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class TestCycles {
	
	 /*private static String readString5(String prompt) { 
	        Scanner scanner = new Scanner(System.in); 
	        System.out.print(prompt); 
	        return scanner.nextLine(); 
	    } */

	public static void main(String[] args) {
		
//		boolean adjMatrix[][] = new boolean[10000][10000];//CFG代表的邻接矩阵
//		int adjMatrixTest[][] = new int[1000000][1000000];//权重邻接矩阵
//		int result[][] =new int [10000][10000];//用来存放所有路径的数组
		int num = 0;//用来计数总路径数
		
		//尾部到首部连接
//		adjMatrix[nail][2] = true;
//		adjMatrixTest=adjMatrix;//将邻接矩阵保存
		
		
//		String str = "115475";
		String str = "76";
		//有向完全图
//		str = readString5("请输入随机图的节点数：");
		int strnum = Integer.parseInt(str);
		String nodes[] = new String[strnum];
		for (int i = 0; i < strnum; i++) {
//			nodes[i] = "Node " + i;
			nodes[i] = String.valueOf(i);
		}
		
		long lasting = System.currentTimeMillis();
	
			
//			System.out.println("这个是随机图！");
		
		/*for (int i = 1; i <= strnum; i++) {
				
			if (i==strnum) {
				adjMatrix[i][1] = true;
//				adjMatrix[1][i] = true;
			}else{
				adjMatrix[i][i+1] = true;
//				adjMatrix[i+1][i] = true;
			}
		}*/
			/*for (int i = 1; i <= strnum; i++) {
				for (int j = 1; j <= strnum; j++) {
					if (j==i) {
						continue;
					}
					int randedge = new java.util.Random().nextInt(100);
//					System.out.println("randedge"+randedge);
					if (randedge>2) {
						continue;
					}
					adjMatrix[i][j] = true;
//					adjMatrix[j][i] = true;
					int randNum = new java.util.Random().nextInt(strnum*(strnum-1)/2);
					while (randNum==0){
						randNum = new java.util.Random().nextInt(strnum*(strnum-1)/2);
					} 
					adjMatrixTest[i][j] = randNum;权重矩阵，暂时用不到

				}

			}*/
		
		/*adjMatrix[11][1] = true;
		*/
		/*for (int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				System.out.print(adjMatrixTest[i][j]);
				if((j+1)%10==0)
				System.out.println();
			}
		}*/
		

		ElementaryCyclesSearch ecs = new ElementaryCyclesSearch(strnum,nodes);
		List cycles = ecs.getElementaryCycles();
//		int minWeight = 0;
//		int weight[] = new int[cycles.size()] ;
		int size[] = new int[cycles.size()] ;
		int maxSize = 0;
		for (int i = 0; i < cycles.size(); i++) {

			List cycle = (List) cycles.get(i);
			
			size[i] = cycle.size();
			if (cycle.size()>=maxSize) {
//				&&
				maxSize = cycle.size();
			}
//			System.out.println("\t weight="+weight[i]);
		}
		
		List<Integer> maxWeightNo = new ArrayList<Integer>();
		/*for (int i = 0; i < weight.length; i++) {
			if (size[i]==maxSize) {
				if (weight[i]<=minWeight) {
					minWeight = weight[i];
				}
			}
		}*/
//		System.out.println("minWeight"+minWeight);
		/*for (int i = 0; i < weight.length; i++) {
			if (weight[i]==minWeight&&size[i]==maxSize) {
				maxWeightNo.add(i+1); 
			}
		}*/
		//下面的for用于循环输出
		int tiaoshu = 0;
		int weight = 0;
		WeightCaclulate wc = new WeightCaclulate();
		for (int i = 0; i < cycles.size(); i++) {

//			System.out.println("maxSize"+maxSize);
//			System.out.println("size[i]"+size[i]);

			/*if (size[i]!=maxSize) {
				continue;
			}*/
			List cycle = (List) cycles.get(i);
			System.out.print("Cycle"+(i+1)+": ");
			for (int j = 0; j < cycle.size(); j++) {
				
				String node = (String) cycle.get(j);
				
				if (j < cycle.size() - 1) {
					System.out.print(Integer.parseInt(node)+1 + " -> ");
				} else {
					System.out.print(Integer.parseInt(node)+1);
				}
				
			}
			weight = wc.doWeightCaculate(cycle, strnum);
			System.out.println();
			System.out.println("  权重："+weight+"\t");
			tiaoshu++;
		}
			
			
		
		System.out.println("共有"+(cycles.size())+"条环路！");
//		System.out.println("其中节点数最多的环路有"+(tiaoshu)+"条！");
		if (cycles.size()!=0) {
//			System.out.println("其中节点数最多的环路中，边权重和最小的为：");
			for (int i = 0; i < maxWeightNo.size(); i++) {
				
				System.out.println("环路"+maxWeightNo.get(i));
			}
		}
		
			
		
		System.out.println("Running Time:" + (System.currentTimeMillis() - lasting) + " milliseconds");
		/*try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
