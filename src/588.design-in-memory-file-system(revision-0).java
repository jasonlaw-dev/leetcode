import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=588 lang=java
 *
 * [588] Design In-Memory File System
 * 
 * filePath -> content O(1)
 * 
 * ls -> check fileContentMap -> if exists -> return [it]
 * if not, check if it is a directory, return sorted keys
 * 
 * how to distinguish file and directory? 
 */

// @lc code=start

class Directory implements Comparator<Directory> {

    public String name;

    public TreeMap<String, Directory> children;

    public Directory(String name) {
        this.name = name;
        this.children = new TreeMap<>();
    }

    @Override
    public int compare(Directory o1, Directory o2) {
        return o1.name.compareTo(o2.name);
    }
}

class FileSystem {
    Map<String, String> fileContents = new HashMap<>();
    Directory root = new Directory("");
    public FileSystem() {
        
    }

    private List<String> splitPath(String path) {
        return Arrays.asList(path.substring(1, path.length()).split("/"));
    }
    
    public List<String> ls(String path) {
        if (fileContents.containsKey(path)) {
            List<String> parts = splitPath(path);
            return Arrays.asList(parts.get(parts.size() - 1));
        }
        Directory dir = root;
        if (path.length() > 1) {
            for (String part : splitPath(path)) {
                dir = dir.children.get(part);
            }
        } 
        
        return new ArrayList<>(dir.children.keySet());
    }
    
    public void mkdir(String path) {
        Directory dir = root;
        if (path.length() > 1) {
            for (String part : splitPath(path)) {
                if (!dir.children.containsKey(part)) {
                    dir.children.put(part, new Directory(part));
                }
                dir = dir.children.get(part);
            }
        } 
    }
    
    public void addContentToFile(String filePath, String content) {
        fileContents.put(filePath, fileContents.getOrDefault(filePath, "") + content);
        mkdir(filePath);
    }
    
    public String readContentFromFile(String filePath) {
        return fileContents.get(filePath);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
// @lc code=end

