import com.kazurayam.katalonforum.CustomStringComparator

import java.util.Arrays
import java.util.Collections
import java.util.List
import java.util.regex.Pattern
import java.util.regex.Matcher

String[] arr = ["AA-1", "AA-2", "AA-2 (1)", "AA-10"]

List expected = Arrays.asList(arr)
assert expected != null
assert expected[0] == "AA-1"
assert expected[1] == "AA-2"
assert expected[2] == "AA-2 (1)"
assert expected[3] == "AA-10"

List sorted1 = Arrays.asList(arr)
Collections.sort(sorted1)
assert sorted1 != null
assert sorted1[0] == "AA-1"
assert sorted1[1] == "AA-10"
assert sorted1[2] == "AA-2"
assert sorted1[3] == "AA-2 (1)"


List sorted2 = Arrays.asList(arr)
Collections.sort(sorted2, new CustomStringComparator())
assert sorted2 != null
assert sorted2[0] == "AA-1"
assert sorted2[1] == "AA-2"
assert sorted2[2] == "AA-2 (1)"
assert sorted2[3] == "AA-10"
