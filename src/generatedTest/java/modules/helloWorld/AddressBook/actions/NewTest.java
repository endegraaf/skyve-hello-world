package modules.helloWorld.AddressBook.actions;

import modules.helloWorld.domain.AddressBook;
import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractActionTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractActionTest} to create your own tests for this action.
 */
public class NewTest extends AbstractActionTest<AddressBook, New> {

	@Override
	protected New getAction() {
		return new New();
	}

	@Override
	protected AddressBook getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(AddressBook.MODULE_NAME, AddressBook.DOCUMENT_NAME);
	}
}