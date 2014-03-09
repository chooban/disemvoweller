package com.rosshendry.reddit.disemvoweller;

public class RunDisemvoweller {

	public static void main( String[] args ) {
		Disemvoweller d = new GuavaDisemvoweller();
		
		Pair<String, String> p = d.disemvowel( "cat on mat" );
		
		System.out.println( "Consonants: " + p.getFirst() );
		System.out.println( "Vowels: " + p.getSecond() );
	}

}
