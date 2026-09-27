class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1;
        r = max(piles)
        minSpeed = r

        while l <= r:
            currSpeed = l + (r - l)//2
            currTime = 0

            for pile in piles:
                currTime += (pile + currSpeed - 1)//currSpeed

            if currTime > h:
                l = currSpeed + 1
            else:
                r = currSpeed - 1
                minSpeed = min(minSpeed, currSpeed)

        return minSpeed
