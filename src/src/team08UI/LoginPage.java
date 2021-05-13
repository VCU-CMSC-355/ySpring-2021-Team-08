package team08UI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoginPage {

	protected Shell shell;
	private Text txtUsername;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginPage window = new LoginPage();
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
		shell.setToolTipText("Username");
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		txtUsername = new Text(shell, SWT.BORDER);
		txtUsername.setToolTipText("Username");
		txtUsername.setBounds(142, 96, 150, 21);
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setFont(SWTResourceManager.getFont("Calibri", 14, SWT.BOLD));
		lblLogin.setBounds(193, 10, 62, 34);
		lblLogin.setText("Login");
		
		Label lblUsername = new Label(shell, SWT.NONE);
		lblUsername.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		lblUsername.setBounds(142, 75, 150, 15);
		lblUsername.setText("Username");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		lblPassword.setBounds(142, 123, 150, 15);
		lblPassword.setText("Password");
		
		text = new Text(shell, SWT.PASSWORD| SWT.BORDER);
		text.setToolTipText("Username");
		text.setBounds(142, 144, 150, 21);
		
		Button btnLogin = new Button(shell, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				HomePage hP = new HomePage();
				hP.open();
			}
		});
		btnLogin.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnLogin.setBounds(142, 171, 75, 25);
		btnLogin.setText("Login");
		
		Button btnRegister = new Button(shell, SWT.NONE);
		btnRegister.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
				RegisterPage rP = new RegisterPage();
				rP.open();
			}
		});
		btnRegister.setFont(SWTResourceManager.getFont("Candara", 9, SWT.NORMAL));
		btnRegister.setBounds(217, 171, 75, 25);
		btnRegister.setText("Register");

	}

}
