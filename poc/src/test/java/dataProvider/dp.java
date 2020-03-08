package dataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;

import genericLib.excelRW;
import genericLib.commonLib;

public class dp  {

	
	@DataProvider(name="dp")
	public static Iterator<Object[]> singleDp(Method m) throws Exception{
	
		return commondp(m.getName().split("_")[0],m.getName().split("_")[1]);
		
	}
	
	
	public static Iterator<Object[]> commondp (String sheetName, String scriptName) throws Exception {
		
	excelRW ex = new excelRW(System.getProperty("user.dir")+ "\\" + commonLib.getprop("TestData"));
	
	
	int row = ex.getRowCount(sheetName);
	int col = ex.getColCount(sheetName);
	
	 List<Object[]> al = new ArrayList<Object[]>();
	
	 for (int i=1; i<=row; i++) {
		String execute = ex.readCellValue(sheetName, i, 2);
		String script = ex.readCellValue(sheetName, i, 1);
		if(execute.equals("y") && script.equals(scriptName)) {
			//create object array
			Object[] x = new Object[1];
			//create hashmap
			Map<String, String> hm = new HashMap<String, String>();
			//iterate column
			//iterate column
			for(int j = 0 ;j<col;j++){
				
				String key=ex.readCellValue(sheetName, 0, j);
				String val=ex.readCellValue(sheetName, i, j);
				hm.put(key, val);
			}
			x[0]=hm;
			al.add(x);
					
		}
	 }
	 return al.iterator();
	 
	 
	}
	

	
	
}