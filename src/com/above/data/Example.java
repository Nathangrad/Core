package com.above.data;

import com.above.exceptions.InvalidDataColumnException;
import com.above.exceptions.InvalidDataRowException;

public class Example {

	public Example() {
		DataTable table = new DataTable(new String[] { "Name", "Role", "Age", "Religion" });
		DataRow row1 = table.addRow();
		try {
			row1.setCell("Name", "Nathan");
			row1.setCell("Role", "Lead-Developer");
			row1.setCell("Religion", "Atheist");
			row1.setCell("Age", 17);
		} catch (InvalidDataColumnException e) {
			e.printStackTrace();
		}
		DataRow row2 = table.addRow();
		try {
			row2.setCell("Name", "Nash");
			row2.setCell("Age", 15);
			row2.setCell("Religion", "Christian");
			row2.setCell("Role", "Manager");
		} catch (InvalidDataColumnException e) {
			e.printStackTrace();
		}
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		int counter = 0;
		for (@SuppressWarnings("unused")
		DataRow r : table.getRows()) {
			for (DataColumn c : table.getColumns()) {
				try {
					builder.append(c.getName() + ": " + table.getRow(counter).getCell(c.getName()) + "\n");
				} catch (InvalidDataColumnException | InvalidDataRowException e) {
					e.printStackTrace();
				}
			}
			builder.append("\n");
			counter++;
		}
		System.out.println(builder.toString());
	}
}
