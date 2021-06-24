import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {

	
		public static void main(String[] args) {
			LinkedHashMap<String,Map<String,String>> outerMap=new LinkedHashMap<String,Map <String,String>>();
			LinkedHashMap<String, Map<String, String>> innerMap=new LinkedHashMap<String,Map <String,String>>();
			LinkedHashMap<String,String> map1=new LinkedHashMap<String,String>();
			LinkedHashMap<String,String> map2=new LinkedHashMap<String,String>();
			ArrayList<ArrayList<String>>  matchingRecordsArrayList =  new ArrayList<ArrayList<String>>();
			ArrayList<ArrayList<String> > nonMatchingRecordsArrayList =  new ArrayList<ArrayList<String> >();
			
			
		
			LinkedHashMap<String,Map<String,String>> nonMatch=new LinkedHashMap<String,Map <String,String>>();
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
			map1.put("updated_at", "9/05/2021");
			outerMap.put("IID002", new LinkedHashMap(map1));
			System.out.println("OuterMap 2 values :"+outerMap);
			//map1.clear();
			
			map1.put("ID", "03");
			map1.put("IssuerID", "IID003");
			map1.put("document_type", "10K");
			map1.put("datalibid", "5555");
			map1.put("seriesid", "5");
			map1.put("value", "80");
			map1.put("updated_at", "05/05/2021");
			outerMap.put("IID003", new LinkedHashMap(map1));
			
			map2.put("KeyID", "001");
			map2.put("DMX_IssuerID", "IID001");
			map2.put("document_type", "12345");
			map2.put("datalibid", "8888");
			map2.put("seriesid", "2");
			map2.put("value", "100");
			map2.put("updated_at", "8/05/2021");
			
			
			innerMap.put("IID001", new LinkedHashMap(map2));
		//	System.out.println("innermap 1 values :"+innerMap);
		//	map2.clear();
			map2.put("KeyID", "002");
			map2.put("DMX_IssuerID", "IID002");
			map2.put("document_type", "67890");
			map2.put("datalibid", "9999");
			map2.put("seriesid", "1");
			map2.put("value", "50");
			map2.put("updated_at", "9/05/2021");
						
			innerMap.put("IID002", new LinkedHashMap(map2));
			
			map2.put("KeyID", "003");
			map2.put("DMX_IssuerID", "IID003");
			map2.put("document_type", "10K");
			map2.put("datalibid", "5555");
			map2.put("seriesid", "5");
			map2.put("value", "10");
			map2.put("updated_at", "05/05/2021");
			innerMap.put("IID003", new LinkedHashMap(map2));
			System.out.println("innermap 2 values :"+innerMap);
			int matchCounter=0;
			int nonMatchCounter=0;
			
			ArrayList <String> DB1tbl1ExcludeColumn=new ArrayList<String>();
			//DB1tbl1ExcludeColumn.add("updated_at");
			DB1tbl1ExcludeColumn.add("ID");
			
			ArrayList <String> DB1tbl1comparisionCondtion1=new ArrayList<String>();
			DB1tbl1comparisionCondtion1.add("updated_at");
			
			ArrayList <String> DB1tbl1comparisionCondtion2=new ArrayList<String>();
			DB1tbl1comparisionCondtion2.add("value");
			
			
			ArrayList <String> DB2tbl2ExcludeColumn=new ArrayList<String>();
			//DB2tbl2ExcludeColumn.add("updated_at");
			DB2tbl2ExcludeColumn.add("KeyID");
			
			ArrayList <String> DB2tbl2comparisionCondtion1=new ArrayList<String>();
			DB2tbl2comparisionCondtion1.add("updated_at");
			
			ArrayList <String> DB2tbl2comparisionCondtion2=new ArrayList<String>();
			DB2tbl2comparisionCondtion2.add("value");
			

			
			for (Map.Entry<String,Map<String,String>> mapOuter:outerMap.entrySet()){
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
				
				/*System.out.println("Exclude :"+exclude);
				System.out.println("condition1 :"+condition1);
				System.out.println("condition2 :"+condition2);
				System.out.println("listOuterMap :"+listOuterMap);
				System.out.println("excelHeadingArrayListOuter :"+excelHeadingArrayListOuter);*/
				
				
				
			//	System.out.println("Outer Map Arraylist is :"+listOuterMap);
			for (Map.Entry<String,Map<String,String>> mapInner:innerMap.entrySet()) {
					String innerMapKey=mapInner.getKey();
					String innerUpdated_At=null;
					ArrayList <String> excludeInner=new ArrayList<String>();
					ArrayList <String> condition1_Inner=new ArrayList<String>();
					ArrayList <String> condition2_Inner=new ArrayList<String>();
					ArrayList<String> listInnerMap=new ArrayList<String>();
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
						
			//System.out.println("Inner Map Arraylist is :"+listInnerMap);	
			if (listOuterMap.equals(listInnerMap)) {
				if (condition1.equals(condition1_Inner)) {
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
						System.out.println("Matching ArrayList  is:"+matchingRecordsArrayList);
						break;
					}
					else {
						ArrayList <String> nonMatchData=new ArrayList<String>();
							if (nonMatchCounter==0) {
								//Heading for non matching values
								for (int j=0;j <excelHeadingArrayListOuter.size();j++) {
									nonMatchData.add("DB1_"+excelHeadingArrayListOuter.get(j));
									nonMatchData.add("DB2_"+excelHeadingArrayListInner.get(j));
									}
								for (int j =0;j< excelHeadingArrayListOuterCondition1.size();j++) {
									nonMatchData.add("DB1_"+excelHeadingArrayListOuterCondition1.get(j));
									nonMatchData.add("DB2_"+excelHeadingArrayListInnerCondition1.get(j));
							}
							
							for (int j =0;j< excelHeadingArrayListOuterCondition2.size();j++) {
								nonMatchData.add("DB1_"+excelHeadingArrayListOuterCondition2.get(j));
								nonMatchData.add("DB2_"+excelHeadingArrayListInnerCondition2.get(j));
							}
								nonMatchingRecordsArrayList.add(nonMatchData);
								nonMatchCounter++;
							}
							//Matching columns from Outer and inner map
							for (int j=0;j <listOuterMap.size();j++) {
								nonMatching.add(listOuterMap.get(j));
								nonMatching.add(listInnerMap.get(j));
							}
							//Difference in comparison value i.e.value column  
							for (int j=0;j <condition1.size();j++) {
								nonMatching.add(condition1.get(j));
								nonMatching.add(condition1_Inner.get(j));
							}
							
							for (int j=0;j <condition2.size();j++) {
								nonMatching.add(condition2.get(j));
								nonMatching.add(condition2_Inner.get(j));
							}
							
							nonMatchingRecordsArrayList.add(nonMatching);
							System.out.println("Non Matching ArrayList  is:"+nonMatchingRecordsArrayList);
							break;
					}
				  }
				}
			condition1_Inner.clear();
			condition2_Inner.clear();
				}
			condition1.clear();
			condition2.clear();
		}	
	}
}




