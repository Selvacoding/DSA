

n = 4 # Example target sum
nums = [1, 2, 3]  # Example array of numbers

# Initialize dp array with 0s
dp = [0] * (n + 1)
dp[0] = 1

for i in range(1, n + 1):
    for x in nums:
        if i - x >= 0:
            dp[i] += dp[i - x]

print(dp[n])  # Output the count of ways to achieve the target sum
