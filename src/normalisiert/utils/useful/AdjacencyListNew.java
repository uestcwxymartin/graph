package normalisiert.utils.useful;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import com.process.DistanceAdjenst;
import com.process.SplitUtil;

public class AdjacencyListNew {
	static int[][] list ;
	
	public static int[][] getAdjacencyList(int adjacencyMatrix) {
		list = new int[adjacencyMatrix][];
		boolean[][] list1 = new boolean[adjacencyMatrix][adjacencyMatrix];
		
        
        try {
                String encoding="utf-8";
//                File file=new File("G:\\��һ\\������\\����ͼ�Ĵ�·����\\48point\\distance_48_biao.txt");
                File file=new File("G:\\�ж�\\��Ŀ\\TSP\\TSP����johnson\\pr76_CandidateSet_EdgeList1.txt");
                if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//���ǵ������ʽ
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    int j=0;int i =0;
                    while((lineTxt = bufferedReader.readLine()) != null){
//                        System.out.println(lineTxt);
                    	SplitUtil su =new SplitUtil();
                    	String []tokens=su.split(lineTxt,' ');
//                    	System.out.println("tokens.length"+tokens.length);
//                    	Pattern pattern = Pattern.compile("//d+");
//                    	list[i] = new int[tokens.length];//�ڽӱ�ĳ��ȣ����ڳ�ʼ������
//                    	for(int j=0;j<tokens.length;j++)
//                    	{
//                    		System.out.println("i"+i);
//                    		System.out.println("j"+j);
//                    		System.out.println(tokens[j]);
                    	if (tokens.length<2) {
							break;
						}
                    	i = Integer.parseInt(tokens[0])-1;
                    	j = Integer.parseInt(tokens[tokens.length-1])-1;
//                    	System.out.println("i "+i+" jj "+Integer.parseInt(tokens[tokens.length-1]));
                    	list1[i][j] =true;
                    	list1[j][i] =true;
                    		/*int a = Integer.parseInt(tokens[j]);
                    		int sizeofpoint = list[a].length;
                    		list[a][sizeofpoint]=i;*/
//                    		System.out.println("list[i][j-1]"+list[i][j-1]);
//                    	}
//                        i++;
                    }
                    for (i = 0; i < list1.length; i++) {
            			Vector v = new Vector();
            			for (j = 0; j < list1[i].length; j++) {
            				if (list1[i][j]) {
            					v.add(new Integer(j));
            				}
            			}

            			list[i] = new int[v.size()];
            			for (j = 0; j < v.size(); j++) {
            				Integer in = (Integer) v.get(j);
            				list[i][j] = in.intValue();
            			}
            		}
                    
//                    System.out.println("i\t"+i);
                    read.close();
        }else{
            System.out.println("�Ҳ���ָ�����ļ�");
        }
        } catch (Exception e) {
            System.out.println("��ȡ�ļ����ݳ���1");
            e.printStackTrace();
        }
        /*for (int j = 0; j < list.length; j++) {//��������ڽӾ���
		for (int j2 = 0; j2 < 6; j2++) {
			System.out.print(list[j][j2]);
		}
		System.out.println();
	}*/
		return list;
		
	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		AdjacencyListNew rl = new AdjacencyListNew();
//        AdjacencyListNew.getAdjacencyList(48);
//	}

}
