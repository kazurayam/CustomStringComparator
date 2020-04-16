package com.kazurayam.katalonforum

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Compare a pair of strings in the format of
 * "aa-bb"
 *   or
 * "aa-bb (cc)"
 * 
 * aa will be sorted alphanumerically
 * bb is expected to be a digit, will be sorted as digit
 * cc is expected to be a digit, will be sorted as digit
 */
public class CustomStringComparator implements Comparator<String> {

	private static Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)\\-([0-9]*)(\\s+\\(([0-9]+)\\))?")

	private Boolean verbose = false
	
	public void setVerbose(Boolean v) {
		this.verbose = v	
	}
	
	public int compare(String a, String b) {
		log(String.format("pattern is %s", pattern.toString()))
		Matcher ma = pattern.matcher(a)
		Matcher mb = pattern.matcher(b)
		Boolean ba = ma.matches()
		Boolean bb = mb.matches()
		int result = 0
		if (ba && bb) {
			log(String.format("a does match pattern. a=%s; ma=%s; groups=%s", a, ma.toString(), stringifyGroups(ma)))
			log(String.format("b does match pattern. b=%s; mb=%s; groups=%s", b, mb.toString(), stringifyGroups(mb)))
			String a1 = ma.group(1)
			String b1 = mb.group(1)
			if (a1 == b1) {
				Integer a2 = Integer.parseInt(ma.group(2))
				Integer b2 = Integer.parseInt(mb.group(2))
				if (a2 == b2) {
					String a4 = ma.group(4)
					String b4 = mb.group(4)
					if (a4 == null) {
						if (b4 == null) {
							result = 0
						} else {
							result = -1
						}
					} else {
						if (b4 == null) {
							result = 1
						} else {
							Integer a4i = Integer.parseInt(a4)
							Integer b4i = Integer.parseInt(b4)
							result = a4i.compareTo(b4i)
							log("a4i is " + a4i + "; b4i is " + b4i + "; result is " + result)
						}
					}
				} else {
					result = a2.compareTo(b2)
				}
			} else {
				result = a1.compareTo(b1)
			}
		} else {
			if (!ba) {
				log(String.format("a does NOT match pattern. a=%s patter=%s", a, pattern.toString()))
			}
			if (!bb) {
				log(String.format("b does NOT match pattern. b=%s patter=%s", b, pattern.toString()))
			}
			result = a.compareTo(b)
		}
		log(String.format('compare("%s","%s") returned %d', a, b, result))
		return result
	}

	private String stringifyGroups(Matcher m) {
		StringBuilder sb = new StringBuilder()
		sb.append("{")
		sb.append('"matches":')
		sb.append(m.matches())
		sb.append(',')
		sb.append('"groupCount":')
		sb.append(m.groupCount())
		sb.append(',')
		sb.append('"group(0)":\"')
		sb.append(m.group(0))
		sb.append('\"')
		for (int i = 1; i <= m.groupCount(); i++) {
			sb.append(',')
			sb.append('\"group(')
			sb.append(i)
			sb.append('):\"')
			sb.append(m.group(i))
			sb.append('\"')
		}
		sb.append("}")
		return sb.toString()
	}

	private void log(String message) {
		if (this.verbose) {
			println String.format(':%s:%s %s', 'CustomStringComparator', 'compare', message)
		}
	}
}


