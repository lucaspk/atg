package graph;

public class Edge {
	private int v1;
	private int v2;
	private float weight;
	
	public Edge(final int v1, final int v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public Edge(final int v1, final int v2, float weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public int getV1() {
		return v1;
	}

	public int getV2() {
		return v2;
	}
	
	public void setV1(int v1) {
		this.v1 = v1;
	}
	
	public void setV2(int v2) {
		this.v2 = v2;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "(" + v1 + "-" + v2 + "): " + weight;
	}
}
