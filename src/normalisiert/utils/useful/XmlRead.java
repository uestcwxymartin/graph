package normalisiert.utils.useful;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlRead {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public void xmlRead(String xmlPath) throws UnsupportedEncodingException {
		SAXReader saxReader = new SAXReader();
		Document doc = null;
		try {
			doc = saxReader.read(xmlPath);
		} catch (DocumentException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
		Element rootElement = doc.getRootElement();
		Element nodeElement = rootElement.element("graph");
		float dishu = 0, zhishu = 0;
		long result = 0;
		long minum = 0, secoMinum = 0, minPosition = 0, secoMinPosition = 0;
		int jiedian = 0;
		for (Iterator iterator = nodeElement.elementIterator(); iterator
				.hasNext();) {
			Element point = (Element) iterator.next();
			String node = point.getName();
			// System.out.println("node"+node);
			if (node.equals("vertex")) {

				ArrayList<Element> edge = (ArrayList<Element>) point.elements();
				for (Element e : edge) {
					String value = e.getStringValue();
					// System.out.println("value "+value);
					
					if (Integer.parseInt(value)<jiedian) { continue; }//阶梯型的权重矩阵
					 
					String cost = e.attributeValue("cost");
					dishu = Float.parseFloat(cost.substring(0, 5));
					// dishu=Float.parseFloat(cost.substring(0,
					// cost.indexOf('0')));
					// System.out.println("dishu"+dishu);
					zhishu = Integer.parseInt(cost.substring(cost.length() - 1,
							cost.length()));
					result = Math.round((double) dishu * Math.pow(10, zhishu));
					/*
					 * if (Integer.parseInt(value)<jiedian) {
					 * writetotxt(result+""
					 * ,0,"G:\\研一\\教研室\\无向图的大环路处理\\distanceXml_24_qian.txt");
					 * }else
					 */
					writetotxt(result + "", 0,
							"G:\\研一\\教研室\\无向图的大环路处理\\48point\\weight_48.txt");
					// System.out.println("result: "+result);
					/*
					 * if (secoMinum>result) { if (minum>result) { minum =
					 * result; minPosition = Integer.parseInt(value); }else {
					 * secoMinum = result; secoMinPosition =
					 * Integer.parseInt(value); } }
					 */

				}

				jiedian++;
				writetotxt("", 1,
						"G:\\研一\\教研室\\无向图的大环路处理\\48point\\weight_48.txt");
				// writetoTwotxt(minPosition+" "+secoMinPosition);
			}
		}
	}

	private void writetotxt(String a, int b, String path) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					path), true));

			writer.write(a + " ");
			// writer.write("   This is end of point");
			if (b != 0) {
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private void writetoTwotxt(String a) { try { BufferedWriter writer = new
	 * BufferedWriter(new FileWriter(new
	 * File("G:\\研一\\教研室\\无向图的大环路处理\\distanceTwoShortXml_24.txt"), true));
	 * 
	 * writer.write(a); writer.write("\r\n"); writer.close(); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * } }
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XmlRead xr = new XmlRead();
		try {
			xr.xmlRead("G:/xmltest/att48.xml");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
