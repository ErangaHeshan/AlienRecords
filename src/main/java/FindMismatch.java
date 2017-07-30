import java.util.*;

/**
 * Created by Eranga Heshan on 7/29/17.
 */

public class FindMismatch {

    public static void main(String[] args){
        Record r1 = new Record(new ArrayList<Object>() {{add("Granga"); add("Heshan"); add("123"); }});
        Record r2 = new Record(new ArrayList<Object>() {{add("Eranga"); add("Heshan"); add("124"); }});
        Record r3 = new Record(new ArrayList<Object>() {{add("Eranga"); add("Deshan"); add("125"); }});
        Record r4 = new Record(new ArrayList<Object>() {{add("Eranga"); add("Heshan"); add("126"); }});
        List<Record> table1 = Arrays.asList(r1,r2,r3,r4);
        Collections.sort(table1);

        Record r5 = new Record(new ArrayList<Object>() {{add("Granga"); add("Heshan"); add("123"); }});
        Record r6 = new Record(new ArrayList<Object>() {{add("Eranga"); add("Hoshan"); add("124"); }});
        Record r7 = new Record(new ArrayList<Object>() {{add("Eranga"); add("Deshan"); add("125"); }});
        Record r8 = new Record(new ArrayList<Object>() {{add("Eranga"); add("Heshan"); add("126"); }});
        List<Record> table2 = Arrays.asList(r5,r6,r7,r8);
        Collections.sort(table2);

        int i=0, j=0;
        boolean loop = true;
        ArrayList<Record> result1 = new ArrayList<Record>();
        ArrayList<Record> result2 = new ArrayList<Record>();
        while(loop){
            Record recordT1 = table1.get(i);
            Record recordT2 = table2.get(j);
            if(!recordT1.equals(recordT2)){
                if(recordT1.compareTo(recordT2) < 0){
                    result1.add(recordT1);
                    i += 1;
                }else{
                    result2.add(recordT2);
                    j += 1;
                }
            }else{
                i += 1;
                j += 1;
            }
            if(i >= table1.size()){
                for(int k=i; k<table2.size(); k++){
                    result2.add(table2.get(k));
                }
                loop = false;
            }
            if(j >= table2.size()){
                for(int k=j; k<table1.size(); k++){
                    result1.add(table1.get(k));
                }
                loop = false;
            }
        }
        System.out.println("Spec:");
        System.out.println(result1);
        System.out.println("\nDatabase:");
        System.out.println(result2);
    }
}
