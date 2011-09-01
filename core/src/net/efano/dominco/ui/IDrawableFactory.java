package net.efano.dominco.ui;

import org.eclipse.swt.widgets.Display;

public interface IDrawableFactory {

	IDrawable getNewDrawable();
	boolean isReady();
	Display getDisplay();
}
