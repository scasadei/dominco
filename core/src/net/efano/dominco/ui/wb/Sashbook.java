package net.efano.dominco.ui.wb;


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

public class Sashbook  {
	private Table table;
	private Table table_1;

	protected Shell shell;
	// private CTabFolder tabFolder;
	private Display display;

	ScrolledComposite scrolledComposite_7;
	
	public synchronized boolean isReady() {
		return (display!=null && shell!=null && !shell.isDisposed());
	}
	
	 public Sashbook() {
	 }
	
	synchronized public void setDisplay() {
		display = Display.getDefault();
	}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Sashbook window = new Sashbook();
			window.open();
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
			      if (scrolledComposite_7!=null) {
			    	  scrolledComposite_7.setBounds(0,0,shell.getClientArea().width,shell.getClientArea().height);
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
		
		scrolledComposite_7 = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_7.setExpandHorizontal(true);
		scrolledComposite_7.setExpandVertical(true);
		scrolledComposite_7.setBounds(0,0,shell.getSize().x,shell.getSize().y);
		
		SashForm sashForm_2 = new SashForm(scrolledComposite_7, SWT.NONE);
		
		SashForm sashForm = new SashForm(sashForm_2, SWT.NONE);
		sashForm.setOrientation(SWT.VERTICAL);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_2 = new ScrolledComposite(scrolledComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
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
		scrolledComposite.setContent(scrolledComposite_2);
		scrolledComposite.setMinSize(scrolledComposite_2.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		ScrolledComposite scrolledComposite_1 = new ScrolledComposite(sashForm, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
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
		sashForm.setWeights(new int[] {1, 1});
		
		SashForm sashForm_1 = new SashForm(sashForm_2, SWT.NONE);
		sashForm_1.setOrientation(SWT.VERTICAL);
		
		ScrolledComposite scrolledComposite_3 = new ScrolledComposite(sashForm_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_3.setExpandHorizontal(true);
		scrolledComposite_3.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_4 = new ScrolledComposite(sashForm_1, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_4.setExpandHorizontal(true);
		scrolledComposite_4.setExpandVertical(true);
		sashForm_1.setWeights(new int[] {1, 1});
		
		SashForm sashForm_3 = new SashForm(sashForm_2, SWT.NONE);
		sashForm_3.setOrientation(SWT.VERTICAL);
		
		ScrolledComposite scrolledComposite_5 = new ScrolledComposite(sashForm_3, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_5.setExpandHorizontal(true);
		scrolledComposite_5.setExpandVertical(true);
		
		ScrolledComposite scrolledComposite_6 = new ScrolledComposite(sashForm_3, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite_6.setExpandHorizontal(true);
		scrolledComposite_6.setExpandVertical(true);
		sashForm_3.setWeights(new int[] {1, 1});
		sashForm_2.setWeights(new int[] {129, 197, 163});
		scrolledComposite_7.setContent(sashForm_2);
		scrolledComposite_7.setMinSize(sashForm_2.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}

	// @Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
