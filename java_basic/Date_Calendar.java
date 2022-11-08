import java.util.Calendar;

public class Date_Calendar {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR); // 몇 년
		int thisMonth = cal.get(Calendar.MONTH); // 몇 월(n+1월)
		int thisDay = cal.get(Calendar.DATE); // 몇 일
		System.out.println("thisYear = " + thisYear);
		System.out.println("thisMonth = " + thisMonth);
		System.out.println("thisDay = " + thisDay);
		System.out.println();

		int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR); // 올해의 n번째 주
		int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH); // 이달의 n번째 주
		System.out.println("weekOfYear(올해의 n번째 주) = " + weekOfYear);
		System.out.println("weekOfMonth(이달의 n번째 주) = " + weekOfMonth);
		System.out.println();

		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR); // 올해의 n번째 일
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH); // 이달의 n번째 일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일(일=1, 월=2, 화=3, 수=4, 목=5, 금=6, 토=7)
		int dayOfWeekInMonth = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH); // 이달의 n번째 요일
		int actualMaxDate = cal.getActualMaximum(Calendar.DATE); // 이달의 마지막 일
		System.out.println("dayOfYear(올해의 n번째 일) = " + dayOfYear);
		System.out.println("dayOfMonth(이달의 n번째 일) = " + dayOfMonth);
		System.out.println("dayOfWeek(1:일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토) = " + dayOfWeek);
		System.out.println("dayOfWeekInMonth(n번째 요일) = " + dayOfWeekInMonth);
		System.out.println("actualMaxDate(이달의 마지막 일) = " + actualMaxDate);
		System.out.println();

		int thisHour1 = cal.get(Calendar.HOUR); // 0~11시
		int thisHour2 = cal.get(Calendar.HOUR_OF_DAY); // 0~23시
		int thisMinute = cal.get(Calendar.MINUTE); // 분
		int thisSecond = cal.get(Calendar.SECOND); // 초
		int thisMilSecond = cal.get(Calendar.MILLISECOND); // 1/1000초
		int thisZoneOffset = cal.get(Calendar.ZONE_OFFSET); // GMT 기준 시차(1/1000초 단위)
		int thisAmPm = cal.get(Calendar.AM_PM); // 0:오전, 1:오후
		System.out.println("thisHour1 = " + thisHour1);
		System.out.println("thisHour2 = " + thisHour2);
		System.out.println("thisMinute = " + thisMinute);
		System.out.println("thisSecond = " + thisSecond);
		System.out.println("thisMilSecond = " + thisMilSecond);
		System.out.println("thisZoneOffset(GMT 기준 시차(1/1000초 단위)) = " + thisZoneOffset);
		System.out.println("thisAmPm(0:오전, 1:오후) = " + thisAmPm);

//-----------------------------------------------------------------------------------------------------------------

		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		final String[] DAY_OF_WEEK = { "", "일", "월", "화", "수", "목", "금", "토" };

		date1.set(1993, 6, 14); // 1993년 7월 14일
		System.out.println(toString(date1) + " " + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일");
		System.out.println(toString(date2) + " " + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일");
		System.out.println();

		// 날짜 계산 방법
		long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;
		System.out.println("생후 " + difference + "초!");
		System.out.println("생후 " + difference / (60 * 60 * 24) + "일!");
		System.out.println();

		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		final int[] TIME_UNIT = { 3600, 60, 1 };
		final String[] TIME_UNIT_NAME = { "시간 ", "분 ", "초 " };

		time1.set(Calendar.HOUR_OF_DAY, 10); // 10시 20분 30초
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);

		time2.set(Calendar.HOUR_OF_DAY, 20); // 20시 30분 10초
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);

		System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "시 " + time1.get(Calendar.MINUTE) + "분 "
				+ time1.get(Calendar.SECOND) + "초");
		System.out.println("time2 : " + time2.get(Calendar.HOUR_OF_DAY) + "시 " + time2.get(Calendar.MINUTE) + "분 "
				+ time2.get(Calendar.SECOND) + "초");
		System.out.println();

		difference = Math.abs(time1.getTimeInMillis() - time2.getTimeInMillis()) / 1000;
		System.out.println("차이는 " + difference + "초!");

		String tmp = "";
		for (int i = 0; i < TIME_UNIT.length; i++) {
			tmp += difference / TIME_UNIT[i] + TIME_UNIT_NAME[i];
			difference %= TIME_UNIT[i];
		}
		System.out.println("차이는 " + tmp);

	}

	public static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DATE) + "일";
	}

}

/*
thisYear = 2022
thisMonth = 10
thisDay = 9

weekOfYear(올해의 n번째 주) = 46
weekOfMonth(이달의 n번째 주) = 2

dayOfYear(올해의 n번째 일) = 313
dayOfMonth(이달의 n번째 일) = 9
dayOfWeek(1:일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토) = 4
dayOfWeekInMonth(n번째 요일) = 2
actualMaxDate(이달의 마지막 일) = 30

thisHour1 = 0
thisHour2 = 0
thisMinute = 23
thisSecond = 21
thisMilSecond = 74
thisZoneOffset(GMT 기준 시차(1/1000초 단위)) = 32400000
thisAmPm(0:오전, 1:오후) = 0
1993년 7월 14일 수요일
2022년 11월 9일 수요일

생후 925344000초!
생후 10710일!

time1 : 10시 20분 30초
time2 : 20시 30분 10초

차이는 36580초!
차이는 10시간 9분 40초 
*/
