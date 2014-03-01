package com.rosshendry.reddit.reemvoweller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SimpleTrie {

	private static final char A = 'a';

	public class TrieNode {
		boolean valid;
		TrieNode[] children;
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

	public SimpleTrie( File file ) throws IOException {
		this();
		String line;
		BufferedReader br = new BufferedReader( new FileReader( file ) );
		while ((line = br.readLine()) != null) {
			System.out.println( "Adding: " + line );
			insert( line );
		}
		br.close();
	}

	public void insert( String key ) {
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
			int index = key.charAt( level ) - A;
			if ( crawler.children[index] == null ) {
				return false;
			}
			crawler = crawler.children[index];
		}
		return (crawler != null) && (crawler.valid == true);
	}
}
