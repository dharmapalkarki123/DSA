package Java8;

import java.lang.annotation.Target;

public interface CheckedExceptionalHandlerConsumer<Target,ExObj extends Exception> {
	
	
	public void accept(Target target) throws ExObj;

}
