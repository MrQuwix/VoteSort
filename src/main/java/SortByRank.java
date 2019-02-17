import java.util.Comparator;

public class SortByRank implements Comparator<Selection> {
    public int compare(Selection o1, Selection o2) {
        return o2.getRank() - o1.getRank();
    }
}
