import java.util.ArrayList;

public class Selection {

    private String name;
    private int rank;
    private ArrayList<Selection> defeated;

    public Selection(String name) {
        this.name = name;
        this.rank = 0;
        this.defeated = new ArrayList<Selection>;
    }

    public Selection(String name, int rank, ArrayList<Selection> defeated) {
        this.name = name;
        this.rank = rank;
        this.defeated = defeated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public ArrayList<Selection> getDefeated() {
        return defeated;
    }

    public void setDefeated(ArrayList<Selection> defeated) {
        this.defeated = defeated;
    }

    public void addDefeated(Selection defeated) {
        this.defeated.add(defeated);
    }

    public String toString() { return this.getName(); }

    public boolean equals(Selection S){
        return this.name == S.getName();
    }

}
