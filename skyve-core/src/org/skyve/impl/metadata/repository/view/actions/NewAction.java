package org.skyve.impl.metadata.repository.view.actions;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.skyve.impl.util.XMLMetaData;
import org.skyve.metadata.controller.ImplicitActionName;

@XmlType(namespace = XMLMetaData.VIEW_NAMESPACE)
@XmlRootElement(namespace = XMLMetaData.VIEW_NAMESPACE, name = "new")
public class NewAction extends PositionableAction {
	public NewAction() {
		implicitName = ImplicitActionName.New;
	}
}
