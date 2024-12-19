import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    
    private List<T> items = new ArrayList<>();

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        items.add(item);
        System.out.println(item + " added to the repository.");
    }

    public void remove(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (items.remove(item)) {
            System.out.println(item + " removed from the repository.");
        } else {
            System.out.println("Item not found in repository.");
        }
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public void setAll(List<T> items) {
        if (items == null) {
            throw new IllegalArgumentException("Items list cannot be null");
        }
        this.items = new ArrayList<>(items);
    }
}

