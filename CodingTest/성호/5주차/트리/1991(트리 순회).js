const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "test.txt";

const input = fs.readFileSync(filePath).toString().trim().split("\n");
const N = +input[0];
let tree = {};
let ans = "";
for (let i = 0; i < N; i++) {
  const [node, left, right] = input[i + 1].split(" ");
  tree[node] = [left, right];
}

function preorder(node) {
  if (node === ".") {
    return;
  }
  const [left, right] = tree[node];
  ans += node;
  preorder(left);
  preorder(right);
}

function inorder(node) {
  if (node === ".") {
    return;
  }
  const [left, right] = tree[node];
  inorder(left);
  ans += node;
  inorder(right);
}

function postorder(node) {
  if (node === ".") {
    return;
  }
  const [left, right] = tree[node];
  postorder(left);
  postorder(right);
  ans += node;
}

function solution() {
  preorder("A");
  ans += "\n";
  inorder("A");
  ans += "\n";
  postorder("A");
  return ans;
}

console.log(solution());
