class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    int capacity;
    Node first;
    Node last;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        first = new Node(-1, -1);
        last = new Node(-1, -1);
        first.next = last;
        last.prev = first;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }else{
            Node node = cache.get(key);
            remove(node);
            addFirst(node);
            return node.value;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            remove(node);
            addFirst(node);
        }else{
            if(cache.size() == capacity){
                Node lru = last.prev;
                remove(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addFirst(newNode);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public void addFirst(Node node){
        first.next.prev = node;
        node.next = first.next;
        first.next = node;
        node.prev = first;
    }
}
