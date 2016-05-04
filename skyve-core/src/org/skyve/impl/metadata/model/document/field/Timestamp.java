package org.skyve.impl.metadata.model.document.field;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.skyve.impl.metadata.model.document.field.validator.DateValidator;
import org.skyve.impl.util.XMLMetaData;
import org.skyve.impl.metadata.model.document.field.ConvertableField;

@XmlType(namespace = XMLMetaData.DOCUMENT_NAMESPACE)
@XmlRootElement(namespace = XMLMetaData.DOCUMENT_NAMESPACE)
public class Timestamp extends ConvertableField {
	/**
	 * For Serialization
	 */
	private static final long serialVersionUID = -5008213051812011630L;

	private DateValidator validator;
	
	public Timestamp() {
		setAttributeType(AttributeType.timestamp);
	}
	
	public DateValidator getValidator() {
		return validator;
	}

	@XmlElement(namespace = XMLMetaData.DOCUMENT_NAMESPACE)
	public void setValidator(DateValidator validator) {
		this.validator = validator;
	}
}
