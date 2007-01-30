/*******************************************************************************
 * Copyright (c) 2007 Brad Reynolds and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Brad Reynolds - initial API and implementation
 ******************************************************************************/

package org.eclipse.jface.tests.internal.databinding.internal.beans;

import java.beans.PropertyDescriptor;

import junit.framework.TestCase;

import org.eclipse.core.internal.databinding.internal.beans.BeanObservableValueDecorator;
import org.eclipse.core.internal.databinding.internal.beans.JavaBeanObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Display;

/**
 * @since 3.3
 */
public class BeanObservableValueDecoratorTest extends TestCase {
	private Bean bean;
	private JavaBeanObservableValue observableValue;
	private BeanObservableValueDecorator decorator;
	private PropertyDescriptor propertyDescriptor;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		bean = new Bean();
		propertyDescriptor = new PropertyDescriptor("value",
				Bean.class);
		observableValue = new JavaBeanObservableValue(
				SWTObservables.getRealm(Display.getDefault()), bean,
				propertyDescriptor, String.class);
		decorator = new BeanObservableValueDecorator(
				observableValue, bean, observableValue
						.getPropertyDescriptor());
	}

	public void testGetDelegate() throws Exception {
		assertEquals(observableValue, decorator.getDelegate());
	}
	
	public void testGetObserved() throws Exception {
		assertEquals(bean, decorator.getObserved());
	}

	public void testGetPropertyDescriptor() throws Exception {
		assertEquals(propertyDescriptor, decorator.getPropertyDescriptor());
	}
}