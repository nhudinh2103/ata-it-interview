package com.ata.interview.constants;


import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 
 * @author dinhnn
 *
 */
public final class Constants {
	
	private Constants() {}

	public static final String SALARY_SURVEY_FILE_NAME_JSON = "salary_survey-3.json";
	
	public static final String FIELD_SEPARATOR = ",";
	
	public static final String SORT_ITEM_SEPARATOR = "@@";
	
	public static final String SORT_ITEM_WITH_DIRECTION_SEPARATOR = ",";
	
	public static final DateTimeFormatter FMT_MMDDYYYY_PATTERN = DateTimeFormat.forPattern("MM/dd/YYYY HH:mm:ss");
}
