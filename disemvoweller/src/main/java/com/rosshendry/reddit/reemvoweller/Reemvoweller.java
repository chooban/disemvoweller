package com.rosshendry.reddit.reemvoweller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class Reemvoweller {

	private Collection<String> wordList;

	public Reemvoweller( Collection<String> possibleWords ) {
		this.wordList = possibleWords;
	}

	public Reemvoweller() {
		// no-op
	}

	public List<String> reemvowel( String consonants, String vowels, int numAnswers ) {
		Preconditions.checkNotNull( wordList, "Word list not instantiated" );
		List<String> wordsSoFar = Collections.emptyList();

		List<String> possibilities = possibleWords( "" );

		return wordsSoFar;
	}

	private List<String> possibleWords( final String prefix ) {
		if ( StringUtils.isEmpty( prefix ) ) {
			return Lists.newArrayList( this.wordList );
		}
		Iterables.filter( this.wordList, new Predicate<String>() {

			@Override
			public boolean apply( final String word ) {
				return word.startsWith( prefix );
			}
			
		});
		return null;
	}

	private boolean isWord( String word ) {
		return wordList.contains( word );
	}
}
