package graph;

public class Pair implements Comparable {
    private Integer vertex;
    private float weight;

    public Pair (Integer v, float w) {
        this.vertex = v;
        this.weight = w;
    }

    public Integer getVertex() {
        return vertex;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Object o) {
        Pair p = (Pair) o;
        return vertex.compareTo(p.getVertex());
    }
}
