class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1]-position[0];
        int ans = 0;
        while(low<= high){
            int mid = low+(high-low)/2;
            if(isPossible(position,m,mid)){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
    boolean isPossible(int[] position , int m , int mid){
        int count = 1;
        int lastPlaced = position[0];
        for(int curr:position){
            if(curr-lastPlaced >=mid){
                count++;
                lastPlaced = curr;
                if(count == m ) return true;
            }
        }
        return false;
    }
}
