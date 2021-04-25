package team08UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Translator {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Translator window = new Translator();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblTranslator = new Label(shell, SWT.NONE);
		lblTranslator.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.BOLD));
		lblTranslator.setBounds(10, 10, 85, 26);
		lblTranslator.setText("Translator");
		
		Label lblEnglish = new Label(shell, SWT.NONE);
		lblEnglish.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblEnglish.setBounds(20, 42, 47, 19);
		lblEnglish.setText("English");
		
		Label lblUserChosenLanguage = new Label(shell, SWT.NONE);
		lblUserChosenLanguage.setFont(SWTResourceManager.getFont("Calibri", 10, SWT.NORMAL));
		lblUserChosenLanguage.setBounds(245, 42, 149, 19);
		lblUserChosenLanguage.setText("User Chosen Language");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(20, 67, 150, 150);
		
		Label lblTesting = new Label(shell, SWT.NONE);
		lblTesting.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblTesting.setVisible(false);
		lblTesting.setBounds(288, 67, 54, 26);
		lblTesting.setText("Testing");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Candara", 8, SWT.NORMAL));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				lblTesting.setVisible(true);
			}
		});
		btnNewButton.setBounds(183, 94, 67, 26);
		btnNewButton.setText("Translate");
		
		Button btnClear = new Button(shell, SWT.NONE);
		btnClear.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnClear.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				lblTesting.setVisible(false);
			}
		});
		btnClear.setBounds(190, 125, 54, 25);
		btnClear.setText("Clear");
		
		Button btnHome = new Button(shell, SWT.NONE);
		btnHome.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				HomePage hP = new HomePage();
				hP.open();
			}
		});
		btnHome.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnHome.setBounds(349, 226, 75, 25);
		btnHome.setText("Home");

	}

}
