package graph;

public class Vertex implements Comparable{

	private Integer value;
	private boolean visited = false;
	
	public Vertex(Integer value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public boolean isVisited() { 
		return visited;
	}
	
	public void setVisited() {
		visited = true;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Vertex vertex = (Vertex) o;
		return (vertex.getValue() != null && value == vertex.getValue());
	}
	
	@Override
	public String toString() {
		return "Value = " + value;
	}

	@Override
	public int compareTo(Object v) {
		Vertex vertex = (Vertex) v;

        if (this.equals(vertex)) {
        	return 0;
        } else {
        	return 1;
        }
	}
	
    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
