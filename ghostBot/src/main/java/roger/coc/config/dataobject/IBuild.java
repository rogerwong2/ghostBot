package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface IBuild {
	public Element getNode();
	public void parseNode(Element node);
}
