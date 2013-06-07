/*******************************************************************************
 * Copyright 2012
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package de.tudarmstadt.ukp.similarity.algorithms.structure;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.tudarmstadt.ukp.similarity.algorithms.api.TextSimilarityMeasure;


public class TokenPairOrderingMeasureTest
{
	static final double epsilon = 0.001; 
	
	@Test
	public void run()
		throws Exception
	{
		TextSimilarityMeasure comparator = new TokenPairDistanceMeasure();
		
		// Reference document
		List<String> doc1 = new ArrayList<String>();
		doc1.add("one");
		doc1.add("two");
		doc1.add("three");
		doc1.add("four");
		
		// Test 1
		List<String> doc2 = new ArrayList<String>();
		doc2.add("two");
		doc2.add("one");
		
		assertEquals(0.0, comparator.getSimilarity(doc1, doc2), epsilon);
		
		// Test 2
		doc2 = new ArrayList<String>();
		doc2.add("one");
		doc2.add("two");
		
		assertEquals(0.0, comparator.getSimilarity(doc1, doc2), epsilon);
		
		// Test 3
		doc2 = new ArrayList<String>();
		doc2.add("one");
		doc2.add("three");
		doc2.add("two");

		assertEquals(0.928, comparator.getSimilarity(doc1, doc2), epsilon);
		
		// Test 4
		doc2 = new ArrayList<String>();
		doc2.add("one");
		doc2.add("three");
		doc2.add("two");
		doc2.add("four");
		
		assertEquals(0.838, comparator.getSimilarity(doc1, doc2), epsilon);
	}
}