/*
 * generated by Xtext 2.11.0
 */
package de.htwdd.sf.beleg.ui.outline

import de.htwdd.sf.beleg.customProlog.Term
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider

/**
 * Customization of the default outline structure.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#outline
 */
class CustomPrologOutlineTreeProvider extends DefaultOutlineTreeProvider {
	def createNode(IOutlineNode node, Term t) {
		createChildren(node, t)
	}
}