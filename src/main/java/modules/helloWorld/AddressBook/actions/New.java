package modules.helloWorld.AddressBook.actions;

import java.lang.Override;
import modules.helloWorld.domain.AddressBook;
import org.skyve.metadata.controller.ServerSideAction;
import org.skyve.metadata.controller.ServerSideActionResult;
import org.skyve.web.WebContext;

public class New implements ServerSideAction<AddressBook> {
	@Override
	public ServerSideActionResult<AddressBook> execute(AddressBook bean, WebContext webContext) {
		
		bean.setOutputText(bean.getInputText());
		
		return new ServerSideActionResult<>(bean);
	}
}
