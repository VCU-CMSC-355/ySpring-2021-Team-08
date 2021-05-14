package team08UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Credits {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Credits window = new Credits();
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
		
		Label lblCredits = new Label(shell, SWT.NONE);
		lblCredits.setAlignment(SWT.CENTER);
		lblCredits.setFont(SWTResourceManager.getFont("Calibri", 12, SWT.NORMAL));
		lblCredits.setBounds(39, 36, 356, 177);
		lblCredits.setText("A translator and tax calculator"+"\nCreated by Team 08"+"\nHaley Currence - Service Broker and Debugging"+"\nStephen Liu - Translator Page and Psuecode"+"\nJoshua Lopez-Boutier - UI and Psuedocode"
		+ "\nShashank - Message Module" + "\nMunim - Tax Calculator");
		
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
