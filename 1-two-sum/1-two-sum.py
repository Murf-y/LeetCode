class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        nums_map ={}
        for i in range(0,len(nums)):
            looking_for = target - nums[i]
            if looking_for in nums_map.keys():
                return [nums_map[looking_for], i]
            nums_map[nums[i]] = i
        
        