class Solution {
	public boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		for (int i = 1; i < intervals.length;i++) {
			if (intervals[i].start < intervals[i - 1.end])
				return false;
		}
		return true;
	}
}