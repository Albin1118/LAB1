import java.util.ArrayList;

public class Set_Improved {
    private ArrayList<Integer> a;

    public Set_Improved() {
        a = new ArrayList<Integer>();
    }

    public int[] toArray() {
        int[] ia = new int[a.size()];
        for (int i = 0; i < ia.length; i++) {
            ia[i] = a.get(i);
        }
        return ia;
    }

    public void insert(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > x) {
                a.add(i, x);
                return; //changed from break to return. break caused the function to add an int twice
            } else {
                if (a.get(i) == x) {
                    return; //changed from break to return. break caused the function to add a duplicate int when it shouldn't
                }
            }
        }
        a.add(x);

    }

    public boolean member(int x) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > x) {
                return false;
            } else {
                if (a.get(i) == x) {
                    return true;
                }
            }
        }
        return false;
    }

    public void section(Set_Improved s) {
        for (int i = 0, j = 0; i < a.size() && j < s.a.size();) {
            if (a.get(i).equals(s.a.get(j))) {
                a.remove(i);
                //i++;this caused an error. when an item is removed from a the index shouldn't increase
                j++;
            } else {
                if (a.get(i) < s.a.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
        }
    }

    public boolean containsArithTriple() {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (member(2 * a.get(i) - a.get(j))) return true;
            }
        }
        return false;
    }
}