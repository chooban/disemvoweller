package com.rosshendry.reddit.reemvoweller;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTrieTest {

	Logger logger = LoggerFactory.getLogger( SimpleTrieTest.class );

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

		List<String> keys = trie.possibleKeys( "ab" );
		assertEquals( "Should be b and l", Arrays.asList( "b", "l" ), keys );
	}
	
	@Test 
	public void testingTheTrieForPossibleRoutes() {
		List<String> words = Arrays.asList( "able", "abba", "bee", "bear" );

		SimpleTrie trie = new SimpleTrie( words );
		List<String> keys = trie.possibleKeys( "ab" );
		assertEquals( "Should be b and l", Arrays.asList( "b", "l" ), keys );
	}

	@Test
	public void emptyStringReturnsAllPossibleKeys() {
		List<String> words = Arrays.asList( "able", "abba", "bee", "bear" );

		SimpleTrie trie = new SimpleTrie( words );
		List<String> keys = trie.possibleKeys( "" );
		assertEquals( "Should be a and b", Arrays.asList( "a", "b" ), keys );
	}
}
