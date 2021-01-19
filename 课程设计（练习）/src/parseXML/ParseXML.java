package parseXML;

import java.net.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import org.w3c.dom.*;
import com.heaton.bot.*;
import java.io.*;

public class ParseXML {
	static private int _indent = 0;

	static private void printlnCommon(Node n) {
		System.out.print(" nodeName=\"" + n.getNodeName() + "\"");
		String val = n.getNamespaceURI();
		if (val != null)
			System.out.print(" url=\"" + val + "\"");
		val = n.getPrefix();
		if (val != null)
			System.out.print(" pre=\"" + val + "\"");
		val = n.getLocalName();
		if (val != null)
			System.out.print(" local=\"" + val + "\"");
		val = n.getNodeValue();
		if (val != null) {
			System.out.print(" nodeValue=");
			if (val.trim().equals(""))
				System.out.print("[WS]");
			else
				System.out.print("\"" + n.getNodeValue() + "\"");
		}
		System.out.println();
	}

	static private void doIndentation() {
		for (int i = 0; i < _indent; i++)
			System.out.println("   ");
	}

	static private void display(Node n) {
		doIndentation();
		int type = n.getNodeType();
		switch (type) {
		case Node.ATTRIBUTE_NODE:
			System.out.print("ATTR:");
			printlnCommon(n);
			break;
		case Node.CDATA_SECTION_NODE:
			System.out.print("CDATA:");
			printlnCommon(n);
			break;
		case Node.COMMENT_NODE:
			System.out.print("COMM:");
			printlnCommon(n);
			break;
		case Node.DOCUMENT_FRAGMENT_NODE:
			System.out.print("DOC_FRAG:");
			printlnCommon(n);
			break;
		case Node.DOCUMENT_NODE:
			System.out.print("DOC:");
			printlnCommon(n);
			break;
		case Node.DOCUMENT_TYPE_NODE:
			System.out.print("DOC_TYPE:");
			printlnCommon(n);
			NamedNodeMap nodeMap = ((DocumentType) n).getEntities();
			_indent += 2;
			for (int i = 0; i < nodeMap.getLength(); i++)
				display((Entity) nodeMap.item(i));
			_indent -= 2;
			break;
		case Node.ELEMENT_NODE:
			System.out.print("ELEM:");
			printlnCommon(n);
			NamedNodeMap atts = n.getAttributes();
			_indent += 2;
			for (int i = 0; i < atts.getLength(); i++)
				display((Node) atts.item(i));
			_indent -= 2;
			break;
		case Node.ENTITY_NODE:
			System.out.print("ENT:");
			printlnCommon(n);
			break;
		case Node.ENTITY_REFERENCE_NODE:
			System.out.print("ENT_REF:");
			printlnCommon(n);
			break;
		case Node.NOTATION_NODE:
			System.out.print("NOTATION:");
			printlnCommon(n);
			break;
		case Node.PROCESSING_INSTRUCTION_NODE:
			System.out.print("PROC_INST:");
			printlnCommon(n);
			break;
		case Node.TEXT_NODE:
			System.out.print("TEXT:");
			printlnCommon(n);
			break;
		default:
			System.out.print("UNSUPPORTED NODE: " + type);
			printlnCommon(n);
			break;
		}

		_indent++;
		for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling())
			display(child);
		_indent--;
	}

	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		InputStream f = null;
		if(args.length != 1){
			System.out.println("Usage:");
			System.out.println("javac ParseXML [qif file or URL to parse]");
			System.exit(0);
		}
		try{
			f = new FileInputStream(new File(args[0]));
		} catch(FileNotFoundException e){
			try {
				HTTPSocket http = new HTTPSocket();
				http.send(args[0], null);
				f = new StringBufferInputStream(http.getBody());
			} catch(UnknownHostException ee){
				System.out.println("Can't open file or URL named: "
						+ args[0] + "(" + ee + ")");
			} catch(IOException ee){
				System.out.println(e);
				System.exit(0);
			}
		}
		
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = null;
			db = dbf.newDocumentBuilder();
			Document doc = null;
			doc = db.parse(f);
			display(doc);
		} catch(Exception e){
			System.out.println("Error: " + e);
		}
		
		try{
			if(f != null)
				f.close();
		} catch (IOException e){
			System.out.println("Error: " + e);
			System.exit(0);
		}
	}
}
