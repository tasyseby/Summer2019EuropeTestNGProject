package com.cybertek.tests.day17_ddf;

import com.cybertek.utilities.ExcelUtil;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //create an object from ExcelUtils
        //it accepts 2 arguments
        // argument 1 : location of file path
        // argument 2 : sheet that we want to open (sheetname)

        ExcelUtil qa3short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        System.out.println("ROW COUNT " + qa3short.rowCount());
        //how many columns in the sheets
        System.out.println("COLUMN COUNT " + qa3short.columnCount());
        System.out.println("Column names "  + qa3short.getColumnsNames());

        List<Map<String, String>> dataList = qa3short.getDataList();

        for (Map<String,String> onerow :dataList){
            System.out.println(onerow);
        }

        System.out.println(dataList.get(0).get("firstname"));

        String [] [] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));
        }

        }



