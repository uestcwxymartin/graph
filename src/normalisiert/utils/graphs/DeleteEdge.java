package normalisiert.utils.graphs;

import java.util.ArrayList;

public class DeleteEdge {

	/**
	 * @param args
	 */
	public int[] doDeleteEdge(ArrayList<PointNode> pn,int numOfPoint)
	{
		int a[] =new int[numOfPoint];
		for (int i=0;i<numOfPoint;i++) {//��ʼ��һά���飬�����洢ÿһ���ڵ�Ķ���
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
			i = pn.indexOf(pointNode);//��ȡ��ɾ��Ԫ��λ��
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
		int num = 24;//ͼ�е������
		Sort st = new Sort();
		ArrayList<PointNode> al = new ArrayList<PointNode>();
		al = st.ReadArrlist("G:\\��һ\\������\\����ͼ�Ĵ�·����\\24point1\\weight_24.txt");

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
