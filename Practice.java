import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		String strArray2=condition1Array[3];
		String [] strDB2Condition1= strArray2.split("\\.");
		String strCondition1DB2=strDB2Condition1[1];
		
		//ArrayList <String> DB2ComparisionCondtion1=new ArrayList<String>();
		DB2ComparisionCondtion1.add(strCondition1DB2);
		System.out.println("DB2ComparisionCondtion1 is :"+DB2ComparisionCondtion1);
		
		
		
		String strArray3=condition3Array[1];
		String [] DB2Condition1=strArray3.split("\\.");
		String strCondition2DB1=DB2Condition1[1];
		
		//ArrayList <String> DB1ComparisionCondtion2=new ArrayList<String>();
		DB1ComparisionCondtion2.add(strCondition2DB1);
		
		System.out.println("DB1ComparisionCondtion2 is :"+DB1ComparisionCondtion2);
		
		String strArray4=condition3Array[3];
		String [] strDB2Condition2= strArray4.split("\\.");
		String strCondition2DB2=strDB2Condition2[1];
		
		//ArrayList <String> DB2ComparisionCondtion2=new ArrayList<String>();
		DB2ComparisionCondtion2.add(strCondition2DB2);
		
		System.out.println("DB2ComparisionCondtion2 is :"+DB2ComparisionCondtion2);
		
		}
			
	  }
	}
}
