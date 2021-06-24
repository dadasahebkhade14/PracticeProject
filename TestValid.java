import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestValid {

	public  Date  stringToDateConvert(String str) throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date=dateFormat.parse(str);
		return date;
	}	
	
	public static void main(String[] args) throws ParseException {
		TestValid  testDemo=new TestValid();
		LinkedHashMap<String,Map<String,String>> DB1=new LinkedHashMap<String,Map <String,String>>();
		LinkedHashMap<String, Map<String, String>> DB2=new LinkedHashMap<String,Map <String,String>>();
		LinkedHashMap<String,String> map1=new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> map2=new LinkedHashMap<String,String>();
		ArrayList<ArrayList<String>>  matchingDataFromDB1DB2 =  new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String> > dataExistOnlyInDB1 =  new ArrayList<ArrayList<String> >();
		ArrayList<ArrayList<String>>  dateConditionNotMatchingData =  new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>>  nonMatchingDataFromDB1DB2 =  new ArrayList<ArrayList<String>>();
		ArrayList <ArrayList<String>> dataExistOnlyInDB2=new ArrayList <ArrayList<String>>();
		Map<String,ArrayList<ArrayList<String>>> globalData=new LinkedHashMap<String,ArrayList<ArrayList<String>>>();
		ArrayList <String> nonMatching=new ArrayList<String>();
		
		map1.put("ID", "01");
		map1.put("IssuerID", "IID001");
		map1.put("document_type", "12345");
		map1.put("datalibid", "8888");
		map1.put("seriesid", "2");
		map1.put("value", "100");
		map1.put("updated_at", "8/05/2021");
		DB1.put("IID001", new LinkedHashMap(map1));
	//	System.out.println("DB1 values :"+DB1);
	//	map1.clear();
		map1.put("ID", "02");
		map1.put("IssuerID", "IID002");
		map1.put("document_type", "67890");
		map1.put("datalibid", "9999");
		map1.put("seriesid", "1");
		map1.put("value", "50");
		map1.put("updated_at", "19/05/2021");
		DB1.put("IID002", new LinkedHashMap(map1));
	//	System.out.println("OuterMap 2 values :"+outerMap);
		//map1.clear();
		
		map1.put("ID", "03");
		map1.put("IssuerID", "IID003");
		map1.put("document_type", "10K");
		map1.put("datalibid", "5555");
		map1.put("seriesid", "5");
		map1.put("value", "80");
		map1.put("updated_at", "10/05/2021");
		DB1.put("IID003", new LinkedHashMap(map1));
		
		map1.put("ID", "04");
		map1.put("IssuerID", "IID004");
		map1.put("document_type", "12121");
		map1.put("datalibid", "78787");
		map1.put("seriesid", "22");
		map1.put("value", "200");
		map1.put("updated_at", "10/05/2021");
		DB1.put("IID004", new LinkedHashMap(map1));
		
		map1.put("ID", "05");
		map1.put("IssuerID", "IID005");
		map1.put("document_type", "12121");
		map1.put("datalibid", "78787");
		map1.put("seriesid", "22");
		map1.put("value", "500");
		map1.put("updated_at", "10/05/2021");
		DB1.put("IID005", new LinkedHashMap(map1));
		
		
		map1.put("ID", "06");
		map1.put("IssuerID", "IID006");
		map1.put("document_type", "10K");
		map1.put("datalibid", "2222");
		map1.put("seriesid", "22");
		map1.put("value", "220");
		map1.put("updated_at", "10/06/2021");
		DB1.put("IID006", new LinkedHashMap(map1));
		
		

		map1.put("ID", "07");
		map1.put("IssuerID", "IID007");
		map1.put("document_type", "100K");
		map1.put("datalibid", "3333");
		map1.put("seriesid", "33");
		map1.put("value", "330");
		map1.put("updated_at", "11/06/2021");
		DB1.put("IID007", new LinkedHashMap(map1));
		

		map1.put("ID", "08");
		map1.put("IssuerID", "IID008");
		map1.put("document_type", "100K");
		map1.put("datalibid", "3333");
		map1.put("seriesid", "33");
		map1.put("value", "330");
		map1.put("updated_at", "11/06/2021");
		DB1.put("IID008", new LinkedHashMap(map1));
		
		

		map1.put("ID", "09");
		map1.put("IssuerID", "IID009");
		map1.put("document_type", "1000K");
		map1.put("datalibid", "4444");
		map1.put("seriesid", "44");
		map1.put("value", "440");
		map1.put("updated_at", "12/06/2021");
		DB1.put("IID009", new LinkedHashMap(map1));
		
		
	//	System.out.println("DB1 map values :"+DB1);
		
		map2.put("KeyID", "001");
		map2.put("DMX_IssuerID", "IID001");
		map2.put("document_type", "12345");
		map2.put("datalibid", "8888");
		map2.put("seriesid", "2");
		map2.put("value", "100");
		map2.put("updated_at", "15/05/2021");
	    DB2.put("IID001", new LinkedHashMap(map2));
		
		map2.put("KeyID", "002");
		map2.put("DMX_IssuerID", "IID002");
		map2.put("document_type", "67890");
		map2.put("datalibid", "9999");
		map2.put("seriesid", "1");
		map2.put("value", "50");
		map2.put("updated_at", "15/05/2021");
		DB2.put("IID002", new LinkedHashMap(map2));
		
		map2.put("KeyID", "003");
		map2.put("DMX_IssuerID", "IID003");
		map2.put("document_type", "20K");
		map2.put("datalibid", "6666");
		map2.put("seriesid", "6");
		map2.put("value", "100");
		map2.put("updated_at", "20/05/2021");
		DB2.put("IID003", new LinkedHashMap(map2));
		
		map2.put("KeyID", "004");
		map2.put("DMX_IssuerID", "IID004");
		map2.put("document_type", "12121");
		map2.put("datalibid", "78787");
		map2.put("seriesid", "22");
		map2.put("value", "200");
		map2.put("updated_at", "20/05/2021");
		DB2.put("IID004", new LinkedHashMap(map2));
		
		
		map2.put("KeyID", "005");
		map2.put("DMX_IssuerID", "IID005");
		map2.put("document_type", "12121");
		map2.put("datalibid", "78787");
		map2.put("seriesid", "22");
		map2.put("value", "400");
		map2.put("updated_at", "20/05/2021");
		DB2.put("IID005", new LinkedHashMap(map2));
		
		
		map2.put("KeyID", "006");
		map2.put("DMX_IssuerID", "IID006");
		map2.put("document_type", "10K");
		map2.put("datalibid", "2222");
		map2.put("seriesid", "22");
		map2.put("value", "220");
		map2.put("updated_at", "15/06/2021");
		DB2.put("IID006", new LinkedHashMap(map2));
		
		

		map2.put("KeyID", "007");
		map2.put("DMX_IssuerID", "IID007");
		map2.put("document_type", "100K");
		map2.put("datalibid", "3333");
		map2.put("seriesid", "33");
		map2.put("value", "430");
		map2.put("updated_at", "18/06/2021");
		DB2.put("IID007", new LinkedHashMap(map2));
		

		map2.put("KeyID", "008");
		map2.put("DMX_IssuerID", "IID008");
		map2.put("document_type", "100K");
		map2.put("datalibid", "3333");
		map2.put("seriesid", "33");
		map2.put("value", "330");
		map2.put("updated_at", "06/06/2021");
		DB2.put("IID008", new LinkedHashMap(map2));
		
		

		map2.put("KeyID", "009");
		map2.put("DMX_IssuerID", "IID009");
		map2.put("document_type", "1000K");
		map2.put("datalibid", "5555");
		map2.put("seriesid", "55");
		map2.put("value", "555");
		map2.put("updated_at", "12/06/2021");
		DB2.put("IID009", new LinkedHashMap(map2));
		

		
		
		
		//System.out.println("DB2 map values :"+DB2);
		
		Map<Integer,Map<String,String>> inputTestDataMap=new LinkedHashMap<Integer,Map<String,String>>();
		Map<String,String> testData=new LinkedHashMap<String,String>();
		testData.put("DB1_columns_Excludes_in_comparision", "ID,ABC");
		testData.put("DB2_columns_Excludes_in_comparision", "KeyID,PQR");
		testData.put("DB1_columns_Inluded_in_comparison", "IssuerID,document_type,datalibid,seriesid");
		testData.put("DB2_columns_Inluded_in_comparison", "DMX_IssuerID,document_type,datalibid,seriesid");
		testData.put("condition1_date_column", "yes, DB1.updated_at ,<, DB2.updated_at");
		testData.put("condition2_numeric_column", "No");
		testData.put("condition3_string_column", "yes,DB1.value,=,DB2.value");
		
		inputTestDataMap.put(001, testData);
		
		
		for ( Map.Entry<Integer,Map<String,String>> mapEntry :inputTestDataMap.entrySet()) {
			Integer Outerkey=mapEntry.getKey();
			Map <String,String > innerEntry =mapEntry.getValue();
			String strDB1ExcludedColumns=innerEntry.get("DB1_columns_Excludes_in_comparision");
			String strDB2ExcludedColumns=innerEntry.get("DB2_columns_Excludes_in_comparision");
			String strCondition1=innerEntry.get("condition1_date_column");
			String strCondition2=innerEntry.get("condition2_numeric_column");
			String strCondition3=innerEntry.get("condition3_string_column");
			
			String[] condition1Array=strCondition1.split(",");
			String condition1= condition1Array[0];
			
			String[] condition2Array=strCondition2.split(",");
			String condition2= condition2Array[0];
			
			String[] condition3Array=strCondition3.split(",");
			String condition3= condition3Array[0];
			
			 ArrayList <String> DB1ExcludeColumn=new ArrayList<String>();
			 ArrayList <String> DB2ExcludeColumn=new ArrayList<String>();
			 ArrayList <String> DB1comparisionCondtion1=new ArrayList<String>();
			 ArrayList <String> DB2ComparisionCondtion1=new ArrayList<String>();
			 ArrayList <String> DB1ComparisionCondtion2=new ArrayList<String>();
			 ArrayList <String> DB2ComparisionCondtion2=new ArrayList<String>();
			 
			if (condition1.equalsIgnoreCase("Yes") && condition2.equalsIgnoreCase("No") && condition3.equalsIgnoreCase("Yes") ) {
				System.out.println("Inside Yes,No ,Yes condition");
				
			 String[] DB1ExcludeArray=strDB1ExcludedColumns.split(",");
			// ArrayList <String> DB1ExcludeColumn=new ArrayList<String>();
			 for (int j=0;j <DB1ExcludeArray.length;j++) {
				 DB1ExcludeColumn.add(DB1ExcludeArray[j]);
			 }
			 
			 System.out.println("DB1ExcludeColumn is :"+ DB1ExcludeColumn);
			 
			 String[] DB2ExcludeArray=strDB2ExcludedColumns.split(",");
			// ArrayList <String> DB2ExcludeColumn=new ArrayList<String>();
			 for (int j=0;j <DB2ExcludeArray.length;j++) {
				 DB2ExcludeColumn.add(DB2ExcludeArray[j]);
			 }
			 
			 System.out.println("DB2ExcludeColumn is :"+ DB2ExcludeColumn);
			 
		//	String[] strCondition1Array=strCondition1.split(",");
		//	String condition1= strCondition1Array[0];
			
			String strArray1=condition1Array[1].trim();
			String [] strDB1Condition1=strArray1.split("\\.");
			String strCondition1DB1=strDB1Condition1[1];
			
			//ArrayList <String> DB1comparisionCondtion1=new ArrayList<String>();
			DB1comparisionCondtion1.add(strCondition1DB1);
			System.out.println("DB1comparisionCondtion1 is :"+DB1comparisionCondtion1);
			
			String strArray2=condition1Array[3].trim();
			String [] strDB2Condition1= strArray2.split("\\.");
			String strCondition1DB2=strDB2Condition1[1];
			
			//ArrayList <String> DB2ComparisionCondtion1=new ArrayList<String>();
			DB2ComparisionCondtion1.add(strCondition1DB2);
			System.out.println("DB2ComparisionCondtion1 is :"+DB2ComparisionCondtion1);
			
			
			
			String strArray3=condition3Array[1].trim();
			String [] DB2Condition1=strArray3.split("\\.");
			String strCondition2DB1=DB2Condition1[1];
			
			//ArrayList <String> DB1ComparisionCondtion2=new ArrayList<String>();
			DB1ComparisionCondtion2.add(strCondition2DB1);
			
			System.out.println("DB1ComparisionCondtion2 is :"+DB1ComparisionCondtion2);
			
			String strArray4=condition3Array[3].trim();
			String [] strDB2Condition2= strArray4.split("\\.");
			String strCondition2DB2=strDB2Condition2[1];
			
			//ArrayList <String> DB2ComparisionCondtion2=new ArrayList<String>();
			DB2ComparisionCondtion2.add(strCondition2DB2);
			
			System.out.println("DB2ComparisionCondtion2 is :"+DB2ComparisionCondtion2);
			
			
				
		  	
		
		
		
		int matchCounter=0;
		int nonMatchCounter=0;
		int dateNonMatchCounter=0;
		int valueNonMatchCounter=0;
		int nonMatchCounterDB2=0;
		//ArrayList <String> DB1tbl1ExcludeColumn=new ArrayList<String>();
		//DB1tbl1ExcludeColumn.add("updated_at");
		//DB1tbl1ExcludeColumn.add("ID");
		
		//ArrayList <String> DB1tbl1comparisionCondtion1=new ArrayList<String>();
		//DB1tbl1comparisionCondtion1.add("updated_at");
		
		//ArrayList <String> DB1tbl1comparisionCondtion2=new ArrayList<String>();
		//DB1tbl1comparisionCondtion2.add("value");
		
		//String strCondition1="yes, DB1.updated,<, DB2.updated";
		//String [] dateCondition=strCondition1.split(",");
		
			
		
		//ArrayList <String> DB2tbl2ExcludeColumn=new ArrayList<String>();
		//DB2tbl2ExcludeColumn.add("updated_at");
		//DB2tbl2ExcludeColumn.add("KeyID");
		
		//ArrayList <String> DB2tbl2comparisionCondtion1=new ArrayList<String>();
		//DB2tbl2comparisionCondtion1.add("updated_at");
		
		//ArrayList <String> DB2tbl2comparisionCondtion2=new ArrayList<String>();
		//DB2tbl2comparisionCondtion2.add("value");
		
		//DB1--Prod db
		//DB2 --OT db
		
		
		
		for (Map.Entry<String,Map<String,String>> mapDB1:DB1.entrySet()){
			boolean nonMatchDataFlag=false;
			String DB1MapKey=mapDB1.getKey();
			String outerUpdate_at=null;
			ArrayList<String> listDB1Map=new ArrayList<String>();
			ArrayList <String> exclude=new ArrayList<String>();
			ArrayList <String> condition1DB1=new ArrayList<String>();
			ArrayList <String> condition2DB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListDB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListCondition1DB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListCondition2DB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListDB2=new ArrayList<String>(); 
			ArrayList<String> excelHeadingArrayListCondition1DB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListCondition2DB2=new ArrayList<String>();
			Map<String,String> DB1MapValues=mapDB1.getValue();
			for (String str:DB1MapValues.keySet()) {
				// Read DB1tbl1Condition1 condition from excel and put into ArrayList to handle it dyanamic.
				if ((DB1ExcludeColumn.contains(str))) {
					exclude.add(DB1MapValues.get(str));
					}
					//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
				else if ((DB1comparisionCondtion1.contains(str))) {
					condition1DB1.add(DB1MapValues.get(str));
					excelHeadingArrayListCondition1DB1.add(str);
						
					}
				else if ((DB1ComparisionCondtion2.contains(str))) {
					condition2DB1.add(DB1MapValues.get(str));
					excelHeadingArrayListCondition2DB1.add(str);
						
					}
				else {
					excelHeadingArrayListDB1.add(str);
					listDB1Map.add(DB1MapValues.get(str));
				}
			}
			
			ArrayList <String> condition1DB2=new ArrayList<String>();
			ArrayList <String> condition2DB2=new ArrayList<String>();
			ArrayList<String> listDB2Map=new ArrayList<String>();	
		
		for (Map.Entry<String,Map<String,String>> mapDB2:DB2.entrySet()) {
				String DB2MapKey=mapDB2.getKey();
				ArrayList <String> excludeInner=new ArrayList<String>();
				Map<String,String> DB2MapValues=mapDB2.getValue();
				for (String str:DB2MapValues.keySet()) {
					// take below if condition from excel as it is i.e.!(str.equalsIgnoreCase("updated_at"))
					if ((DB2ExcludeColumn.contains(str))) {
						excludeInner.add(DB2MapValues.get(str));
						}
						//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
					else if ((DB2ComparisionCondtion1.contains(str))) {
						condition1DB2.add(DB2MapValues.get(str));
						excelHeadingArrayListCondition1DB2.add(str);
						}
					else if ((DB2ComparisionCondtion2.contains(str))) {
						condition2DB2.add(DB2MapValues.get(str));
						excelHeadingArrayListCondition2DB2.add(str);
						}
					else {
						excelHeadingArrayListDB2.add(str);
						listDB2Map.add(DB2MapValues.get(str));
					}
					
				}					
					
		// First comparison based on common columns from both tables 
				
if (listDB1Map.equals(listDB2Map)) {
			nonMatchDataFlag=true;
			Date dateDB1=null;
			Date dateDB2=null;
			String strDateDB1=null;
			String strDateDB2=null;
			boolean dateFlag=false;
			// Second comparison based on date column 
			if (condition1Array[0].equalsIgnoreCase("Yes")) {
				strDateDB1=condition1DB1.get(0);
				strDateDB2= condition1DB2.get(0);
				dateDB1=testDemo.stringToDateConvert(strDateDB1);
				dateDB2=testDemo.stringToDateConvert(strDateDB2);
					if (condition1Array[2].equalsIgnoreCase(">")) {
					dateFlag=dateDB1.after(dateDB2);
					}
					else if (condition1Array[2].equalsIgnoreCase("<")) {
						dateFlag=dateDB1.before(dateDB2);
						}
					else if (condition1Array[2].equalsIgnoreCase("=")) {
						dateFlag=dateDB1.equals(dateDB2);
						}
		//if date condition becomes true ,then it checks for third condition		
		if (dateFlag==true) {  
			//Third comparison based value column			
					if (condition2DB1.equals(condition2DB2)) {
								  ArrayList<String> matching= new ArrayList<String>();
								  if (matchCounter==0) {
										//Heading for matching value
										ArrayList<String> matchData= new ArrayList<String>();
										for (int j=0;j <excelHeadingArrayListDB1.size();j++) {
											matchData.add("DB1_"+excelHeadingArrayListDB1.get(j));
											}
										for (int j =0;j< excelHeadingArrayListCondition1DB1.size();j++) {
												matchData.add("DB1_"+excelHeadingArrayListCondition1DB1.get(j));
												matchData.add("DB2_"+excelHeadingArrayListCondition1DB2.get(j));
										}
										
										for (int j =0;j< excelHeadingArrayListCondition2DB1.size();j++) {
											matchData.add("DB1_"+excelHeadingArrayListCondition2DB1.get(j));
											matchData.add("DB2_"+excelHeadingArrayListCondition2DB2.get(j));
										}
										matchingDataFromDB1DB2.add(matchData);
										matchCounter++;
									}
		
										//matching columns other than value
									for(int j=0;j<listDB1Map.size();j++) {
										matching.add(listDB1Map.get(j));
									}
									//matching condition value column
									for (int j=0;j<condition1DB1.size();j++) {
										matching.add(condition1DB1.get(j));
										matching.add(condition1DB2.get(j));
									}
									
									for (int j=0;j<condition2DB1.size();j++) {
										matching.add(condition2DB1.get(j));
										matching.add(condition2DB2.get(j));
									}
									
									matchingDataFromDB1DB2.add(matching);
									System.out.println("Matching data from both DB in ArrayList format:"+matchingDataFromDB1DB2);
									break;
								}
								
					else {
								ArrayList<String> valueNotMatchingData= new ArrayList<String>();
								  if (valueNonMatchCounter==0) {
									  ArrayList<String> valueNotMatchingDataHeading= new ArrayList<String>();
										for (int j=0;j <excelHeadingArrayListDB1.size();j++) {
											valueNotMatchingDataHeading.add("DB1_"+excelHeadingArrayListDB1.get(j));
											}
										for (int j =0;j< excelHeadingArrayListCondition1DB1.size();j++) {
											valueNotMatchingDataHeading.add("DB1_"+excelHeadingArrayListCondition1DB1.get(j));
											valueNotMatchingDataHeading.add("DB2_"+excelHeadingArrayListCondition1DB2.get(j));
										}
										
										for (int j =0;j< excelHeadingArrayListCondition2DB1.size();j++) {
											valueNotMatchingDataHeading.add("DB1_"+excelHeadingArrayListCondition2DB1.get(j));
											valueNotMatchingDataHeading.add("DB2_"+excelHeadingArrayListCondition2DB2.get(j));
										}
										nonMatchingDataFromDB1DB2.add(valueNotMatchingDataHeading);
										valueNonMatchCounter++;
									}
		
										//matching columns other than value
									for(int j=0;j<listDB1Map.size();j++) {
										valueNotMatchingData.add(listDB1Map.get(j));
									}
									//matching condition value column
									for (int j=0;j<condition1DB1.size();j++) {
										valueNotMatchingData.add(condition1DB1.get(j));
										valueNotMatchingData.add(condition1DB2.get(j));
									}
									
									for (int j=0;j<condition2DB1.size();j++) {
										valueNotMatchingData.add(condition2DB1.get(j));
										valueNotMatchingData.add(condition2DB2.get(j));
									}
									
									nonMatchingDataFromDB1DB2.add(valueNotMatchingData);
									System.out.println("non matching data is:"+nonMatchingDataFromDB1DB2);
									break;
								  }
					}
		
	else {
				ArrayList<String> dateNonMatchingData= new ArrayList<String>();
				 if (dateNonMatchCounter==0) {	
					 ArrayList<String> datenonMatchingDataHeading= new ArrayList<String>();
					for (int j=0;j <excelHeadingArrayListDB1.size();j++) {
						datenonMatchingDataHeading.add("DB1_"+excelHeadingArrayListDB1.get(j));
						datenonMatchingDataHeading.add("DB2_"+excelHeadingArrayListDB2.get(j));
						}
					for (int j =0;j< excelHeadingArrayListCondition1DB1.size();j++) {
						datenonMatchingDataHeading.add("DB1_"+"date1");
						datenonMatchingDataHeading.add("DB2_"+ "date2");
					}
					
					dateConditionNotMatchingData.add(datenonMatchingDataHeading);
					dateNonMatchCounter++;
				 }

					//matching columns other than value
				for(int j=0;j<listDB1Map.size();j++) {
					dateNonMatchingData.add(listDB1Map.get(j));
					dateNonMatchingData.add(listDB2Map.get(j));
				}
				//matching condition value column
				for (int j=0;j<condition1DB1.size();j++) {
					dateNonMatchingData.add(strDateDB1);
					dateNonMatchingData.add(strDateDB2);
				}
				dateConditionNotMatchingData.add(dateNonMatchingData);
				System.out.println("date condition not matching data :"+dateConditionNotMatchingData);
				break;
				}
			}
		}

listDB2Map.clear();
condition1DB2.clear();
condition2DB2.clear();
	
}

if (nonMatchDataFlag==false) {
				
				ArrayList <String> nonMatchData=new ArrayList<String>();
				ArrayList <String> noMatchDataValueDB1=new ArrayList<String>();
						if (nonMatchCounter==0) {
							//Heading for non matching values
							for (int j=0;j <excelHeadingArrayListDB1.size();j++) {
								nonMatchData.add("DB1_"+excelHeadingArrayListDB1.get(j));
								}
							for (int j =0;j< excelHeadingArrayListCondition1DB1.size();j++) {
								nonMatchData.add("DB1_"+excelHeadingArrayListCondition1DB1.get(j));
							}
						for (int j =0;j< excelHeadingArrayListCondition2DB1.size();j++) {
							nonMatchData.add("DB1_"+excelHeadingArrayListCondition2DB1.get(j));
						}
						dataExistOnlyInDB1.add(nonMatchData);
						nonMatchCounter++;
						}
						
						for (int j=0;j <listDB1Map.size();j++) {
							noMatchDataValueDB1.add(listDB1Map.get(j));
						}
						
						for (int j=0;j<condition1DB1.size();j++) {
							noMatchDataValueDB1.add(condition1DB1.get(j));
							noMatchDataValueDB1.add(condition2DB1.get(j));
						}
						dataExistOnlyInDB1.add(noMatchDataValueDB1);
						System.out.println("data exist only in DB1:"+dataExistOnlyInDB1);
						//break;
				}
			listDB2Map.clear();
			condition1DB2.clear();
			condition2DB2.clear();
			
			listDB1Map.clear();
			condition1DB1.clear();
			condition2DB1.clear();
	}
		
		// To check records which exist only in DB2
		
		for (Map.Entry<String,Map<String,String>> mapDB2:DB2.entrySet()) {
			ArrayList <String> excludeDB2=new ArrayList<String>();
			ArrayList <String> condition1DB2=new ArrayList<String>();
			ArrayList <String> condition2DB2=new ArrayList<String>();
			ArrayList<String> listDB2Map=new ArrayList<String>();	
			ArrayList<String> excelHeadingArrayListCondition1DB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListCondition2DB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListDB2=new ArrayList<String>(); 
		
			String DB2MapKey=mapDB2.getKey();
			Map<String,String> DB2MapValues=mapDB2.getValue();
			for (String str:DB2MapValues.keySet()) {
				// take below if condition from excel as it is i.e.!(str.equalsIgnoreCase("updated_at"))
				if ((DB2ExcludeColumn.contains(str))) {
					excludeDB2.add(DB2MapValues.get(str));
					}
					//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
				else if ((DB2ComparisionCondtion1.contains(str))) {
					condition1DB2.add(DB2MapValues.get(str));
					excelHeadingArrayListCondition1DB2.add(str);
					}
				else if ((DB2ComparisionCondtion2.contains(str))) {
					condition2DB2.add(DB2MapValues.get(str));
					excelHeadingArrayListCondition2DB2.add(str);
					}
				else {
					excelHeadingArrayListDB2.add(str);
					listDB2Map.add(DB2MapValues.get(str));
					}
				}					
				
		ArrayList<String> listDB1Map=new ArrayList<String>();	
		ArrayList <String> condition1DB1=new ArrayList<String>();
		ArrayList <String> condition2DB1=new ArrayList<String>();
		boolean noDataExist=false;
		for (Map.Entry<String,Map<String,String>> mapDB1:DB1.entrySet()){
			String DB1MapKey=mapDB1.getKey();
			ArrayList <String> excludeDB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListDB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListCondition1DB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListCondition2DB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInner1DB2=new ArrayList<String>(); 
			Map<String,String> DB1MapValues=mapDB1.getValue();
			for (String str:DB1MapValues.keySet()) {
				// Read DB1tbl1Condition1 condition from excel and put into ArrayList to handle it dyanamic.
				if ((DB1ExcludeColumn.contains(str))) {
					excludeDB1.add(DB1MapValues.get(str));
					}
					//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
				else if ((DB1comparisionCondtion1.contains(str))) {
					condition1DB1.add(DB1MapValues.get(str));
					excelHeadingArrayListCondition1DB1.add(str);
						
					}
				else if ((DB1ComparisionCondtion2.contains(str))) {
					condition2DB1.add(DB1MapValues.get(str));
					excelHeadingArrayListCondition2DB1.add(str);
						
					}
				else {
					excelHeadingArrayListDB1.add(str);
					listDB1Map.add(DB1MapValues.get(str));
				}
			}
			
			if (listDB2Map.equals(listDB1Map)) {
				noDataExist=true;
				break;
			}
			
		listDB1Map.clear();
		condition1DB1.clear();
		condition2DB1.clear();
}
		
 	if (noDataExist==false) {
 			ArrayList <String> noMatchDataDB2=new ArrayList<String>();
 			ArrayList <String> noMatchDataValueDB2=new ArrayList<String>();
			if (nonMatchCounterDB2==0) {
				
				for (int j=0;j <excelHeadingArrayListDB2.size();j++) {
					noMatchDataDB2.add("DB2_"+excelHeadingArrayListDB2.get(j));
					}
				for (int j =0;j< excelHeadingArrayListCondition1DB2.size();j++) {
					noMatchDataDB2.add("DB2_"+excelHeadingArrayListCondition1DB2.get(j));
					}
			
				for (int j =0;j< excelHeadingArrayListCondition2DB2.size();j++) {
					noMatchDataDB2.add("DB2_"+excelHeadingArrayListCondition2DB2.get(j));
					}
				dataExistOnlyInDB2.add(noMatchDataDB2);
				nonMatchCounterDB2++;
				}
			
			for (int j=0;j <listDB2Map.size();j++) {
				noMatchDataValueDB2.add(listDB2Map.get(j));
				}
			
			for (int j=0;j<condition1DB2.size();j++) {
				noMatchDataValueDB2.add(condition1DB2.get(j));
				}
			
			for (int j=0;j<condition2DB2.size();j++) {
				noMatchDataValueDB2.add(condition2DB2.get(j));
				}
			dataExistOnlyInDB2.add(noMatchDataValueDB2);
			System.out.println("data exist only in DB2:"+dataExistOnlyInDB2);
			//break;
			}
 	
 		listDB1Map.clear();
 		condition1DB1.clear();
 		condition2DB1.clear();
 		
 		listDB2Map.clear();
 		condition1DB2.clear();
 		condition2DB2.clear();
	}
	
		globalData.put("MatchingDataFromDB1DB2", matchingDataFromDB1DB2);
		globalData.put("NonMatchingDataFromDB1DB2", nonMatchingDataFromDB1DB2);
		globalData.put("DateConditionNonMatchData", dateConditionNotMatchingData);
		globalData.put("DataExistonlyInDB1", dataExistOnlyInDB1);
		globalData.put("DataExistonlyInDB2", dataExistOnlyInDB2);
		System.out.println("global map to print is :"+globalData);
		
			}
		}
	} 
}
