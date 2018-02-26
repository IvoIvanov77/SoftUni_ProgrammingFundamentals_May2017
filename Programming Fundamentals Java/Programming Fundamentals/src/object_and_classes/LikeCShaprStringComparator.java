package object_and_classes;

import java.util.Comparator;

public class LikeCShaprStringComparator implements Comparator<String> {

	@Override
	public int compare(String x, String y) {
		// TODO Auto-generated method stub
		return x.compareToIgnoreCase(y) == 0 ? -x.compareTo(y) : x.compareToIgnoreCase(y);
		
	}

}
