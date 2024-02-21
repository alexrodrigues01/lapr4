package gramaticas.script;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;


public class XMLUpdater {


    public static void update(String fileName, String id, String atributo, String texto) {
        try {
            System.out.println(fileName);
            System.out.println(id);
            System.out.println(atributo);
            System.out.println(texto);

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            String[] tag = fileName.split("[\\\\.]");

            String element = tag[tag.length - 2];

            NodeList listOfElements = document.getElementsByTagName(element);

            for (int i = 0; i < listOfElements.getLength(); i++) {
                Node mainElement = listOfElements.item(i);
                if (mainElement.getAttributes().getNamedItem("id").getTextContent().trim().equals(id)) {
                    NodeList childNodes = mainElement.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node item = childNodes.item(j);
                        if (item.getNodeType() == Node.ELEMENT_NODE) {
                            if (item.getNodeName().equalsIgnoreCase(atributo)) {
                                item.setTextContent(texto);
                            }
                        }
                    }
                }
            }

            try (FileOutputStream output =
                         new FileOutputStream(fileName)) {
                writeXml(document, output);
            } catch (IOException | TransformerException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {

        }
    }

    // write doc to output stream
    private static void writeXml(Document doc,
                                 OutputStream output)
            throws TransformerException, UnsupportedEncodingException {

        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "no");
        tf.setOutputProperty(OutputKeys.METHOD, "xml");
        tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        tf.transform(source, result);
    }

    public static void updateSoma(String fileName, String parametroTipo,String parametro, String parametroMudar, int valor){
        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileName);

            String[] tag = fileName.split("[\\\\.]");

            String element = tag[tag.length - 2];

            NodeList listOfElements = document.getElementsByTagName(element);

            boolean alterar = false;
            for (int i = 0; i < listOfElements.getLength(); i++) {
                Node mainElement = listOfElements.item(i);
                    NodeList childNodes = mainElement.getChildNodes();
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node item = childNodes.item(j);
                        if (item.getNodeType() == Node.ELEMENT_NODE) {
                            if (item.getNodeName().equalsIgnoreCase(parametroTipo)) {
                                if (item.getTextContent().equalsIgnoreCase(parametro)) {
                                    alterar = true;
                                }
                            }
                            if (item.getNodeName().equalsIgnoreCase(parametroMudar) && alterar) {
                                item.setTextContent(Double.parseDouble(item.getTextContent()) + valor + "");
                                alterar = false;
                            }
                        }
                    }
            }

            try (FileOutputStream output =
                         new FileOutputStream(fileName)) {
                writeXml(document, output);
            } catch (IOException | TransformerException e) {
                e.printStackTrace();
            }
        }catch (Exception e){

        }
    }
}