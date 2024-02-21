package gramaticas.script;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLParser {

        public static String xmlPaser(String idd,String option,String fileName) {

            // Instantiate the Factory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            try {

                // optional, but recommended
                // process XML securely, avoid attacks like XML External Entities (XXE)
                dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

                // parse XML file
                DocumentBuilder db = dbf.newDocumentBuilder();

                Document doc = db.parse(new File(fileName));

                // optional, but recommended
                // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

//                System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
//                System.out.println("------");

                // get <staff>
                String[] tag= fileName.split("[\\\\.]");
                NodeList list = doc.getElementsByTagName(tag[tag.length-2]);

                for (int temp = 0; temp < list.getLength(); temp++) {

                    Node node = list.item(temp);

                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        Element element = (Element) node;

                        // get staff's attribute
                        String id = element.getAttribute("id");

//                        System.out.println("Current Element :" + node.getNodeName());
//                        System.out.println("Staff Id : " + id);
//                        System.out.println("Nome : " + nome);
//                        System.out.println("Phone: " + phone);
//                        System.out.println("Email : " + nickname);
//                        System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);

                        if(idd.equalsIgnoreCase(id)){
                            try {
                                return element.getElementsByTagName(option).item(0).getTextContent();
                            }catch(NullPointerException e){
                                }
                        }
                    }
                }

            } catch (SAXException | IOException | ParserConfigurationException | NullPointerException e) {
                e.printStackTrace();
            }
            return "Parametro Invalido";
        }

    }
