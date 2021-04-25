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

public class RegisterPage {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RegisterPage window = new RegisterPage();
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
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.BOLD));
		lblNewLabel.setBounds(181, 10, 71, 26);
		lblNewLabel.setText("Register");
		
		text = new Text(shell, SWT.BORDER);
		text.setToolTipText("Username");
		text.setBounds(142, 63, 150, 21);
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		lblUsername.setBounds(142, 42, 150, 15);
		lblUsername.setText("Username");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		lblPassword.setBounds(142, 90, 55, 15);
		lblPassword.setText("Password");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setToolTipText("Username");
		text_1.setBounds(142, 111, 150, 21);
		
		Label lblConfirmPassword = new Label(shell, SWT.NONE);
		lblConfirmPassword.setBounds(142, 138, 150, 15);
		lblConfirmPassword.setText("Confirm Password");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setToolTipText("Username");
		text_2.setBounds(142, 159, 150, 21);
		
		Button btnRegisterAccount = new Button(shell, SWT.NONE);
		btnRegisterAccount.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				HomePage hP = new HomePage();
				hP.open();
			}
		});
		btnRegisterAccount.setBounds(161, 184, 111, 25);
		btnRegisterAccount.setText("Register Account");
		
		Button btnGoBack = new Button(shell, SWT.NONE);
		btnGoBack.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				LoginPage lP = new LoginPage();
				lP.open();
			}
		});
		btnGoBack.setBounds(349, 226, 75, 25);
		btnGoBack.setText("Go back");

	}
}
