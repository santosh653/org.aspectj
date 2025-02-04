/********************************************************************
 * Copyright (c) 2006 Contributors. All rights reserved.
 * This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v 2.0
 * which accompanies this distribution and is available at
 * https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.txt
 *
 * Contributors: IBM Corporation - initial API and implementation
 * 				 Helen Hawkins   - iniital version
 *******************************************************************/
package org.aspectj.org.eclipse.jdt.core.dom;

import java.util.ArrayList;
import java.util.List;


/**
 * DeclarePrecedenceDeclaration DOM AST node.
 *
 * Has everything a DeclareDeclaration has plus:
 *   	a TypePattern list called 'parentTypePatterns'
 */
public class DeclarePrecedenceDeclaration extends DeclareDeclaration {

	public static final ChildPropertyDescriptor JAVADOC_PROPERTY =
		internalJavadocPropertyFactory(DeclarePrecedenceDeclaration.class);

	public static final ChildListPropertyDescriptor TYPE_PATTERNS_LIST_PROPERTY =
		new ChildListPropertyDescriptor(DeclarePrecedenceDeclaration.class, "parentTypePatterns", TypePattern.class, NO_CYCLE_RISK); //$NON-NLS-1$

	private static final List PROPERTY_DESCRIPTORS_2_0;
	private static final List PROPERTY_DESCRIPTORS_3_0;

	static {
		List propertyList = new ArrayList(2);
		createPropertyList(DeclarePrecedenceDeclaration.class, propertyList);
		addProperty(JAVADOC_PROPERTY, propertyList);
		addProperty(TYPE_PATTERNS_LIST_PROPERTY, propertyList);
		PROPERTY_DESCRIPTORS_2_0 = reapPropertyList(propertyList);

		propertyList = new ArrayList(2);
		createPropertyList(DeclarePrecedenceDeclaration.class, propertyList);
		addProperty(JAVADOC_PROPERTY, propertyList);
		addProperty(TYPE_PATTERNS_LIST_PROPERTY, propertyList);
		PROPERTY_DESCRIPTORS_3_0 = reapPropertyList(propertyList);
	}

	protected ASTNode.NodeList typePatterns =new ASTNode.NodeList(TYPE_PATTERNS_LIST_PROPERTY);

	DeclarePrecedenceDeclaration(AST ast) {
		super(ast);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	ASTNode clone0(AST target) {
		DeclarePrecedenceDeclaration result = new DeclarePrecedenceDeclaration(target);
		result.setSourceRange(this.getStartPosition(), this.getLength());
		result.setJavadoc(
			(Javadoc) ASTNode.copySubtree(target, getJavadoc()));
		result.typePatterns().addAll(
				ASTNode.copySubtrees(target, typePatterns()));
		return result;
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	final boolean subtreeMatch0(ASTMatcher matcher, Object other) {
		// dispatch to correct overloaded match method
		return ((AjASTMatcher)matcher).match(this, other);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	void accept0(ASTVisitor visitor) {
		if (visitor instanceof AjASTVisitor) {
			boolean visitChildren = ((AjASTVisitor)visitor).visit(this);
			if (visitChildren) {
				// visit children in normal left to right reading order
				acceptChild(visitor, getJavadoc());
				acceptChildren(visitor, this.typePatterns);
			}
			((AjASTVisitor)visitor).endVisit(this);
		}
	}

	/* (omit javadoc for this method)
	 * Method declared on BodyDeclaration.
	 *
	 * There are no modifiers declared for DeclareErrorDeclaration -
	 * therefore we don't do anything with this
	 */
	SimplePropertyDescriptor internalModifiersProperty() {
		return internalModifiersPropertyFactory(DeclareErrorDeclaration.class);
	}

	/* (omit javadoc for this method)
	 * Method declared on BodyDeclaration.
	 *
	 * There are no modifiers declared for DeclareErrorDeclaration -
	 * therefore we don't do anything with this
	 */
	ChildListPropertyDescriptor internalModifiers2Property() {
		return internalModifiers2PropertyFactory(DeclareErrorDeclaration.class);
	}

	/* (omit javadoc for this method)
	 * Method declared on BodyDeclaration.
	 */
	ChildPropertyDescriptor internalJavadocProperty() {
		return JAVADOC_PROPERTY;
	}

	/**
	 * Returns a list of structural property descriptors for this node type.
	 * Clients must not modify the result.
	 *
	 * @param apiLevel the API level; one of the
	 * <code>AST.JLS&ast;</code> constants
	 * @return a list of property descriptors (element type:
	 * {@link StructuralPropertyDescriptor})
	 * @since 3.0
	 */
	public static List propertyDescriptors(int apiLevel) {
		if (apiLevel == AST.JLS2_INTERNAL) {
			return PROPERTY_DESCRIPTORS_2_0;
		} else {
			return PROPERTY_DESCRIPTORS_3_0;
		}
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	final List internalStructuralPropertiesForType(int apiLevel) {
		return propertyDescriptors(apiLevel);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	final ASTNode internalGetSetChildProperty(ChildPropertyDescriptor property, boolean get, ASTNode child) {
		if (property == JAVADOC_PROPERTY) {
			if (get) {
				return getJavadoc();
			} else {
				setJavadoc((Javadoc) child);
				return null;
			}
		}
		// allow default implementation to flag the error
		return super.internalGetSetChildProperty(property, get, child);
	}

	/* (omit javadoc for this method)
	 * Method declared on ASTNode.
	 */
	List internalGetChildListProperty(ChildListPropertyDescriptor property) {
		if (property == TYPE_PATTERNS_LIST_PROPERTY) {
			return typePatterns();
		}
		// allow default implementation to flag the error
		return super.internalGetChildListProperty(property);
	}

	/**
	 * Returns the live ordered list of type patterns for this
	 * declare precedence.
	 *
	 * @return the live list of type patterns
	 *    (element type: <code>TypePattern</code>)
	 */
	public List typePatterns() {
		return this.typePatterns;
	}

	int treeSize() {
		return
			memSize()
			+ (this.optionalDocComment == null ? 0 : getJavadoc().treeSize())
			+ (this.modifiers == null ? 0 : this.modifiers.listSize())
			+ this.typePatterns.listSize();
	}
}
