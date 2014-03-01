package com.rosshendry.reddit.reemvoweller;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class SimpleTrieTest {

	@Test
	public void createTrie() throws IOException {
		String wordsFile = ClassLoader.getSystemResource("enable1.txt").getFile();
		SimpleTrie trie = new SimpleTrie( new File( wordsFile ) );
		
		assertTrue( "Should be a key", trie.contains( "and" ) );
	}

}
