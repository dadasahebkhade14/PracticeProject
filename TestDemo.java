import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.DateFormatter;

public class TestDemo {

	public  Date  stringToDateConvert(String str) throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		Date date=dateFormat.parse(str);
		return date;
		
		
	}
	
	public static void main(String[] args) throws ParseException {
		
		TestDemo  testDemo=new TestDemo();
		LinkedHashMap<String,Map<String,String>> outerMap=new LinkedHashMap<String,Map <String,String>>();
		LinkedHashMap<String, Map<String, String>> innerMap=new LinkedHashMap<String,Map <String,String>>();
		LinkedHashMap<String,String> map1=new LinkedHashMap<String,String>();
		LinkedHashMap<String,String> map2=new LinkedHashMap<String,String>();
		ArrayList<ArrayList<String>>  matchingRecordsArrayList =  new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String> > nonMatchDataArrayListDB2 =  new ArrayList<ArrayList<String> >();
		ArrayList<ArrayList<String>>  dateNonMatchingArrayList =  new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>>  valueNonMatchingArrayList =  new ArrayList<ArrayList<String>>();
		ArrayList <ArrayList<String>> noMatchDataArrayListDB1=new ArrayList <ArrayList<String>>();
		Map<String,ArrayList<ArrayList<String>>> globalData=new HashMap<String,ArrayList<ArrayList<String>>>();
	
		//LinkedHashMap<String,Map<String,String>> nonMatch=new LinkedHashMap<String,Map <String,String>>();
		ArrayList <String> nonMatching=new ArrayList<String>();
		
		
		
		
		map1.put("ID", "01");
		map1.put("IssuerID", "IID001");
		map1.put("document_type", "12345");
		map1.put("datalibid", "8888");
		map1.put("seriesid", "2");
		map1.put("value", "100");
		map1.put("updated_at", "8/05/2021");
		outerMap.put("IID001", new LinkedHashMap(map1));
	//	System.out.println("OuterMap 1 values :"+outerMap);
	//	map1.clear();
		map1.put("ID", "02");
		map1.put("IssuerID", "IID002");
		map1.put("document_type", "67890");
		map1.put("datalibid", "9999");
		map1.put("seriesid", "1");
		map1.put("value", "50");
		map1.put("updated_at", "19/05/2021");
		outerMap.put("IID002", new LinkedHashMap(map1));
	//	System.out.println("OuterMap 2 values :"+outerMap);
		//map1.clear();
		
		map1.put("ID", "03");
		map1.put("IssuerID", "IID003");
		map1.put("document_type", "10K");
		map1.put("datalibid", "5555");
		map1.put("seriesid", "5");
		map1.put("value", "80");
		map1.put("updated_at", "10/05/2021");
		outerMap.put("IID003", new LinkedHashMap(map1));
		
		map1.put("ID", "04");
		map1.put("IssuerID", "IID004");
		map1.put("document_type", "12121");
		map1.put("datalibid", "78787");
		map1.put("seriesid", "22");
		map1.put("value", "200");
		map1.put("updated_at", "10/05/2021");
		outerMap.put("IID004", new LinkedHashMap(map1));
		
		map1.put("ID", "05");
		map1.put("IssuerID", "IID005");
		map1.put("document_type", "12121");
		map1.put("datalibid", "78787");
		map1.put("seriesid", "22");
		map1.put("value", "500");
		map1.put("updated_at", "10/05/2021");
		outerMap.put("IID005", new LinkedHashMap(map1));
		
		
		
		System.out.println("OuterMap 2 values :"+outerMap);
		
		map2.put("KeyID", "001");
		map2.put("DMX_IssuerID", "IID001");
		map2.put("document_type", "12345");
		map2.put("datalibid", "8888");
		map2.put("seriesid", "2");
		map2.put("value", "100");
		map2.put("updated_at", "15/05/2021");
	    innerMap.put("IID001", new LinkedHashMap(map2));
		
		map2.put("KeyID", "002");
		map2.put("DMX_IssuerID", "IID002");
		map2.put("document_type", "67890");
		map2.put("datalibid", "9999");
		map2.put("seriesid", "1");
		map2.put("value", "50");
		map2.put("updated_at", "15/05/2021");
		innerMap.put("IID002", new LinkedHashMap(map2));
		
		map2.put("KeyID", "003");
		map2.put("DMX_IssuerID", "IID003");
		map2.put("document_type", "20K");
		map2.put("datalibid", "6666");
		map2.put("seriesid", "6");
		map2.put("value", "100");
		map2.put("updated_at", "20/05/2021");
		innerMap.put("IID003", new LinkedHashMap(map2));
		
		map2.put("KeyID", "04");
		map2.put("DMX_IssuerID", "IID004");
		map2.put("document_type", "12121");
		map2.put("datalibid", "78787");
		map2.put("seriesid", "22");
		map2.put("value", "200");
		map2.put("updated_at", "20/05/2021");
		innerMap.put("IID004", new LinkedHashMap(map2));
		
		
		map2.put("KeyID", "05");
		map2.put("DMX_IssuerID", "IID005");
		map2.put("document_type", "12121");
		map2.put("datalibid", "78787");
		map2.put("seriesid", "22");
		map2.put("value", "400");
		map2.put("updated_at", "20/05/2021");
		innerMap.put("IID005", new LinkedHashMap(map2));
		
		
		System.out.println("innermap 2 values :"+innerMap);
		int matchCounter=0;
		int nonMatchCounter=0;
		int dateNonMatchCounter=0;
		int valueNonMatchCounter=0;
		int nonMatchCounterDB1=0;
		ArrayList <String> DB1tbl1ExcludeColumn=new ArrayList<String>();
		//DB1tbl1ExcludeColumn.add("updated_at");
		DB1tbl1ExcludeColumn.add("ID");
		
		ArrayList <String> DB1tbl1comparisionCondtion1=new ArrayList<String>();
		DB1tbl1comparisionCondtion1.add("updated_at");
		
		ArrayList <String> DB1tbl1comparisionCondtion2=new ArrayList<String>();
		DB1tbl1comparisionCondtion2.add("value");
		
		String strCondition1="yes, DB1.updated,<, DB2.updated";
		String [] dateCondition=strCondition1.split(",");
		
		for (int j=0;j <dateCondition.length;j++) {
			System.out.println("arrya element is :"+dateCondition[j]);
		}
		
		
		
		ArrayList <String> DB2tbl2ExcludeColumn=new ArrayList<String>();
		//DB2tbl2ExcludeColumn.add("updated_at");
		DB2tbl2ExcludeColumn.add("KeyID");
		
		ArrayList <String> DB2tbl2comparisionCondtion1=new ArrayList<String>();
		DB2tbl2comparisionCondtion1.add("updated_at");
		
		ArrayList <String> DB2tbl2comparisionCondtion2=new ArrayList<String>();
		DB2tbl2comparisionCondtion2.add("value");
		
		
		
		for (Map.Entry<String,Map<String,String>> mapOuter:outerMap.entrySet()){
			boolean nonMatchDataFlag=false;
			String outerMapKey=mapOuter.getKey();
			String outerUpdate_at=null;
			ArrayList<String> listOuterMap=new ArrayList<String>();
			ArrayList <String> exclude=new ArrayList<String>();
			ArrayList <String> condition1=new ArrayList<String>();
			ArrayList <String> condition2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListOuter=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListOuterCondition1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListOuterCondition2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInner=new ArrayList<String>(); 
			ArrayList<String> excelHeadingArrayListInnerCondition1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInnerCondition2=new ArrayList<String>();
			Map<String,String> outerMapValues=mapOuter.getValue();
			for (String str:outerMapValues.keySet()) {
				// Read DB1tbl1Condition1 condition from excel and put into ArrayList to handle it dyanamic.
				if ((DB1tbl1ExcludeColumn.contains(str))) {
					exclude.add(outerMapValues.get(str));
					//excelHeadingArrayListOuter.add(str);
					//listOuterMap.add(outerMapValues.get(str));
					}
					//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
				else if ((DB1tbl1comparisionCondtion1.contains(str))) {
						condition1.add(outerMapValues.get(str));
						excelHeadingArrayListOuterCondition1.add(str);
						
					}
				else if ((DB1tbl1comparisionCondtion2.contains(str))) {
						condition2.add(outerMapValues.get(str));
						excelHeadingArrayListOuterCondition2.add(str);
						
					}
				else {
					excelHeadingArrayListOuter.add(str);
					listOuterMap.add(outerMapValues.get(str));
				}
			}
			ArrayList <String> condition1_Inner=new ArrayList<String>();
			ArrayList <String> condition2_Inner=new ArrayList<String>();
			ArrayList<String> listInnerMap=new ArrayList<String>();	
		
		for (Map.Entry<String,Map<String,String>> mapInner:innerMap.entrySet()) {
				String innerMapKey=mapInner.getKey();
				String innerUpdated_At=null;
				ArrayList <String> excludeInner=new ArrayList<String>();
				ArrayList <String> compareValueInnerr=new ArrayList<String>();
				Map<String,String> InnermapValues=mapInner.getValue();
				for (String str:InnermapValues.keySet()) {
					// take below if condition from excel as it is i.e.!(str.equalsIgnoreCase("updated_at"))
					if ((DB2tbl2ExcludeColumn.contains(str))) {
						excludeInner.add(InnermapValues.get(str));
						//excelHeadingArrayListInner.add(str);
						//listInnerMap.add(InnermapValues.get(str));
						}
						//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
					else if ((DB2tbl2comparisionCondtion1.contains(str))) {
							condition1_Inner.add(InnermapValues.get(str));
							excelHeadingArrayListInnerCondition1.add(str);
						}
					else if ((DB2tbl2comparisionCondtion2.contains(str))) {
							condition2_Inner.add(InnermapValues.get(str));
							excelHeadingArrayListInnerCondition2.add(str);
						}
					else {
						excelHeadingArrayListInner.add(str);
						listInnerMap.add(InnermapValues.get(str));
					}
					
				}					
					
		// First,comparison based on common columns from both tables 
				
if (listOuterMap.equals(listInnerMap)) {
			nonMatchDataFlag=true;
			Date dateDB1=null;
			Date dateDB2=null;
			String strDateOuter=null;
			String strDate1Inner=null;
			boolean dateFlag=false;
			// Second ,comparison based on date column 
			if (dateCondition[0].equalsIgnoreCase("Yes")) {
				strDateOuter=condition1.get(0);
				strDate1Inner= condition1_Inner.get(0);
				dateDB1=testDemo.stringToDateConvert(strDateOuter);
				dateDB2=testDemo.stringToDateConvert(strDate1Inner);
					if (dateCondition[2].equalsIgnoreCase(">")) {
					dateFlag=dateDB1.after(dateDB2);
					}
					else if (dateCondition[2].equalsIgnoreCase("<")) {
						dateFlag=dateDB1.before(dateDB2);
						}
					else if (dateCondition[2].equalsIgnoreCase("=")) {
						dateFlag=dateDB1.equals(dateDB2);
						}
				
		if (dateFlag==true) {  
						
			if (condition2.equals(condition2_Inner)) {
						  ArrayList<String> matching= new ArrayList<String>();
						  if (matchCounter==0) {
								//Heading for matching value
								ArrayList<String> matchData= new ArrayList<String>();
								for (int j=0;j <excelHeadingArrayListOuter.size();j++) {
									matchData.add("DB1_"+excelHeadingArrayListOuter.get(j));
									}
								for (int j =0;j< excelHeadingArrayListOuterCondition1.size();j++) {
										matchData.add("DB1_"+excelHeadingArrayListOuterCondition1.get(j));
										matchData.add("DB2_"+excelHeadingArrayListInnerCondition1.get(j));
								}
								
								for (int j =0;j< excelHeadingArrayListOuterCondition2.size();j++) {
									matchData.add("DB1_"+excelHeadingArrayListOuterCondition2.get(j));
									matchData.add("DB2_"+excelHeadingArrayListInnerCondition2.get(j));
								}
								matchingRecordsArrayList.add(matchData);
								matchCounter++;
							}

								//matching columns other than value
							for(int j=0;j<listOuterMap.size();j++) {
								matching.add(listOuterMap.get(j));
							}
							//matching condition value column
							for (int j=0;j<condition1.size();j++) {
								matching.add(condition1.get(j));
								matching.add(condition1_Inner.get(j));
							}
							
							for (int j=0;j<condition2.size();j++) {
								matching.add(condition2.get(j));
								matching.add(condition2_Inner.get(j));
							}
							
													
							matchingRecordsArrayList.add(matching);
							//Map<String,ArrayList<ArrayList<String>>> matchingRecords=new HashMap<String,ArrayList<ArrayList<String>>>();
							//matchingRecords.put("MatchingData", matchingRecordsArrayList);
							System.out.println("Matching data from both DB in ArrayList format:"+matchingRecordsArrayList);
							//System.out.println("Matching data from both DB in Map format :"+matchingRecords);
							break;
						}
						
				else {
						ArrayList<String> valueNotMatchingData= new ArrayList<String>();
						  if (valueNonMatchCounter==0) {
							  ArrayList<String> valueNotMatchingDataHeading= new ArrayList<String>();
								for (int j=0;j <excelHeadingArrayListOuter.size();j++) {
									valueNotMatchingDataHeading.add("DB1_"+excelHeadingArrayListOuter.get(j));
									}
								for (int j =0;j< excelHeadingArrayListOuterCondition1.size();j++) {
									valueNotMatchingDataHeading.add("DB1_"+excelHeadingArrayListOuterCondition1.get(j));
									valueNotMatchingDataHeading.add("DB2_"+excelHeadingArrayListInnerCondition1.get(j));
								}
								
								for (int j =0;j< excelHeadingArrayListOuterCondition2.size();j++) {
									valueNotMatchingDataHeading.add("DB1_"+excelHeadingArrayListOuterCondition2.get(j));
									valueNotMatchingDataHeading.add("DB2_"+excelHeadingArrayListInnerCondition2.get(j));
								}
								valueNonMatchingArrayList.add(valueNotMatchingDataHeading);
								valueNonMatchCounter++;
							}

								//matching columns other than value
							for(int j=0;j<listOuterMap.size();j++) {
								valueNotMatchingData.add(listOuterMap.get(j));
							}
							//matching condition value column
							for (int j=0;j<condition1.size();j++) {
								valueNotMatchingData.add(condition1.get(j));
								valueNotMatchingData.add(condition1_Inner.get(j));
							}
							
							for (int j=0;j<condition2.size();j++) {
								valueNotMatchingData.add(condition2.get(j));
								valueNotMatchingData.add(condition2_Inner.get(j));
							}
							
							valueNonMatchingArrayList.add(valueNotMatchingData);
							System.out.println("non matching data is:"+valueNonMatchingArrayList);
							break;
						  }
						
				}
			
		
	else {
				ArrayList<String> datenonMatchingData= new ArrayList<String>();
				 if (dateNonMatchCounter==0) {	
					 ArrayList<String> datenonMatchingDataHeading= new ArrayList<String>();
					for (int j=0;j <excelHeadingArrayListOuter.size();j++) {
						datenonMatchingDataHeading.add("DB1_"+excelHeadingArrayListOuter.get(j));
						datenonMatchingDataHeading.add("DB2_"+excelHeadingArrayListInner.get(j));
						}
					for (int j =0;j< excelHeadingArrayListOuterCondition1.size();j++) {
						datenonMatchingDataHeading.add("DB1_"+"date1");
						datenonMatchingDataHeading.add("DB2_"+ "date2");
					}
					
					dateNonMatchingArrayList.add(datenonMatchingDataHeading);
					dateNonMatchCounter++;
				 }

					//matching columns other than value
				for(int j=0;j<listOuterMap.size();j++) {
					datenonMatchingData.add(listOuterMap.get(j));
					datenonMatchingData.add(listInnerMap.get(j));
				}
				//matching condition value column
				for (int j=0;j<condition1.size();j++) {
					datenonMatchingData.add(strDateOuter);
					datenonMatchingData.add(strDate1Inner);
				}
				dateNonMatchingArrayList.add(datenonMatchingData);
				System.out.println("date condition not matching data :"+dateNonMatchingArrayList);
				break;

				}
			}
		
		}
	listInnerMap.clear();
	condition1_Inner.clear();
	condition2_Inner.clear();
	
}

if (nonMatchDataFlag==false) {
				
				ArrayList <String> nonMatchData=new ArrayList<String>();
						if (nonMatchCounter==0) {
							//Heading for non matching values
							for (int j=0;j <excelHeadingArrayListOuter.size();j++) {
								nonMatchData.add("DB1_"+excelHeadingArrayListOuter.get(j));
								//nonMatchData.add("DB2_"+excelHeadingArrayListInner.get(j));
								}
							for (int j =0;j< excelHeadingArrayListOuterCondition1.size();j++) {
								nonMatchData.add("DB1_"+excelHeadingArrayListOuterCondition1.get(j));
								//nonMatchData.add("DB2_"+excelHeadingArrayListInnerCondition1.get(j));
						}
						
						for (int j =0;j< excelHeadingArrayListOuterCondition2.size();j++) {
							nonMatchData.add("DB1_"+excelHeadingArrayListOuterCondition2.get(j));
							//nonMatchData.add("DB2_"+excelHeadingArrayListInnerCondition2.get(j));
						}
						nonMatchDataArrayListDB2.add(nonMatchData);
							nonMatchCounter++;
						}
						
						for (int j=0;j <listOuterMap.size();j++) {
							nonMatching.add(listOuterMap.get(j));
						}
						
						for (int j=0;j<condition1.size();j++) {
							nonMatching.add(condition1.get(j));
							nonMatching.add(condition2.get(j));
						}
						nonMatchDataArrayListDB2.add(nonMatching);
						System.out.println("data exist only in DB1:"+nonMatchDataArrayListDB2);
						//break;
				}
			listOuterMap.clear();
			condition1.clear();
			condition2.clear();
	}
		
		// To check records which exist only in DB2
		
		for (Map.Entry<String,Map<String,String>> mapInner:innerMap.entrySet()) {
			ArrayList <String> excludeInnerDB1=new ArrayList<String>();
			ArrayList <String> condition1_InnerDB1=new ArrayList<String>();
			ArrayList <String> condition2_InnerDB1=new ArrayList<String>();
			ArrayList<String> listInnerMapDB1=new ArrayList<String>();	
			ArrayList <String> compareValueInnerrDB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInnerCondition1DB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInnerCondition2DB1=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInnerDB1=new ArrayList<String>(); 
		
			String innerMapKey=mapInner.getKey();
			String innerUpdated_At=null;
			Map<String,String> InnermapValues=mapInner.getValue();
			for (String str:InnermapValues.keySet()) {
				// take below if condition from excel as it is i.e.!(str.equalsIgnoreCase("updated_at"))
				if ((DB2tbl2ExcludeColumn.contains(str))) {
					excludeInnerDB1.add(InnermapValues.get(str));
					//excelHeadingArrayListInner.add(str);
					//listInnerMap.add(InnermapValues.get(str));
					}
					//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
				else if ((DB2tbl2comparisionCondtion1.contains(str))) {
					condition1_InnerDB1.add(InnermapValues.get(str));
					excelHeadingArrayListInnerCondition1DB1.add(str);
					}
				else if ((DB2tbl2comparisionCondtion2.contains(str))) {
					condition2_InnerDB1.add(InnermapValues.get(str));
					excelHeadingArrayListInnerCondition2DB1.add(str);
					}
				else {
					excelHeadingArrayListInnerDB1.add(str);
					listInnerMapDB1.add(InnermapValues.get(str));
					}
				}					
				
		ArrayList<String> listOuterMapDB2=new ArrayList<String>();	
		boolean noDataExist=false;
		for (Map.Entry<String,Map<String,String>> mapOuter:outerMap.entrySet()){
			String outerMapKey=mapOuter.getKey();
			String outerUpdate_at=null;
			
			ArrayList <String> excludeDB2=new ArrayList<String>();
			ArrayList <String> condition1DB2=new ArrayList<String>();
			ArrayList <String> condition2DB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListOuterDB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListOuterCondition1DB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListOuterCondition2DB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInner1DB2=new ArrayList<String>(); 
			ArrayList<String> excelHeadingArrayListInnerCondition1DB2=new ArrayList<String>();
			ArrayList<String> excelHeadingArrayListInnerCondition2DB2=new ArrayList<String>();
			Map<String,String> outerMapValues=mapOuter.getValue();
			for (String str:outerMapValues.keySet()) {
				// Read DB1tbl1Condition1 condition from excel and put into ArrayList to handle it dyanamic.
				if ((DB1tbl1ExcludeColumn.contains(str))) {
					excludeDB2.add(outerMapValues.get(str));
					//excelHeadingArrayListOuter.add(str);
					//listOuterMap.add(outerMapValues.get(str));
					}
					//Read DB1tbl1Condition2 condition from excel and put into ArrayList and handle dyanamic condition
				else if ((DB1tbl1comparisionCondtion1.contains(str))) {
					condition1DB2.add(outerMapValues.get(str));
					excelHeadingArrayListOuterCondition1DB2.add(str);
						
					}
				else if ((DB1tbl1comparisionCondtion2.contains(str))) {
					condition2DB2.add(outerMapValues.get(str));
					excelHeadingArrayListInnerCondition2DB2.add(str);
						
					}
				else {
					excelHeadingArrayListOuterDB2.add(str);
					listOuterMapDB2.add(outerMapValues.get(str));
				}
			}
			
			if (listInnerMapDB1.equals(listOuterMapDB2)) {
				noDataExist=true;
				//break;
			}
			listOuterMapDB2.clear();
			condition1DB2.clear();
			condition2DB2.clear();
	}
		
 		if (noDataExist==false) {
 			ArrayList <String> noMatchDataDB1=new ArrayList<String>();
 			ArrayList <String> noMatchDataValueDB1=new ArrayList<String>();
			if (nonMatchCounterDB1==0) {
				
				for (int j=0;j <excelHeadingArrayListInnerDB1.size();j++) {
					noMatchDataDB1.add("DB1_"+excelHeadingArrayListInnerDB1.get(j));
					
					}
				for (int j =0;j< excelHeadingArrayListInnerCondition1DB1.size();j++) {
					noMatchDataDB1.add("DB1_"+excelHeadingArrayListInnerCondition1DB1.get(j));
			}
			
			for (int j =0;j< excelHeadingArrayListInnerCondition2DB1.size();j++) {
				noMatchDataDB1.add("DB1_"+excelHeadingArrayListInnerCondition2DB1.get(j));
				
			}
			noMatchDataArrayListDB1.add(noMatchDataDB1);
			nonMatchCounterDB1++;
		}
			
			for (int j=0;j <listInnerMapDB1.size();j++) {
				noMatchDataValueDB1.add(listInnerMapDB1.get(j));
			}
			
			for (int j=0;j<condition1_InnerDB1.size();j++) {
				noMatchDataValueDB1.add(condition1_InnerDB1.get(j));
				
			}
			
			for (int j=0;j<condition2_InnerDB1.size();j++) {
				noMatchDataValueDB1.add(condition2_InnerDB1.get(j));
				
			}
			noMatchDataArrayListDB1.add(noMatchDataValueDB1);
			System.out.println("data exist only in DB2:"+noMatchDataArrayListDB1);
			//break;
		}
 		listInnerMapDB1.clear();
		condition1_InnerDB1.clear();
		condition2_InnerDB1.clear();
	}
	
		globalData.put("MatchingData", matchingRecordsArrayList);
		globalData.put("NonMatchingData", valueNonMatchingArrayList);
		globalData.put("DateNonMatchData", dateNonMatchingArrayList);
		globalData.put("DataExistonlyInDB2", nonMatchDataArrayListDB2);
		globalData.put("DataExistonlyInDB1", noMatchDataArrayListDB1);
		System.out.println("global map to print is :"+globalData);
		
		
}
		
		
}
		

	
	



