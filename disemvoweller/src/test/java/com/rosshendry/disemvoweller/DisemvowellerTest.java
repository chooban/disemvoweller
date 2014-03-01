package com.rosshendry.disemvoweller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.rosshendry.reddit.disemvoweller.Disemvoweller;
import com.rosshendry.reddit.disemvoweller.GuavaDisemvoweller;
import com.rosshendry.reddit.disemvoweller.Pair;
import com.rosshendry.reddit.disemvoweller.SimpleDisemvoweller;

@RunWith(value = Parameterized.class)
public class DisemvowellerTest {

	@Parameter
	public Disemvoweller disemvoweller;
	
	@Parameters
	public static List<Disemvoweller[]> getDisemvowellers() {
		return Arrays.asList( new Disemvoweller[][] { { new SimpleDisemvoweller() },{ new GuavaDisemvoweller() } } );
	}
	
	@Test
	public void firstTest() {
		Pair<String,String> results = disemvoweller.disemvowel( "two drums and a cymbal fall off a cliff" );
		
		assertEquals( "Wrong sentence", "twdrmsndcymblfllffclff", results.getFirst() );
		assertEquals( "Wrong vowels", "ouaaaaoai", results.getSecond() );
	}
	
	@Test
	public void secondTest() {
		Pair<String,String> results = disemvoweller.disemvowel( "all those who believe in psychokinesis raise my hand" );
		assertEquals( "Wrong sentence", "llthswhblvnpsychknssrsmyhnd", results.getFirst() );
		assertEquals( "Wrong vowels", "aoeoeieeioieiaiea", results.getSecond() );
	}

}
