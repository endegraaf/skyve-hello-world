package modules.helloWorld.domain;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFixture.FixtureType;
import util.AbstractDomainTest;

/**
 * Generated - local changes will be overwritten.
 * Extend {@link AbstractDomainTest} to create your own tests for this document.
 */
public class AddressBookTest extends AbstractDomainTest<AddressBook> {

	@Override
	protected AddressBook getBean() throws Exception {
		return new DataBuilder()
			.fixture(FixtureType.crud)
			.build(AddressBook.MODULE_NAME, AddressBook.DOCUMENT_NAME);
	}
}