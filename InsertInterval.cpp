class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> v  ;
        intervals.push_back(newInterval);
        sort(intervals.begin(),intervals.end());
        int n = intervals.size();
        for(int i = 0;  i < n ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!v.empty() && end <= v[v.size()-1][1])
               continue;
            for(int j = i + 1; j < n ; j++){
                if(end >= intervals[j][0]){
                    end = max(end,intervals[j][1]);
                    i++;
                }
                else{
                    break;
                }
            }
            v.push_back({start,end});
        }
       return v;
    }
};
