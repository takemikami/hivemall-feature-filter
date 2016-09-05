package com.takemikami.hivemall.utils;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.LinkedList;
import java.util.List;

public final class FeatureFilter extends UDF  {
    public List<Text> evaluate(List<Text> original, List<Text> filter) {
        List<Text> rtn = new LinkedList<Text>();
        for(Text key : filter) {
            String matchPrefix = key + ":";
            for(Text keyval : original) {
                if(keyval.toString().startsWith(matchPrefix)){
                    rtn.add(keyval);
                    break;
                }
            }
        }
        return rtn;
    }
}
