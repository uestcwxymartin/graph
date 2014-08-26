package normalisiert.utils.hamierton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.lang.StringBuilder;

import normalisiert.utils.graphs.MSL;
import normalisiert.utils.graphs.PointNode;
import normalisiert.utils.graphs.Sort;

public class StringTest {

	/**
	 * @param args
	 */
	public String StringRecombination(String a) {// ��·��1��ʼ�����ַ���˳���������
		// TODO Auto-generated method stub
		int t = a.indexOf("1");
		if (t<=0) {
			return "konghang";
		}
//		 System.out.println("t"+t);
		String tmBack = a.substring(t);
		String tmFront = a.substring(0, t);
		String newString = tmBack + " " + tmFront;
		// System.out.println(newString+" newString");
		return newString;
	}

	public String StringReverse(String s1) {// ���ַ�����ת
		// System.out.println("a "+a.replaceAll(" ", ""));
		// System.out.println("b "+b.replaceAll(" ", ""));
		String s2 = null;
		for(int i=s1.length()-1;i>=0;i--)
		{
			if (s2==null) {
				s2 = s1.charAt(i)+"";
			}else	s2 += s1.charAt(i);
		}
		return s2;

	}

	ArrayList<ArrayList<String>> aap = new ArrayList<ArrayList<String>>();

	public ArrayList<String> ReadArrlist(String path) {// ��ȡ���ܶ���ͼ�������·��������1��ʼ�Ļ�·

		String encoding = "utf-8";
		String temp = null;
		ArrayList<String> cy = new ArrayList<String>();
		String zhiwei = null;
		int i = 0;
		try {
			File file = new File(path);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;

				while ((lineTxt = bufferedReader.readLine()) != null) {
					String[] tokens = lineTxt.split(" ");
					if (tokens[0].equals("1")) {
						temp = lineTxt.trim()+" 1";
					} else
					{
						zhiwei = StringRecombination(lineTxt.trim()).trim();
						if (zhiwei.equals("konghang")) {
							continue;
						}
						temp = zhiwei+" 1";
					}
					cy.add(temp);
					/*
					 * for (int j = 0; j < tokens.length; j++) { }
					 */
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
		return cy;
	}

	public HashMap<String, String> QuRongYu(ArrayList<String> als)// ȥ���໷·
	{
		HashMap<String, String> hm = new HashMap<String, String>();
		for (int i = 0; i < als.size(); i++) {
//			System.out.println("StringReverse(als.get(i)) "+i+" "+StringReverse(als.get(i)));
			if (hm.containsKey(als.get(i).trim())||hm.containsKey(StringReverse(als.get(i)))) {
				// als.remove(i);
			} else
				hm.put(als.get(i).trim(), als.get(i).replaceAll(" ", ""));
			// System.out.println(hm);
		}
		return hm;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringTest st = new StringTest();
		/*
		 * boolean bl = st.StringEqual(st.StringRecombination(a),
		 * st.StringRecombination(b)); System.out.println("bl " + bl);
		 */
		ArrayList<String> als = new ArrayList<String>();
		HashMap<String, String> bls = new HashMap<String, String>();
		als = st.ReadArrlist("G://��һ//������//����ͼ�Ĵ�·����//hamilton//Console//paths.txt");
//		als.add("1 2 3 4 ");als.add(" 1 2 3 4  ");
		/*
		 * for (String string : als) { System.out.println(""+string); }
		 */
		bls = st.QuRongYu(als);
		for (Iterator<String> iterator = bls.keySet().iterator(); iterator
				.hasNext();) {
			try {
				Object key = iterator.next();
				System.out.println(key.toString());
//				System.out.println(bls.get(key));
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		System.out.println("����"+bls.size()+"����·");
	}
}
