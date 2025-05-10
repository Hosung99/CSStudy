function solution(storage, requests) {
  let answer = 0;
  let arr = [];
  const dx = [1, -1, 0, 0];
  const dy = [0, 0, 1, -1];

  for (let i = 0; i < storage.length; i++) {
    arr.push(storage[i]);
  }

  function doLift(input) {
    let temp = [];
    for (let i = 0; i < arr.length; i++) {
      let tempStr = "";
      for (let j = 0; j < arr[i].length; j++) {
        if (arr[i][j] === input) {
          let flag = true;
          let q = [{ curX: i, curY: j }];
          let visited = Array.from({ length: arr.length }, () =>
            Array(arr[i].length).fill(false)
          );
          visited[i][j] = true;
          while (q.length > 0) {
            const { curX, curY } = q.shift();
            for (let dir = 0; dir < 4; dir++) {
              let nx = curX + dx[dir];
              let ny = curY + dy[dir];
              if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[i].length) {
                flag = false;
                break;
              } else {
                if (arr[nx][ny] === " " && !visited[nx][ny]) {
                  q.push({ curX: nx, curY: ny });
                  visited[nx][ny] = true;
                }
              }
            }
          }
          if (flag) {
            tempStr += arr[i][j];
          } else {
            tempStr += " ";
          }
        } else {
          tempStr += arr[i][j];
        }
      }
      temp.push(tempStr);
    }
    arr = temp;
  }

  function doCrain(input) {
    let temp = [];
    for (let i = 0; i < arr.length; i++) {
      let tempStr = "";
      for (let j = 0; j < arr[i].length; j++) {
        if (arr[i][j] !== input) {
          tempStr += arr[i][j];
        } else {
          tempStr += " ";
        }
      }
      temp.push(tempStr);
    }
    arr = temp;
  }

  for (let i = 0; i < requests.length; i++) {
    let input = requests[i];
    if (input.length === 1) {
      doLift(input);
    } else {
      doCrain(input[0]);
    }
  }

  for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr[i].length; j++) {
      if (arr[i][j] !== " ") {
        answer++;
      }
    }
  }
  return answer;
}
