package com.kundan.practice;

import java.util.*;

/**
 * https://leetcode.com/discuss/interview-question/1508471/code-design-file-processing-scenario
 *
 * Given a list of [FileName, FileSize, [Collection]] - Collection is optional, i.e., a collection can have 1 or more files. Same file can be a part of more than 1 collection.
 * How would you design a system
 *
 * To calculate total size of files processed.
 * To calculate Top K collections based on size.
 * Example:
 * file1.txt(size: 100)
 * file2.txt(size: 200) in collection "collection1"
 * file3.txt(size: 200) in collection "collection1"
 * file4.txt(size: 300) in collection "collection2"
 * file5.txt(size: 100)
 * Output:
 *
 * Total size of files processed: 900
 * Top 2 collections:
 *
 * collection1 : 400
 * collection2 : 300
 */
public class FileCollectionSize {


    PriorityQueue<Collection> collections;
    PriorityQueue<File> files;

    public FileCollectionSize() {
        collections = new PriorityQueue<>();
        files = new PriorityQueue<>();
    }

    public void addFile(File file) {
        files.offer(file);
        if (file.collections() != null && file.collections().length > 0) {
            System.out.println("Added file and now adding file to collection "+file);
            for (Collection collection : file.collections()) {
                //traverse the list of collections. if found, add file to the collection
                //if not found, create a collection and add file to that
                collection.addFile(file);
                if (collections.contains(collection)) {
                    System.out.println("Collection already present, adding file="+file.name()+" to "+collection.name);
                } else {
                    System.out.println("Collection not present, adding collection="+collection.name+" & "+file);
                    collections.add(collection);
                }
            }
        } else {
            System.out.println("Added file alone as collection is null "+file);
        }
        System.out.println("After files added, collections="+collections);
    }

    public void listTopNFilesBySize(int N) {
        System.out.println("Top N files are: ");
        int size = files.size();
        for (int i=0; i<N && i< size; i++) {
            System.out.println((i+1)+"."+files.poll());
        }
    }
    public void listTopNCollectionsBySize(int N) {
        System.out.println("Top N Collections are: ");
        int size = collections.size();
        for (int i=0; i<N && i< size; i++) {
            System.out.println((i+1)+"."+collections.poll());
        }
    }
    public static void main(String[] args) {

        FileCollectionSize fileCollectionSize = new FileCollectionSize();

        List<Collection> collectionList = new ArrayList<>();

        Collection collection1 = new Collection("collection1");
        Collection collection2 = new Collection("collection2");

        collectionList.add(collection1);
        collectionList.add(collection2);


        File file1 = new File("file1.txt", 400);
        File file2 = new File("file2.txt", 200, collection1);
        File file3 = new File("file3.txt", 200, collection1);
        File file4 = new File("file4.txt", 300, collection2);
        File file5 = new File("file5.txt", 700);
        File file6 = new File("file6.txt", 100, collectionList.toArray(new Collection[0]));

        fileCollectionSize.addFile(file1);fileCollectionSize.addFile(file2); fileCollectionSize.addFile(file3);
        fileCollectionSize.addFile(file4); fileCollectionSize.addFile(file5); fileCollectionSize.addFile(file6);

        fileCollectionSize.listTopNFilesBySize(3);

        fileCollectionSize.listTopNCollectionsBySize(2);

    }
}



record File(String name, long size, Collection... collections)  implements Comparable<File>{

    @Override
    public int compareTo(File other) {
        return Long.compare(other.size(), this.size());
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", collection=" + Arrays.toString(collections) +
                '}';
    }
}

class Collection implements Comparable<Collection> {

    String name;
    Set<File> fileList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collection that = (Collection) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Collection(String name) {
        this.name = name;
        this.fileList = new HashSet<>();
    }

    public void addFile(File file) {
        this.fileList.add(file);
    }

    public boolean removeFile(File file) {
        return this.fileList.remove(file);
    }

    public long size() {
        return this.fileList.stream().map(File::size).mapToLong(Long::longValue).sum();
    }

    @Override
    public int compareTo(Collection other) {
        return Long.compare(other.size(), this.size());
    }

    @Override
    public String toString() {
        return "Collection{" +
                "name='" + name + '\'' +
                ", size=" + size() +
                '}';
    }
}