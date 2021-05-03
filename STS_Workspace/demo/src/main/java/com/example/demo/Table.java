package com.example.demo;
//package com.epam.engx.cleancode.complextask.task1;

import java.util.List;

public class Table {

	private static final String TABLE_UPPER_START = "╔";
	private static final String TABLE_UPPER_MIDDLE = "╦";
	private static final String TABLE_UPPER_END = "╗";
	private static final String TABLE_MIDDLE_START = "╠";
	private static final String TABLE_MIDDLE_CENTER = "╬";
	private static final String TABLE_MIDDLE_END = "╣";
	private static final String TABLE_BOTTOM_START = "╚";;
	private static final String TABLE_BOTTOM_MIDDLE = "╩";
	private static final String TABLE_BOTTOM_END = "╝";
	private static final String COLUMN_SEPERATOR = "║";
	private static final String LINE_SEPERATOR = "\n";
	private static final String EMPTY_STRING = "";
	
	private List<DataSet> dataSetList;
	private boolean isEmptyTable;
	private String tableName;

	 Table(List<DataSet> dataSets, String tableName) {
		this.dataSetList = dataSets;
		this.tableName = tableName;
		this.isEmptyTable = getMaxColumnSize(dataSets) == 0 ? true : false;
	}

	public String getTableString() {
		if (isEmptyTable) {
			return getEmptyTable(tableName);
		} else {
			return getHeaderOfTheTable() + getStringTableData();
		}
	}

	private String getEmptyTable(String tableName) {
		String textEmptyTable = COLUMN_SEPERATOR+" Table '" + tableName + "' is empty or does not exist "+COLUMN_SEPERATOR;
		String result = TABLE_UPPER_START;
		result += createHorizontalLine(textEmptyTable.length() - 2);
		result += TABLE_UPPER_END + LINE_SEPERATOR;
		result += textEmptyTable + LINE_SEPERATOR;
		result += TABLE_BOTTOM_START;
		result += createHorizontalLine(textEmptyTable.length() - 2);
		result += TABLE_BOTTOM_END + LINE_SEPERATOR;
		return result;
	}

	private String getStringTableData() {
		int rowsCount;
		rowsCount = dataSetList.size();
		int maxColumnSize = getMaxColumnSize(dataSetList);
		String result = EMPTY_STRING;
		maxColumnSize = calculateMaxColumnSize(maxColumnSize);
		
		int columnCount = 0;
		if (!dataSetList.isEmpty()) {
			columnCount =  dataSetList.get(0).getColumnNames().size();
		}
		
		result += insertRecords(rowsCount, maxColumnSize, columnCount);
		result += TABLE_BOTTOM_START;
		for (int j = 1; j < columnCount; j++) {
			result += createHorizontalLine(maxColumnSize);
			result += TABLE_BOTTOM_MIDDLE;
		}
		result += createHorizontalLine(maxColumnSize);
		result += TABLE_BOTTOM_END + LINE_SEPERATOR;
		return result;
	}

	private int calculateMaxColumnSize(int value) {
		int maxColumnSize = value;
		if (maxColumnSize % 2 == 0) {
			maxColumnSize += 2;
		} else {
			maxColumnSize += 3;
		}
		return maxColumnSize;
	}

	private String insertRecords(int rowsCount, int maxColumnSize, int columnCount) {
		String result = EMPTY_STRING;
		for (int row = 0; row < rowsCount; row++) {
			List<Object> values = dataSetList.get(row).getValues();
			result += COLUMN_SEPERATOR;
			result += ProcessColumns(maxColumnSize, columnCount, values);
			result += LINE_SEPERATOR;
			if (row < rowsCount - 1) {
				result += TABLE_MIDDLE_START;
				for (int j = 1; j < columnCount; j++) {
					result += createHorizontalLine(maxColumnSize);
					result += TABLE_MIDDLE_CENTER;
				}
				result += createHorizontalLine(maxColumnSize);
				result += TABLE_MIDDLE_END + LINE_SEPERATOR;
			}
		}
		return result;
	}

	private String createHorizontalLine(int value) {
		String result = EMPTY_STRING;
		for (int i = 0; i < value; i++) {
			result += "═";
		}
		return result;
	}

	private String ProcessColumns(int maxColumnSize, int columnCount, List<Object> values) {
		String result = EMPTY_STRING;
		for (int column = 0; column < columnCount; column++) {
			int valuesLength = String.valueOf(values.get(column)).length();
			result += insertSpaceToCell(maxColumnSize, valuesLength);
			result += String.valueOf(values.get(column));
			if (valuesLength % 2 == 0) {
				result += insertSpaceToCell(maxColumnSize, valuesLength);
			} else {
				result += insertSpaceToCell(maxColumnSize, valuesLength - 1);
			}
			result += COLUMN_SEPERATOR;
		}
		return result;
	}

	private String ProcessHeaderColumns(List<String> columnNames, int columnCount, int maxColumnSize) {
		String result = "";
		for (int column = 0; column < columnCount; column++) {
			result += COLUMN_SEPERATOR;
			int columnNamesLength = columnNames.get(column).length();
			result += insertSpaceToCell(maxColumnSize, columnNamesLength);
			result += columnNames.get(column);
			if (columnNamesLength % 2 == 0) {
				result += insertSpaceToCell(maxColumnSize, columnNamesLength);
			} else {
				result += insertSpaceToCell(maxColumnSize, columnNamesLength - 1);
			}
		}
		return result;
	}

	private String insertSpaceToCell(int maxColumnSize, int valuesLength) {
		String result = EMPTY_STRING;
		for (int j = 0; j < (maxColumnSize - valuesLength) / 2; j++) {
			result += " ";
		}
		return result;
	}

	
	private String getHeaderOfTheTable() {
		int maxColumnSize = getMaxColumnSize(dataSetList);
		String result = EMPTY_STRING;

		int columnCount = 0;
		if (!dataSetList.isEmpty()) {
			columnCount =  dataSetList.get(0).getColumnNames().size();
		}
		
		maxColumnSize = calculateMaxColumnSize(maxColumnSize);
		result += TABLE_UPPER_START;
		for (int j = 1; j < columnCount; j++) {
			result += createHorizontalLine(maxColumnSize);
			result += TABLE_UPPER_MIDDLE;
		}
		result += createHorizontalLine(maxColumnSize);
		result += TABLE_UPPER_END + LINE_SEPERATOR;
		List<String> columnNames = dataSetList.get(0).getColumnNames();
		result += ProcessHeaderColumns(columnNames, columnCount, maxColumnSize);
		result += COLUMN_SEPERATOR + LINE_SEPERATOR;
		if (dataSetList.size() > 0) {
			result += TABLE_MIDDLE_START;
			for (int j = 1; j < columnCount; j++) {
				result += createHorizontalLine(maxColumnSize);
				result += TABLE_MIDDLE_CENTER;
			}
			result += createHorizontalLine(maxColumnSize);
			result += TABLE_MIDDLE_END + LINE_SEPERATOR;
		} else {
			result += TABLE_BOTTOM_START;
			for (int j = 1; j < columnCount; j++) {
				result += createHorizontalLine(maxColumnSize);
				result += TABLE_BOTTOM_MIDDLE;
			}
			result += createHorizontalLine(maxColumnSize);
			result += TABLE_BOTTOM_END + LINE_SEPERATOR;
		}
		return result;
	}



	private int getMaxColumnSize(List<DataSet> dataSets) {
		int maxLengthOfColumnNames = 0;
		int maxLengthOfDataSetValues = 0;
		if (!dataSets.isEmpty()) {
			List<String> columnNames = dataSets.get(0).getColumnNames();
			
			for (String columnName : columnNames) {
				if (columnName.length() > maxLengthOfColumnNames) {
					maxLengthOfColumnNames = columnName.length();
				}
			}
			
			for (DataSet dataSet : dataSets) {
				int maxLengthOfValues = getMaxLengthOfDataSet(dataSet.getValues());
				if (maxLengthOfValues > maxLengthOfDataSetValues) {
					maxLengthOfDataSetValues = maxLengthOfValues;
				}
			}
		}
		return Math.max(maxLengthOfColumnNames, maxLengthOfDataSetValues);
	}


	private int getMaxLengthOfDataSet(List<Object> values) {
		int maxLength = 0;
		for (Object value : values) {
			if (String.valueOf(value).length() > maxLength) {
				maxLength = String.valueOf(value).length();
			}
		}
		return maxLength;
	}
	
}

