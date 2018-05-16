package graph;

public class Edge implements Comparable {
	private Vertex v1;
	private Vertex v2;
	private Double weight;
	
	public Edge(final Vertex v1, final Vertex v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	public Edge(final Vertex v1, final Vertex v2, Double weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public Vertex getV1() {
		return v1;
	}

	public Vertex getV2() {
		return v2;
	}
	
	public void setV1(Vertex v1) {
		this.v1 = v1;
	}
	
	public void setV2(Vertex v2) {
		this.v2 = v2;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	@Override
    public int compareTo(Object o) {
        Edge edge = (Edge) o;
        if (v1.equals(edge.getV1()) && v2.equals(edge.getV2())) {
        	return 0;
        }
        return 1;
    }
	
    @Override
    public boolean equals(Object o) {
    	
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (this.equals(edge)) {
        } else {
        	System.out.println("Nem");
        }

        return this.equals(edge);
    }

	@Override
	public String toString() {
		return "(" + v1.getValue() + "-" + v2.getValue() + "): " + weight;
	}
	
    @Override
    public int hashCode() {
        return v1.hashCode() + v2.hashCode();
    }
}
