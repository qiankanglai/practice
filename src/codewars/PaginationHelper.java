package codewars;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiank on 1/29/2016.
 */
public class PaginationHelper<I> {
    private int totalCount = 0;
    private int itemsPerPage = 0;
    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.totalCount = collection.size();
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return totalCount;
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (totalCount-1)/itemsPerPage+1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        int c = pageCount();
        if(pageIndex < 0 || pageIndex >= c) return -1;
        if(pageIndex == c-1)
            return totalCount%itemsPerPage;
        else
            return itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if(itemIndex < 0 || itemIndex >= totalCount) return -1;
        return (itemIndex-1)/itemsPerPage;
    }

    public static void main(String args[])
    {
        ArrayList<Character> arr = new ArrayList<>();
        arr.add('a');arr.add('a');arr.add('a');arr.add('a');arr.add('a');arr.add('a');
        PaginationHelper<Character> helper = new PaginationHelper(arr, 4);
        System.out.println(helper.pageCount()); //should == 2
        System.out.println(helper.itemCount()); //should == 6
        System.out.println(helper.pageItemCount(0)); //should == 4
        System.out.println(helper.pageItemCount(1)); // last page - should == 2
        System.out.println(helper.pageItemCount(2)); // should == -1 since the page is invalid

        // pageIndex takes an item index and returns the page that it belongs on
        System.out.println(helper.pageIndex(5)); //should == 1 (zero based index)
        System.out.println(helper.pageIndex(2)); //should == 0
        System.out.println(helper.pageIndex(20)); //should == -1
        System.out.println(helper.pageIndex(-10)); //should == -1
    }
}