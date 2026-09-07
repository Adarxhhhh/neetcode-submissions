class StockSpanner {

    class Stock{
        int price;
        int span;

        public Stock(int price, int span){
            this.price = price;
            this.span = span;
        }
    }

    Deque<Stock> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;

        while(!stack.isEmpty() && stack.peek().price <= price){
            span += stack.pop().span;
        }

        stack.push(new Stock(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */