package com.process;

import java.util.ArrayList;
import java.util.List;

public class SplitUtil {
	
	public String[] split(String str, char separatorChar) {
        if (str == null) {
            return null;
        }

        int length = str.length();

        /*if (length == 0) {
            return ArrayUtil.EMPTY_STRING_ARRAY;
        }*/
        List    list  = new ArrayList();
        int     m     = 0;
        int     start = 0;
        boolean match = false;

        while (m < length) {
            if (str.charAt(m) == separatorChar) {
                if (match) {
                    list.add(str.substring(start, m));
                    match = false;
                }
                start = ++m;
                continue;
            }
            match = true;
            m++;
        }

        if (match) {
            list.add(str.substring(start, m));
        }

        return (String[]) list.toArray(new String[list.size()]);
    }

}
