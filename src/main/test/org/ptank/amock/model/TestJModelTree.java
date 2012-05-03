package org.ptank.amock.model;

import javax.swing.JFrame;
import javax.swing.JTree;

import org.ptank.amock.model.swing.JModelBasedTreeSwingModel;

public class TestJModelTree {

	public static void main(String args[]) {
		JFrame mainFrame = new JFrame();
		
		JTree tree = new JTree();
		JModelBasedTreeNode baseModel = new JModelBasedTreeBuilder().buildTree(JModelBasedTreeNode.class);
		tree.setModel(new JModelBasedTreeSwingModel(baseModel));
		
		mainFrame.add(tree);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
	
}
