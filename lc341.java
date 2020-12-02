/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<ListIterator<NestedInteger>> lists;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!lists.empty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger()) {
                    return lists.peek().previous() == x;
                
                }
                lists.push(x.getList().listIterator());
            }
         }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */






//using Queue

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;   
    Queue<Integer> queue = new LinkedList<>();
    
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        flat(nestedList);
    }
    
    
    public void flat(List<NestedInteger> nestedList) {
        
        //push the nested Integer to queue
        for (NestedInteger ni : nestedList) {
            
            if (ni.isInteger()) {
                queue.offer(ni.getInteger());
            } else {
                List<NestedInteger> tmp = ni.getList();
                flat(tmp);
            }
        }
    }

    @Override
    public Integer next() {
        if (queue.isEmpty()) return null;
        
        Integer res = queue.poll();
        return res;
        
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */