package normalisiert.utils.graphs;

import java.util.ArrayList;


public class Shuzu {

	/**
	 * @param args
	 */
	static ArrayList<ArrayList> list = new ArrayList<ArrayList>();//���ÿһ�������еĽڵ������
	static ArrayList<ArrayList> bianList = new ArrayList<ArrayList>();//��Ӧ��������еıߵ�����
	public static void check(PointNode b)//������ĸ�������
	{
		if(list.size() == 0)
		{
			ArrayList<Integer> sub = new ArrayList<Integer>();
			sub.add(b.getX());
			sub.add(b.getY());
			list.add(sub);
			ArrayList<PointNode> bian = new ArrayList<PointNode>();
			bian.add(b);
			bianList.add(bian);
			return;
		}
		int first = b.getX();
		int shuyu1 = -1;
		int second = b.getY();
		int shuyu2 = -1;
		for(int i = 0;i<list.size();i++)//��������ڵ�ֱ������ĸ�����
		{
			for(int m = 0;m<list.get(i).size();m++)
			{
				if(first == (Integer)list.get(i).get(m))
					shuyu1 = i;
				if(second == (Integer)list.get(i).get(m))
					shuyu2 = i;
			}
		}
		if(shuyu1 == -1 && shuyu2 ==-1)//��ʾ�������ڵ㶼û����Ҫ�¼���
		{
			ArrayList<Integer> sub = new ArrayList<Integer>();
			sub.add(b.getX());
			sub.add(b.getY());
			list.add(sub);
			ArrayList<PointNode> bian = new ArrayList<PointNode>();
			bian.add(b);
			bianList.add(bian);
		}
		if(shuyu1 == -1 && shuyu2 != -1)//��ʾ��һ�����Ѿ���������ֻ����һ������Ϳ�����
		{
			list.get(shuyu2).add(first);
			bianList.get(shuyu2).add(b);
		}
		if(shuyu2 == -1 && shuyu1 != -1)//��ʾ��һ�����Ѿ���������ֻ����һ������Ϳ�����
		{
			list.get(shuyu1).add(first);
			bianList.get(shuyu1).add(b);
		}
		if(shuyu1 == shuyu2 && shuyu1 != -1)//����������ͬһ������ ���γɻ�
		{
			
		}
		if(shuyu1 != shuyu2 && shuyu1 != -1 && shuyu2 != -1)//��ʾ�������ڲ�ͬ������ ��Ҫ�ϲ�
		{
			for(int i = 0;i<list.get(shuyu2).size();i++)
			{
				list.get(shuyu1).add(list.get(shuyu2).get(i));
			}
			list.remove(shuyu2);
			for(int i = 0;i<bianList.get(shuyu2).size();i++)
			{
				bianList.get(shuyu1).add(bianList.get(shuyu2).get(i));
			}
			bianList.get(shuyu1).add(b);
			bianList.remove(shuyu2);
		}
	}
	public static void show()
	{
		for(int i = 0;i<bianList.get(0).size();i++)
			System.out.println(bianList.get(0).get(i));
		System.out.println("bianList.get(0).size()"+bianList.get(0).size());
	}
}
