package normalisiert.utils.useful;

import java.util.List;
import java.util.Vector;

import normalisiert.utils.graphs.AdjacencyListForAddPoint;
import normalisiert.utils.graphs.AdjacencyListForMST;
import normalisiert.utils.graphs.AdjacencyListForNewCheck;




public class ElementaryCyclesSearch {
	
	private List cycles = null;

	private int matrix = 0;
	
	private int[][] adjList = null;

	
	private Object[] graphNodes = null;

	
	private boolean[] blocked = null;

	
	private Vector[] B = null;

	
	private Vector stack = null;

	
	public ElementaryCyclesSearch(int matrix, Object[] graphNodes) {
//		public ElementaryCyclesSearch(boolean[][] matrix, Object[] graphNodes) {
		this.matrix = matrix;
		this.graphNodes = graphNodes;
//		this.adjList = AdjacencyListNew.getAdjacencyList(matrix);
//		this.adjList = AdjacencyListForNewCheck.returnList();
//		this.adjList = AdjacencyListForAddPoint.returnList(matrix);
		this.adjList = AdjacencyListNew.getAdjacencyList(matrix);
	}

	
	public List getElementaryCycles() {
		this.cycles = new Vector();
		this.blocked = new boolean[this.adjList.length];
		this.B = new Vector[this.adjList.length];
		this.stack = new Vector();
		StrongConnectedComponents sccs = new StrongConnectedComponents(this.adjList);//强连通分量
		int s = 0;

		while (true) {
			SCCResult sccResult = sccs.getAdjacencyList(s);
			if (sccResult != null && sccResult.getAdjList() != null) {
				Vector[] scc = sccResult.getAdjList();
				s = sccResult.getLowestNodeId();
				if (s!=0) {
					break;
				}//大环路必须是包含所有点，即从节点0开始的环路
				for (int j = 0; j < scc.length; j++) {
					if ((scc[j] != null) && (scc[j].size() > 0)) {
						this.blocked[j] = false;
						this.B[j] = new Vector();
					}
				}

				
				this.findCycles(s, s, scc);
				s++;
			} else {
				break;
			}
		}

		return this.cycles;
	}

	
	@SuppressWarnings("unchecked")
	private boolean findCycles(int v, int s, Vector[] adjList) {
		boolean f = false;
		this.stack.add(new Integer(v));
		this.blocked[v] = true;

		for (int i = 0; i < adjList[v].size(); i++) {
			int w = ((Integer) adjList[v].get(i)).intValue();
			// found cycle
			if (w == s) {
				@SuppressWarnings("rawtypes")
				Vector cycle = new Vector();
				for (int j = 0; j < this.stack.size(); j++) {
					int index = ((Integer) this.stack.get(j)).intValue();
//					System.out.println("index"+index);
					cycle.add(this.graphNodes[index]);
				}
				if (this.cycles.size()!=0) {//当只找一个环路时
					if (f) {
						this.unblock(v);
					} else {
						for (int i1 = 0; i1 < adjList[v].size(); i1++) {
							int w1 = ((Integer) adjList[v].get(i1)).intValue();
							if (!this.B[w1].contains(new Integer(v))) {
								this.B[w1].add(new Integer(v));
							}
						}
					}

					this.stack.remove(new Integer(v));
					return f;
				}//end
				if (cycle.size()>=matrix*1) {
					this.cycles.add(cycle);
					f = true;
					break;
				}
//				this.cycles.add(cycle);
				
				f = true;
			} else if (!this.blocked[w]) {
				if (this.findCycles(w, s, adjList)) {
					f = true;
				}
			}
		}

		if (f) {
			this.unblock(v);
		} else {
			for (int i = 0; i < adjList[v].size(); i++) {
				int w = ((Integer) adjList[v].get(i)).intValue();
				if (!this.B[w].contains(new Integer(v))) {
					this.B[w].add(new Integer(v));
				}
			}
		}

		this.stack.remove(new Integer(v));
		return f;
	}

	
	private void unblock(int node) {
		this.blocked[node] = false;
		Vector Bnode = this.B[node];
		while (Bnode.size() > 0) {
			Integer w = (Integer) Bnode.get(0);
			Bnode.remove(0);
			if (this.blocked[w.intValue()]) {
				this.unblock(w.intValue());
			}
		}
	}
}

