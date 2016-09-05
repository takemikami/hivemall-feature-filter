# hivemall feature filter

This is hive UDF: return subset of features' array, you like feature keys.

hivemall  
https://github.com/myui/hivemall

## example

```
hive> select rowid, label, features from a9atrain limit 5;
1    0    ["3:1","11:1","14:1","19:1","39:1","42:1","55:1","64:1","67:1","73:1","75:1","76:1","80:1","83:1"]
2    0    ["5:1","7:1","14:1","19:1","39:1","40:1","51:1","63:1","67:1","73:1","74:1","76:1","78:1","83:1"]
3    0    ["3:1","6:1","17:1","22:1","36:1","41:1","53:1","64:1","67:1","73:1","74:1","76:1","80:1","83:1"]
4    0    ["5:1","6:1","17:1","21:1","35:1","40:1","53:1","63:1","71:1","73:1","74:1","76:1","80:1","83:1"]
5    0    ["2:1","6:1","18:1","19:1","39:1","40:1","52:1","61:1","71:1","72:1","74:1","76:1","80:1","95:1"]
```

```
hive> add jar hivemall-feature-filter-1.0-SNAPSHOT.jar;
hive> create temporary function feature_filter as 'com.takemikami.hivemall.utils.FeatureFilter';
hive> select rowid, label, feature_filter(features, array('80','83')) from a9atrain limit 5;
1	0	["80:1","83:1"]
2	0	["83:1"]
3	0	["80:1","83:1"]
4	0	["80:1","83:1"]
5	0	["80:1"]
```
