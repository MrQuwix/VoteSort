import java.util.*;

public class Selection implements Comparable{

    private String name;
    private int rank;
    private HashSet<Selection> defeated;

    public Selection(String name) {
        this.name = name;
        this.rank = 0;
        this.defeated = new HashSet<Selection>();
    }

    public Selection(String name, int rank, HashSet<Selection> defeated) {
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

    public HashSet<Selection> getDefeated() {
        return defeated;
    }

    public void setDefeated(HashSet<Selection> defeated) {
        this.defeated = defeated;
    }

    public void addDefeated(Selection defeated) {
        this.defeated.add(defeated);
    }

//    public void addAll(Selection defeated) {
//        if(defeated.getDefeated().size() != 0) {
//            Selection holder = new Selection("holder");
//            for (Selection temp : defeated.getDefeated() ) {
//                this.addDefeated(temp);
//                this.addAll(temp);
//            }
//        }
//    }

    public List<Selection> sort(){
        List<Selection> defeatedList = new ArrayList<Selection>(this.defeated);
        Collections.sort(defeatedList);
        return defeatedList;
    }

    public String toString() { return this.getName(); }

    public boolean equals(Selection S){
        return this.name == S.getName();
    }

    @Override
    public int compareTo(Object o) {
        Selection S = (Selection) o;
        return this.name.compareTo( S.getName());
    }
}
