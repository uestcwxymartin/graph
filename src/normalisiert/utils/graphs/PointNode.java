package normalisiert.utils.graphs;

@SuppressWarnings("rawtypes")
public class PointNode implements Comparable{
	public int x;
	public int y;
	public int value;
	/*public PointNode(int x, int y, int value) {//���ڽ����͵�weightʹ��
		super();
		this.x = x;
		this.y = y+x+1;
		this.value = value;
	}*/
	public PointNode(int x, int y, int value) {//���ڷ��εľ���ʹ��
		super();
		this.x = x;
		if (x>y) {
			this.y = y;
		}else
			this.y = y+1;
		this.value = value;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	@Override
	/*public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return ((PointNode)arg0).value-this.value;//����
	}*/
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return this.value-((PointNode)arg0).value;//����
	}
	public String toString()
	{
		return "Bian [x=" + x + ", y=" + y + ", value="
				+ value + "]";
	}

}
