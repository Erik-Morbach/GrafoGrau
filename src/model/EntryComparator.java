package model;

import java.util.Comparator;
import java.util.Map.Entry;

public class EntryComparator implements Comparator<Entry<Integer,Node>> {

	@Override
	public int compare(Entry<Integer, Node> arg0, Entry<Integer, Node> arg1) {
	
		return arg0.getKey()-arg1.getKey();
	}

}
