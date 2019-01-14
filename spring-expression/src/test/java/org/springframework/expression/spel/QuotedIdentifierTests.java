package org.springframework.expression.spel;

import org.junit.Test;

public class QuotedIdentifierTests extends AbstractExpressionTests {

	@Test
	public void testUmlautGetter() {
		evaluate("new org.springframework.expression.spel.Umlauts().`ÄÖÜ`", 0, Integer.class);
	}

	@Test
	public void testUmlautMethod() {
		evaluate("new org.springframework.expression.spel.Umlauts().`großerTest`(5)", 5, Integer.class);
	}

	@Test
	public void testChinese() {
		evaluate("new org.springframework.expression.spel.Chinese().`名字`", "Hello Chinese", String.class);
	}
}

class Umlauts {

	private int äöü;

	public Umlauts() {
		this.äöü = 0;
	}

	public int getÄÖÜ() {
		return this.äöü;
	}

	public int großerTest(int value) {
		this.äöü = value;
		return this.äöü;
	}
}

class Chinese {

	public Chinese(){};

	public String get名字(){
		return "Hello Chinese";
	}
}
