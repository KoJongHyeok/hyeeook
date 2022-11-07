import java.util.Calendar;

public class Date_Calendar {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		int thisYear = cal.get(Calendar.YEAR);		// 몇 년
		int thisMonth = cal.get(Calendar.MONTH);	// 몇 월(n+1월)
		int thisDay = cal.get(Calendar.DATE);		// 몇 일
		System.out.println("thisYear = " + thisYear);
		System.out.println("thisMonth = " + thisMonth);
		System.out.println("thisDay = " + thisDay);
		System.out.println();
		
		int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);	// 올해의 n번째 주
		int weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH);	// 이달의 n번째 주
		System.out.println("weekOfYear(올해의 n번째 주) = " + weekOfYear);
		System.out.println("weekOfMonth(이달의 n번째 주) = " + weekOfMonth);
		System.out.println();
		
		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);		// 올해의 n번째 일
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);	// 이달의 n번째 일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);		// 요일(일=1, 월=2, 화=3, 수=4, 목=5, 금=6, 토=7)
		int dayOfWeekInMonth = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);	// 이달의 n번째 요일
		int actualMaxDate = cal.getActualMaximum(Calendar.DATE);	// 이달의 마지막 일
		System.out.println("dayOfYear(올해의 n번째 일) = " + dayOfYear);
		System.out.println("dayOfMonth(이달의 n번째 일) = " + dayOfMonth);
		System.out.println("dayOfWeek(1:일, 2:월, 3:화, 4:수, 5:목, 6:금, 7:토) = " + dayOfWeek);
		System.out.println("dayOfWeekInMonth(n번째 요일) = " + dayOfWeekInMonth);
		System.out.println("actualMaxDate(이달의 마지막 일) = " + actualMaxDate);
		System.out.println();
		
		int thisHour1 = cal.get(Calendar.HOUR);				// 0~11시
		int thisHour2 = cal.get(Calendar.HOUR_OF_DAY);		// 0~23시
		int thisMinute = cal.get(Calendar.MINUTE);			// 분
		int thisSecond = cal.get(Calendar.SECOND);			// 초
		int thisMilSecond = cal.get(Calendar.MILLISECOND);	// 1/1000초
		int thisZoneOffset = cal.get(Calendar.ZONE_OFFSET);	// GMT 기준 시차(1/1000초 단위)
		int thisAmPm = cal.get(Calendar.AM_PM);				// 0:오전, 1:오후
		System.out.println("thisHour1 = " + thisHour1);
		System.out.println("thisHour2 = " + thisHour2);
		System.out.println("thisMinute = " + thisMinute);
		System.out.println("thisSecond = " + thisSecond);
		System.out.println("thisMilSecond = " + thisMilSecond);
		System.out.println("thisZoneOffset(GMT 기준 시차(1/1000초 단위)) = " + thisZoneOffset);
		System.out.println("thisAmPm(0:오전, 1:오후) = " + thisAmPm);
		
	}

}
