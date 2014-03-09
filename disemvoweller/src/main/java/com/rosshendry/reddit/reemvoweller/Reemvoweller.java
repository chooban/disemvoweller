package com.rosshendry.reddit.reemvoweller;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;

public class Reemvoweller {

	private SimpleTrie trie;
	final Logger logger = LoggerFactory.getLogger( Reemvoweller.class );
	private List<String> sentencesSoFar;
	
	public Reemvoweller( SimpleTrie possibleWords ) {
		this.trie = possibleWords;
	}

	private Reemvoweller() {
		// no-op
	}

	public List<String> reemvowel( final String consonants, final String vowels ) {
		Preconditions.checkNotNull( trie, "Word list not instantiated" );
		sentencesSoFar = new LinkedList<>();

		logger.info( "Starting to reemowel with " + consonants + " and " + vowels );
		reemvowel( vowels, consonants, "", "" );
		return sentencesSoFar;
	}

	private boolean reemvowel( final String vowels, final String consonants, String soFar, String lastWord ) {
		List<String> possibleKeys = trie.possibleKeys( lastWord.toString() );
		
		logger.trace( "So far: " + soFar.toString() );
		logger.trace( "Possible keys: " + possibleKeys );
		
		if ( consonants.length() == 0 && vowels.length() == 0 ) {
			logger.debug( "End of both consonants and vowels" );
			if ( trie.contains( lastWord.toString() ) ) {
				logger.debug( "Last word is in the trie, so adding a new sentence" );
				logger.debug( soFar.toString() );
				sentencesSoFar.add( soFar.toString() );
				return true;
			}
		}

		String nextConsonant = consonants.substring( 0, 1 );
		if ( possibleKeys.contains( nextConsonant ) ) {
			soFar += nextConsonant;
			lastWord += nextConsonant;
			logger.debug( "Keys contains consonant " + nextConsonant );
			logger.debug( "Sentence so far is " + soFar.toString() );
			logger.debug( "Last word so far is " + lastWord.toString() );
			reemvowel( vowels, consonants.substring( 1 ), soFar, lastWord );
		}

		String nextVowel = vowels.substring( 0, 1 );
		logger.trace( "Looking for " + nextVowel + " in " + possibleKeys );
		if ( possibleKeys.contains( nextVowel ) ) {
			soFar += nextVowel;
			lastWord += nextVowel;
			logger.debug( "Keys contains vowel " + nextVowel );
			logger.debug( "Sentence so far is " + soFar.toString() );
			logger.debug( "Last word so far is " + lastWord.toString() );
			reemvowel( vowels.substring( 1 ), consonants, soFar, lastWord );
		}

		logger.debug( "Checking to see if " + lastWord.toString() + " is a key" );
		if ( trie.contains( lastWord.toString() ) ) {
			logger.debug( "Trie contains " + lastWord.toString() + " so adding it and moving on" );
			reemvowel( vowels, consonants, soFar += " ", "" );
		}
		
		logger.debug( "End game" );
		// If we got all the way here then this path is a bust.
		return false;
	}
}
