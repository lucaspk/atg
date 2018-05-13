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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return vertex.equals(pair.vertex);
    }

    @Override
    public int hashCode() {
        return vertex.hashCode();
    }
}
