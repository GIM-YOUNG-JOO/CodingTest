let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");
const n = input.shift();
function solution() {
    for (let i = 0; i < n; i++) {
        let a = input[i].split(' ').map(Number);
        console.log(`Case #${i + 1}: ${a[0] + a[1]}`);
    }
}

solution();