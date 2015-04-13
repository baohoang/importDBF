package vn.ansv.ebu.provisioning.importdbf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jamel.dbf.DbfReader;
import org.jamel.dbf.structure.DbfDataType;
import org.jamel.dbf.structure.DbfField;
import org.jamel.dbf.structure.DbfHeader;

public class CustomDbfReader {
	private File inputFile;
	private int numOfColumns;
	private List<String> columnNames;
	private List<String> columnTypes;
	private List<Object[]> rowData;
	private int numOfRows;

	public CustomDbfReader(File input) {
		this.inputFile = input;
		DbfReader dbf = new DbfReader(this.inputFile);
		DbfHeader header = dbf.getHeader();
		this.numOfColumns = header.getFieldsCount();
		this.columnNames = new ArrayList<String>();
		this.columnTypes = new ArrayList<String>();
		for (int i = 0; i < numOfColumns; i++) {
			DbfField fields = header.getField(i);
			String name = fields.getName();
			DbfDataType type = fields.getDataType();
			String typeName = type.name();
			this.columnNames.add(name);
			this.columnTypes.add(typeName);
		}
		this.numOfRows = dbf.getRecordCount();
		this.rowData = new ArrayList<Object[]>();
		for (int i = 0; i < numOfRows; i++) {
			this.rowData.add(dbf.nextRecord());
		}
		dbf.close();
	}

	public File getInputFile() {
		return inputFile;
	}

	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	public int getNumOfColumns() {
		return numOfColumns;
	}

	public void setNumOfColumns(int numOfColumns) {
		this.numOfColumns = numOfColumns;
	}

	public List<String> getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(List<String> columnNames) {
		this.columnNames = columnNames;
	}

	public List<String> getColumnTypes() {
		return columnTypes;
	}

	public void setColumnTypes(List<String> columnTypes) {
		this.columnTypes = columnTypes;
	}

	public List<Object[]> getRowData() {
		return rowData;
	}

	public void setRowData(List<Object[]> rowData) {
		this.rowData = rowData;
	}

	public int getNumOfRows() {
		return numOfRows;
	}

	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}

}
