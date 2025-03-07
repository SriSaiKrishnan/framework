package com.sai.utility;

import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private DataProviderUtils(){}

    private static String dataSheetName;

    public static void setDataSheetName(String dataSheetName) {
        DataProviderUtils.dataSheetName = dataSheetName;
    }


    @DataProvider(parallel = true)
    public static Object[] getData(Method method){

        String testname = method.getName();
        List<Map<String,String>> list = ExcelUtils.readExcel(dataSheetName);
        List<Map<String,String>> iterationList = new ArrayList<>();

        for (int i=0; i<list.size(); i++){

            if(list.get(i).get("testname").equalsIgnoreCase(testname)
                    && list.get(i).get("execute").equalsIgnoreCase("yes")){
                iterationList.add(list.get(i));
            }

        }

        return iterationList.toArray();

    }

}
