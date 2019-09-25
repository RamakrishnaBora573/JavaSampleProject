package testNG.dataprovider;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;



public class DataReadingWithMAP {
	
	public static Map<String,Map<String,String>> readMultipleTestData(String sFilePath,String sSheetName,String sTestCaseName)throws Exception{


		Map<String,Map<String,String>> objTestData = new HashMap<String, Map<String,String>>();

		String sKey,sValue, sCurTestCaseName,sPreviousTestCaseName = "";
		int iRowNo = 1;
		Workbook objWorkbook = Workbook.getWorkbook(new File(sFilePath));
		Sheet objSheet = objWorkbook.getSheet(sSheetName);
		int iRowCount =  objSheet.getRows();
		int iColCount =  objSheet.getColumns();
		for(int iRowCounter=1;iRowCounter<iRowCount;iRowCounter++){

			Map<String,String> objRowData = new HashMap<String, String>();
			sCurTestCaseName = objSheet.getCell(0, iRowCounter).getContents();
			if ((sPreviousTestCaseName).length()!=0 && (sCurTestCaseName != sPreviousTestCaseName) && sTestCaseName.trim().length() > 0){
				break;
			}
			if ((sCurTestCaseName.equalsIgnoreCase(sTestCaseName)))
			{
				sPreviousTestCaseName = sCurTestCaseName;	

				for(int iColCounter = 1;iColCounter<iColCount;iColCounter++){
					sKey = ((Sheet) objSheet).getCell(iColCounter,0).getContents();
					sKey = sKey.trim();
					sValue = ((Sheet) objSheet).getCell(iColCounter,iRowCounter).getContents();
					sValue = sValue.trim();
					System.out.println(sValue);
					if((!sValue.equalsIgnoreCase(null)) && (sValue.trim().length()!=0)){
						//System.out.println(sKey+sValue);
						objRowData.put(sKey,sValue);
					}
				}
				objTestData.put("Row" + iRowNo,objRowData);

				objRowData=null;

				iRowNo = iRowNo + 1;
			}  
		}
		return objTestData;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		DataReadingWithMAP dm = new DataReadingWithMAP();
		
		dm.readMultipleTestData("C:\\TestData\\MingleShare.xls","MingleShare","TC_01_MingleShareAndDrillback_VerifyGroupListShareAndDrillback");

	}

}
