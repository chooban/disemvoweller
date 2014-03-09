package com.rosshendry.reddit.reemvoweller;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Splitter;

public class ReemvowellerTest {

	private Reemvoweller reemvoweller;

	@Test
	public void test() {
		List<String> words = slurpEnableWords();
		reemvoweller = new Reemvoweller( words );
		
		List<String> results = reemvoweller.reemvowel( "wwllfndffthstrds", "eieoeaeoi", 1 );
	}

	private List<String> slurpEnableWords() {
		List<String> words = Collections.emptyList();
		try {
			String wordsFile = ClassLoader.getSystemResource("enable1.txt").getFile();
			byte[] encoded = Files.readAllBytes( Paths.get( wordsFile ) );
			String complete = Charset.forName( "UTF-8" ).decode( ByteBuffer.wrap( encoded ) ).toString();
			
			words = Splitter.on( System.lineSeparator() ).splitToList( complete );
		} catch (IOException e) {
			e.printStackTrace();
			fail( "Could not read file" );
		}
		return words;
	}

}
