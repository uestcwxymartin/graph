package normalisiert.utils.graphs;

import java.util.ArrayList;


public class Shuzu {

	/**
	 * @param args
	 */
	static ArrayList<ArrayList> list = new ArrayList<ArrayList>();//存放每一个数组中的节点的数组
	static ArrayList<ArrayList> bianList = new ArrayList<ArrayList>();//对应存放数组中的边的数组
	public static void check(PointNode b)//检查在哪个数组中
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
		for(int i = 0;i<list.size();i++)//检查两个节点分别属于哪个数组
		{
			for(int m = 0;m<list.get(i).size();m++)
			{
				if(first == (Integer)list.get(i).get(m))
					shuyu1 = i;
				if(second == (Integer)list.get(i).get(m))
					shuyu2 = i;
			}
		}
		if(shuyu1 == -1 && shuyu2 ==-1)//表示这两个节点都没有需要新加入
		{
			ArrayList<Integer> sub = new ArrayList<Integer>();
			sub.add(b.getX());
			sub.add(b.getY());
			list.add(sub);
			ArrayList<PointNode> bian = new ArrayList<PointNode>();
			bian.add(b);
			bianList.add(bian);
		}
		if(shuyu1 == -1 && shuyu2 != -1)//表示有一个点已经在数组中只把另一个加入就可以了
		{
			list.get(shuyu2).add(first);
			bianList.get(shuyu2).add(b);
		}
		if(shuyu2 == -1 && shuyu1 != -1)//表示有一个点已经在数组中只把另一个加入就可以了
		{
			list.get(shuyu1).add(first);
			bianList.get(shuyu1).add(b);
		}
		if(shuyu1 == shuyu2 && shuyu1 != -1)//表述两个在同一个组中 会形成环
		{
			
		}
		if(shuyu1 != shuyu2 && shuyu1 != -1 && shuyu2 != -1)//表示两个点在不同的组中 需要合并
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
