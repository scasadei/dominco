package net.efano.dominco.ui.widget;

// import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;


public class StackedScrollableTablesTest {

	private Table table;
	private Table table_1;

	protected Shell shell;
	// private CTabFolder tabFolder;
	private Display display;

	ScrolledComposite outermostScrollable;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		init();
		addContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public synchronized boolean isReady() {
		return (display!=null && shell!=null && !shell.isDisposed());
	}
	
	
	synchronized public void setDisplay() {
		display = Display.getDefault();
	}

	public synchronized void  openInOwnThread() {
		Runnable ru = new Runnable() {
			@Override
			public void run() {
				open();
			}
		};
		new Thread(ru).start();
	}

	public void init() {
		setDisplay(); 
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Strings Viewer");
		
		 shell.addListener (SWT.Resize,  new Listener () {
			    public void handleEvent (Event e) {
			      Rectangle rect = shell.getClientArea ();
			      if (outermostScrollable!=null) {
			    	  outermostScrollable.setBounds(0,0,shell.getClientArea().width,shell.getClientArea().height);
			    }
			      System.out.println(rect);
			    }
			  });
	    		
	}

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 * @return 
	 */
	public void addContents() {
		
		outermostScrollable = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		outermostScrollable.setExpandHorizontal(true);
		outermostScrollable.setExpandVertical(true);
		outermostScrollable.setBounds(0,0,shell.getSize().x,shell.getSize().y);
		
		SashForm outermostSashForm = new SashForm(outermostScrollable, SWT.NONE);
		
		
		StackedScrollableTables sst = new StackedScrollableTables(outermostSashForm,0);
		sst.layout();
		
		SashForm sashForm_2 = new SashForm(outermostSashForm, SWT.NONE);
		sashForm_2.setOrientation(SWT.VERTICAL);

		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(sashForm_2, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_2.setExpandHorizontal(true);
		scrolledComposite_2.setExpandVertical(true);
		
		table_1 = new Table(scrolledComposite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tblclmnContext = new TableColumn(table_1, SWT.NONE);
		tblclmnContext.setWidth(100);
		tblclmnContext.setText("context");
		
		TableItem tableItem = new TableItem(table_1, SWT.NONE);
		tableItem.setText("Date");
		
		TableItem tableItem_1 = new TableItem(table_1, SWT.NONE);
		tableItem_1.setText("15.09.2011");
		scrolledComposite_2.setContent(table_1);
		scrolledComposite_2.setMinSize(table_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		//scrolledComposite.setContent(scrolledComposite_2);
		//scrolledComposite.setMinSize(scrolledComposite_2.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(sashForm_2, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_1.setExpandHorizontal(true);
		scrolledComposite_1.setExpandVertical(true);
		
		table = new Table(scrolledComposite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnContent = new TableColumn(table, SWT.NONE);
		tblclmnContent.setWidth(100);
		tblclmnContent.setText("content");
		
		TableItem tableItem_2 = new TableItem(table, SWT.NONE);
		tableItem_2.setText("Pinco");
		
		TableItem tableItem_3 = new TableItem(table, SWT.NONE);
		tableItem_3.setText("Pallino");
		
		TableItem tableItem_4 = new TableItem(table, SWT.NONE);
		tableItem_4.setText("Giorgio");
		scrolledComposite_1.setContent(table);
		scrolledComposite_1.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		// sashForm.setWeights(new int[] {1, 1, 1});
		// sashForm.setWeights(new int[] {1, 1});
		
		SashForm sashForm_3 = new SashForm(outermostSashForm, SWT.NONE);
		sashForm_3.setOrientation(SWT.VERTICAL);
		
		ScrolledComposite scrolledComposite_3 = new ScrolledComposite(sashForm_3, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_3.setExpandHorizontal(true);
		scrolledComposite_3.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_4 = new ScrolledComposite(sashForm_3, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_4.setExpandHorizontal(true);
		scrolledComposite_4.setExpandVertical(true);
		sashForm_3.setWeights(new int[] {1, 1});
		
		outermostSashForm.setWeights(new int[] {129, 197, 163});
		outermostScrollable.setContent(outermostSashForm);
		outermostScrollable.setMinSize(outermostSashForm.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}
	
}
