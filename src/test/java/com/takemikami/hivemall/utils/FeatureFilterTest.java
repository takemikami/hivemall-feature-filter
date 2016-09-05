package com.takemikami.hivemall.utils;

import org.apache.hadoop.io.Text;
import org.junit.Test;
import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class FeatureFilterTest {

    @Test
    public void test() {
        FeatureFilter udf = new FeatureFilter();

        List<Text> original = new LinkedList<Text>();
        original.add(new Text("1:1"));
        original.add(new Text("2:0"));
        original.add(new Text("3:1"));

        List<Text> filter = new LinkedList<Text>();
        filter.add(new Text("1"));
        filter.add(new Text("3"));

        List<Text> rtn = udf.evaluate(original, filter);

        Assert.assertEquals("invalid array size", 2, rtn.size());
        Assert.assertEquals("invalid last element", new Text("3:1"), rtn.get(rtn.size()-1));
    }

}