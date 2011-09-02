package net.efano.dominco1.core;


import java.util.Date;

import net.efano.dominco1.core.Frame;

public class SessionFrame extends Frame {

	String authorName;
	Date startTime;

	public SessionFrame (String anAuthorName, Date aDate) {
		super(null,null);
		authorName = anAuthorName;
		startTime = aDate;
	}

}
