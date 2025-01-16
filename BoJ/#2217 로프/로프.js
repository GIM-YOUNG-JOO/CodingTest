let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n").map(Number);
const n = input.shift();
input.sort((a, b) => a - b);

function solution() {
    let max = 0;
    for (let i = 0; i < input.length; i++) {
        max = Math.max(max, input[i] * (n - i));
    }

    return max;
}

console.log(solution());