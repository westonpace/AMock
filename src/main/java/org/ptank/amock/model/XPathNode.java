package org.ptank.amock.model;

public class XPathNode {

	private String path;
	
	public XPathNode() {
		path = "/";
	}
	
	public XPathNode(String path) {
		this.path = cutTrailingSlash(path);
	}
	
	public XPathNode append(String newPath) {
		return new XPathNode(cutTrailingSlash(cutTrailingSlash(this.path) + "/" + cutLeadingSlash(newPath)));
	}
	
	public XPathNode index(int index) {
		return new XPathNode(this.path + "[" + index + "]");
	}

	private String cutLeadingSlash(String input) {
		if(input.startsWith("/")) {
			return input.substring(1);
		} else {
			return input;
		}
	}
	
	private String cutTrailingSlash(String input) {
		if(input.endsWith("/")) {
			return input.substring(0,input.length()-1);
		} else {
			return input;
		}
	}
	
	public String toString() {
		return path;
	}
	
	public String getRawPath() {
		return path;
	}
}
