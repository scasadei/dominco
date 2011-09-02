package net.efano.dominco.oldstuff.core;

import java.util.Vector;

public class Frame {

	Frame() {
		
	}
	Frame context;
	Symbolic generator;
	Vector<Frame> subframes;
	
	public Frame(Frame aContext, Symbolic aGenerator) {
		context = aContext;
		generator = aGenerator;
	}

	public void addSubframe(Frame aFrame) {
		subframes.add(aFrame);
	}
	
}
