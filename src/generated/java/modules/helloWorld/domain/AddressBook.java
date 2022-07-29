package modules.helloWorld.domain;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import org.skyve.CORE;
import org.skyve.domain.messages.DomainException;
import org.skyve.impl.domain.AbstractPersistentBean;

/**
 * AddressBook
 * 
 * @stereotype "persistent"
 */
@XmlType
@XmlRootElement
public class AddressBook extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "helloWorld";

	/** @hidden */
	public static final String DOCUMENT_NAME = "AddressBook";

	@Override
	@XmlTransient
	public String getBizModule() {
		return AddressBook.MODULE_NAME;
	}

	@Override
	@XmlTransient
	public String getBizDocument() {
		return AddressBook.DOCUMENT_NAME;
	}

	public static AddressBook newInstance() {
		try {
			return CORE.getUser().getCustomer().getModule(MODULE_NAME).getDocument(CORE.getUser().getCustomer(), DOCUMENT_NAME).newInstance(CORE.getUser());
		}
		catch (RuntimeException e) {
			throw e;
		}
		catch (Exception e) {
			throw new DomainException(e);
		}
	}

	@Override
	@XmlTransient
	public String getBizKey() {
		try {
			return org.skyve.util.Binder.formatMessage("AddressBook", this);
		}
		catch (@SuppressWarnings("unused") Exception e) {
			return "Unknown";
		}
	}

	@Override
	public boolean equals(Object o) {
		return ((o instanceof AddressBook) && 
					this.getBizId().equals(((AddressBook) o).getBizId()));
	}
}
