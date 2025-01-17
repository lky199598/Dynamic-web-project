package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {

		ActionContext context = ActionContext.getContext();
		Map<String, Object> session = context.getSession();
		
		if(session.get("loginInfo") != null)
		{
			String result = arg0.invoke();
			return result;
		}
		
		return "loginAgain";			
	}

}
