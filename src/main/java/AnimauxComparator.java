import java.util.Comparator;

public class AnimauxComparator implements Comparator<Secteur> {

    @Override
    public int compare(Secteur o1, Secteur o2) {
        if (o1.getNombreAnimaux() > o2.getNombreAnimaux())
            return 1;
        else if (o1.getNombreAnimaux() < o2.getNombreAnimaux())
            return -1;
        else
            return 0;
    }
}
