package org.skyve.metadata.sail.language.step.interaction;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.skyve.metadata.sail.execution.Executor;
import org.skyve.metadata.sail.language.Step;
import org.skyve.impl.util.UtilImpl;
import org.skyve.impl.util.XMLMetaData;

/**
 * Select the tab with the given tabPath.
 * The tabPath can either be the title of the tab, or if the tab pane is nested in another tab,
 * something like outerTabTitle/innerTabTitle.
 * 
 * @author mike
 */
@XmlType(namespace = XMLMetaData.SAIL_NAMESPACE)
@XmlRootElement(namespace = XMLMetaData.SAIL_NAMESPACE)
public class TabSelect implements Step {
	private String tabPath;

	public String getTabPath() {
		return tabPath;
	}

	@XmlAttribute(name = "path", required = true)
	public void setTabPath(String tabPath) {
		this.tabPath = UtilImpl.processStringValue(tabPath);
	}

	@Override
	public void execute(Executor executor) {
		executor.execute(this);
	}
	
	@Override
	public String getIdentifier() {
		return tabPath;
	}
}
