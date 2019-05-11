import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateDifference {
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public static void datum(Date date) {

		Date myDate = new Date();
		System.out.println(myDate);
		System.out.println(new SimpleDateFormat("MM-dd-yyyy").format(myDate));

	}

}