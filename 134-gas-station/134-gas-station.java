class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int n = gas.length;
        // for(int i=0; i<gas.length; i++) {
        //     if(cost[i] <= gas[i]) {
        //         int currGas = gas[i];
        //         int j = i;
        //         while(currGas >= cost[j]) {
        //             currGas = currGas - cost[j] + gas[(j+1) % n];
        //             j = (j+1) % n;
        //             if (j == i) {
        //                 return i;
        //             }
        //         }
        //     }
        // }
        // return -1;
        
        int sum = 0;
        int n = gas.length;
        for(int i=0; i<n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;
        
        int currFuel = 0;
        int start = 0;
        for(int i=0; i<n; i++) {
            currFuel += gas[i] - cost[i];
            if (currFuel < 0) {
                start = i+1;
                currFuel = 0;
            }
        }
        return start;
    }
}