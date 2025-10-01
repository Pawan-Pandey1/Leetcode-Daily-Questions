class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drink=numBottles;

        while(numBottles>=numExchange){
            int exchanged=numBottles/numExchange;
            int extraEmpty=numBottles%numExchange;
            drink+=exchanged;
            numBottles=exchanged+extraEmpty;
        }
        return drink;
    }
}