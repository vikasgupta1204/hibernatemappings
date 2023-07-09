package com.jwtauth.jwt.Dsa;

import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {

    public int solve(int[] A,int B) {

        int maxLen=0;
        int l=0;
        int r=0;
        int sum=0;
        while(r<A.length){
            sum=sum+A[r];
            if(sum==B){
                maxLen=Math.max(r-l+1,maxLen);
            }

            while(sum>B&&l<=r){
                sum=sum-A[l];
                l++;
                if(sum==B)maxLen=Math.max(r-l+1,maxLen);
            }
            r++;
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int arr[]={7,-87,18,-65,16,-16,38,31};
        Solution1 solution1=new Solution1();
       int ans= solution1.solve(arr,69);
        System.out.println(ans);
    }
}
