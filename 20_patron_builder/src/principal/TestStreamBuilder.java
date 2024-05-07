package principal;

import java.util.stream.Stream;

public class TestStreamBuilder {

	public static void main(String[] args) {
	Stream<String> st=Stream.of("hello","by","none");
	
	
	Stream.Builder<String> builder =Stream.builder();
	Stream<String> st2=builder
			.add("hello")
			.add("by")
			.add("none")
			.build();
	}

}
