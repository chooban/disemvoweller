package com.rosshendry.reddit.disemvoweller;

import com.google.common.base.CharMatcher;

public class GuavaDisemvoweller implements Disemvoweller {

	@Override
	public Pair<String, String> disemvowel( String toBeDisemvowelled ) {
		CharMatcher matcher = CharMatcher.anyOf( "aeiou" );
		return new Pair<>( matcher.or( CharMatcher.WHITESPACE ).removeFrom( toBeDisemvowelled ), matcher.retainFrom( toBeDisemvowelled ) );
	}

}
