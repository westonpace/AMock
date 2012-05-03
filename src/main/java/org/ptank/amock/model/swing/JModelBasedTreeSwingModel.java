package org.ptank.amock.model.swing;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import org.ptank.amock.model.JModelBasedTreeNode;

public class JModelBasedTreeSwingModel implements TreeModel {

	private JModelBasedTreeNode root;

	public JModelBasedTreeSwingModel(JModelBasedTreeNode root) {
		this.root = root;
	}
	
	public void addTreeModelListener(TreeModelListener arg0) {
		//Do nothing, non dynamic
	}

	public Object getChild(Object node, int index) {
		return ((JModelBasedTreeNode)node).getChildren().get(index);
	}

	public int getChildCount(Object node) {
		return ((JModelBasedTreeNode)node).getChildren().size();
	}

	public int getIndexOfChild(Object node, Object child) {
		return ((JModelBasedTreeNode)node).getChildren().indexOf(child);
	}

	public JModelBasedTreeNode getRoot() {
		return root;
	}

	public boolean isLeaf(Object node) {
		return ((JModelBasedTreeNode)node).getChildren().size() == 0;
	}

	public void removeTreeModelListener(TreeModelListener arg0) {
		//Do nothing
	}

	public void valueForPathChanged(TreePath arg0, Object arg1) {
		throw new RuntimeException("Not implemented");
	}
	
}
