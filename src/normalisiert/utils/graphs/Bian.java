package normalisiert.utils.graphs;

public class Bian implements Comparable //两点之间的加权边
{
	private int first,second;//表示一条边的两个节点
	private int value;//权值
	
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