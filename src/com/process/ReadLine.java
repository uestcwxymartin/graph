package com.process;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadLine {

	/**
	 * @param args
	 */
	public long[][] readTxtFile(String filePath){
		long[][] list = new long[115475][];
		int i =0;
        
        try {
                String encoding="utf-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	list[i] = new long[3];
//                        System.out.println(lineTxt);
                    	SplitUtil su =new SplitUtil();
                    	String []tokens=su.split(lineTxt,' ');
//                    	System.out.println("tokens.length"+tokens.length);
//                    	Pattern pattern = Pattern.compile("//d+");
                    	for(int j=0;j<tokens.length;j++)
                    	{
//                    		System.out.println("i"+i);
//                    		System.out.println("j"+j);
//                    		System.out.println(tokens[j]);
                    		if (j==0) continue;
//                    		Matcher matcher = pattern.matcher(tokens[j]);
//                    		matcher.group();
                    		list[i][j-1] =(long)Double.parseDouble(tokens[j]);

//                    		System.out.println("list[i][j-1]"+list[i][j-1]);
                    	}
                        i++;
                    }
                    System.out.println("i\t"+i);
                    read.close();
        }else{
            System.out.println("找不到指定的文件");
        }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
		return list;
     
    }
	
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "G:\\研一\\教研室\\无向图的大环路处理\\usa115475.tsp.txt";
		ReadLine rl = new ReadLine();
        rl.readTxtFile(filePath);

	}*/

}
