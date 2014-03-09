package com.rosshendry.reddit.reemvoweller;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTrieTest {

	Logger logger = LoggerFactory.getLogger( SimpleTrieTest.class );

	@Ignore
	@Test
	public void createTrie() throws IOException {
		String wordsFile = ClassLoader.getSystemResource( "enable1.txt" ).getFile();
		SimpleTrie trie = new SimpleTrie( new File( wordsFile ) );

		assertTrue( "Should be a key", trie.contains( "and" ) );
	}

	@Test
	public void testingTheTrieForFullKeys() {
		List<String> words = Arrays.asList( "able", "abba", "bee", "bear" );

		SimpleTrie trie = new SimpleTrie( words );
		assertTrue( "Should be a key", trie.contains( "able" ) );
		assertFalse( "Should not be a key", trie.contains( "bearing" ) );

		String[] keys = trie.possibleKeys( "ab" );
		assertArrayEquals( "Should be b and l", new String[] { "l", "b" }, keys );
	}
	
	@Test 
	public void testingTheTrieForPossibleRoutes() {
		List<String> words = Arrays.asList( "able", "abba", "bee", "bear" );

		SimpleTrie trie = new SimpleTrie( words );
		String[] keys = trie.possibleKeys( "ab" );
		assertArrayEquals( "Should be b and l", new String[] { "b", "l" }, keys );
	}

}
