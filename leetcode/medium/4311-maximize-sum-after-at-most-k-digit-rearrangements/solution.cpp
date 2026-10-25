#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    long long maximizeSum(vector<int>& nums, int k) {
        long long sum = 0;
        vector<pair<int, int>> gains;

        for (int i = 0; i < nums.size(); i++) {
            string temp = to_string(nums[i]);

            sort(temp.begin(), temp.end(), [](char a, char b) {
                return a > b;
            });

            int x = stoi(temp);
            int gain = x - nums[i];

            gains.push_back({gain, i});
        }

        sort(gains.begin(), gains.end(), [](pair<int, int> a, pair<int, int> b) {
            return a.first > b.first;
        });

        for (int i = 0; i < k && i < gains.size(); i++) {
            if (gains[i].first > 0) {
                nums[gains[i].second] += gains[i].first;
            }
        }

        for (int x : nums) {
            sum += x;
        }

        return sum;
    }
};