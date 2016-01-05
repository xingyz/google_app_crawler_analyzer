package com.factrus.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javafx.scene.control.Label;

import org.mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;

/**
 * 
 * @author nicolas.husser
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {

	@Mock
	private static Label lbl_helloWorld;
	
	@Test
	public static void shouldReturnEmptyStringIfLabelIsEmpty(){
		
	}
	
}
