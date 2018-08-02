package com.plus.app.client.util.right;

public interface AdvMouseNotifier {
	public void addClickListener(AdvMouseAdapter listener);
	public void removeClickListener(AdvMouseAdapter listener);
	public void addMouseListener(AdvMouseAdapter listener);
}
