function solution(begin, target, words) {
  let answer = Infinity;

  function bfs() {
    let visited = { begin: true };
    let q = [{ str: begin, depth: 0 }];
    while (q.length > 0) {
      const { str, depth } = q.shift();
      if (str === target) {
        answer = Math.min(answer, depth);
      }
      for (let word of words)
        if (!visited[word] && isPossible(word, str)) {
          visited[word] = true;
          q.push({ str: word, depth: depth + 1 });
        }
    }
  }

  function isPossible(word, str) {
    let cnt = 0;
    for (let i = 0; i < word.length; i++) {
      if (word[i] !== str[i]) {
        cnt++;
      }
    }
    if (cnt === 1) {
      return true;
    }
    return false;
  }

  bfs();
  return answer === Infinity ? 0 : answer;
}
