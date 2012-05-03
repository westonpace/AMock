package org.ptank.amock.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This uses JModel annotations to present a class object as
 * an XPath-based model node.
 */
public class JModelBasedTreeNode {

	private Class<?> elementClass;
	private XPathNode path;
	
	private String name;
	
	private List<JModelBasedTreeNode> children = new ArrayList<JModelBasedTreeNode>();
	
	public JModelBasedTreeNode(Class<?> elementClass, String name, XPathNode path) {
		this.elementClass = elementClass;
		this.name = name;
		this.path = path;
	}
	
	public Class<?> getElementClass() {
		return elementClass;
	}
	
	public XPathNode getPath() {
		return path;
	}
	
	public String getName() {
		return name;
	}
	
	public void addChild(JModelBasedTreeNode child) {
		children.add(child);
	}
	
	public List<JModelBasedTreeNode> getChildren() {
		return children;
	}

	public String toString() {
		return name + " [" + elementClass.getSimpleName() + "] " + path; 
	}
	
}
