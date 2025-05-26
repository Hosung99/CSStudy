function solution(maps) {
  const dx = [1, -1, 0, 0];
  const dy = [0, 0, 1, -1];
  const n = maps.length;
  const m = maps[0].length;
  let visited = Array.from({ length: n }, () => Array(m).fill(-1));
  function bfs() {
    let q = [{ curX: 0, curY: 0 }];
    visited[0][0] = 1;
    while (q.length > 0) {
      const { curX, curY } = q.shift();
      if (curX === n && curY === m) {
        return;
      }
      for (let dir = 0; dir < 4; dir++) {
        let nx = curX + dx[dir];
        let ny = curY + dy[dir];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
          continue;
        }
        if (visited[nx][ny] > -1 || maps[nx][ny] === 0) {
          continue;
        }
        visited[nx][ny] = visited[curX][curY] + 1;
        q.push({ curX: nx, curY: ny });
      }
    }
  }
  bfs();
  return visited[n - 1][m - 1];
}
