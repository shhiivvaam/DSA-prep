import java.util.*;

public class Heap {
    private ArrayList<Integer> data = new ArrayList<>();

    public void add(int item) {
        this.data.add(item);
        heapify(data.size() - 1);
    }

    public int remove() {
        swap(0, this.data.size() - 1);
        int remove = this.data.remove(this.data.size() - 1); // now in this stage the, last element of the ArrayList
                                                             // Contains the { min element } that is the root one.
        downheapify(0); // place the swapped element at the right position
        return remove;
    }

    public void heapify(int child) {
        int parent = (child - 1) / 2;
        if (this.data.get(parent) > this.data.get(child)) {
            swap(parent, child);
            heapify(parent);
        }
    }

    public void downheapify(int parent) {
        int lci = 2 * parent + 1;
        int rci = 2 * parent + 2;
        int mini = parent; // this parent is the index only

        if (lci < this.data.size() && this.data.get(lci) < this.data.get(mini)) {
            mini = lci;
        }
        if (rci < this.data.size() && this.data.get(rci) < this.data.get(mini)) {
            mini = rci;
        }

        if (mini != parent) {
            swap(mini, parent);
            downheapify(mini);
        }
    }

    public int getmin() {
        return this.data.get(0);
    }

    public int size() {
        return this.data.size();
    }

    public void display() {
        System.out.println(this.data);
    }

    public void swap(int i, int j) {
        int ith = data.get(i);
        int jth = data.get(j);
        this.data.set(i, jth);
        this.data.set(j, ith);
    }
}
