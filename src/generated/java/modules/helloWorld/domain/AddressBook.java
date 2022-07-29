package modules.helloWorld.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import modules.helloWorld.AddressBook.AddressBookExtension;
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
public abstract class AddressBook extends AbstractPersistentBean {
	/**
	 * For Serialization
	 * @hidden
	 */
	private static final long serialVersionUID = 1L;

	/** @hidden */
	public static final String MODULE_NAME = "helloWorld";

	/** @hidden */
	public static final String DOCUMENT_NAME = "AddressBook";

	/** @hidden */
	public static final String inputTextPropertyName = "inputText";

	/** @hidden */
	public static final String outputTextPropertyName = "outputText";

	/**
	 * Input Text
	 **/
	private String inputText = "Hello World";

	/**
	 * Output Text
	 **/
	private String outputText;

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

	public static AddressBookExtension newInstance() {
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

	/**
	 * {@link #inputText} accessor.
	 * @return	The value.
	 **/
	public String getInputText() {
		return inputText;
	}

	/**
	 * {@link #inputText} mutator.
	 * @param inputText	The new value.
	 **/
	@XmlElement
	public void setInputText(String inputText) {
		preset(inputTextPropertyName, inputText);
		this.inputText = inputText;
	}

	/**
	 * {@link #outputText} accessor.
	 * @return	The value.
	 **/
	public String getOutputText() {
		return outputText;
	}

	/**
	 * {@link #outputText} mutator.
	 * @param outputText	The new value.
	 **/
	@XmlElement
	public void setOutputText(String outputText) {
		preset(outputTextPropertyName, outputText);
		this.outputText = outputText;
	}
}
