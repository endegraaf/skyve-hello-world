package modules.helloWorld.AddressBook;

import org.skyve.util.DataBuilder;
import org.skyve.util.test.SkyveFactory;
import org.skyve.util.test.SkyveFixture;

@SkyveFactory
public class AddressBookFactory {
	@SkyveFixture(
			types = SkyveFixture.FixtureType.crud
	)
	public AddressBookExtension crudInstance() {
		return new DataBuilder().fixture(SkyveFixture.FixtureType.crud).factoryBuild(AddressBookExtension.MODULE_NAME, AddressBookExtension.DOCUMENT_NAME);
	}
}
