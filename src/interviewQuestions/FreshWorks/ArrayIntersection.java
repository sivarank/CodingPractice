package interviewQuestions.FreshWorks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
	static List<Integer> findIntersection(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a1.size(); i++) {
			int curElement = a1.get(i);
			if (map.containsKey(curElement)) {
				map.put(curElement, map.get(curElement) + 1);
			} else {
				map.put(curElement, 1);
			}
		}

		for (int i = 0; i < a2.size(); i++) {
			int curElement = a2.get(i);
			if (map.containsKey(curElement)) {
				result.add(curElement);
				if (map.get(curElement) > 1) {
					map.put(curElement, map.get(curElement) - 1);
				} else {
					map.remove(curElement);
				}
			}
		}
		return result;
	}

	static List<Integer> intersectionArray(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		List<Integer> result = new ArrayList<Integer>();
		if (a1.isEmpty() || a2.isEmpty()) {
			return result;
		}
		return a2.size() > a1.size() ? findIntersection(a1, a2) : findIntersection(a2, a1);
	}

	public static void main(String[] args) {
		System.out.println(intersectionArray(new ArrayList<Integer>(Arrays.asList(3,2,1)), new ArrayList<Integer>(Arrays.asList(4,1,2))));
	}

}
