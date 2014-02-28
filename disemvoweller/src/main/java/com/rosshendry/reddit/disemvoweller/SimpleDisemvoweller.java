package com.rosshendry.reddit.disemvoweller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class SimpleDisemvoweller implements Disemvoweller {

	final Pattern vowelsPattern = Pattern.compile( "[aeiou]" );
	
	public Pair<String, String> disemvowel( String toBeDisemvowelled ) {

		StringBuffer sentence = new StringBuffer();
		StringBuffer vowels = new StringBuffer();

		String s;
		Matcher m;
		
		for ( int i = 0; i < toBeDisemvowelled.length(); i++ ) {
			
			s = toBeDisemvowelled.substring( i, i + 1 );
			
			if ( StringUtils.isBlank( s ) ) {
				continue;
			}
			m = vowelsPattern.matcher( s );
			
			if ( m.matches() ) {
				vowels.append( s );
			}
			else {
				sentence.append( s );
			}
			
		}
		return new Pair<>( sentence.toString(), vowels.toString() );
	}

}
