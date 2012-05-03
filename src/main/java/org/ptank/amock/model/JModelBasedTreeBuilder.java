package org.ptank.amock.model;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.PropertyUtils;

public class JModelBasedTreeBuilder {

	public JModelBasedTreeNode buildTree(Class<?> rootClass) {
		
		JModelBasedTreeNode root = new JModelBasedTreeNode(rootClass,"root",new XPathNode());
		
		buildTree(root);
		
		return root;
	}
	
	private void buildTree(JModelBasedTreeNode node) {
		System.out.println("Building " + node.getPath());
		Class<?> nodeClass = node.getElementClass();
		
		PropertyDescriptor [] properties = PropertyUtils.getPropertyDescriptors(nodeClass);
		
		for(PropertyDescriptor descriptor : properties) {
			if(!isDefaultProperty(descriptor)) {
				String name = descriptor.getDisplayName();
				Class<?> propertyClass = descriptor.getPropertyType();
				XPathNode path = node.getPath().append(name);
				
				JModelBasedTreeNode childNode = new JModelBasedTreeNode(propertyClass, name, path);
				if(!isBaseType(propertyClass)) {
					buildTree(childNode);
				}
				node.addChild(childNode);
			}
		}
	}

	private boolean isDefaultProperty(PropertyDescriptor descriptor) {
		return descriptor.getName().equals("class");
	}
	
	private boolean isBaseType(Class<?> elementClass) {
		return elementClass.isPrimitive() || elementClass.getPackage().getName().startsWith("java.");
	}
	
}
