package modules.helloWorld.AddressBook;

import java.lang.String;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import org.skyve.persistence.DocumentQuery;
import org.skyve.persistence.Persistence;

/**
 * This class acts as a service layer to encapsulate domain logic.
 *
 * Add this line to classes that wish to use it: @Inject private transient AddressBookService service;
 */
@Default
public class AddressBookService {
	@Inject
	private Persistence persistence;

	public AddressBookExtension get(String bizId) {
		final DocumentQuery query = persistence.newDocumentQuery(AddressBookExtension.MODULE_NAME, AddressBookExtension.DOCUMENT_NAME);
		query.getFilter().addEquals(AddressBookExtension.DOCUMENT_ID, bizId);
		return query.beanResult();
	}

	public List<AddressBookExtension> getAll() {
		final DocumentQuery query = persistence.newDocumentQuery(AddressBookExtension.MODULE_NAME, AddressBookExtension.DOCUMENT_NAME);
		return query.beanResults();
	}
}
