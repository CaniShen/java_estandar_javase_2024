package principal;


import java.time.Duration;
import java.time.LocalTime;
import java.util.stream.LongStream;

public class SumaNumeros {

	public static void main(String[] args) {
		LocalTime t1=LocalTime.now();
		System.out.println(LongStream.rangeClosed(1,60_000_000_000L)
				.parallel()
				.sum());
		
		LocalTime t2=LocalTime.now();
		Duration p=Duration.between(t1, t2);
		System.out.println(p);//3.0647104 segudos.
	}

}
