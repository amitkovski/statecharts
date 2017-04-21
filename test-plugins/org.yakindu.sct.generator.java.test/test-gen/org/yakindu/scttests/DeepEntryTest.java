/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/

package org.yakindu.scttests;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.deepentry.DeepEntryStatemachine;
import org.yakindu.scr.deepentry.DeepEntryStatemachine.State;

/**
 * Unit TestCase for DeepEntry
 */
@SuppressWarnings("all")
public class DeepEntryTest {
	private DeepEntryStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new DeepEntryStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testEnterToSubstate() {
		assertTrue(statemachine.getX() == 0l);
		 
		assertTrue(statemachine.getY() == 0l);
		 
		assertTrue(statemachine.getZ() == 0l);
		 
		statemachine.enter();
		assertTrue(statemachine.getX() == 1l);
		 
		assertTrue(statemachine.getY() == 1l);
		 
		assertTrue(statemachine.getZ() == 2l);
		 
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r2_B_r_BB));
		 
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r2_C));
		 
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r2_B_r_BB));
		 
		assertTrue(statemachine.getY() == 1l);
		 
	}
}
