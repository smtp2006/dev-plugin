package kg.eclipse.popup.actions;

import kg.eclipse.util.ISelectionUtil;
import kg.eclipse.util.JavaInfo;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class CreateJavaBeanTestAction implements IObjectActionDelegate {

	private Shell shell;
	private ISelection selection;
	/**
	 * Constructor for Action1.
	 */
	public CreateJavaBeanTestAction() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		MessageDialog.openInformation(
			shell,
			"dev-plugin",
			"Dev menu was executed.");
		JavaInfo javaInfo = ISelectionUtil.parseJavaInfo(selection);
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	    this.selection = selection;
	}

}
