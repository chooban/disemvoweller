package com.rosshendry.reddit.reemvoweller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTrie {

	private final Logger logger = LoggerFactory.getLogger( SimpleTrie.class );
	private static final char A = 'a';

	public class TrieNode {
		boolean valid;
		TrieNode[] children;

		/**
		 * Returns string along the line of "{valid:true/false; children: [g,h,t]; }
		 */
		@Override
		public String toString() {

			StringBuilder sb = new StringBuilder();
			boolean first = true;
			for ( int i = 0; i < 26; i++ ) {
				if ( children[i] != null ) {
					if ( !first ) {
						sb.append( ", " );
					}
					first &= false;
					sb.append( String.valueOf( (char) (i + A) ) );
				}
			}
			return String.format( "{ valid: %s, children: [%s]}", valid, sb.toString() );
		}
	}

	public TrieNode root;

	private TrieNode getNode() {
		TrieNode t = new TrieNode();
		t.valid = false;
		t.children = new TrieNode[26];
		return t;
	}

	public SimpleTrie() {
		root = getNode();
	}

	SimpleTrie( List<String> words ) {
		this();
		for ( String s : words ) {
			insert( s );
		}
	}

	public SimpleTrie( File file ) throws IOException {
		this();
		String line;
		BufferedReader br = new BufferedReader( new FileReader( file ) );
		while ((line = br.readLine()) != null) {
			insert( line );
		}
		br.close();
	}

	public void insert( String key ) {
		if ( logger.isTraceEnabled() ) {
			logger.trace( "Adding " + key );
		}

		TrieNode crawler = root;
		for ( int level = 0; level < key.length(); level++ ) {
			int index = key.charAt( level ) - A;
			if ( crawler.children[index] == null ) {
				crawler.children[index] = getNode();
			}
			crawler = crawler.children[index];
		}
		crawler.valid = true;
	}

	public boolean contains( String key ) {
		TrieNode crawler = root;
		for ( int level = 0; level < key.length(); level++ ) {
			logger.trace( "Inspecting routes from " + String.valueOf( key.charAt( level ) ) );
			int index = key.charAt( level ) - A;
			if ( crawler.children[index] == null ) {
				logger.debug( String.format( "No child at index %d, character %s", index, String.valueOf( (char) (index + A) ) ) );
				return false;
			}
			crawler = crawler.children[index];
		}
		return (crawler != null) && (crawler.valid == true);
	}

	public String[] possibleKeys( String key ) {
		logger.debug( "Finding possible keys for " + key );
		TrieNode crawler = findLastNodeForString( key );

		if ( crawler == null ) {
			logger.debug( "Could not find " + key + " in the trie" );
			return null;
		}

		List<String> keys = new LinkedList<>();
		for ( int i = 0; i < 26; i++ ) {
			if ( crawler.children[i] != null ) {
				keys.add( String.valueOf( (char) (i + A) ) );
			}
		}
		return keys.toArray( new String[] {});
	}

	private TrieNode findLastNodeForString( String key ) {
		TrieNode crawler = root;
		for ( int level = 0; level < key.length(); level++ ) {
			logger.trace( "Inspecting routes from " + String.valueOf( key.charAt( level ) ) );
			int index = key.charAt( level ) - A;
			if ( crawler.children[index] == null ) {
				logger.debug( String.format( "No child at index %d, character %s", index, String.valueOf( (char) (index + A) ) ) );
				break;
			}
			crawler = crawler.children[index];
		}
		logger.info( "Returning " + crawler.toString() );
		return crawler;
	}
}
