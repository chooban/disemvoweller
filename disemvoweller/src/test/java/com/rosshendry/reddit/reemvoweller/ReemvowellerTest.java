package com.rosshendry.reddit.reemvoweller;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Splitter;

public class ReemvowellerTest {

	private Reemvoweller reemvoweller;
	private SimpleTrie trie;

	{
		String wordsFile = ClassLoader.getSystemResource( "enable1.txt" ).getFile();
		try {
			trie = new SimpleTrie( new File( wordsFile ) );
		} catch (IOException e) {
			Assert.fail( "Couldn't even get started" );
		}
	}
	@Test
	public void test() {
		reemvoweller = new Reemvoweller( trie );
		
		List<String> results = reemvoweller.reemvowel( "wwllfndffthstrds", "eieoeaeoi" );
	}

}
