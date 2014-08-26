package normalisiert.utils.graphs;

import java.util.ArrayList;

public class DeleteEdge {

	/**
	 * @param args
	 */
	public int[] doDeleteEdge(ArrayList<PointNode> pn,int numOfPoint)
	{
		int a[] =new int[numOfPoint];
		for (int i=0;i<numOfPoint;i++) {//初始化一维数组，用来存储每一个节点的度数
			a[i] = numOfPoint-1;
		}
		int i=0,j=0,m=0;
		PointNode pointNode = new PointNode(0, 0, 0);
		while(m<(numOfPoint-1)*(numOfPoint-1)&&j<pn.size()) {
			
			pointNode = pn.get(j);
			if (a[pointNode.x]<(int)(0.5*(numOfPoint+1))&&a[pointNode.y]<(int)(0.5*(numOfPoint+1))) {
				m++;
				j++;
				continue;
			}
			i = pn.indexOf(pointNode);//获取待删除元素位置
			pn.remove(i);
			a[pointNode.x] --;a[pointNode.y] --;
			m++;
//			System.out.print(pointNode.value+" "+pointNode.x+" "+pointNode.y+" ");
//			System.out.println(a[23]+"a[23]");
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 24;//图中点的数量
		Sort st = new Sort();
		ArrayList<PointNode> al = new ArrayList<PointNode>();
		al = st.ReadArrlist("G:\\研一\\教研室\\无向图的大环路处理\\24point1\\weight_24.txt");

		st.SortArrlist(al);
		DeleteEdge de = new DeleteEdge();
		int a[] =de.doDeleteEdge(al,num);
		for (int i = 0; i < a.length; i++) {
			System.out.print(" "+a[i]);
		}
		System.out.println();
		for (PointNode pointNode : al) {
			System.out.print(pointNode.value+" "+pointNode.x+" "+pointNode.y+" ");
		}
		System.out.println(al.size()+"pointNode");
	}

}
