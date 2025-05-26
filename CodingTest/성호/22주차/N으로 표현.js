function solution(N, number) {
  if (number === N) {
    return 1;
  }

  const dp = Array.from({ length: 9 }, () => new Set());

  dp[1].add(N);

  for (let i = 2; i <= 8; i++) {
    const repeatedN = Number(N.toString().repeat(i));
    dp[i].add(repeatedN);

    for (let j = 1; j < i; j++) {
      const leftGroup = dp[j];
      const rightGroup = dp[i - j];

      for (const a of leftGroup) {
        for (const b of rightGroup) {
          const results = [
            a + b,
            a - b,
            b - a,
            a * b,
            Math.floor(a / b),
            Math.floor(b / a),
          ];

          for (const result of results) {
            if (result > 0) {
              dp[i].add(result);
            }
          }
        }
      }
    }

    if (dp[i].has(number)) {
      return i;
    }
  }

  return -1;
}
