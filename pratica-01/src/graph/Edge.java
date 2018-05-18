package graph;

public class Edge implements Comparable {
	private Integer v1;
	private Integer v2;
	private Double weight;
	
	public Edge(final Integer v1, final Integer v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public Edge(final Integer v1, final Integer v2, Double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public Integer getV1() {
		return v1;
	}

	public Integer getV2() {
		return v2;
	}
	
	public void setV1(int v1) {
		this.v1 = v1;
	}
	
	public void setV2(int v2) {
		this.v2 = v2;
	}

	public Double getWeight() {
		return weight;
	}

	public boolean isLoop() {
		return v1 == v2;
	}
	
	public void setWeight(Double weight) {
		this.weight = weight;
	}
		
	@Override
    public int compareTo(Object o) {
        Edge edge = (Edge) o;
        if (v1.equals(edge.getV1()) && v2.equals(edge.getV2())) {
        	return 0;
        } else {
        	return 1;
        }
    }
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return v1.equals(edge.getV1());
    }

	@Override
	public String toString() {
		return "(" + v1 + "-" + v2 + "): " + weight;
	}
}
