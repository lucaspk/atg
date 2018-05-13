package graph;

public class VertexInfo {
    public Integer predecessor;
    public float distance;

    public VertexInfo(Integer predecessor, float distance){
        this.predecessor = predecessor;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "predecessor = " + predecessor +
                ", distance = " + distance;
    }
}
