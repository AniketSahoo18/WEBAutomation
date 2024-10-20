package listeners;

import java.util.ArrayList;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor {

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		// List will contain all the tests that testng going to execute
		// At Run Time disable few tests

		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		result.add(methods.get(0));

		return result;
	}

}
