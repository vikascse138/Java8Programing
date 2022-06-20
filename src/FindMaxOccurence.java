import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMaxOccurence {

	public static void main(String[] args) {
		Stream<Integer> input = Stream.of(1, 2, 2, 3, 1, 2, 3, 1, 2, 3, 4, 5);
		Map<Integer, Long> map = input.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		System.out.println(Collections.max(map.keySet()) + " " + Collections.max(map.values()));
		Entry<Integer, Long> entry = Collections.max(map.entrySet(), new Comparator<Entry<Integer, Long>>() {

			@Override
			public int compare(Entry<Integer, Long> o1, Entry<Integer, Long> o2) {

				return o1.getValue().compareTo(o2.getValue());
			}

		});
		System.out.println(entry);

		// Using Lamda

		Entry<Integer, Long> entry1 = Collections.max(map.entrySet(),
				(Entry<Integer, Long> e1, Entry<Integer, Long> e2) -> e1.getValue().compareTo(e2.getValue()));
		System.out.println(entry1);
	}
}
