package normalisiert.utils.useful;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import com.process.SplitUtil;

public class WeightInput {

	/**
	 * @param args
	 */
	public int[][] getWeightAdjacencyList(int pointNum) {
		int[][] list = new int[pointNum][];
		int i =0;
        
        try {
                String encoding="utf-8";
                File file=new File("G:\\研一\\教研室\\无向图的大环路处理\\24point\\weight_24.txt");
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    
                    while((lineTxt = bufferedReader.readLine()) != null){
//                        System.out.println(lineTxt);
                    	SplitUtil su =new SplitUtil();
                    	String []tokens=su.split(lineTxt,' ');
//                    	System.out.println("tokens.length"+tokens.length);
//                    	Pattern pattern = Pattern.compile("//d+");
                    	list[i] = new int[tokens.length];//邻接表的长度，用于初始化数组
                    	for(int j=0;j<tokens.length;j++)
                    	{
//                    		System.out.println("i"+i);
//                    		System.out.println("j"+j);
//                    		System.out.println(tokens[j]);
                    		list[i][j] =Integer.parseInt(tokens[j]);
                    		/*int a = Integer.parseInt(tokens[j]);
                    		int sizeofpoint = list[a].length;
                    		list[a][sizeofpoint]=i;*/
//                    		System.out.println("list[i][j-1]"+list[i][j-1]);
                    	}
                        i++;
                    }
//                    System.out.println("i\t"+i);
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        /*for (int j = 0; j < list.length; j++) {//用来输出邻接矩阵
		for (int j2 = 0; j2 < 6; j2++) {
			System.out.print(list[j][j2]);
		}
		System.out.println();
	}*/
		return list;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
