/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package normalisiert.utils.useful;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

	public void writeToTwotxt(String a, int b) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					"G:\\研一\\教研室\\无向图的大环路处理\\100point\\distance_100_biao.txt"),
					true));

			writer.write(a);
			if (b == 0) {
				writer.write("\r\n");
			}

			// writer.newLine();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String text = "";

		ArrayList<ArrayList<String>> node = new ArrayList<ArrayList<String>>();
		FileReader fr = null;
		try {
			fr = new FileReader(
					"G:\\研一\\教研室\\无向图的大环路处理\\100point\\distanceTwoSmallPointXml_100.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bw = new BufferedReader(fr);
		try {
			text = bw.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (text != null) {
			String[] arrays = text.split(" ");
			ArrayList<String> row = new ArrayList<String>(Arrays.asList(arrays));
			node.add(row);
			text = bw.readLine();
		}

		for (int i = 0; i < node.size(); i++) {
			ArrayList<String> currentrow = node.get(i);
			int rowlength = currentrow.size();
			for (int j = 0; j < rowlength; j++) {
				int number = Integer.parseInt(currentrow.get(j));
				if (!(node.get(number).contains(i + "")))

					node.get(number).add(i + "");
			}

		}
		Graph gra = new Graph();
		for (ArrayList<String> str : node) {
			for (String s : str) {
				System.out.print(s + "\t");
				gra.writeToTwotxt(s + " ", 1);
			}
			gra.writeToTwotxt("", 0);
			System.out.println();
		}

	}

}
