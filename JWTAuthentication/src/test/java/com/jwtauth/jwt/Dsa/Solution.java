package com.jwtauth.jwt.Dsa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int arr[]={7,-87,18,-65,16,-16,38,31};
        Solution s=new Solution();
        int ans=s.solve(arr,19);
        System.out.println(ans);
    }
    public int solve(int[] A, int B) {
        int low=0;
        int high=A.length-1;
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(A,mid,B)==B){
                ans=Math.max(mid,ans);
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }

    public int check(int[] A,int mid,int B){
        int sum=0;
        for(int i=0;i<mid;i++){
            sum=sum+A[i];
        }

        if(sum==B){
            return sum;
        }

        int l=0;
        int r=mid;
        while(r<A.length){
            sum=sum-A[l];
            sum=sum+A[r];
            if(sum==B)return sum;
            r++;
            l++;
        }

        return sum;


    }
}