package leetcode;

import java.util.ArrayList;

/**
 * Created by Anthony on 2014/6/8.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path==null || path.length() == 0)
            return "/";
        String[] _p = path.split("/");
        ArrayList<String> p = new ArrayList<String>();
        for(int i = 0; i < _p.length; i++){
            if(_p[i].equals("") || _p[i].equals("."))
                continue;
            if(_p[i].equals("..")) {
                if(p.size() > 0)
                    p.remove(p.size() - 1);
            }
            else
                p.add(_p[i]);
        }
        StringBuilder sb = new StringBuilder();
        if(p.size() == 0)
            sb.append("/");
        else{
            for(String p2:p){
                sb.append("/");
                sb.append(p2);
            }
        }
        return sb.toString();
    }
}
