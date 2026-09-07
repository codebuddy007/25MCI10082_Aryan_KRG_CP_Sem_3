class Solution {
    public int[] constructRectangle(int area) {
        double sqrt = Math.sqrt(area);
        int W = (int)sqrt;
        int[] ans = new int[2];
        for(int i = W;i >0;i--){
            if(area % i==0){
                int L = area/i;
                ans[0]=L;
                ans[1]=i;
                break;
            }
        }
        
        return ans;
    }

}
