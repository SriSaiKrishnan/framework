package com.sai.listener;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import com.sai.utility.ExcelUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> method, ITestContext iTestContext) {

        List<IMethodInstance> result = new ArrayList<>();
        List<Map<String,String>> list = ExcelUtils.readExcel("runmanager");

        for (int i=0; i<method.size(); i++){
            for (int j=0; j<list.size(); j++){
                if(method.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testcasename"))
                        && list.get(j).get("execute").equalsIgnoreCase("yes")){
                    result.add(method.get(i));
                }
            }
        }

        return result;

    }
}
