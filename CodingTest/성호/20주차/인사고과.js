function solution(scores) {
  let wanho = scores[0];
  let answer = 1;
  scores.sort((a, b) => {
    return a[0] === b[0] ? a[1] - b[1] : b[0] - a[0];
  });
  let max = scores[0][1];
  for (let i = 0; i < scores.length; i++) {
    const score = scores[i];
    if (score[1] < max) {
      if (score[0] === wanho[0] && score[1] === wanho[1]) {
        return -1;
      }
    } else {
      max = Math.max(max, score[1]);
      if (score[0] + score[1] > wanho[0] + wanho[1]) {
        answer++;
      }
    }
  }
  return answer;
}
