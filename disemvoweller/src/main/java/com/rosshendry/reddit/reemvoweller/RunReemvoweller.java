package com.rosshendry.reddit.reemvoweller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunReemvoweller {

	static Logger logger = LoggerFactory.getLogger( RunReemvoweller.class );

	public static void main( String[] args ) {
		String wordsFile = ClassLoader.getSystemResource( "enable1.txt" ).getFile();
		SimpleTrie trie = null;
		try {
			trie = new SimpleTrie( new File( wordsFile ) );
		} catch (IOException e) {
			System.exit( 1 );
		}

		Reemvoweller reemvoweller = new Reemvoweller( trie );
		
		logger.info( "Embarking on reemvowelling" );
		List<String> results = reemvoweller.reemvowel( "ctnmt", "aoa" );
		logger.info( "Finished reemvowelling" );
		
		int i = 1;
		for ( String s : results ) {
			logger.info( i++ + " : " + s );
		}
		
		System.exit( 0 );
	}
}
