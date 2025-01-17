package Listener;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import JavaBean.User;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */
@WebListener("This is Servlet 3.0 Listener")
public class MyHttpSessionListener implements HttpSessionListener {

	private int userNumber = 0;

	/**
	 * Default constructor.
	 */
	public MyHttpSessionListener() {

	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		userNumber++;
		arg0.getSession().getServletContext()
				.setAttribute("userNumber", userNumber);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		userNumber--;
		arg0.getSession().getServletContext()
				.setAttribute("userNumber", userNumber);

		ArrayList<User> UserList = (ArrayList<User>) arg0.getSession()
				.getServletContext().getAttribute("UserList");

		if (UserList != null) {
			for (User user : UserList)
				if (user.getSessionID().equals(arg0.getSession().getId())) {
					UserList.remove(user);
					arg0.getSession().getServletContext()
							.setAttribute("UserList", UserList);
					break;

				}
		}

	}

}
