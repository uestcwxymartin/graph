package normalisiert.utils.graphs;

public class Bian implements Comparable //����֮��ļ�Ȩ��
{
	private int first,second;//��ʾһ���ߵ������ڵ�
	private int value;//Ȩֵ
	
	public Bian(int first, int second, int value)
	{
		this.first = first;
		this.second = second;
		this.value = value;
	}
	public int getFirst()
	{
		return first;
	}
	public int getSecond()
	{
		return second;
	}
	public int getValue()
	{
		return value;
	}
	@Override
	public int compareTo(Object arg0)
	{
		return value > ((Bian)arg0).value?1:(value == ((Bian)arg0).value?0:-1);
	}
	@Override
	public String toString()
	{
		return "Bian [first=" + first + ", second=" + second + ", value="
				+ value + "]";
	}
	
}