package org.skyve.impl.sail.execution;

import org.skyve.metadata.user.User;

public abstract class SeleneseExecutor extends ScriptExecutor {
	public SeleneseExecutor(User user) {
		super(user);
	}

	protected void command(String command, String parameter1, String parameter2) {
		indent().append("<tr><td>").append(command).append("</td><td>");
		if (parameter1 != null) {
			append(parameter1);
		}
		append("</td><td>");
		if (parameter2 != null) {
			append(parameter2);
		}
		append("</td></tr>").newline();
	}
	
	protected void command(String command, String parameter1) {
		command(command, parameter1, null);
	}

	protected void command(String command) {
		command(command, null, null);
	}

	protected void startTest(String heading) {
		indent().append("<table>").newline();
		in().indent().append("<thead>").newline();
		in().indent().append("<tr><th>").append(heading).append("</th></tr>").newline();
		out().indent().append("</thead>").newline();
		indent().append("<tbody>").newline().in();
	}
	
	protected void endTest() {
		out().indent().append("</tbody>").newline();
		out().indent().append("</table>").newline();
	}
}